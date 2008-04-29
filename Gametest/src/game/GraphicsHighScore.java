package game;

import java.awt.Graphics2D;

import javax.swing.JLabel;

public class GraphicsHighScore {

	protected int xLocation;
	protected int yLocation;
	protected String string;
	
	public GraphicsHighScore(String string, int xLocation, int yLocation){
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.string = string;
	}
	
	public void paint(Graphics2D g){
			g.drawString(string, xLocation, yLocation);
	}
	
}
