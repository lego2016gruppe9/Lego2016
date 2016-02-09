package levels.behavoir;

import Parcour.RobotControl;
import lejos.utility.Delay;

public class FindWallBehavior extends AbstractBehavior{
	
	private final float startDistance = 0.07f;
	private final float startSpeed = 340f;
	private float kp = 380f;
	//boolean turnRight;
	private float currentDistance; 
	
	public FindWallBehavior(RobotControl robot) {
		super(robot);
		
	}

	
	public boolean takeControl() {
	
		return (currentDistance != startDistance);
	}
	
	@Override
	protected void onInit() {
	
		System.out.println("searching wall");
		robot.enableUs();
	}

	protected void loop() {
		currentDistance = robot.getDistanceValueRaw();
	    float error = (currentDistance - startDistance);

		float vl = startSpeed + kp * error;
		float vr = startSpeed - kp * error;

		
		
		robot.drive(vl, vr);
		
		
		if (!takeControl()) {
			suppress();
		}
	}

}
