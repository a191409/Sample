//　自分が格納されているフォルダ名
package control;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;

import beans.*;
import dao.*;

public class ScoreManager {

    // 属性
    private Connection connection = null;

    // 引数を持たないコンストラクタ
    public ScoreManager() {
    }

    // 追加
    // 引数はStudentオブジェクト
    public Score registScore(Score score) {
        Score regist_score = new Score();
        // StudentDAOオブジェクト生成
        ScoreDAO scoreDAO = new ScoreDAO();

        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = scoreDAO.createConnection();

        // StudentオブジェクトをDataBaseに登録する
        regist_score = scoreDAO.registScore(score, this.connection);

        // DataBaseとの接続を切断する
        scoreDAO.closeConnection(this.connection);

        // コネクションオブジェクトを破棄する
        this.connection = null;
        return regist_score;
    }

    // 検索
    public Score searchScore(Score score) {

        // StudentDAOオブジェクト生成
        ScoreDAO scoreDAO = new ScoreDAO();

        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = scoreDAO.createConnection();

        // StudentオブジェクトをDataBaseに登録する
        Score return_score = scoreDAO.searchScore(score, this.connection);

        // DataBaseとの接続を切断する
        scoreDAO.closeConnection(this.connection);

        // コネクションオブジェクトを破棄する
        this.connection = null;

        return return_score;

    }
}
