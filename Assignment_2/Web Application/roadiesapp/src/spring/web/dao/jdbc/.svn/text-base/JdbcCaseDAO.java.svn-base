package spring.web.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import spring.web.dao.CaseDAO;
import spring.web.model.Case;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author aabhushanmainali Data Access Object implementing CaseDAO based on
 *         Java Database Connectivity using SQL Important usages:
 *         PreparedStatement class is used for preparing a SQL command that is
 *         to be executed. 
 *         ResultSet class consists of the result from the data
 *         returned by the database for the query
 *         Connection obtains the database connection to be used set in the context file
 *         spring-database.xml
 */
@Repository("caseDAO")
public class JdbcCaseDAO implements CaseDAO {
	// Data source injected through context
	@Autowired
	private DataSource dataSource;

	/**
	 * @param uid
	 *            User id of the user who is reporting a case
	 * @param problem
	 *            Problem that is being report
	 * @param location
	 *            Location data of the user to be inserted
	 * @return true/false according to the success/failure of inserting data
	 */
	@Override
	public boolean insert(int uid, String problem, String location) {

		String sql = "INSERT INTO cases "
				+ "(USER_ID, PROBLEM, LOCATION) VALUES (?, ?, ?)";
		Connection conn = null;
		int result;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setString(2, problem);
			ps.setString(3, location);
			result = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		if (result == 0) {
			return false;
		}

		return true;
	}

	/**
	 * @param uid
	 *            User id of the user whose cases are to be obtained
	 * @return list of cases corrensponding to the user id
	 */
	@Override
	public List<Case> findByUid(int uid) {

		String sql = "SELECT CASE_ID, USER_ID, LOCATION, PROBLEM, TIMESTAMP FROM CASES WHERE USER_ID = ?";

		Connection conn = null;

		List<Case> cases = new ArrayList<Case>();

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			Case c = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Case();
				c.setCid(rs.getInt("CASE_ID"));
				c.setUid(rs.getInt("USER_ID"));
				c.setLocation(rs.getString("LOCATION"));
				c.setProblem(rs.getString("PROBLEM"));
				c.setTimestamp(rs.getTimestamp("TIMESTAMP"));
				cases.add(c);
			}
			rs.close();
			ps.close();
			return cases;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	/**
	 * @param username
	 *            Username of the user whose cases are to be obtained
	 * @return list of cases corresponding to the user id
	 */
	@Override
	public List<Case> findByUsername(String username) {

		String sql = "SELECT CASE_ID, USER_ID, LOCATION, PROBLEM"
				+ " FROM CASE"
				+ " LEFT JOIN USER ON CASE.USER_ID = USER.USER_ID"
				+ "WHERE USER.USERNAME = ?";

		Connection conn = null;

		List<Case> cases = new ArrayList<Case>();

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			Case c = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Case();
				c.setCid(rs.getInt("CASE_ID"));
				c.setUid(rs.getInt("USER_ID"));
				c.setLocation(rs.getString("LOCATION"));
				c.setProblem(rs.getString("PROBLEM"));
				cases.add(c);
			}
			rs.close();
			ps.close();
			return cases;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	/**
	 * @param cid
	 *            Id of the case that you want to retrieve
	 * @return Case corresponding to the cid attribute
	 */
	@Override
	public Case findByCid(int cid) {

		String sql = "SELECT CASE_ID, USER_ID, LOCATION, PROBLEM FROM CASE WHERE CASE_ID = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			Case c = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				c = new Case();
				c.setCid(rs.getInt("CASE_ID"));
				c.setUid(rs.getInt("USER_ID"));
				c.setLocation(rs.getString("LOCATION"));
				c.setProblem(rs.getString("PROBLEM"));
			}
			rs.close();
			ps.close();
			return c;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}