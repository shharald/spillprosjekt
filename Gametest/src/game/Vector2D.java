package game;

import java.lang.Math;

/**
 * A vector class which me and Arni are very proud of :)
 * We are considering sending an threatening mail to sun.
 * @author Vidar K Strat
 *
 */

public class Vector2D {
	private double theta;
	private double length;
	private double xCoordinate;
	private double yCoordinate;
	
	public Vector2D(double xTheta, double yLength, boolean isPolar){
		if(isPolar){
			this.setPolar(xTheta, yLength);
		} else {
			this.setCoordinate(xTheta, yLength);
		}
	}
	
	public void setCoordinate(double xCor, double yCor){
		this.xCoordinate = xCor;
		this.yCoordinate = yCor;
		this.theta = Math.atan2(yCor, xCor);
		if(this.theta < 0){
			this.theta += 2*Math.PI;
		}
		this.length = Math.sqrt((yCor*yCor)+(xCor*xCor));
	}
	
	public void setPolar(double theta, double length){
		this.length = length;
		this.theta = theta%(2*Math.PI);
		if(this.theta < 0){
			this.theta += Math.PI;
		}
		if(theta%(2*Math.PI) >= 0 && theta%2*Math.PI <= Math.PI/2){
			this.yCoordinate = length*Math.sin(theta);
			this.xCoordinate = length*Math.cos(theta);
		} else if(theta%(2*Math.PI) <= Math.PI){
			double tempTheta = Math.PI - theta;
			this.yCoordinate = length*Math.sin(tempTheta);
			this.xCoordinate = length*Math.cos(tempTheta);
		} else if(theta%(2*Math.PI) <= ((3/2)*Math.PI)){
			double tempTheta = theta - Math.PI;
			this.yCoordinate = length*Math.sin(tempTheta);
			this.xCoordinate = length*Math.cos(tempTheta);
		} else if(theta%(2*Math.PI) < 2*Math.PI){
			double tempTheta = 2*Math.PI - theta;
			this.yCoordinate = length*Math.sin(tempTheta);
			this.xCoordinate = length*Math.cos(tempTheta);
		}
		
	}

	public double getTheta() {
		return theta;
	}

	public double getLength() {
		return length;
	}

	public double getXCoordinate() {
		return xCoordinate;
	}

	public double getYCoordinate() {
		return yCoordinate;
	}
	
	public String toString(){
		return "X:" + this.xCoordinate + " Y:" + this.yCoordinate + " Theta:" + this.theta + " Length:" + this.length;
	}
}
