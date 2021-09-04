package code;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {	

		// load the spring configuration file
		ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach myCoach = (TrackCoach) context.getBean("myCoach", Coach.class);
		// use the object
		System.out.println(myCoach.getDailyWorkout());
		// let's call our new method for fortunes
		System.out.println(myCoach.getDailyFortune());				
		// close the context
		context.close();
	}

}
