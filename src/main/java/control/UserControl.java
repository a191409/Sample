package control;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;

import beans.Task;
import beans.User;

public class UserControl extends ClientControl {

    // 属性
    private Connection connection = null;

    // 引数を持たないコンストラクタ
    public UserControl() {
    }

    //User作成
    public User registUser(User user) {

        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = createConnection();
        String error = null;
        //user.hashPassword();
        // userオブジェクトをDataBaseに登録する
        try {
            // SQLコマンド
            String sql = "insert into users (email, pass)values(?, ?)";

            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);

            // SQLコマンドのクエッションマークに値を、1番目から代入する
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPass());
            stmt.executeUpdate();

            ResultSet res = stmt.getGeneratedKeys();
            if(res.next()){
                user.setId(res.getInt(1));
            }
        } catch (SQLException e) {
            error = "同名アカウントが存在しています。";
        } finally {
            if(user.getId() != 0){
                System.out.println("ログインIDは"+user.getId()+"です。");
            }else{
                System.out.println(error);
            }
            // DataBaseとの接続を切断する
            closeConnection(this.connection);

            // コネクションオブジェクトを破棄する
            this.connection = null;
            return user;
        }

    }
    //login機能
    public User login(User user){
        User check_user = new User();
        this.connection = createConnection();
        try {
            // SQLコマンド
            String sql = "select * from users where email = '" + user.getEmail() + "'";

            // SQLのコマンドを実行する
            // 実行結果はrsに格納される
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            rs.first();
            if(rs != null){
                check_user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("pass"));
                // rsからそれぞれの情報を取り出し、Studentオブジェクトに設定する
                if (check_user.getPass().equals(user.getPass())) {//文字列が同値である。
                    user.setId(check_user.getId());
                } else {
                    user = null;
                }
            }else{
                user = null;
            }
            // 終了処理
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
            user = null;
        } finally {
            // DataBaseとの接続を切断する
            closeConnection(this.connection);
            // コネクションオブジェクトを破棄する
            this.connection = null;
            return user;
        }
    }
    public ArrayList<User> list() {
        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = createConnection();
        String error = "errorなし";
        ArrayList<User> list = new ArrayList<User>();
        // userオブジェクトをDataBaseに登録する
        try {
            // SQLコマンド
            String sql = "SELECT * FROM users";

            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);

            ResultSet res = stmt.executeQuery(sql);
            while(res.next())
            {
                User user = new User(res.getInt(1),res.getString(2),null);
                list.add(user);
                // 取得した情報を表示します。
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            // DataBaseとの接続を切断する
            closeConnection(this.connection);

            // コネクションオブジェクトを破棄する
            this.connection = null;
            return list;
        }
    }
}