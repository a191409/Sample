//  自分が格納されているフォルダ名
package beans;

import java.sql.Timestamp;

public class Match extends Default{

    // 属性
    private String name = null;//大会名


	/**
	* Default empty Match constructor
	*/
	public Match() {
		super();
	}

	/**
	* Default Match constructor
	*/
	public Match(int ID, String name, Timestamp created_at, Timestamp updated_at) {
		super(ID,created_at, updated_at);
		this.name = name;
	}
	/**
	* Returns value of Name
	* @return
	*/
	public String getName() {
		return name;
	}

	/**
	* Sets new value of Name
	* @param
	*/
	public void setName(String name) {
		this.name = name;
	}
}
