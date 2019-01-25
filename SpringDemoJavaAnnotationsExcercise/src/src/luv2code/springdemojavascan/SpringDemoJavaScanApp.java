package src.luv2code.springdemojavascan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDemoJavaScanApp {

	public static void main(String[] args) {
		
		// load config file
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(JavaConfigFile.class);

		
		// get yer beans
		Coach myCoach = context.getBean("weirdCoach", Coach.class);
		
		// make yer coffee
		System.out.println(myCoach.getDailyFortune());
		System.out.println(myCoach.getDailyWorkout());
		
		// close the shop
		context.close();
	}

}
