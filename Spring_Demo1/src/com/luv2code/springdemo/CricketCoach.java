package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	private String emailAddress, team;
	
	public CricketCoach() {
		System.out.println("inside constructor");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside Setter");
		this.fortuneService = fortuneService;
	}
	
	public void setEmailAddress(String emailAddress) {
		System.out.println("setting email");
		this.emailAddress = emailAddress;
	}
	
	public void setTeam(String team) {
		System.out.println("Setting team");
		this.team = team;
	}
	@Override
	public String getDailyWorkout() {
		return "I dont know anything about Cricket, so do whatevers";
	}

	@Override
	public String getDailyFortune() {
		return "good luck kid, " +  fortuneService.getFortune();
	}
	
	@Override
	public String getEmailAndTeam() {
		return this.emailAddress + " " + this.team;
	}
}
