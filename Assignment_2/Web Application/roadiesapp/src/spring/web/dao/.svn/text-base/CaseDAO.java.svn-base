package spring.web.dao;


import java.util.List;

import spring.web.model.Case;

/**
 * 
 * @author aabhushanmainali
 * Data Access Object Interface dealing with Case data
 */
public interface CaseDAO 
{
	/**
	 * @param uid
	 *            User id of the user who is reporting a case
	 * @param problem
	 *            Problem that is being report
	 * @param location
	 *            Location data of the user to be inserted
	 * @return true/false according to the success/failure of inserting data
	 */
	public boolean insert(int uid, String problem, String location);
	
	/**
	 * @param cid
	 *            cid for case to be obtained
	 * @return Case corrensponding to the cid
	 */
	public Case findByCid(int cid);
	
	/**
	 * @param uid
	 *            User id of the user whose cases are to be obtained
	 * @return list of cases corrensponding to the user id
	 */
	public List<Case> findByUid(int uid);
	
	/**
	 * @param username
	 *            Username of the user whose cases are to be obtained
	 * @return list of cases corrensponding to the username
	 */
	public List<Case> findByUsername(String username);
	
}