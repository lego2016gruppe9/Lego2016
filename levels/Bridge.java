package levels;

import levels.behavoir.Edgedetectionbehavior;
import Parcour.RobotConfig;
import Parcour.RobotControl;

public class Bridge {

	public static void main(String[] args) {
		RobotConfig config = new RobotConfig();
		RobotControl robot = new RobotControl(config);
		Edgedetectionbehavior eb = new Edgedetectionbehavior();
		eb.Turnthethirdmotor();
		
		while(! eb.detectEdge()){
			robot.drive(300f, 300f);
		}
		eb.turnRobot(10);
	}
}
