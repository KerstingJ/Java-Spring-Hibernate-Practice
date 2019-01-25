package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/*
 * prototype scope tells spring to make a new object with every instance
 * singleton uses the same bean for every instance
 * 
 * spring doesn't destroy prototype beans
 */
@Component
@Scope("singleton")
public class TennisCoach implements Coach {
	
	
	// autowired can also be used directly on a field -- pretty cool use
	// uses reflection... whatever that is
	// to resolve multiple bean error use @Qualifier annotation with the component name
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	
	// uses setter injection with annotations to set fortuneService
	// can use autowired with any method as long as a component fits argument object
	/*
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		
		return "backhands and ball smacks";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	@PostConstruct
	private void extraCreationSteps() {
		System.out.println("This is where i would connect to a database or socket of some type");
		
	}
	
	@PreDestroy
	private void extraDestroySteps() {
		/*
		 * if the bean is set for prototype spring will never call this method
		 */
		System.out.println("This is where i would end the connection to the database\nIF I HAD ONE!!!!!!");
	}

}
