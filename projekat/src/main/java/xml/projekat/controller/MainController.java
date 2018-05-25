package xml.projekat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(
			value= {"/"},
			method = {RequestMethod.GET, RequestMethod.POST})
	public String redirectHome() {
		return "redirect:/index.html";
	}
	
	@RequestMapping(
			value= {"/login"},
			method = {RequestMethod.GET, RequestMethod.POST})
	public String redirectLogin() {
		return "redirect:/login.html";
	}
	
	@RequestMapping(
			value= {"/register"},
			method = {RequestMethod.GET, RequestMethod.POST})
	public String redirectRegister() {
		return "redirect:/registracija.html";
	}
}
