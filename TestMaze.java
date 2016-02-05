package test;

import Parcour.RobotConfig;
import Parcour.RobotControl;
import lejos.utility.Delay;

public class TestMaze {

	public static void main(String[] args) {
		Findwall();
	}

	public static void Findwall() {
		RobotConfig config = new RobotConfig();
		RobotControl robot = new RobotControl(config);
		robot.drive(400f, 400f);
		while (config.getLeftMotor().isStalled() && config.getRightMotor().isStalled()) {
			config.getLeftMotor().rotate(-10);
			config.getRightMotor().rotate(-10);

			while (config.getLeftMotor().isMoving() && config.getRightMotor().isMoving()) {
				config.getLeftMotor().forward();
				config.getRightMotor().forward();
			}

			while (robot.getDistanceValue() <= 0.08) {
				robot.drive(400f, 400f);
				System.out.println(robot.getDistanceValue());
//				Delay.msDelay(1000);
			}
//			while (robot.getDistanceValue() > 0.08) {
//				robot.stopRobot();
//			}
			robot.stopRobot();
		}
	}

}
