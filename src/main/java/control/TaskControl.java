package control;//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;

import beans.*;
import control.ClientControl;

public class TaskControl extends ClientControl {

    // 属性
    private Connection connection = null;

    // 引数を持たないコンストラクタ
    public TaskControl() {
    }

    //task取得
    public ArrayList<Task> search(User user) {
        ArrayList<Task> list = new ArrayList<Task>();
        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = createConnection();
        String error = "errorなし";
        // userオブジェクトをDataBaseに登録する
        try {
            // SQLコマンド
            String sql = "SELECT * FROM tasks INNER JOIN categories ON tasks.category_id = categories.id where categories.user_id = '"+user.getId() +"' and tasks.did_it = 0 order by category_id,deadline";

            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);

            ResultSet res = stmt.executeQuery(sql);
            while(res.next())
            {
                Task task = new Task(res.getInt(1),res.getString(2),res.getString(3),res.getDate(4),res.getInt(5),res.getInt(6),res.getString(8),res.getInt(9));
                list.add(task);
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
    public String registTask(Task task) {

        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = createConnection();
        String error = null;
        try {
            // SQLコマンド
            String sql = "insert into tasks(name,description,deadline,did_it,category_id)values(?,?,?,?,?)";
            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);

            // SQLコマンドのクエッションマークに値を、1番目から代入する
            stmt.setString(1, task.getName());
            stmt.setString(2, task.getDescription());
            stmt.setDate(3, task.getLimit());
            stmt.setInt(4, task.getDidit());
            stmt.setInt(5, task.getCategory_id());
            stmt.executeUpdate();

            ResultSet res = stmt.getGeneratedKeys();
            if(res.next()){
                task.setId(res.getInt(1));
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
    public String didTask(Task task) {

        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = createConnection();
        String error = null;
        try {
            // SQLコマンド
            String sql = "delete from tasks where tasks.id = '"+ task.getId()+"'";
            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            error = "削除できませんでした。";
        } finally {
            // DataBaseとの接続を切断する
            closeConnection(this.connection);

            // コネクションオブジェクトを破棄する
            this.connection = null;
            return error;
        }
    }
    public String update(Task task){
        this.connection = createConnection();
        String error = null;
        try {
            // SQLコマンド
            String sql = "update tasks set tasks.name = '"+task.getName() + "',tasks.description = '"+task.getDescription()+"', tasks.deadline = '"+task.getLimit()+"',tasks.category_id = '"+task.getCategory_id()+"'where tasks.id = '"+ task.getId()+"'";
            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            error = "アップデートできませんでした。";
        } finally {
            // DataBaseとの接続を切断する
            closeConnection(this.connection);

            // コネクションオブジェクトを破棄する
            this.connection = null;
            return error;
        }
    }
}