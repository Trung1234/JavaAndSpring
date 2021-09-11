package code;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// read spring config file
		ClassPathXmlApplicationContext context = 
						new ClassPathXmlApplicationContext("applicationContext.xml");				
		// get the bean from spring container
		Coach theCoach = context.getBean("thatSillyCoach", Coach.class);				
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());						
		// close the context
		context.close();
	}

}
