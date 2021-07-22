package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.*;

public class ScoreDAO {

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
    public Score registScore(Score score, Connection connection) {

        try {
            // SQLコマンド
            String sql = "insert into scores (score,user_id)values(?,?)";

            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, score.getScore());
            stmt.setInt(2,score.getUsers_id());

            stmt.executeUpdate();
            
            //このauto_incrementで作成されたidを取得したい。
        } catch (SQLException e) {
            score = null;
        } finally {
        }
    }
    public Score searchScore(Score score, Connection connection) {
        return null;
    }
}