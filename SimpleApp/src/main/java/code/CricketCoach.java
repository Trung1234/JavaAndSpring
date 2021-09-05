package code;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;	
	
	// create a no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	// our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}


	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}


	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
