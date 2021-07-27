package beans;

import java.sql.Date;
import java.sql.Timestamp;
import java.sql.Date;

public class Result extends Default{

    // 属性
    private int round = 0;//大会の段階識別
	private Date date = null;
	private int score_1 = 0;
	private int score_2 = 0;
    private int user_id_1 = 0;//登録者ID
    private int user_id_2 = 0;//相手のID
    private int matches_id = 0;//大会識別ID


	/**
	* Default empty Result constructor
	*/
	public Result() {
		super();
	}

	/**
	* Default Result constructor
	*/
	public Result(int ID, int round,Date date, int score_1, int score_2, Timestamp created_at, Timestamp updated_at, int user_id_1, int user_id_2, int matches_id) {
		super(ID,created_at, updated_at);
		this.round = round;
		this.date = date;
		this.score_1 = score_1;
		this.score_2 = score_2;
		this.user_id_1 = user_id_1;
		this.user_id_2 = user_id_2;
		this.matches_id = matches_id;
	}

	/**
	* Returns value of round
	* @return
	*/
	public int getRound() {
		return round;
	}

	/**
	* Sets new value of round
	* @param
	*/
	public void setRound(int round) {
		this.round = round;
	}

	/**
	* Returns value of date
	* @return
	*/
	public Date getDate() {
		return date;
	}

	/**
	* Sets new value of date
	* @param
	*/
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	* Returns value of score_1
	* @return
	*/
	public int getScore_1() {
		return score_1;
	}

	/**
	* Sets new value of score_1
	* @param
	*/
	public void setScore_1(int score_1) {
		this.score_1 = score_1;
	}

	/**
	* Returns value of score_2
	* @return
	*/
	public int getScore_2() {
		return score_2;
	}

	/**
	* Sets new value of score_2
	* @param
	*/
	public void setScore_2(int score_2) {
		this.score_2 = score_2;
	}

	/**
	* Returns value of user_id_1
	* @return
	*/
	public int getUser_id_1() {
		return user_id_1;
	}

	/**
	* Sets new value of user_id_1
	* @param
	*/
	public void setUser_id_1(int user_id_1) {
		this.user_id_1 = user_id_1;
	}

	/**
	* Returns value of user_id_2
	* @return
	*/
	public int getUser_id_2() {
		return user_id_2;
	}

	/**
	* Sets new value of user_id_2
	* @param
	*/
	public void setUser_id_2(int user_id_2) {
		this.user_id_2 = user_id_2;
	}

	/**
	* Returns value of matches_id
	* @return
	*/
	public int getMatches_id() {
		return matches_id;
	}

	/**
	* Sets new value of matches_id
	* @param
	*/
	public void setMatches_id(int matches_id) {
		this.matches_id = matches_id;
	}
}
