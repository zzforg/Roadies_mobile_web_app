package spring.web.controller;
import java.util.List;

import spring.web.model.Case;
import spring.web.service.impl.CaseServiceImpl;
import spring.web.service.impl.UserServiceImpl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author aabhushanmainali
 * This is a controller class that displays the dashboard of the Web application
 *
 */
@Controller
public class IndexController {
	
	//User service being injected through context
	@Autowired
	UserServiceImpl userService;
	
	//Case service being injected through context
	@Autowired
	CaseServiceImpl caseService;
	
	/**
	 * 
	 * @param model Map that is sent to the view
	 * @return Rendered HTML output of index.jsp
	 */
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index(ModelMap model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
	    int userId = (userService.getUserByUsername(username)).getUid();
	    List<Case> cases = caseService.getCaseByUid(userId);
		model.addAttribute("username", username);
		model.addAttribute("message", "Hi " +username+ "! Welcome to Roadies. ");
		model.addAttribute("cases",cases);
		return "index";
	}
}