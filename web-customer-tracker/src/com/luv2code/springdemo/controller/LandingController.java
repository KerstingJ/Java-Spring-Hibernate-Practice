package com.luv2code.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandingController {
	
	@RequestMapping("/")
	public String landingPage() {
		
		return "index";
	}

}
