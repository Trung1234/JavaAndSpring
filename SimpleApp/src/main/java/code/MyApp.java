package code;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach myCoach = (TrackCoach) context.getBean("myCoach", Coach.class);
		// use the object
		System.out.println(myCoach.getDailyWorkout());
	}

}
