package Parcour;

import levels.FollowLine;

public class Main {
	public static void main(String[] args) {
		RobotConfig config = new RobotConfig();
		RobotControl robot = new RobotControl(config);
		FollowLine line = new FollowLine(robot);
	}

}
