package src.luv2code.springdemojavascan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeirdCoach implements Coach {
	
	@Autowired
	FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "stand with your back to the wall with wind blowing on it";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
