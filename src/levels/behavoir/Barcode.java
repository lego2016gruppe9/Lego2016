package levels.behavoir;


import Parcour.RobotConfig;
import Parcour.RobotControl;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3ColorSensor;

public class Barcode {
	RobotConfig config = new RobotConfig();
	RobotControl robot = new RobotControl(config);

	// The width of an element pair of the barcode (in millimeter: one white line (= 25mm), one black ground (= 25mm)).
	private static final float WIDTH_BARCODE_ELEMENT = 50.0f;

	private final int BLACK = 0;
	private final int WHITE = 1;
	private int barcode = 0;
	private  EV3ColorSensor colorSensor;
	private final float THRESHOLD_WHITE = 0.7f;//The minimum color value of a white/silver element of the barcode
	private final float WHEEL_LENGTH =  106.8142f;// the wheel-length value ÐèÒª²âÁ¿
	
	
	public void run(){
		int position = BLACK;
		long startTime = 0;
		boolean programRunning = true;
		float currentColorValue = 0;
	
while (programRunning) {
			
			// Getting the current color value from the sensor
			float[] sample = new float[colorSensor.sampleSize()];
			colorSensor.fetchSample(sample, 0);
			currentColorValue = sample[0];
			
			// Displaying the current detected bar code
			LCD.clear();
			LCD.drawString("Barcode:", 0, 7);
			LCD.drawInt(barcode, 3, "Barcode:".length(), 7);
			//System.out.println("Barcode = " + barcode);
			
			robot.drive(robot.maxSpeed() * 0.3f);
			
			if (currentColorValue > THRESHOLD_WHITE  ){
				
				if (position == BLACK) {
					// Robot was previously on a black line
					position = WHITE;
					startTime = System.nanoTime();
					barcode++;
				}
			} else {
				
				// Calculating the moved distance since the last white line
				float elapsedTime = System.nanoTime() - startTime;
				float currentSpeed = robot.getSpeed();
				float traveledDistanceDegree = currentSpeed * (elapsedTime / 1000000000.0f);	
				float traveledDistanceMM = traveledDistanceDegree / 360.0f * WHEEL_LENGTH;

				System.out.println("Distance = " + traveledDistanceMM);
				
				
				if (position != BLACK){
					position = BLACK;
				}else if( barcode >= 1 && traveledDistanceMM > WIDTH_BARCODE_ELEMENT) {
					programRunning = false;
				}
				}
			if (barcode >7){
				barcode = 0;
				programRunning = false;
			}
			}
	}
	

}
