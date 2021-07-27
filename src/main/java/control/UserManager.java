//　自分が格納されているフォルダ名
package control;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.util.ArrayList;

import beans.Match;
import beans.User;
import dao.UserDAO;

public class UserManager {

    // 属性
    private Connection connection = null;

    // 引数を持たないコンストラクタ
    public UserManager() {
    }

    // 追加
    // 引数はStudentオブジェクト
    public void registUser(User user) {

        // StudentDAOオブジェクト生成
        UserDAO userDAO = new UserDAO();

        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = userDAO.createConnection();
        user.hashPassword();
        // userオブジェクトをDataBaseに登録する
        userDAO.registUser(user, this.connection);

        // DataBaseとの接続を切断する
        userDAO.closeConnection(this.connection);

        // コネクションオブジェクトを破棄する
        this.connection = null;

    }

    // 検索
    public ArrayList<User> searchUserlist() {
        ArrayList<User> list = new ArrayList<User>();
        // StudentDAOオブジェクト生成
        UserDAO userDAO = new UserDAO();

        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = userDAO.createConnection();

        // 検索する
        list = userDAO.searchUserlist(this.connection);

        // DataBaseとの接続を切断する
        userDAO.closeConnection(this.connection);

        // コネクションオブジェクトを破棄する
        this.connection = null;

        return list;
    }

    public User loginUser(User user) {

        // StudentDAOオブジェクト生成
        UserDAO userDAO = new UserDAO();

        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = userDAO.createConnection();
        user.hashPassword();
        // 検索する
        user = userDAO.loginUser(user, this.connection);

        // DataBaseとの接続を切断する
        userDAO.closeConnection(this.connection);

        // コネクションオブジェクトを破棄する
        this.connection = null;

        return user;
    }

    public User searchUser(User user) {

        // StudentDAOオブジェクト生成
        UserDAO userDAO = new UserDAO();

        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = userDAO.createConnection();

        // 検索する
        user = userDAO.searchUser(user, this.connection);

        // DataBaseとの接続を切断する
        userDAO.closeConnection(this.connection);

        // コネクションオブジェクトを破棄する
        this.connection = null;

        return user;
    }
}
