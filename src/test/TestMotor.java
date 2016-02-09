package test;


import lejos.hardware.port.MotorPort;
import lejos.hardware.Button;
import lejos.hardware.motor.EV3LargeRegulatedMotor;


public class TestMotor {
	private static EV3LargeRegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.A);
	private static EV3LargeRegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.B);

	/*
	 * init: make the robot move forward 
	 */
	public TestMotor(){
		leftMotor.setSpeed(700);
		rightMotor.setSpeed(700);
		//leftMotor.rotate(251);
		//rightMotor.rotate(-120);
		leftMotor.forward();
		rightMotor.forward();
        }


	/*
	 * if the the speed of two motors are different
	 * then make them same
	 */
	public void robotAdjust() {
		// TODO Auto-generated method stub
		int i=0;
		while(i==0){
		int left_v = leftMotor.getSpeed();
		int right_v = rightMotor.getSpeed();
	
		while(left_v!=right_v){
			leftMotor.setSpeed(right_v);
		if(left_v== right_v){
			break;	
			}
		
		//leftMotor.rotate(250);
		//rightMotor.rotate(-220);
		leftMotor.forward();
		rightMotor.forward();
		if (Button.readButtons() != 0) {
			break;
		}
		}
		}	
	}

	public static void main(String[] args){
	    TestMotor test = new TestMotor();
		test.robotAdjust();
	}
	
}	


	




