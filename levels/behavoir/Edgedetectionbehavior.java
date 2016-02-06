package levels.behavoir;

import Parcour.RobotConfig;
import Parcour.RobotControl;
import lejos.robotics.RegulatedMotor;
//import lejos.utility.Delay;

public class Edgedetectionbehavior {
	
//	public Edgedetectionbehavior(){
//		
//	}
	
	RobotConfig config = new RobotConfig();
	RobotControl robot = new RobotControl(config);
	private float olddistance = robot.getDistanceValue();
	private boolean isonedge = false;
	private float threshold = 0; // to define by what kind of situation the robot on the edge 
	//private float diameter = 1; //车轮的直径，单位是cm
	//private float pi = 3.1415926f;
	//private float starttime = 0;
  
	public void Turnthethirdmotor() {
		robot.turnancillayMotor(-45);
		config.getAncillaryMotor().waitComplete();
		robot.stopancillaryMotor();
	}

	public boolean detectEdge() {
        if ((robot.getDistanceValue() - olddistance) > threshold){
        	isonedge = true;
        }else{
        
        }
		return isonedge;
	}
	
	public void turnRobot(int angle){
		if(isonedge){
			//when the robot is on the edge turn right
			config.getLeftMotor().rotateTo(angle);
			config.getRightMotor().rotateTo(angle);
			config.getLeftMotor().waitComplete();
			config.getLeftMotor().waitComplete();
			//starttime = System.currentTimeMillis();
			//这里需要一个转角后让小车调整成直行函数
			this.Calibrationrobot(-angle);
		}else{
			robot.drive(300, 300);
		}
	}
	
  public void Calibrationrobot(int angle){
	  // -Angle
	  //float V = diameter * pi * config.getRightMotor().getSpeed();
	  config.getLeftMotor().synchronizeWith(new RegulatedMotor[]{config.getRightMotor()});
	  config.getLeftMotor().startSynchronization();
      while(robot.getDistanceValue() <= 0.02){
    	  robot.drive(200, 200);
      }
      // the robot will turn left 
      config.getLeftMotor().rotateTo(angle);
	  config.getRightMotor().rotateTo(angle);
	  while(true){
		  robot.drive(300, 300);
	  }
  }
	
	
}
