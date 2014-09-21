package spring.web.controller;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author aabhushanmainali
 * Login controller handles login operation and uses Spring Security for validation which
 * corresponds to spring-security.xml context file
 */
@Controller
public class LoginController {

 
	/**
	 * 
	 * @param model Map sent to the view
	 * @return HTML render of login.jsp
	 */
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
 
	}
	
	/**
	 * 
	 * @param model Map sent to the view
	 * @return HTML render of login with error attribute set
	 */
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";
	}
	
	/**
	 * 
	 * @param model Map sent to the view
	 * @return HTML render of login.jsp
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		SecurityContextHolder.getContext().setAuthentication(null);
		return "login";
 
	}
	
}

