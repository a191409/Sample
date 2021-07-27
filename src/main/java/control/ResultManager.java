//　自分が格納されているフォルダ名
package control;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.util.ArrayList;

import beans.Result;
import dao.ResultDAO;

public class ResultManager {

    // 属性
    private Connection connection = null;

    // 引数を持たないコンストラクタ
    public ResultManager() {
    }

    // 追加
    // 引数はStudentオブジェクト
    public void registResult(Result result) {

        // StudentDAOオブジェクト生成
        ResultDAO resultDAO = new ResultDAO();

        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = resultDAO.createConnection();

        // StudentオブジェクトをDataBaseに登録する
        resultDAO.registResult(result, this.connection);

        // DataBaseとの接続を切断する
        resultDAO.closeConnection(this.connection);

        // コネクションオブジェクトを破棄する
        this.connection = null;

    }
    //大会名登録時に検索する
    public ArrayList<Result> searchResult(Result result) {

        // MatchDAOオブジェクト生成
        ArrayList<Result> list = new ArrayList<Result>();
        ResultDAO resultDAO = new ResultDAO();

        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = resultDAO.createConnection();

        // リストを作成する
        list = resultDAO.searchResult(result,this.connection);

        // DataBaseとの接続を切断する
        resultDAO.closeConnection(this.connection);

        // コネクションオブジェクトを破棄する
        this.connection = null;

        return list;
    }
    //大会名一覧
    public ArrayList<Result> searchResultlist() {

        // MatchDAOオブジェクト生成
        ArrayList<Result> list = new ArrayList<Result>();
        ResultDAO resultDAO = new ResultDAO();

        // DataBaseへ接続し、コネクションオブジェクトを生成する
        this.connection = resultDAO.createConnection();

        // リストを作成する
        list = resultDAO.searchResultlist(this.connection);

        // DataBaseとの接続を切断する
        resultDAO.closeConnection(this.connection);

        // コネクションオブジェクトを破棄する
        this.connection = null;

        return list;
    }
}