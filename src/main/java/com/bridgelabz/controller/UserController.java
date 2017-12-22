package com.bridgelabz.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.pojo.User;
import com.bridgelabz.service.UserService;
import com.bridgelabz.validation.UserValidation;

@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidation userValidation;
	
	/*@RequestMapping("/register")
	public String registerForm() {
		System.out.println("Hello hello 211222");
		return "register";
	}*/
	
	@GetMapping("register")
	public ModelAndView registerForm() {
		System.out.println("Inside get method");
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("login");
	    modelAndView.addObject("user", new User());
	    return modelAndView;
    }
	
	@PostMapping("save")
	public ModelAndView doRegister(User user) {
	    ModelAndView modelAndView = new ModelAndView();
	    System.out.println("Inside Post method");
	    String valid=userValidation.userValidation(user);
	    
	    if(valid!="true") {
	    	System.out.println(valid);
	    	logger.info("Validation errors while submitting form.");
        	modelAndView.setViewName("register");
        	modelAndView.addObject("user", user);
    	    return modelAndView;
	    }
	    
        /*if(result.hasErrors()) {
        	logger.info("Validation errors while submitting form.");
        	modelAndView.setViewName("user-creation");
        	modelAndView.addObject("user", user);
    	    return modelAndView;
        }*/	
	  /*  user=userService.createUser(user);
	    System.out.println(user.getId());*/
		/*userService.addUser(user);*/
		 modelAndView.addObject("user", new User());
		modelAndView.setViewName("login");
		System.out.println("Line 3");
    	logger.info("Form submitted successfully.");	    
	    return modelAndView;
    }	
	
	@PostMapping("/login")
	public ModelAndView doLogin(User user) {
	ModelAndView modelAndView = new ModelAndView();
	System.out.println(user.getUserEmail());
	System.out.println(user.getUserPassword());
	/*User user1=userService.login(user.getUserEmail(), user.getUserPassword());
	System.out.println("----->"+user1.getId()+" "+user1.getUserEmail());*/
	modelAndView.setViewName("register");
	return modelAndView; 
	}
	
	/*@RequestMapping("/allUser")
	public List<User> getAllUser(){
		
		return Arrays.asList(
				new User(1,"sujay","sujay.gmail.com","9900356542"),
				new User(2,"manja","manja@gmail.com","8746021045")
				
				);
		
	}*/
	
	@RequestMapping(value="/createUser",method = RequestMethod.POST)
	public void createUser(@RequestBody User user) {
		System.out.println("\n\n25425634\n\n");
		userService.saveUser(user);
	}
	@RequestMapping("/getUser")
	public List<User> getUser() {
		return userService.getAllUser();
	}
	
} 