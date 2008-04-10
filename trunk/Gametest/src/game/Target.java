package game;

import java.awt.image.BufferedImage;

public class Target extends GuiObject{


	private int targetNumber;
	private String stringToWrite;
	private int speedOfObject = 1;
	private int pointsForClear = 1000;
	private int status = 0;
	
	
	public Target(int targetNumber, String stringToWrite, BufferedImage image) {
		super();
		bi = image;
		this.stringToWrite = stringToWrite;
		this.targetNumber = targetNumber;
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
	
	public int getTargetNumber() {
		return targetNumber;
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

