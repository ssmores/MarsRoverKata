package marsRover;

public class MarsRover {
	//A MarsRover robot has a location (x, y coordinates) and a direction.
	//It will also remember the plateau area in which it will navigate. 
	private int xCoordinate;
	private int yCoordinate;
	private String directionFacing;
	private int plateauLowerXCoor = 0;
	private int plateauLowerYCoor = 0;
	private int plateauUpperXCoor;
	private int plateauUpperYCoor;

	
	public int getxCordinate() {
		return xCoordinate;
	}
	
	public void setxCordinate(int xCordinate) {
		this.xCoordinate = xCordinate;
	}
	
	public int getyCordinate() {
		return yCoordinate;
	}
	
	public void setyCordinate(int yCordinate) {
		this.yCoordinate = yCordinate;
	}
	
	public String getDirectionFacing() {
		return directionFacing;
	}
	
	public void setDirectionFacing(String directionFacing) {
		this.directionFacing = directionFacing;
	}
	
	public int getPlateauLowerXCoor() {
		return plateauLowerXCoor;
	}
	
	public void setPlateauLowerXCoor(int plateauLowerXCoor) {
		this.plateauLowerXCoor = plateauLowerXCoor;
	}
	
	public int getPlateauLowerYCoor() {
		return plateauLowerYCoor;
	}
	
	public void setPlateauLowerYCoor(int plateauLowerYCoor) {
		this.plateauLowerYCoor = plateauLowerYCoor;
	}
	
	public int getPlateauUpperXCoor() {
		return plateauUpperXCoor;
	}
	
	public void setPlateauUpperXCoor(int plateauUpperXCoor) {
		this.plateauUpperXCoor = plateauUpperXCoor;
	}
	
	public int getPlateauUpperYCoor() {
		return plateauUpperYCoor;
	}
	
	public void setPlateauUpperYCoor(int plateauUpperYCoor) {
		this.plateauUpperYCoor = plateauUpperYCoor;
	}
	
	public void initializeRoverPosition(String[] initialLocation) {
		setxCordinate(Integer.parseInt(initialLocation[0]));
		setyCordinate(Integer.parseInt(initialLocation[1]));
		setDirectionFacing(initialLocation[2]);
	}
	
	public void explore(String movement) {
		for(char c : movement.toCharArray()) {
			if(c == 'M') {
				move();
			} else if(c == 'L') {
				turnLeft();
			} else if(c == 'R') {
				turnRight();	
			}
		}
	}

	private void turnRight() {
		//Turning right is a 90 degree turn clockwise.
		if(this.directionFacing.equals("N")) {
			this.directionFacing = "E";
		} else if(this.directionFacing.equals("E")) {
			this.directionFacing = "S";
		} else if(this.directionFacing.equals("S")) {
			this.directionFacing = "W";
		} else if(this.directionFacing.equals("W")) {
			this.directionFacing = "N";
		}
	}

	private void turnLeft() {
		//Turning left is a 90 degree turn counterclockwise.
		if(this.directionFacing.equals("N")) {
			this.directionFacing = "W";
		} else if(this.directionFacing.equals("E")) {
			this.directionFacing = "N";
		} else if(this.directionFacing.equals("S")) {
			this.directionFacing = "E";
		} else if(this.directionFacing.equals("W")) {
			this.directionFacing = "S";
		}
	}

	//Assumes rover will not fall off edge of plateau. If it's at an edge and is tasked to move forward, it will stay put.
	private void move() {
		if(this.directionFacing.equals("N") && this.yCoordinate < this.plateauUpperYCoor) {
			this.yCoordinate += 1;
		} else if(this.directionFacing.equals("S") && this.yCoordinate > this.plateauLowerYCoor) {
			this.yCoordinate -= 1;
		} else if(this.directionFacing.equals("E") && this.xCoordinate < this.plateauUpperXCoor) {
			this.xCoordinate += 1;
		} else if(this.directionFacing.equals("W") && this.xCoordinate > this.plateauLowerXCoor) {
			this.xCoordinate -= 1;
		}
	}
	
}
