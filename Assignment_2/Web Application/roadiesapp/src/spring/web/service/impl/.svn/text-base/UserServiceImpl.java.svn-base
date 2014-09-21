package spring.web.service.impl;

import spring.web.dao.jdbc.JdbcUserDAO;
import spring.web.model.User;
import spring.web.service.UserService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementation of UserService that uses DAO implementation methods to access User data
 * @author aabhushanmainali
 *
 */

@Service("userService")
public class UserServiceImpl implements UserService {
	
	//Injection of JdbcUserDao through context
	@Autowired
	private JdbcUserDAO userDao;
	
	/**
	 * @param username Username of the user to be created
	 * @param password Password of the user to be created
	 * @param enable User enable
	 * @return true/false according to the success/failure of creation
	 */
	@Override
	public boolean createUser(String username, String password, boolean enabled){
		return userDao.insert(username, password, enabled);
	}
	
	/**
	 * @param uid User id of the user for who role is to be created
	 * @param authority Authority of the user role to be created
	 * @return true/false according to the success/failure of creation
	 */
	@Override
	public boolean createUserRole(int uid, String authority){
		return userDao.insertUserRole(uid, authority);
	}
	
	/**
	 * @param User object which has to be inserted to db
	 * @return success/failure:true/false
	 */
	@Override
	public boolean createUser(User u){
		return userDao.insert(u.getUsername(), u.getPassword(), u.getEnabled());
	}
	
	/**
	 * @param username Username of the person
	 * @return User object for the corresponding username
	 */
	@Override
	public User getUserByUsername(String username){
		return userDao.findByUsername(username);
	}
	
	/**
	 * @param userId UserId for which User object has to be obtained
	 * @return User object
	 */
	@Override
	public User getUserByUserId(int userId){
		return userDao.findByUid(userId);
	}

}
