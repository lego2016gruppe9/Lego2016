package levels.behavoir;

import Parcour.RobotControl;

public class HitWall extends AbstractBehavior{

	public HitWall(RobotControl robot) {
		super(robot);
	}


	public boolean takeControl() {
	
		return (robot.getTleft() == 1.0f || robot.getTright()== 1.0f);
			
		
	
		
	}


	protected void loop() {
		
		robot.moveInDistance(300, -100);
		
		robot.turnRobotRight(-90);
		
		
		if (!takeControl()) {
			suppress();
		}
		
	}

	
}
