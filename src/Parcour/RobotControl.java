package Parcour;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.filter.MeanFilter;
import lejos.robotics.navigation.DifferentialPilot;

public class RobotControl {

	private RobotConfig config;
	private final float Tire_diameter = 30; // in mm
    private final float pi = 3.1415926f;
    private final float LengthOfWheel = 132; // in mm

	public RobotControl(RobotConfig config) {
		this.config = config;
	}

	public float getTleft() {
		EV3TouchSensor tleft = config.getTleft();
		SensorMode TouchMode = (SensorMode) tleft.getTouchMode();
		float[] sample = new float[TouchMode.sampleSize()];
		tleft.fetchSample(sample, 0);
		return sample[0];
	
	}
	public float getTright() {
		EV3TouchSensor tright = config.getTright();
		SensorMode TouchMode = (SensorMode) tright.getTouchMode();
		float[] sample = new float[TouchMode.sampleSize()];
		tright.fetchSample(sample, 0);
		return sample[0];
	
	}
	
	
	
	
	
	public float getDistanceValue() {
		enableUs();
		EV3UltrasonicSensor us = config.getUs();
		MeanFilter f = new MeanFilter(us, 3);
		SensorMode DistanceMode = (SensorMode) us.getDistanceMode();
		float[] sample = new float[DistanceMode.sampleSize()];
		f.fetchSample(sample, 0);
		return sample[0];
		
	}
	
	public float getDistanceValueRaw() {
		enableUs();
		EV3UltrasonicSensor us = config.getUs();
		SensorMode DistanceMode = (SensorMode) us.getDistanceMode();
		float[] sample = new float[DistanceMode.sampleSize()];
		us.fetchSample(sample, 0);
		return sample[0];
		
	}
	
	public void enableColorSensor() {
		EV3ColorSensor colorSensor = config.getColorSensor();
		SensorMode colorMode = colorSensor.getRedMode();
		colorSensor.setCurrentMode(colorMode.getName());
		colorSensor.setFloodlight(true);
	}
	public void enableUs() {
		EV3UltrasonicSensor us = config.getUs();
		SensorMode DistanceMode =(SensorMode) us.getDistanceMode();
		us.enable();
		
	}

	public float getColorSensorValue() {
		enableColorSensor();
		EV3ColorSensor colorSensor = config.getColorSensor();
		MeanFilter f = new MeanFilter(colorSensor, 3);
		SensorMode colorMode = colorSensor.getRedMode();
		float[] sample = new float[colorMode.sampleSize()];
		f.fetchSample(sample, 0);
		return sample[0];
	}
	
	public float getRawColorSensorValue() {
		enableColorSensor();
		EV3ColorSensor colorSensor = config.getColorSensor();
		SensorMode colorMode = colorSensor.getRedMode();
		float[] sample = new float[colorMode.sampleSize()];
		colorSensor.fetchSample(sample, 0);
		return sample[0];
	}



	
	
	
	
	public void stopRobot() {
		config.getLeftMotor().flt();
		config.getRightMotor().flt();

		config.getLeftMotor().stop();
		config.getRightMotor().stop();
	}

	public void drive(float leftSpeed, float rightSpeed) {
		config.getLeftMotor().setSpeed(leftSpeed);
		config.getRightMotor().setSpeed(rightSpeed);

		config.getLeftMotor().forward();
		config.getRightMotor().forward();
	}

	public void backdrive(float leftSpeed, float rightSpeed) {
		config.getLeftMotor().setSpeed(leftSpeed);
		config.getRightMotor().setSpeed(rightSpeed);

		config.getLeftMotor().backward();
		config.getRightMotor().backward();
	}
	
	
	    
	
	public void pilot() {
		DifferentialPilot pilot = new DifferentialPilot(1.1811f,1.1811f,5.9f,config.getLeftMotor(),config.getRightMotor(),true);
		
		
		
	}
	 
	 
	public void moveInDistance(float speed,float distance){
        if (speed > 0.0f){
            //lMotorspeed = speed;
            //rMotorspeed = speed;
             
            float TurnsOfTire = distance/(Tire_diameter * pi);
            float TurnsOfMotor = TurnsOfTire * 360.0f;
             
            this.stopRobot();
            config.getLeftMotor().setSpeed(speed);
            config.getRightMotor().setSpeed(speed);
             
            if (distance > 0.0f ){
                config.getLeftMotor().rotate((int) TurnsOfMotor, true);
                config.getRightMotor().rotate((int)TurnsOfMotor, true);
            }else if (distance < 0.0f){
                config.getLeftMotor().rotate((int) ( TurnsOfMotor), true);
                config.getRightMotor().rotate((int) ( TurnsOfMotor), true);
            }
            config.getLeftMotor().waitComplete();
            config.getRightMotor().waitComplete();
        }
    }
	
	 
	 public void turnRobotRight(int degree){
	        float distanceFullCircle = LengthOfWheel * pi;
	        float distanceToMove = distanceFullCircle / 360.0f * degree;
	 
	        float distanceOneRotation = Tire_diameter * pi;
	 
	        float amountRotations = distanceToMove / distanceOneRotation;
	        int degreesToRotate = (int) (amountRotations * 360.0f);
	 
	        config.getLeftMotor().rotate(degreesToRotate, true);
	        config.getRightMotor().rotate((-1) * degreesToRotate, true);
	        config.getLeftMotor().waitComplete(); 
	        config.getRightMotor().waitComplete();
	    }
	
	
	
	 
	public RobotConfig getConfig() {
		return config;
	}

}
