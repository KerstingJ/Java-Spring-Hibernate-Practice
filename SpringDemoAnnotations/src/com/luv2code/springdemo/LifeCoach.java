package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LifeCoach implements Coach {
	
	private FortuneService fortuneService;
	
	// uses Constructor injection to set fortuneService
	@Autowired
	LifeCoach(@Qualifier("RESTFortuneService") FortuneService theFortuneService) {
		fortuneService = theFortuneService;
		/*
		 * using @Qualifier on constructor needs to be passed with the argument
		 * 
		 * why is the name for RESTFortuneService different than the other ones?
		 *  if there are more than one Capital letter at the beginning of the class name
		 *  the name will remain the same ie. RESTFortuneService instead of rESTFortuneService
		 */
	}

	@Override
	public String getDailyWorkout() {
		return "Live yo best life booboo!";
	}
	
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
