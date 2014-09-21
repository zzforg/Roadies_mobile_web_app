package spring.web.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import spring.web.dao.UserDAO;
import spring.web.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author aabhushanmainali Data Access Object implementing UserDAO based on
 *         Java Database Connectivity using SQL Important usages:
 *         PreparedStatement class is used for preparing a SQL command that is
 *         to be executed. 
 *         ResultSet class consists of the result from the data
 *         returned by the database for the query
 *         Connection obtains the database connection to be used set in the context file
 *         spring-database.xml
 */

@Repository("userDAO")
public class JdbcUserDAO implements UserDAO
{
	@Autowired
	private DataSource dataSource;
 
	/**
	 * @param username
	 *            Username of the user who is reporting a case
	 * @param password
	 *            Password of the user to be inserted
	 * @param location
	 *            Location data of the user to be inserted
	 * @return true/false according to the success/failure of inserting data
	 */
	@Override
	public boolean insert(String username, String password, boolean enabled){
 
		String sql = "INSERT INTO users " +
				"(USERNAME, PASSWORD, ENABLED) VALUES (?, ?, ?)";
		Connection conn = null;
		int result;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setBoolean(3, enabled);
			result = ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
		if(result == 0){
			return true;
		}
		return false;
	}
	
	/**
	 * @param uid is the id of the user for whom Role is being added.
	 * @param authority is the authority of the Role being added
	 * @return true/false according to the success of data being added to the database
	 */
	
	@Override
	public boolean insertUserRole(int uid, String authority){
 
		String sql = "INSERT INTO user_roles " +
				"(USER_ID, AUTHORITY) VALUES (?, ?)";
		Connection conn = null;
		int result;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setString(2, authority);
			result = ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
		if(result == 0){
			return true;
		}
		return false;
	}
	
	/**
	 * @param uid is the id of the user for which details are being obtained
	 * @return User object for the corresponding id
	 */
 
	@Override
	public User findByUid(int uid){
 
		String sql = "SELECT USER_ID, USERNAME, PASSWORD, TIMESTAMP FROM users WHERE USER_ID = ?";
 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			User user = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(
					rs.getInt("USER_ID"),
					rs.getString("USERNAME"), 
					rs.getString("PASSWORD")
				);
				user.setTimestamp(rs.getTimestamp("TIMESTAMP"));
			}
			rs.close();
			ps.close();
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	/**
	 * @param username for which User details is being searched
	 * @return User object corresponding  to the username
	 */
	@Override
	public User findByUsername(String username){
 
		String sql = "SELECT USER_ID, USERNAME, PASSWORD, TIMESTAMP FROM users WHERE USERNAME = ?";
 
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			User user = null;
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(
					rs.getInt("USER_ID"),
					rs.getString("USERNAME"), 
					rs.getString("PASSWORD")
				);
				user.setTimestamp(rs.getTimestamp("TIMESTAMP"));
			}
			rs.close();
			ps.close();
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}