package Parcour;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.filter.MeanFilter;

public class RobotControl {

	private RobotConfig config;
	private float maxSpeed;

	public RobotControl(RobotConfig config) {
		this.config = config;
	}

	public float getDistanceValue() {
		EV3UltrasonicSensor us = config.getUs();

		// LinearCalibrationFilter filter = new LinearCalibrationFilter();

		return 0.0f;
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
	public void drive(float speed) {
		config.leftMotor.setSpeed(speed);
		config.rightMotor.setSpeed(speed);
		config.leftMotor.forward();
		config.rightMotor.forward();
	}

	public void drive(float leftSpeed, float rightSpeed) {
		config.getLeftMotor().setSpeed(leftSpeed);
		config.getRightMotor().setSpeed(rightSpeed);

		config.getLeftMotor().forward();
		config.getRightMotor().forward();
	}

	public RobotConfig getConfig() {
		return config;
	}

	public float maxSpeed() {
		// TODO Auto-generated method stub
		return this.maxSpeed;
	}
	
	public float getSpeed() {
		return (config.leftMotor.getRotationSpeed() + config.rightMotor.getRotationSpeed()) / 2.0f;
	}



}
