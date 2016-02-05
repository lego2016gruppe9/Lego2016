package levels.behavoir;

import Parcour.RobotControl;

public class FollowLineBehavior extends AbstractBehavior {

	private final float startSpeed = 200;
	private final float startParameter = 0.75f;
	private final float kp = 80f;
	private long lastFound;

	public FollowLineBehavior(RobotControl robot) {
		super(robot);
	}

	@Override
	public boolean takeControl() {
		return robot.getColorSensorValue() > 0.6;
	}

	@Override
	protected void onInit() {
		System.out.println("following line");
		robot.enableColorSensor();
		lastFound = System.currentTimeMillis();
	}

	@Override
	protected void loop() {
		float newParameter = robot.getRawColorSensorValue();
		
		float error = (newParameter - startParameter);

		float vl = startSpeed - kp * error;
		float vr = startSpeed + kp * error;

		robot.drive(vl, vr);

		if (!takeControl()) {
			if ((System.currentTimeMillis() - lastFound) < 600) {
				suppress();
			}
		} else {
			lastFound = System.currentTimeMillis();
		}
	}

}
