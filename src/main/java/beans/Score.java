package beans;

public class Score {

    // 属性
    private int id = 0; //スコア識別ID
    private int score = 0;//スコア
    private int users_id = 0;//ユーザー識別ID



  	/**
  	* Default empty Score constructor
  	*/
  	public Score() {
  	}

  	/**
  	* Default Score constructor
  	*/
  	public Score(int id, int score, int users_id) {
  		this.id = id;
  		this.score = score;
  		this.users_id = users_id;
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
  	* Returns value of score
  	* @return
  	*/
  	public int getScore() {
  		return score;
  	}

  	/**
  	* Sets new value of score
  	* @param
  	*/
  	public void setScore(int score) {
  		this.score = score;
  	}

  	/**
  	* Returns value of users_id
  	* @return
  	*/
  	public int getUsers_id() {
  		return users_id;
  	}

  	/**
  	* Sets new value of users_id
  	* @param
  	*/
  	public void setUsers_id(int users_id) {
  		this.users_id = users_id;
  	}
}
