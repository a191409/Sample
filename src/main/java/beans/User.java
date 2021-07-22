//  自分が格納されているフォルダ名
package beans;

public class User {

    // 属性
    private int id = 0; //ユーザー識別ID
    private String userName = null;//ログインID
    private String userPass = null;//パスワード

    // 初期値を引数に持ったコンストラクタ
    public User(int id,String userName,String userPass) {

        this.id = id;
        this.userName = userName;
        this.userPass = userPass;

    }

    // 初期値を引数に持たないコンストラクタ
    // Java beansは初期値を持たないコンストラクタが必ず必要
    public User() {
    }

  	/**
  	* Returns value of id
  	* @return
  	*/
  	public int getId() {
  		return id;
  	}

  	/**
  	* Sets new value of id
  	* @param
  	*/
  	public void setId(int id) {
  		this.id = id;
  	}

  	/**
  	* Returns value of userName
  	* @return
  	*/
  	public String getUserName() {
  		return userName;
  	}

  	/**
  	* Sets new value of userName
  	* @param
  	*/
  	public void setUserName(String userName) {
  		this.userName = userName;
  	}

  	/**
  	* Returns value of userPass
  	* @return
  	*/
  	public String getUserPass() {
  		return userPass;
  	}

  	/**
  	* Sets new value of userPass
  	* @param
  	*/
  	public void setUserPass(String userPass) {
  		this.userPass = userPass;
  	}
}
