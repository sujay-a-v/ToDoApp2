package com.bridgelabz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bridgelabz.pojo.DocDetails;
import com.bridgelabz.service.DocService;

@Controller
public class DocController {

	@Autowired
	private DocService docService;
	
	@RequestMapping("/docDetails")
	public String docDetails() {
		System.out.println("Hello 123 ");
		return "docDetails";
		
	}
	
	@RequestMapping("/AddDetails")
	public String AddDetails(ModelMap map) {
		map.addAttribute("details", new DocDetails());
		System.out.println("AddDetails");
		return "AddDetails";
		
	}
}
