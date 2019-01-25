package com.luv2code.springdemo;

public class MmaCoach implements Coach {
	
	// define private field for dependency
	private FortuneService fortuneService;
	
	// define a constructor for dependency injection
	public MmaCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "TWIST HIS DICK!, Give him the ol' DICK TWIST";
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

}
