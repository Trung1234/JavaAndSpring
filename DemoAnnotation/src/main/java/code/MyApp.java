package code;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// read spring config file
		ClassPathXmlApplicationContext context = 
						new ClassPathXmlApplicationContext("applicationContext.xml");				
		// get the bean from spring container
		Coach theCoach = context.getBean("badmitonCoach", Coach.class);				
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());	
		System.out.println(theCoach.getDailyFortune());	
		// close the context
		context.close();
	}

}
