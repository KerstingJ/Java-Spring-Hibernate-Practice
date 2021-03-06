package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//handle request to show the form
	@RequestMapping("/showForm")
	public String showForm() {
		
		return "helloworld-form";
	}
	
	
	//handle request to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		
		return "helloworld";
	}
	
	//Shouting request
	//handle request form data
	//add data to model
	@RequestMapping("/processFormVTwo")
	public String processFormV2(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("studentName");
		
		name = name.toUpperCase();
		
		name = "Yo!!, " + name;
		
		model.addAttribute("message", name);
		
		
		return "helloworld";
	}
	
	
	@RequestMapping("/processFormVThree")
	public String processFormV3(@RequestParam("studentName") String name , Model model) {
		
		name = name.toUpperCase();
		
		name = "bruhhhh, " + name;
		
		model.addAttribute("message", name);
		
		
		return "helloworld";
	}

}
