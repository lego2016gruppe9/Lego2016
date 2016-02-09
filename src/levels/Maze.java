package levels;

import Parcour.RobotControl;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import levels.behavoir.MazeBehavior;
import levels.behavoir.FindWallBehavior;
import levels.behavoir.HitWall;

public class Maze {

	private Arbitrator arbitrator;

	public Maze(RobotControl robot) {

		Behavior[] behaviors = new Behavior[] { new FindWallBehavior(robot),new MazeBehavior(robot), new HitWall(robot)  };

		arbitrator = new Arbitrator(behaviors, false);
		arbitrator.start();

	}

}