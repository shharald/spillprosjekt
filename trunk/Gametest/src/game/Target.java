package game;

import java.awt.image.BufferedImage;

public class Target extends GuiObject{


	private int targetNumber;
	private String stringToWrite;
	private int speedOfObject = 1;
	private int pointsForClear = 100000;
	private int status = 2;
	private Vector2D vector; 
	private Player player;
	private double theta;
	
	
	public Target(int targetNumber, String stringToWrite, BufferedImage image, double theta, Player player) {
		super();
		this.theta = theta;
		super.bi = image;
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


	}
	
	public void createVector (Player player) {
		this.vector = new Vector2D(theta, (double)450, true);
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

	public void setPlayer(Player player) {
		this.player = player;
	}
	public Player getPlayer() {
		return player;
	}

	public Vector2D getVector() {
		return vector;
	}

	public void setVector(Vector2D vector) {
		this.vector = vector;
	}
	
}