//　自分が格納されているフォルダ名
package control;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.util.ArrayList;

import beans.Match;
import dao.MatchDAO;

public class MatchManager {

    // 属性
    private Connection connection = null;

    // 引数を持たないコンストラクタ
    public MatchManager() {
    }

    // 追加
    // 引数はStudentオブジェクト
    public void registMatch(Match match) {

        // StudentDAOオブジェクト生成
        MatchDAO matchDAO = new MatchDAO();

        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = matchDAO.createConnection();

        // StudentオブジェクトをDataBaseに登録する
        matchDAO.registMatch(match, this.connection);

        // DataBaseとの接続を切断する
        matchDAO.closeConnection(this.connection);

        // コネクションオブジェクトを破棄する
        this.connection = null;

    }

    // 検索
    public Match searchMatch(Match match) {

        // StudentDAOオブジェクト生成
        MatchDAO matchDAO = new MatchDAO();

        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = matchDAO.createConnection();

        // 検索する
        match = matchDAO.searchMatch(match, this.connection);

        // DataBaseとの接続を切断する
        matchDAO.closeConnection(this.connection);

        // コネクションオブジェクトを破棄する
        this.connection = null;

        return match;
    }
    //大会名一覧
    public ArrayList<Match> searchMatchlist() {

        // MatchDAOオブジェクト生成
        ArrayList<Match> list = new ArrayList<Match>();
        MatchDAO matchDAO = new MatchDAO();

        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = matchDAO.createConnection();

        // リストを作成する
        list = matchDAO.searchMatchlist(this.connection);

        // DataBaseとの接続を切断する
        matchDAO.closeConnection(this.connection);

        // コネクションオブジェクトを破棄する
        this.connection = null;

        return list;
    }
}
