package levels.behavoir;

import Parcour.RobotControl;

public class SearchLineBehavior extends AbstractBehavior {

	private float vl;
	private float vr;
	boolean turnRight;

	public SearchLineBehavior(RobotControl robot) {
		super(robot);
	}

	@Override
	public boolean takeControl() {
		return robot.getColorSensorValue() <= 0.22;
	}

	@Override
	protected void onInit() {
		vl = 400;
		vr = 300;
		turnRight = true;
		System.out.println("searching line");
		robot.enableColorSensor();

	}

	@Override
	protected void loop() {

		float step = turnRight ? 0.1f : -0.1f;

		vl += step;
		vr -= step;

		if (vl > 400) {
			turnRight = true;
		} else if (vr > 400) {
			turnRight = false;
		}

		robot.drive(vl, vr);

		if (!takeControl()) {
			suppress();
		}
	}

}
