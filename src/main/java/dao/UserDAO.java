package dao;

import java.sql.*;
import java.util.ArrayList;

import beans.User;

public class UserDAO extends Client{
    // 情報をデータベースに登録する
    // 引数はStudentオブジェクトと、Connectionオブジェクト
    public void registUser(User user, Connection connection) {

        try {
            // SQLコマンド
            String sql = "insert into users (names,passes, created_at, updated_at)values(?, ?, ?, ?)";

            // SQLコマンドの実行
            PreparedStatement stmt = connection.prepareStatement(sql);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            // SQLコマンドのクエッションマークに値を、1番目から代入する
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPass());
            stmt.setTimestamp(3, currentTime);
            stmt.setTimestamp(4, currentTime);

            stmt.executeUpdate();

        } catch (SQLException e) {
          user = null;
        } finally {
        }
    }

    public User loginUser(User user, Connection connection) {

        try {
            // SQLコマンド
            String sql = "select * from users where names = '" + user.getName() + "'";

            // SQLのコマンドを実行する
            // 実行結果はrsに格納される
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            rs.first();
            if(rs != null){
               User check_user = new User(rs.getInt("id"), rs.getString("names"), rs.getString("passes"),rs.getTimestamp("created_at"),rs.getTimestamp("updated_at"));
            // rsからそれぞれの情報を取り出し、Studentオブジェクトに設定する
              if (check_user.getPass().equals(user.getPass())) {//文字列が同値である。
                  user.setId(check_user.getId());
                  user.setCreated_at(check_user.getCreated_at());
                  user.setUpdated_at(check_user.getUpdated_at());
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
    public ArrayList<User> searchUserlist(Connection connection){
        try {
            ArrayList<User> list = new ArrayList<User>();
            // SQLコマンド
            String sql = "select * from users";

            // SQLのコマンドを実行する
            // 実行結果はrsに格納される
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                User user = new User(rs.getInt(1),rs.getString(2),rs.getString("passes"),rs.getTimestamp("created_at"),rs.getTimestamp("updated_at"));
                list.add(user);
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
    public User searchUser(User user, Connection connection) {

        try {
            // SQLコマンド
            String sql = "select * from users where names = '" + user.getName() + "'";

            // SQLのコマンドを実行する
            // 実行結果はrsに格納される
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            rs.first();
            if(rs != null){
                user = new User(rs.getInt("id"), rs.getString("names"), rs.getString("passes"),rs.getTimestamp("created_at"),rs.getTimestamp("updated_at"));
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
