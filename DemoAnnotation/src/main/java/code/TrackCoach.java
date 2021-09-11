package code;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TrackCoach implements Coach {
	public String getDailyWorkout() {
		return "Run a hard 5k TrackCoach";
	}
	
}










