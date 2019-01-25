package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Do a lot of the running and stuff";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Override
	public String getEmailAndTeam() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// add init method
	
	public void doMyStartUp() {
		System.out.println("Doing startup stuff for track coach, this is where id add hooks to db etc...");
	}
	
	// add destroy method
	
	public void doMyCleanUp() {
		System.out.println("destroying the bean, its lived a good life but like all things it must come to an end");
	}

}
