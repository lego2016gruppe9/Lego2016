package levels;

import Parcour.RobotConfig;
import lejos.robotics.subsumption.Behavior;

public class Maze implements Behavior {

	private RobotConfig config;
	// private static DifferentialPilot pilot = new
	// DifferentialPilot(20,100,leftmotor,rightmotor,false);

	private boolean finished = false;

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub

		return true;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub

	}
	// us.getDistanceMode();

	@Override
	public void suppress() {
		// TODO Auto-generated method stub

	}

}
