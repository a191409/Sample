//  自分が格納されているフォルダ名
package beans;

public class Match {

    // 属性
    private int id = 0; //大会名識別ID
    private String matchName = null;//大会名


	/**
	* Default empty Match constructor
	*/
	public Match() {
	}

	/**
	* Default Match constructor
	*/
	public Match(int id, String matchName) {
		this.id = id;
		this.matchName = matchName;
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
	* Returns value of matchName
	* @return
	*/
	public String getMatchName() {
		return matchName;
	}

	/**
	* Sets new value of matchName
	* @param
	*/
	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}
}
