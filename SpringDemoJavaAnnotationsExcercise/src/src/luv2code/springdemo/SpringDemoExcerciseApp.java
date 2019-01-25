package src.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDemoExcerciseApp {

	public static void main(String[] args) {
		// set up config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(JavaConfigFile.class);
				
		// get yer beans
		Coach myCoach = context.getBean("fightCoach", Coach.class);
		
		// make yer coffee
		System.out.println(myCoach.getDailyWorkout() + "\n" + myCoach.getDailyFortune());
		
		// clean it up
		context.close();

	}

}
