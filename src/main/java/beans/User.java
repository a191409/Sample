//  自分が格納されているフォルダ名
package beans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class User {

    // 属性
    private int id = 0;
    private String email = null;//メールアドレス
    private String pass = null;//パスワード

    // 初期値を引数に持ったコンストラクタ
    public User(int id,String email,String pass) {
        this.id = id;
        this.email = email;
        this.pass = pass;

    }

    // 初期値を引数に持たないコンストラクタ
    // Java beansは初期値を持たないコンストラクタが必ず必要
    public User() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}