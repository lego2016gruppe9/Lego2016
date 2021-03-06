package levels;

import Parcour.RobotControl;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import levels.behavoir.FollowLineBehavior;
import levels.behavoir.SearchLineBehavior;
import levels.behavoir.BridgeBehavior;

public class Bridge {private Arbitrator arbitrator;

public Bridge(RobotControl robot) {

	Behavior[] behaviors = new Behavior[] { new SearchLineBehavior(robot), new FollowLineBehavior(robot) };

	arbitrator = new Arbitrator(behaviors, false);
	arbitrator.start();

	
	
	

}
}
