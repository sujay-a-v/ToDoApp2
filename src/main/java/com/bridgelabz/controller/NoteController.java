package com.bridgelabz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bridgelabz.pojo.User;

@Controller
public class NoteController {
	
	@RequestMapping("/home")
	public String homePage(ModelMap modelMap) {
		User user=new User();
		modelMap.put("user", user);
		return "home";
	}

}
