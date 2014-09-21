package spring.web.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * User model class including details of the user
 * @author aabhushanmainali
 *
 */
public class User {
	
	private int uid;

	private String username;
	
	private String password;

	private String email;
	
	private String fName;
	
	private String mName;
	
	private String lName;
	
	private Date dob;
	
	private String mobile;
	
	private String street;
	
	private String suburb;
	
	private String state;
	
	private String postCode;
	
	private String country;
	
	private boolean enabled;
	
	private Timestamp timestamp;
	
	/**
	 * Empty Constructor for class
	 */
	public User() {
		super();
	}
	
	/**
	 * User constructor
	 * @param uid user id 
	 * @param username
	 * @param password
	 */
	public User(int uid, String username, String password) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		
	}
	
	public User(String username) {
		super();
		this.username = username;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password="
				+ password + ", email=" + email + ", fName=" + fName
				+ ", mName=" + mName + ", lName=" + lName + ", dob=" + dob
				+ ", mobile=" + mobile + ", street=" + street + ", suburb="
				+ suburb + ", state=" + state + ", postCode=" + postCode
				+ ", country=" + country + ", enabled=" + enabled
				+ ", timestamp=" + timestamp + "]";
	}
	
	
}