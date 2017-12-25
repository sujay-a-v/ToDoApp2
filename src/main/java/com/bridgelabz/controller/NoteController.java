package com.bridgelabz.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bridgelabz.pojo.Notes;
import com.bridgelabz.pojo.User;
import com.bridgelabz.service.NotesService;

@Controller
public class NoteController {
	
	@Autowired
	private NotesService notesService;
	
	@RequestMapping("/home")
	public String homePage(ModelMap modelMap) {
		User user=new User();
		modelMap.put("user", user);
		return "home";
	}
	
	/*@RequestMapping(value="/getNotes")
	public List<Notes> getAllNotes(HttpSession session){
		System.out.println("Inside Note controller");
		User user=(User) session.getAttribute("user");
		User noteUser=(User) session.getAttribute("user");
		System.out.println("\n\n noteUser---> "+noteUser);
		System.out.println("User in Note controller --> "+user);
		List<Notes> notes=notesService.fetchAllNotes(user);
		System.out.println("Line 12344");
		return null;
		
	}*/

}
