package spring.web.model;

import java.sql.Timestamp;

/**
 * 
 * @author aabhushanmainali
 * Case is the model object that stores details of a repair case for the user
 */
public class Case {
	
	//case id for the case
	private int cid;
	
	//location of the case taking place
	private String location;
	
	//timestamp of the case being reported
	private Timestamp timestamp;
	
	//problem being reported
	private String problem;
	
	//id of the user reporting the case
	private int uid;
	
	//Empty Constructor
	public Case(){
		super();
	}
	
	/**
	 * Constructor
	 * @param uid id of the user
	 * @param location location of the case
	 * @param problem problem being reported
	 */
	
	public Case(int uid, String location, String problem) {
		super();
		this.location = location;
		this.problem = problem;
		this.uid = uid;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
}