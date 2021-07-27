package beans;

import java.sql.Timestamp;
import java.util.Date;

public class Default {

    private int id = 0; //auto_incrementで入力されるid
    private Timestamp created_at = null;
    private Timestamp updated_at = null;


	/**
	* Default empty Default constructor
	*/
	public Default() {
	}

	/**
	* Default Default constructor
	*/
	public Default(int id, Timestamp created_at, Timestamp updated_at) {
		this.id = id;
		this.created_at = created_at;
		this.updated_at = updated_at;
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
	* Returns value of created_at
	* @return
	*/
	public Timestamp getCreated_at() {
		return created_at;
	}

	/**
	* Sets new value of created_at
	* @param
	*/
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	/**
	* Returns value of updated_at
	* @return
	*/
	public Timestamp getUpdated_at() {
		return updated_at;
	}

	/**
	* Sets new value of updated_at
	* @param
	*/
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
}
