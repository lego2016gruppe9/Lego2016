package test;

import Parcour.RobotConfig;
import Parcour.RobotControl;
import lejos.utility.Delay;

public class TestMaze {

	public static void main(String[] args) {
		Findwall();
	}

	public static void turn(RobotControl robot,RobotConfig config, int angle) {
		if (config.getLeftMotor().isStalled() && config.getRightMotor().isStalled()) {
			config.getLeftMotor().rotateTo(angle, true);
			config.getRightMotor().rotateTo(angle, true);

//			while (config.getLeftMotor().isMoving() && config.getRightMotor().isMoving()) {
//				config.getLeftMotor().forward();
//				config.getRightMotor().forward();
//			//	robot.drive(500f, 500f);
//			}

		}
	}

	public static void Findwall() {
		RobotConfig config = new RobotConfig();
		RobotControl robot = new RobotControl(config);
		// robot.drive(400f, 400f);
		float distance = robot.getDistanceValue();

		while (0.0 <= distance && distance < 0.4) {
			robot.drive(300f, 300f);
			// while (robot.getDistanceValue() <= 0.08) {
			//
			// System.out.println(robot.getDistanceValue());
			// // Delay.msDelay(1000);
			// }

			if (distance > 0.2) {
				robot.stopRobot();
				turn(robot,config, -10);
				robot.drive(300f, 300f);
				Delay.msDelay(500);
				robot.stopRobot();
				turn(robot,config, 10);
			}
			if (distance <= 0.05) {
				robot.stopRobot();
				turn(robot,config, 10);
				robot.drive(300f, 300f);
				Delay.msDelay(500);
			}

			// if (config.getLeftMotor().isStalled() &&
			// config.getRightMotor().isStalled()) {
			// config.getLeftMotor().rotate(-10);
			// config.getRightMotor().rotate(-10);
			//
			// while (config.getLeftMotor().isMoving() &&
			// config.getRightMotor().isMoving()) {
			// config.getLeftMotor().forward();
			// config.getRightMotor().forward();
			// }
			//
			// }

		}
	}
}
