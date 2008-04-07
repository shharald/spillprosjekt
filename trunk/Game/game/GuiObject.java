package game;

import java.awt.image.BufferedImage;

public class GuiObject {
	protected BufferedImage bi;
	private int XLocation, YLocation = 0;
	
	
	public GuiObject() {
	}

	public void setBufferedImage (BufferedImage bi){
		this.bi = bi;
	}
	
	public BufferedImage getBufferedImage (){
		return bi;
	}
	
	public boolean setXLocation (int newXLocation){
		XLocation = newXLocation;
		return true;
	}
	
	public int getXLocation (){
		return XLocation;
	}
	
	public boolean setYLocation (int newYLocation){
		YLocation = newYLocation;
		return true;
	}

	public int getYLocation (){
		return YLocation;
	}
	
}
