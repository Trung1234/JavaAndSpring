package code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	
	@Autowired
	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	public String getDailyWorkout() {
		return "Run a hard 5k TrackCoach";
	}
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}










