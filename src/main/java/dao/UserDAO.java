package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.User;

public class UserDAO {

    private final static String HOST_NAME = "db";
    private final static String DATABASE_NAME = "Sample";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "root";
    private final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private final static String DRIVER_URL = "jdbc:mysql://" + HOST_NAME + ":3306/" + DATABASE_NAME + "?useUnicode=true&characterEncoding=utf-8";

    // データベースとの接続を行う
    // データベースの接続情報を持ったConnectionオブジェクトを返す
    public Connection createConnection() {
        try {
            Class.forName(DRIVER_NAME);
            Connection con = DriverManager.getConnection(DRIVER_URL, USER_NAME, PASSWORD);
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("Can't Find JDBC Driver.\n");
        } catch (SQLException e) {
            System.out.println("Connect Error.\n");
        }
        return null;
    }

    // Connectionオブジェクトを使って、データベースとの接続を切断する
    // 引数Connectionオブジェクト
    public void closeConnection(Connection con) {

        try {
            con.close();
        } catch (Exception ex) {
        }
    }

    // 情報をデータベースに登録する
    // 引数はStudentオブジェクトと、Connectionオブジェクト
    public void registUser(User user, Connection connection) {

        try {
            // SQLコマンド
            String sql = "insert into users (names,passes)values(?, ?)";

            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql);

            // SQLコマンドのクエッションマークに値を、1番目から代入する
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getUserPass());

            stmt.executeUpdate();

        } catch (SQLException e) {
          user = null;
        } finally {
        }
    }

    public User loginUser(User user, Connection connection) {

        try {
            // SQLコマンド
            String sql = "select * from users where names = '" + user.getUserName() + "'";

            // SQLのコマンドを実行する
            // 実行結果はrsに格納される
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            rs.first();
            if(rs != null){
               User check_user = new User(rs.getInt("id"), rs.getString("names"), rs.getString("passes"));
            // rsからそれぞれの情報を取り出し、Studentオブジェクトに設定する
              if (check_user.getUserPass().equals(user.getUserPass())) {//文字列が同値である。
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

            // Studentオブジェクトを返す
            return user;
        } catch (SQLException e) {

            // エラーが発生した場合、エラーの原因を出力する
            e.printStackTrace();
            return null;
        } finally {
        }
    }
    public User searchUser(User user, Connection connection) {

        try {
            // SQLコマンド
            String sql = "select * from users where names = '" + user.getUserName() + "'";

            // SQLのコマンドを実行する
            // 実行結果はrsに格納される
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            rs.first();
            if(rs != null){
               user = new User(rs.getInt("id"), rs.getString("names"), rs.getString("passes"));
            }else{
              user = null;
            }
            // 終了処理
            stmt.close();
            rs.close();

            // Studentオブジェクトを返す
            return user;
        } catch (SQLException e) {

            // エラーが発生した場合、エラーの原因を出力する
            e.printStackTrace();
            return null;
        } finally {
        }
    }
}
