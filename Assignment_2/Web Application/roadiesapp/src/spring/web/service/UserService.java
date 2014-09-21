package spring.web.service;

import spring.web.model.User;

/**
 * User Service is the service interface class that provides access to user data in db through DAO
 * @author aabhushanmainali
 *
 */
public interface UserService  
{ 	
	boolean createUser(String username, String password, boolean enabled);
	boolean createUser(User u);
	User getUserByUsername(String username);	
	User getUserByUserId(int userId);
	boolean createUserRole(int uid, String authority);
	
}
