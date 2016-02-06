package Parcour;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;


public class RobotConfig {

	private final EV3LargeRegulatedMotor leftMotor;
	private final EV3LargeRegulatedMotor rightMotor;
	private final EV3ColorSensor colorSensor;
	private  EV3UltrasonicSensor us;
    private  EV3MediumRegulatedMotor ancillaryMotor;
	private  EV3TouchSensor tleft;
	private  EV3TouchSensor tright;

	public RobotConfig() {
		this.leftMotor = new EV3LargeRegulatedMotor(MotorPort.A);
		this.rightMotor = new EV3LargeRegulatedMotor(MotorPort.B);
		this.colorSensor = new EV3ColorSensor(SensorPort.S4);
		this.ancillaryMotor = new EV3MediumRegulatedMotor(MotorPort.C);
		
		this.us = new EV3UltrasonicSensor(SensorPort.S2);
	    this.tleft = new EV3TouchSensor(SensorPort.S3);
 	    this.tright = new EV3TouchSensor(SensorPort.S1);
	}

	/**
	 * @return the leftMotor
	 */
	public EV3LargeRegulatedMotor getLeftMotor() {
		return leftMotor;
	}

	public EV3MediumRegulatedMotor getAncillaryMotor() {
		return ancillaryMotor;
	}
	/**
	 * @return the rightMotor
	 */
	public EV3LargeRegulatedMotor getRightMotor() {
		return rightMotor;
	}

	/**
	 * @return the colorSensor
	 */
	public EV3ColorSensor getColorSensor() {
		return colorSensor;
	}

	/**
	 * @return the us
	 */
	public EV3UltrasonicSensor getUs() {
		return us;
	}

	/**
	 * @return the tleft
	 */
	public EV3TouchSensor getTleft() {
		return tleft;
	}

	/**
	 * @return the tright
	 */
	public EV3TouchSensor getTright() {
		return tright;
	}
}