package test;

import Parcour.RobotConfig;
import Parcour.RobotControl;
import lejos.utility.Delay;

public class TestMaze {

	public static void main(String[] args) {
		Findwall();
	}

	
	public static void turn(RobotConfig config, int angle) {
		if (config.getLeftMotor().isStalled() && config.getRightMotor().isStalled()) {
			config.getLeftMotor().rotate(angle);
			config.getRightMotor().rotate(angle);

			while (config.getLeftMotor().isMoving() && config.getRightMotor().isMoving()) {
				config.getLeftMotor().forward();
				config.getRightMotor().forward();
			}

		}
	}
	
	public static void Findwall() {
		RobotConfig config = new RobotConfig();
		RobotControl robot = new RobotControl(config);
		// robot.drive(400f, 400f);

		while (true) {
			robot.drive(400f, 400f);
//			while (robot.getDistanceValue() <= 0.08) {
//				
//				System.out.println(robot.getDistanceValue());
//				// Delay.msDelay(1000);
//			}
			if (robot.getDistanceValue() > 0.08) {
				robot.stopRobot();
			}
			
			if (robot.getDistanceValue() <= 0.02) {
				turn(config, 5);
			}
			
			turn(config, -10);
			
//			if (config.getLeftMotor().isStalled() && config.getRightMotor().isStalled()) {
//				config.getLeftMotor().rotate(-10);
//				config.getRightMotor().rotate(-10);
//
//				while (config.getLeftMotor().isMoving() && config.getRightMotor().isMoving()) {
//					config.getLeftMotor().forward();
//					config.getRightMotor().forward();
//				}
//
//			}
		}
	}

}
