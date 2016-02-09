package levels.behavoir;

import Parcour.RobotControl;

public class MazeBehavior  extends AbstractBehavior {
	
	private float currentDistance ;
	private final float startSpeed = 340f;
	private final float startDistance = 0.07f;
	
	public MazeBehavior(RobotControl robot) {
		super(robot);
		
	}

	@Override
	public boolean takeControl() {
		
		return (currentDistance == startDistance);

	}
	

	protected void onInit() {
		System.out.println("following wall");
		robot.enableUs();;
		
	}

	@Override
	protected void loop() {
		currentDistance = robot.getDistanceValue();
		robot.drive(startSpeed, startSpeed);

	
		if (!takeControl()) {
		suppress();
	}
	}
}
