package roadiesActivities;

import java.util.ArrayList;

public class User {
	private String userName;
	private String password;
	private ArrayList<String> user;

	public User(String userName, String password) {
		userName = this.userName;
		password = this.password;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String psd) {
		this.password = psd;
	}

	public String getPassword() {
		return password;
	}

	public ArrayList<String> getUser() {
		user = new ArrayList<String>();
		user.add(0, userName);
		user.add(1, password);
		return user;
	}

}
