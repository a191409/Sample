//  自分が格納されているフォルダ名
package beans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

public class User extends Default{

    // 属性
    private String name = null;//ログインID
    private String pass = null;//パスワード

    // 初期値を引数に持ったコンストラクタ
    public User(int id, String name, String pass, Timestamp created_at,Timestamp updated_at) {
		super(id, created_at, updated_at);
		this.name = name;
		this.pass = pass;

	}
    // 初期値を引数に持たないコンストラクタ
    // Java beansは初期値を持たないコンストラクタが必ず必要
    public User() {
    	super();
    }
  	/**
  	* Returns value of userName
  	* @return
  	*/
  	public String getName() {
  		return name;
  	}

  	/**
  	* Sets new value of userName
  	* @param
  	*/
  	public void setName(String name) {
  		this.name = name;
  	}

  	/**
  	* Returns value of userPass
  	* @return
  	*/
  	public String getPass() {
  		return pass;
  	}

  	/**
  	* Sets new value of userPass
  	* @param
  	*/
  	public void setPass(String pass) {
  		this.pass = pass;
  	}

	public void hashPassword(){
		this.pass=getHash(this.name,this.pass);
	}
	private String getHash(String name, String password) {
		final String HASH_ALGORITHM = "SHA-256";
		final int STRETCH_COUNT = 1024;
		final String FIXED_SALT = "vBjRGHZ6awqJL9JDQuNftAzaPSnHszQN";
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		String salt = name + FIXED_SALT;
		messageDigest.update(salt.getBytes());
		byte[] hashed = messageDigest.digest(password.getBytes());
		for (int i = 0; i < STRETCH_COUNT; i++) {
			hashed = messageDigest.digest(hashed);
		}
		return getHexString(hashed);
	}
	private String getHexString(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			stringBuffer.append(Integer.toHexString((bytes[i] >> 4) & 0x0f));
			stringBuffer.append(Integer.toHexString(bytes[i] & 0x0f));
		}
		return stringBuffer.toString();
	}
	public static User getCurrentUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		return (User)session.getAttribute("user");
	}
}
