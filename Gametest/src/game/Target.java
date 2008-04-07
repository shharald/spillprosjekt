package game;

public class Target extends GuiObject{

	private String stringToWrite;
	private int speedOfObject = 1;
	private int pointsForClear = 1000;
	private int status = 0;
	
	
	public Target(int level, int targetNumber) {

		if (level == 1) {
			if (targetNumber == 1) stringToWrite = "Merkur";
			if (targetNumber == 2) stringToWrite = "Venus";
			if (targetNumber == 3) stringToWrite = "Tellus";
			if (targetNumber == 4) stringToWrite = "Mars";
			if (targetNumber == 5) stringToWrite = "Jupiter";
			if (targetNumber == 6) stringToWrite = "Saturn";
			if (targetNumber == 7) stringToWrite = "Uranus";
			if (targetNumber == 8) stringToWrite = "Neptun";
		}
	} 
	
	public String getStringToWrite () {
		return stringToWrite;
	}

	public int getSpeedOfObject() {
		return speedOfObject;
	}

	public void setSpeedOfObject(int speedOfObject) {
		this.speedOfObject = speedOfObject;
	}

	public int getPointsForClear() {
		return pointsForClear;
	}

	public void setPointsForClear(int pointsForClear) {
		this.pointsForClear = pointsForClear;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
