package Parcour;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.filter.MeanFilter;

public class RobotControl {

	private RobotConfig config;

	public RobotControl(RobotConfig config) {
		this.config = config;
	}

	public float getDistanceValue() {
		EV3UltrasonicSensor us = config.getUs();
		float[] sample = new float[1];
		us.fetchSample(sample, 0);
		return sample[0];
	}
	
	public float getTouchvalueleft(){
       EV3TouchSensor tsl = config.getTleft();
       float[] sample = new float[1];
       tsl.fetchSample(sample, 0);
	   return sample[0];
	}
	
	public float getTouchvalueright(){
	       EV3TouchSensor tsr = config.getTright();
	       float[] sample = new float[1];
	       tsr.fetchSample(sample, 0);
		   return sample[0];
	}
	
	public void enableColorSensor() {
		EV3ColorSensor colorSensor = config.getColorSensor();
		SensorMode colorMode = colorSensor.getRedMode();
		colorSensor.setCurrentMode(colorMode.getName());
		colorSensor.setFloodlight(true);
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
     
	public void stopancillaryMotor(){
		config.getAncillaryMotor().flt();
		
		config.getAncillaryMotor().stop();
	} 
	
	public void turnancillayMotor(int angle){
		config.getAncillaryMotor().rotate(angle);
	}
	
	public void drive(float leftSpeed, float rightSpeed) {
		config.getLeftMotor().setSpeed(leftSpeed);
		config.getRightMotor().setSpeed(rightSpeed);

		config.getLeftMotor().forward();
		config.getRightMotor().forward();
	}
	
	public void backdrive(float leftSpeed,float rightSpeed){
		config.getLeftMotor().setSpeed(leftSpeed);
		config.getRightMotor().setSpeed(rightSpeed);

		config.getLeftMotor().backward();
		config.getRightMotor().backward();
		
	}

	public RobotConfig getConfig() {
		return config;
	}

}
