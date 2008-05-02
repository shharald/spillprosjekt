package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

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
			g.setFont(new Font("Arial", Font.BOLD, 30));
			Color temp = g.getColor();
			g.setColor(Color.WHITE);
			g.drawString(string, xLocation, yLocation);
			g.setColor(temp);
	}
	
}
