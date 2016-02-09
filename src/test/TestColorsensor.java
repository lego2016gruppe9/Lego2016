package test;

import lejos.hardware.sensor.EV3ColorSensor;
import lejos.utility.Delay;
import lejos.hardware.port.SensorPort;

import java.util.Arrays;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.SampleProvider;

public class TestColorsensor {
	private static EV3UltrasonicSensor us = new EV3UltrasonicSensor(SensorPort.S2);
	private static EV3ColorSensor colorsensor = new EV3ColorSensor(SensorPort.S4);
	private static SampleProvider sp;
	private static int sampleSize;
	//public static NormalizationFilter nf = new NormalizationFilter(colorsensor.getRedMode(), 0, 1, true);
	
private static float[] getsample() {
	
	sp = colorsensor.getRedMode();
	float[] sample = new float[sampleSize];
	colorsensor.fetchSample(sample, 0);
	return sample ;
	
}




public static void main(String args []){	
	
float t;
//sampleSize = colorsensor.sampleSize();
//for (int i=0; i<2; i++){
 //float[] sample = getsample();
 t= getsample() [0];
	 
System.out.println("t");
Delay.msDelay(10000);
//}

}}