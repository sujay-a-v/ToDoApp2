package com.bridgelabz.controller;

import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String homePage( HttpSession session) {
		User user=new User();
		User noteUser=(User) session.getAttribute("user");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("user1",user);
		List<Notes> notes=notesService.fetchAllNotes(noteUser);
		modelAndView.addObject("notes",notes);
		Notes note=new Notes();
		modelAndView.addObject("note",note);
		//modelMap.put("user", user);
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
	
	/*@RequestMapping(value="addNote",method = RequestMethod.POST)
	public ModelAndView addNote(@RequestParam("title") String title, @RequestParam("description") String description, HttpServletRequest request, HttpSession session) {
		Notes note = new Notes();
	//	note.setDescription(map.get("description")[0]);
		note.setTitle(title);
		note.setDescription(description);
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
	}*/
	
	@RequestMapping(value="addNote",method = RequestMethod.POST)
	public String addNote(Notes note, HttpServletRequest request, HttpSession session) {
		/*Notes note = new Notes();
	//	note.setDescription(map.get("description")[0]);
		note.setTitle(title);
		note.setDescription(description);*/
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
		modelAndView.setViewName("redirect:home");
		modelAndView.addObject("user1",noteUser);
		modelAndView.addObject("notes",notes);
		modelAndView.addObject("note",note);
		
		return "redirect:home";
	}
	
	@RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
	public ModelAndView deleteNote(@PathVariable int id,HttpSession session) {
		Notes currentNote = notesService.fetchById(id);
		if (currentNote == null) {
			
			return null;
		}
		notesService.deleteUserNotes(id);
		User noteUser=(User) session.getAttribute("user");
		List<Notes> notes=notesService.fetchAllNotes(noteUser);
		ModelAndView modelAndView=new ModelAndView();
		Notes note=new Notes();
		
		modelAndView.addObject("user1",noteUser);
		modelAndView.addObject("notes",notes);
		modelAndView.addObject("note",note);
		modelAndView.setViewName("home");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
	public ModelAndView editNote(@PathVariable int id,HttpSession session) {
		User noteUser=(User) session.getAttribute("user");
		Notes currentNote = notesService.fetchById(id);
		session.setAttribute("createTime", currentNote.getCreateDate());
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("noteEdit");
		modelAndView.addObject("note",currentNote);
		return modelAndView;
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public ModelAndView update(Notes note,HttpSession session)
	{
		User user=(User) session.getAttribute("user");
		note.setUser(user);
		Date date=new Date();
		note.setModifiedDate(date);
		Notes currentNote=notesService.fetchById(note.getId());
		ModelAndView modelAndView=new ModelAndView();
		if(currentNote!=null) {
			Date date1=(Date) session.getAttribute("createTime");
			note.setCreateDate(date1);
			notesService.modifiedNotes(note.getId(), note);
		}
		
		modelAndView.addObject("user1",user);
		List<Notes> notes=notesService.fetchAllNotes(user);
		modelAndView.addObject("notes",notes);
		modelAndView.addObject("note",note);
		System.out.println(modelAndView.getViewName());
		System.out.println("DDD ->"+modelAndView.wasCleared());
		modelAndView.setViewName("home");
		System.out.println(modelAndView.getViewName());
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/other/{opp}/{id}",method = RequestMethod.GET)
	public ModelAndView otherFunction(@PathVariable("opp") int opp,@PathVariable("id") int id,HttpSession session) {
		
		Notes note=notesService.fetchById(id);
		User user=(User) session.getAttribute("user");
		note.setUser(user);
		Date date=new Date();
		note.setModifiedDate(date);
		ModelAndView modelAndView=new ModelAndView();
		if(opp==1) {
			note.setArchive("true");
		}else if(opp==2) {
			note.setArchive("false");
		}else if(opp==3){
			note.setTrash("true");
		}else if(opp==4) {
			note.setTrash("false");
		}else if(opp==5) {
			
		}
		
		notesService.modifiedNotes(note.getId(), note);
		modelAndView.addObject("user1",user);
		List<Notes> notes=notesService.fetchAllNotes(user);
		modelAndView.addObject("notes",notes);
		modelAndView.addObject("note",note);
		modelAndView.setViewName("home");
		//modelAndView.setView("home");
		return modelAndView;
		
	}

}
