package com.bridgelabz.controller;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.pojo.Notes;
import com.bridgelabz.pojo.User;
import com.bridgelabz.service.NotesService;
import com.bridgelabz.service.UserService;
import com.bridgelabz.utility.Token;
import com.bridgelabz.validation.UserValidation;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NotesService notesService;
	
	@Autowired
	private UserValidation userValidation;
	
	@Autowired
	private Token token;
	
	
	@RequestMapping("/register")
	public String registerForm(ModelMap modelMap) {
		User user=new User();
		modelMap.put("user", user);
		
		return "register";
	}
	
	@RequestMapping("/")
	public String loginPage(ModelMap modelMap) {
		User user=new User();
		modelMap.put("user", user);
		return "login";
	}
	
	
	/*@RequestMapping("/")
	public ModelAndView welcome(ModelMap modelMap) {
		System.out.println("!@#");
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("login");
		 modelAndView.addObject("user", new User());
		return modelAndView;
		
	}*/
	
	/*@GetMapping("register")
	public ModelAndView registerForm() {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("register");
	    modelAndView.addObject("user", new User());
	    return modelAndView;
    }*/
	
	/*@PostMapping("save")*/
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String doRegister(User user) {
	    String valid=userValidation.userValidation(user);
	    ModelMap modelMap=new ModelMap();
	    if(valid!="true") {
	    	System.out.println(valid);
	    	logger.info("Validation errors while submitting form.");
        	modelMap.put("user", user);
    	    return "register";
	    }
	    userService.saveUser(user);
		String accessToken=token.generateToken(user.getId());
		modelMap.put("user", user);
		System.out.println("Line 3");
    	logger.info("Form submitted successfully.");	    
	    return "login";
    }	
	
	/*@PostMapping("/login")*/
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String doLogin(User user,HttpSession session) {
	ModelMap modelMap=new ModelMap();
	User user1=userService.checkUserData(user.getUserEmail(), user.getUserPassword());
	ModelAndView modelAndView=new ModelAndView();
	if(user1==null) {
		//modelAndView.setViewName("login");
		return "redirect:/";
	}
	session.setAttribute("user", user1);
	/*List<Notes> notes=notesService.fetchAllNotes(user1);
	Notes note=new Notes();
	modelMap.put("user1", user1);
	modelAndView.setViewName("home");
	modelAndView.addObject("user1",user1);
	modelAndView.addObject("notes",notes);
	modelAndView.addObject("note",note);*/
	return "redirect:/home"; 
	}
	
	/*@RequestMapping(value="/createUser",method = RequestMethod.POST)
	public void createUser(@RequestBody User user) {
		userService.saveUser(user);
		String accessToken=token.generateToken(user.getId());
		System.out.println("Token is ---> "+accessToken);
	}
	@RequestMapping("/getUser")
	public List<User> getUser() {
		return userService.getAllUser();
	}*/
	
} 