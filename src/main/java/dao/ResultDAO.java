package dao;

import beans.Result;

import java.sql.*;
import java.util.ArrayList;

public class ResultDAO extends Client{
    public void registResult(Result result, Connection connection) {

        try {
            // SQLコマンド
            String sql = "insert into results (rounds,date,user_1_score,user_2_score,created_at, updated_at,matches_id,user_1_id,user_2_id)values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            // SQLコマンドのクエッションマークに値を、1番目から代入する
            stmt.setInt(1, result.getRound());
            stmt.setDate(2, result.getDate());
            stmt.setInt(3,result.getScore_1());
            stmt.setInt(4,result.getScore_2());
            stmt.setTimestamp(5, currentTime);
            stmt.setTimestamp(6, currentTime);
            stmt.setInt(7,result.getMatches_id());
            stmt.setInt(8,result.getUser_id_1());
            stmt.setInt(9,result.getUser_id_2());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            result = null;
        } finally {
        }
    }

    public ArrayList<Result> searchResultlist(Connection connection){
        try {
            ArrayList<Result> list = new ArrayList<Result>();
            // SQLコマンド
            String sql = "select * from results";

            // SQLのコマンドを実行する
            // 実行結果はrsに格納される
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                Result result = new Result(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getInt(4),rs.getInt(5),rs.getTimestamp(6),rs.getTimestamp(7),rs.getInt(8),rs.getInt(9),rs.getInt(10));
                list.add(result);
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
    // 検索
    public ArrayList<Result> searchResult(Result result, Connection connection) {

        try {
            ArrayList<Result> list = new ArrayList<Result>();
            // SQLコマンド
            String sql = "select * from results where rounds = '" + result.getId() + "'  and date = '" + result.getDate() + "' and (user_1_id = '" + result.getUser_id_1() + "' or user_2_id = '" + result.getUser_id_1() + "')";

            // SQLのコマンドを実行する
            // 実行結果はrsに格納される
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                Result check_result = new Result(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getInt(4),rs.getInt(5),rs.getTimestamp(6),rs.getTimestamp(7),rs.getInt(8),rs.getInt(9),rs.getInt(10));
                list.add(check_result);
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
}
