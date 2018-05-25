package xml.projekat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xml.projekat.model.User;
import xml.projekat.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRep;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value="/registerUser",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean registerUser(@RequestBody User user) {

		User us = null;
		
		if(!(userRep.findByEmail(user.getEmail()) == null)) return false;
		
		us  = new User(user.getEmail(),user.getUserPassword(),user.getUserName(), user.getUserSurname(), "KORISNIK",user.getCity(),user.getMobileNumber());
		
			us.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
			userRep.save(us);
			return true;
	}
	
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public boolean checkStatus(HttpServletRequest request) {
		if(!SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) return true;
		return false;
	}

	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	public boolean checkRole(HttpServletRequest request) {
		System.out.println("Stigao sam ovdje");
		try {
			//SecurityContextHolder.getContext().getAuthentication().;
			//request.getSession().invalidate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(HttpServletRequest request) {
		
		return "Vi ste admin!";
	}
	
	@RequestMapping(value = "/korisnik", method = RequestMethod.GET)
	public String korisnik(HttpServletRequest request) {
		
		return "Vi ste korisnik!";
	}
	
	@RequestMapping(value = "/agent", method = RequestMethod.GET)
	public String agent(HttpServletRequest request) {
		
		return "Vi ste agent!";
	}
	
	
	@RequestMapping(value="/editUser",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean editUser(@RequestBody User user,HttpServletRequest request) {
		Authentication a = SecurityContextHolder.getContext().getAuthentication();
		User userDB = userRep.findByEmail(a.getName());
		userDB.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
	
		userRep.save(userDB);
			
		return true;

	}
	
	
}