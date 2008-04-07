package game;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class LoadImages {
	private BufferedImage loadedimage;
	
	public BufferedImage getBG(int level){		
		try {
			loadedimage = ImageIO.read( new File( "M:/workspace/Gametest/images/bg.png" ) );
		System.out.println("Lastet bakgrunn");
		} catch (Exception e) {
			System.out.println("Lastet ikke bakgrunn");
		}	
		return loadedimage;
	}
	public BufferedImage getTarget(int level, int targetNumber){
		try {
			loadedimage = ImageIO.read( new File( "M:/workspace/Gametest/images/venus100100.png" ) );
		System.out.println("Lastet planet");
		} catch (Exception e) {
			System.out.println("Lastet ikke planet");
		}	
		return loadedimage;
	}
	
	public BufferedImage getPanel(int level){
		try {
			loadedimage = ImageIO.read( new File( "M:/workspace/Gametest/images/panel.png" ) );
		System.out.println("Lastet panel.");
		} catch (Exception e) {
			System.out.println("Lastet ikke panel");
		}	
		return loadedimage;
	}
}