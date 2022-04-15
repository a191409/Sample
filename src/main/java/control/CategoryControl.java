package control;//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;

import beans.*;
import control.ClientControl;

public class CategoryControl extends ClientControl {

    // 属性
    private Connection connection = null;

    // 引数を持たないコンストラクタ
    public CategoryControl() {
    }

    //Category初期値作成
    public Category initialCategory(Category category) {

        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = createConnection();
        String error = null;
        //user.hashPassword();
        // userオブジェクトをDataBaseに登録する
        try {
            // SQLコマンド
            String sql = "insert into categories (name, user_id)values(?, ?)";

            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);

            // SQLコマンドのクエッションマークに値を、1番目から代入する
            stmt.setString(1, category.getName());
            stmt.setInt(2, category.getUser_id());
            stmt.executeUpdate();

            ResultSet res = stmt.getGeneratedKeys();
            if(res.next()){
                category.setId(res.getInt(1));
            }
        } catch (SQLException e) {
            error = "同名アカウントが存在しています。";
        } finally {
            // DataBaseとの接続を切断する
            closeConnection(this.connection);

            // コネクションオブジェクトを破棄する
            this.connection = null;
            return category;
        }
    }
    public ArrayList<Category> search(User user) {
        ArrayList<Category> list = new ArrayList<Category>();
        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = createConnection();
        String error = "errorなし";
        //user.hashPassword();
        // userオブジェクトをDataBaseに登録する
        try {
            // SQLコマンド
            String sql = "SELECT * FROM categories  where categories.user_id = '"+user.getId() +"'";

            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);

            ResultSet res = stmt.executeQuery(sql);
            while(res.next())
            {
                Category category = new Category(res.getInt(1),res.getString(2),res.getInt(3));
                list.add(category);
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
    public String registCategory(Category category) {

        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = createConnection();
        String error = null;
        // categoryオブジェクトをDataBaseに登録する
        try {
            // SQLコマンド
            String sql = "insert into categories(name,user_id)values(?,?)";
            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);

            // SQLコマンドのクエッションマークに値を、1番目から代入する
            stmt.setString(1, category.getName());
            stmt.setInt(2, category.getUser_id());
            stmt.executeUpdate();

            ResultSet res = stmt.getGeneratedKeys();
            if(res.next()){
                category.setId(res.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
            error = "登録ができませんでした。";
        } finally {
            // DataBaseとの接続を切断する
            closeConnection(this.connection);

            // コネクションオブジェクトを破棄する
            this.connection = null;
            return error;
        }

    }
}