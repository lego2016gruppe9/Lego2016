package Parcour;

//import levels.FollowLine;
//import levels.behavoir.Barcode;

//import levels.FollowLine;
import levels.Maze;


public class Main {
	public static void main(String[] args) {
		RobotConfig config = new RobotConfig();
		RobotControl robot = new RobotControl(config);
		//FollowLine line = new FollowLine(robot);
		//Barcode barcode = new Barcode();
		Maze maze = new Maze(robot) ;
	
	}

}
