package code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BadmitonCoach implements Coach {	
	@Autowired
	private FortuneService fortuneService;
	
	public BadmitonCoach() {
		System.out.println(">> BadmitonCoach: inside default constructor");
	}
	public String getDailyWorkout() {
		return "Practice your badminton skill";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
