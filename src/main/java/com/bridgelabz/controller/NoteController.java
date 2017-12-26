package com.bridgelabz.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="addNote",method = RequestMethod.POST)
	public ModelAndView addNote(Notes note,HttpSession session) {
		User noteUser=(User) session.getAttribute("user");
		//User noteUser=userService.getByEmail(email);
		Date date = new Date();
		note.setCreateDate(date);
		note.setModifiedDate(date);
		note.setUser(noteUser);
		notesService.addUserNotes(note);
		//System.out.println("\n\n Notes from DB \n");
		List<Notes> notes=notesService.fetchAllNotes(noteUser);
		System.out.println("Ajjayya");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("home");
		modelAndView.addObject("user1",noteUser);
		modelAndView.addObject("notes",notes);
		modelAndView.addObject("note",note);
		
		return modelAndView;
	}

}
