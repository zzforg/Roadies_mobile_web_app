package spring.web.service.impl;

import java.util.List;

import spring.web.dao.jdbc.JdbcCaseDAO;
import spring.web.dao.jdbc.JdbcUserDAO;
import spring.web.model.Case;
import spring.web.service.CaseService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementation of CaseService that uses DAO implementation methods to access Case data
 * @author aabhushanmainali
 *
 */
@Service("caseService")
public class CaseServiceImpl implements CaseService {
	
	//Injection of JdbcCaseDao through context
	@Autowired
	private JdbcCaseDAO caseDAO;
	
	//Injection of JdbcUserDao through context
	@Autowired
	private JdbcUserDAO userDAO;

	/**
	 * @param username for whom Case is being created
	 * @param problem for the Case
	 * @param location Location of the user
	 * @return
	 */
	@Override
	public boolean createCase(String username, String problem, String location) {
	    int uid = (userDAO.findByUsername(username)).getUid();
		return this.caseDAO.insert(uid, problem, location);
	}

	/**
	 * @param username for whom the Cases are being obtained
	 * @return list of cases for the username
	 */
	@Override
	public List<Case> getCaseByUsername(String username) {
		return this.caseDAO.findByUsername(username);
	}
	
	/**
	 * @param userId User Id for whom the cases are being obtained
	 * @return Get the list of cases corresponding to the id
	 */
	@Override
	public List<Case> getCaseByUid(int userId) {
		return this.caseDAO.findByUid(userId);
	}

	/**
	 * @param caseId Id of the case to be obtained
	 * @return Case corresponding to the caseId
	 */
	@Override
	public Case getCaseByCaseId(int caseId) {
		return this.caseDAO.findByCid(caseId);
	}

}
