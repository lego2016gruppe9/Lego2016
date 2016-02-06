package test;

import Parcour.RobotConfig;
import Parcour.RobotControl;
import lejos.utility.Delay;

public class testTouchsensor {

	public void Touchsensorbehavior() {
		RobotConfig config = new RobotConfig();
		RobotControl robot = new RobotControl(config);

		float ispressedl = robot.getTouchvalueleft();
		float ispressedr = robot.getTouchvalueright();

		// test value of touch sensor is 0 if not pressed; 1 when pressed
		while (ispressedl == 1 || ispressedr == 1) {

			// 这里的0.5需要做出调整！！这里只是一个初始值，需要调整
			while (robot.getDistanceValue() <= 0.5 && robot.getDistanceValue() > 0) {
				robot.backdrive(300f, 300f);
			//	Delay.msDelay(400);
			}
			robot.stopRobot();

		}
	}
	
}
