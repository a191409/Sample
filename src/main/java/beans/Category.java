//  自分が格納されているフォルダ名
package beans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class Category {

    // 属性
    private int id = 0;
    private String name = null;//パスワード
    private int user_id = 0;

    // 初期値を引数に持ったコンストラクタ
    public Category(int id,String name,int user_id) {
        this.id = id;
        this.name = name;
        this.user_id = user_id;

    }

    // 初期値を引数に持たないコンストラクタ
    // Java beansは初期値を持たないコンストラクタが必ず必要
    public Category() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}