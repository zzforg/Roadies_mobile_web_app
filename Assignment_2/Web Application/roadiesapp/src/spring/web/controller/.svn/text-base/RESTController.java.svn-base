package spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;

import spring.web.model.User;
import spring.web.service.impl.CaseServiceImpl;
import spring.web.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/services")
public class RESTController {

	@Autowired
	UserServiceImpl userService;

	@Autowired
	CaseServiceImpl caseService;

	@RequestMapping(value = "/test/{test}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String testServiceUser(@PathVariable String test, ModelMap model) {
		model.addAttribute("test", test);
		return "/services/index";
	}

	@RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
	public ModelAndView getUser(@PathVariable String username) {
		User u = userService.getUserByUsername(username);
		return new ModelAndView("users", "object", u);
	}

	@RequestMapping(value = "/getSolution", method = RequestMethod.GET)
	public String getSolution(@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("problem") String problem,
			@RequestParam("location") String location, ModelMap model) {
		if (userService.getUserByUsername(username) == null) {
			userService.createUser(username, password, true);
			userService.createUserRole(
					(userService.getUserByUsername(username)).getUid(),
					"ROLE_USER");
		}
		caseService.createCase(username, problem, location);
		model.addAttribute("test", "Fetching solution");
		return "OK";
	}

}