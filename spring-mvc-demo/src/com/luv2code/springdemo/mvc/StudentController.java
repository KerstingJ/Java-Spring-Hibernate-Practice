package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}")
	private LinkedHashMap<String, String> countryOptions;
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a new student object
		Student theStudent = new Student();
		
		//add student object as a model attribute
		theModel.addAttribute("student", theStudent);
		
		//add Country options to the model
		theModel.addAttribute("countryOptions", countryOptions);
		
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		System.out.println(theStudent);
		
		return "student-confirmation";
	}
}
