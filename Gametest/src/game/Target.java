package game;

import java.awt.image.BufferedImage;

public class Target extends GuiObject{


	private int targetNumber;
	private String stringToWrite;
	private int speedOfObject = 1;
	private int pointsForClear = 1000;
	private int status = 0;
	private Vector2D vector; 
	private Player player;
	
	
	public Target(int targetNumber, String stringToWrite, BufferedImage image, int xLocation, int yLocation, Player player) {
		super();
		this.XLocation = xLocation;
		this.YLocation = yLocation;
		bi = image;
		this.stringToWrite = stringToWrite;
		this.targetNumber = targetNumber;
		this.player = player;
		this.createVector(player);
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
	
	public void createVector (Player player) {
		vector = new Vector2D(player.getXLocation()-this.XLocation, player.getYLocation()-this.YLocation, false);
	}
	
	public double getTheta () {
		return vector.getTheta();
	}
	
	public double getLength () {
		return vector.getLength();
	}

	public double getXCoordinate() {
		return vector.getXCoordinate();
	}
	
	public double getYCoordinate() {
		return vector.getYCoordinate();
	}
	
	public void increasePolar (double thetaIncrease, double lenghtIncrease) {
		vector.setPolar(vector.getTheta()+thetaIncrease, vector.getLength()+lenghtIncrease);
		this.setXLocation(player.getXLocation()+vector.getXCoordinate());
		this.setYLocation(player.getYLocation()+vector.getYCoordinate());
		//System.out.println(this.getXLocation());
		//System.out.println(vector.toString());
	}
	
}