package levels.behavoir;

import Parcour.RobotControl;

public class BridgeBehavior extends AbstractBehavior{

	private float vl;
	private float vr;
	boolean turnRight;
	
	public BridgeBehavior(RobotControl robot) {
		super(robot);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean takeControl() {
		return robot.getColorSensorValue() <= 0.04 || robot.getDistanceValue() > 0.08;
	}

	@Override
	protected void loop() {
		// TODO Auto-generated method stub
		
	}

}
