package com.bridgelabz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.pojo.DocDetails;
import com.bridgelabz.service.DocService;

@Controller
public class DocController {

	@Autowired
	private DocService docService;
	
	@RequestMapping("/docDetails")
	public ModelAndView docDetails() {
		ModelAndView modelAndView=new ModelAndView();
		List<DocDetails> allDetails=docService.getAllDetails();
		modelAndView.addObject("allDetails",allDetails);
		
		//modelAndView.setViewName("docDetails");
		return modelAndView;
		
	}
	
	@RequestMapping("/AddDetails")
	public String AddDetails(ModelMap map) {
		map.addAttribute("details", new DocDetails());
		return "AddDetails";
	}
	
	@RequestMapping(value="/saveDetails",method = RequestMethod.POST)
	public String saveDetails(DocDetails docDetails) {
		docService.saveDetails(docDetails);
		return "redirect:/docDetails";
	}
	
	@RequestMapping(value="/viewTax/{id}")
	public ModelAndView getById(@PathVariable("id") int id) {
		System.out.println(id);
		DocDetails details=docService.getDetailsById(id);
		System.out.println("one doc - "+details);
		return null;
		
	}
}
