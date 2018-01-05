package com.bridgelabz.controller;

import java.util.Calendar;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.pojo.Notes;
import com.bridgelabz.pojo.User;
import com.bridgelabz.service.NotesService;


@Controller
public class NoteController {
	
	@Autowired
	private NotesService notesService;
	
	@RequestMapping("/home")
	public ModelAndView homePage( HttpSession session) {
		User noteUser=(User) session.getAttribute("user");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("user1",noteUser);
		List<Notes> notes=notesService.fetchAllNotes(noteUser);
		modelAndView.addObject("notes",notes);
		Notes note=new Notes();
		modelAndView.addObject("note",note);
		//modelMap.put("user", user);
		return modelAndView;
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
		Date date = new Date();
		note.setCreateDate(date);
		note.setModifiedDate(date);
		note.setUser(noteUser);
		notesService.addUserNotes(note);
		return "redirect:/home";
	}
	
	@RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
	public String deleteNote(@PathVariable int id,HttpSession session) {
		notesService.deleteUserNotes(id);
		return "redirect:/Trash";
		
	}
	
	@RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
	public ModelAndView editNote(@PathVariable int id,HttpSession session) {
		Notes currentNote = notesService.fetchById(id);
		session.setAttribute("createTime", currentNote.getCreateDate());
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("noteEdit");
		modelAndView.addObject("note",currentNote);
		return modelAndView;
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String update(Notes note,HttpSession session)
	{
		User user=(User) session.getAttribute("user");
		note.setUser(user);
		Date date=new Date();
		note.setModifiedDate(date);
		Notes currentNote=notesService.fetchById(note.getId());
		if(currentNote!=null) {
			Date date1=(Date) session.getAttribute("createTime");
			note.setCreateDate(date1);
			notesService.modifiedNotes(note.getId(), note);
		}
		return "redirect:/home";
	}
	
	@RequestMapping(value="/other/{opp}/{id}",method = RequestMethod.GET)
	public String otherFunction(@PathVariable("opp") int opp,@PathVariable("id") int id,HttpSession session) {
		
		Notes note=notesService.fetchById(id);
		User user=(User) session.getAttribute("user");
		note.setUser(user);
		Date date=new Date();
		note.setModifiedDate(date);
		if(opp==1) {
			note.setArchive("true");
		}else if(opp==2) {
			note.setArchive("false");
			notesService.modifiedNotes(note.getId(), note);
			return "redirect:/Archive";
		}else if(opp==3){
			note.setTrash("true");
		}else if(opp==4) {
			note.setTrash("false");
			notesService.modifiedNotes(note.getId(), note);
			return "redirect:/Trash";
		}else if(opp==5) {
			note.setPin("true");
		}else if(opp==6) {
			note.setPin("false");
		}
		notesService.modifiedNotes(note.getId(), note);
		return "redirect:/home";
		
	}
	
	@RequestMapping(value="/copy/{id}",method = RequestMethod.GET)
	public String makeCopy(@PathVariable int id,HttpSession session) {
		Notes copyNote = notesService.fetchById(id);
		User noteUser=(User) session.getAttribute("user");
		Date date = new Date();
		copyNote.setCreateDate(date);
		copyNote.setModifiedDate(date);
		copyNote.setUser(noteUser);
		notesService.addUserNotes(copyNote);
		return "redirect:/home";
	}
	
	@RequestMapping("/Archive")
	public ModelAndView archivePage( HttpSession session) {
		User noteUser=(User) session.getAttribute("user");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("user1",noteUser);
		List<Notes> notes=notesService.fetchAllNotes(noteUser);
		modelAndView.addObject("notes",notes);
		return modelAndView;
	}
	
	@RequestMapping("/Trash")
	public ModelAndView trashPage( HttpSession session) {
		User noteUser=(User) session.getAttribute("user");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("user1",noteUser);
		List<Notes> notes=notesService.fetchAllNotes(noteUser);
		modelAndView.addObject("notes",notes);
		return modelAndView;
	}
	
	@RequestMapping("/note/{id}")
	public String editModel(@PathVariable("id") int id,ModelMap madelMap) {
		Notes note = notesService.fetchById(id);
		madelMap.addAttribute("note", notesService.fetchById(id));
		System.out.println("34435r%%$");
		return "/home :: modalContents";
	}
	
	@RequestMapping("/reminder/{id}")
	public String addReminder(@PathVariable("id") int id,@RequestParam("reminder") String reminder) {
		System.out.println("reminder ---> "+ reminder);
		Notes note = notesService.fetchById(id);
		note.setReminder(reminder);
		notesService.modifiedNotes(note.getId(), note);
		
		System.out.println("34435r%%$");
		System.out.println("Rwjvnf");
		return "redirect:/home";
	}
	
	
	@RequestMapping(value="/reminder/{opp}/{id}",method = RequestMethod.GET)
	public String addReminder(@PathVariable("opp") int opp,@PathVariable("id") int id,HttpSession session) {
		
		Notes note=notesService.fetchById(id);
		User user=(User) session.getAttribute("user");
		note.setUser(user);
		Date date=new Date();
		note.setModifiedDate(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		String year1=Integer.toString(year);
		int month = cal.get(Calendar.MONTH)+1;
		String month1=Integer.toString(month);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		if(opp==1) {
			int nextWeek=day+7;
			String nextWeek1=Integer.toString(nextWeek);
			String reminder=nextWeek1+"/"+month1+"/"+year1;
			reminder=reminder+" 8AM";
			System.out.println("\n\n"+reminder+"\n\n");
			note.setReminder(reminder);
		}else if(opp==2) {
			int tommorow=day+1;
			String tommorow1=Integer.toString(tommorow);
			String reminder=tommorow1+"/"+month1+"/"+year1;
			reminder=reminder+" 8AM";
			System.out.println("\n\n"+reminder+"\n\n");
			note.setReminder(reminder);
		}else if(opp==3){
			note.setTrash("true");
		}else if(opp==4) {
			note.setTrash("false");
			notesService.modifiedNotes(note.getId(), note);
			return "redirect:/Trash";
		}else if(opp==5) {
			note.setPin("true");
		}else if(opp==6) {
			note.setPin("false");
		}
		notesService.modifiedNotes(note.getId(), note);
		return "redirect:/home";
		
	}
}
