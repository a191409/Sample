package dao;

import java.sql.*;
import java.util.ArrayList;

import beans.Match;

public class MatchDAO extends Client{
    // 情報をデータベースに登録する
    // 引数はStudentオブジェクトと、Connectionオブジェクト
    public void registMatch(Match match, Connection connection) {

        try {
            // SQLコマンド
            String sql = "insert into matches (names,created_at, updated_at)values(?,?,?)";

            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            // SQLコマンドのクエッションマークに値を、1番目から代入する
            stmt.setString(1, match.getName());
            stmt.setTimestamp(2, currentTime);
            stmt.setTimestamp(3, currentTime);

            stmt.executeUpdate();

        } catch (SQLException e) {
          match = null;
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
          ResultSet rs = stmt.executeQuery(sql);
          
            while(rs.next())
            {
              Match match = new Match(rs.getInt(1),rs.getString(2),rs.getTimestamp(3),rs.getTimestamp(4));
              list.add(match);
              // 取得した情報を表示します。
            }
            // ResultSetのオブジェクトをクローズします。
            rs.close();
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
    public Match searchMatch(Match match, Connection connection) {

        try {
            // SQLコマンド
            String sql = "select * from matches where names = '" + match.getName() + "'";

            // SQLのコマンドを実行する
            // 実行結果はrsに格納される
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            rs.first();
            if(rs != null){
                match = new Match(rs.getInt(1), rs.getString(2),rs.getTimestamp(3),rs.getTimestamp(4));
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
}
