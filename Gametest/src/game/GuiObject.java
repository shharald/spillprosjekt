package game;

import java.awt.image.BufferedImage;

public class GuiObject {
	protected BufferedImage bi;
	protected double XLocation, YLocation = 0;
	
	
	public GuiObject() {
	}

	public void setBufferedImage (BufferedImage bi){
		this.bi = bi;
	}
	
	public BufferedImage getBufferedImage (){
		return bi;
	}
	
	public boolean setXLocation (double newXLocation){
		XLocation = newXLocation;
		return true;
	}
	
	public double getXLocation (){
		return XLocation;
	}
	
	public boolean setYLocation (double newYLocation){
		YLocation = newYLocation;
		return true;
	}

	public double getYLocation (){
		return YLocation;
	}	
}
