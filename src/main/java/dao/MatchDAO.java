package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Match;

public class MatchDAO {

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
    public void registMatch(Match match, Connection connection) {

        try {
            // SQLコマンド
            String sql = "insert into matches (names)values(?)";

            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql);

            // SQLコマンドのクエッションマークに値を、1番目から代入する
            stmt.setString(1, match.getMatchName());

            stmt.executeUpdate();

        } catch (SQLException e) {
          match = null;
        } finally {
        }
    }

    public Match searchMatch(Match match, Connection connection) {

        try {
            // SQLコマンド
            String sql = "select * from matches where names = '" + match.getMatchName() + "'";

            // SQLのコマンドを実行する
            // 実行結果はrsに格納される
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            rs.first();
            if(rs != null){
               match = new Match(rs.getInt("id"), rs.getString("names"));
            }else{
              match = null;
            }
            // 終了処理
            stmt.close();
            rs.close();

            // Studentオブジェクトを返す
            return match;
        } catch (SQLException e) {

            // エラーが発生した場合、エラーの原因を出力する
            e.printStackTrace();
            return null;
        } finally {
        }
    }
    public ArrayList<Match> searchMatchlist(Connection connection){
      try {
          ArrayList<Match> list = new ArrayList<Match>();
          // SQLコマンド
          String sql = "select * from matches";

          // SQLのコマンドを実行する
          // 実行結果はrsに格納される
          Statement stmt = connection.createStatement();
          ResultSet rs1 = stmt.executeQuery(sql);
          
            while(rs1.next())
            {
              Match match = new Match(rs1.getInt(1),rs1.getString(2));
              list.add(match);
              // 取得した情報を表示します。
            }
            // ResultSetのオブジェクトをクローズします。
            rs1.close();
            // Statementのオブジェクトをクローズします。
            stmt.close();
          return list;
      } catch (SQLException e) {

          // エラーが発生した場合、エラーの原因を出力する
          e.printStackTrace();
          return null;
      } finally {
      }
    }
}
