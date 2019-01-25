package src.luv2code.springdemo;

public class FightCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public FightCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "find random guy at the bar and go for it";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
