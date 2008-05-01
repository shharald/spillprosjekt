package game;

//import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
//import java.awt.image.BufferedImageOp;
import java.io.File;

import javax.imageio.ImageIO;

public abstract class GraphicsButton{
	
	protected BufferedImage image;
	protected BufferedImage imagePressed;
	protected int xLocation;
	protected int yLocation;
	protected String name;
	protected boolean pressed;
	
	public GraphicsButton(String name, int xLocation, int yLocation, String imageFileName, String imageFileNamePressed){
		this.name = name;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.setImage(imageFileName);
		this.setImagePressed(imageFileNamePressed);
		System.out.println("The button " + name + " was sucsessfully created!");
	}
	
	public void setImage(String fileName){
		try{
			this.image = ImageIO.read( new File( "resources/" + fileName));
		} catch(Exception e){
			System.out.println("Could not load the picture " + fileName + " into the button " + name);
		}
	}
	
	public void setImagePressed(String fileNamePressed){
		try{
			this.imagePressed = ImageIO.read( new File( "resources/" + fileNamePressed));
		} catch(Exception e){
			System.out.println("Could not load the picture " + fileNamePressed + " into the button " + name);
		}
	}
	
	public BufferedImage getImage(){
		return this.image;
	}
		
	public int getXLocation() {
		return xLocation;
	}

	public void setXLocation(int location) {
		xLocation = location;
	}

	public int getYLocation() {
		return yLocation;
	}

	public void setYLocation(int location) {
		yLocation = location;
	}
	
	public void setPressed(boolean pressed){
		this.pressed = pressed;
	}

	public boolean contains(int x, int y){
		if((x > (this.getXLocation()) &&  
				(x < (this.getXLocation() + this.getImage().getWidth())) &&
				(y < (this.getYLocation() + this.getImage().getHeight())) &&
				(y > (this.getYLocation()))))
			{
				return true;
			}
		
		
		return false;
	}
	
	public void paint(Graphics2D g){
		if(!pressed){
			g.drawImage(this.image, null, this.xLocation, this.yLocation);
		} else {
			g.drawImage(this.imagePressed, null, this.xLocation, this.yLocation);
		}
		System.out.println(this.pressed);
	}
	
	public String toString(){
		return this.name;
	}
	
	public abstract void clicked();
}
