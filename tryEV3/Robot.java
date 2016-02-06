package tryEV3;
import ch.aplu.ev3.*;

/**
 * The main robot.
 * @author doukate
 * 
 */
public class Robot {
	
	private Gear gear;
	private LegoRobot ken;
	
	
	public Robot() {
		this.setGear(new Gear());
	}

	public Gear getGear() {
		return gear;
	}

	public void setGear(Gear gear) {
		this.gear = gear;
	}
	
	public void gearUp() {
		
	}
	
	
	
	
	
	
//	public Robot() {
//		LegoRobot robot = new LegoRobot();
//		Motor lMotor = new Motor(MotorPort.A);
//		Motor rMotor = new Motor(MotorPort.B);
//		robot.addPart(lMotor);
//		robot.addPart(rMotor);
//		lMotor.forward();
//		rMotor.forward();
//		
//	}
}
