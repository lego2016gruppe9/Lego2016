package levels.behavoir;

import Parcour.RobotControl;
import lejos.hardware.Button;
import lejos.robotics.subsumption.Behavior;

public abstract class AbstractBehavior implements Behavior {

	protected RobotControl robot;
	protected boolean isSuppressed = false;

	public AbstractBehavior(RobotControl robot) {
		this.robot = robot;
	}

	protected void onInit() {

	}

	protected abstract void loop();

	protected void onExit() {
		robot.stopRobot();
	}

	@Override
	public void action() {
		
		synchronized (this) {
			isSuppressed = false;
		}
		
		onInit();

		while (true) {
			
			if (Button.readButtons() != 0) {
				System.out.println("button pressed");
				System.exit(0);
				return;
			}

			loop();

			synchronized (this) {
				if (isSuppressed) {
					onExit();
					return;
				}
			}
		}
	}

	@Override
	public synchronized void suppress() {
		isSuppressed = true;
	}

}