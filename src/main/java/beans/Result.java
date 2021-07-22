package beans;

public class Result {

    // 属性
    private int id = 0; //対戦結果識別ID
    private int round = 0;//大会の段階識別
    private int scores_id_1 = 0;//スコア識別ID1
    private int scores_id_2 = 0;//スコア識別ID2
    private int matches_id = 0;//大会識別ID



	/**
	* Default empty Result constructor
	*/
	public Result() {
	}

	/**
	* Default Result constructor
	*/
	public Result(int id, int round, int scores_id_1, int scores_id_2, int matches_id) {
		this.id = id;
		this.round = round;
		this.scores_id_1 = scores_id_1;
		this.scores_id_2 = scores_id_2;
		this.matches_id = matches_id;
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
	* Returns value of scores_id_1
	* @return
	*/
	public int getScores_id_1() {
		return scores_id_1;
	}

	/**
	* Sets new value of scores_id_1
	* @param
	*/
	public void setScores_id_1(int scores_id_1) {
		this.scores_id_1 = scores_id_1;
	}

	/**
	* Returns value of scores_id_2
	* @return
	*/
	public int getScores_id_2() {
		return scores_id_2;
	}

	/**
	* Sets new value of scores_id_2
	* @param
	*/
	public void setScores_id_2(int scores_id_2) {
		this.scores_id_2 = scores_id_2;
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
