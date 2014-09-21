package spring.web.dao;

import spring.web.model.User;

/**
 * 
 * @author aabhushanmainali
 * Data Access Object interface dealing with User Data
 */
public interface UserDAO 
{
	public boolean insert(String username, String password, boolean enabled);
	public boolean insertUserRole(int uid, String authority);
	public User findByUid(int uid);
	public User findByUsername(String username);
}