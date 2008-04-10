package game;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class LoadImages {
	private BufferedImage loadedimage;
	
//	public GuiObject getGuiObjectWithBufferedImage(){
//		try {
//			loadedimage = ImageIO.read( new File( "M:/workspace/Gametest/images/venus100100.png" ) );
//			guiObject = new GuiObject(loadedimage);
//			System.out.println("Lastet bilde. "+guiObject.getBufferedImage().getHeight()+"x"+guiObject.getBufferedImage().getHeight());
//		} catch (Exception e) {
//			System.out.println("Lastet ikke bilde");
//		}	
//		return guiObject;
//	}
	
//	public GuiObject getGuiObjectWithBufferedImageBG(){		
//		try {
//			loadedimage = ImageIO.read( new File( "M:/workspace/Gametest/images/space4.jpg" ) );
//			guiObject = new GuiObject(loadedimage);
//			System.out.println("Lastet bilde. "+guiObject.getBufferedImage().getHeight()+"x"+guiObject.getBufferedImage().getWidth());
//		} catch (Exception e) {
//			System.out.println("Lastet ikke bilde");
//		}	
//		return guiObject;
//	}
	
	public BufferedImage getImage(String filename){		
		try {
			loadedimage = ImageIO.read( new File( "images/" + filename ) );
			System.out.println("Lastet bilde " + filename);
		} catch (Exception e) {
			System.out.println("Lastet ikke bilde " + filename);
		}	
		return loadedimage;
	}
//	public BufferedImage getTarget(int level, int targetNumber){
//		try {
//			loadedimage = ImageIO.read( new File( "images/venus100100.png" ) );
//		System.out.println("Lastet planet");
//		} catch (Exception e) {
//			System.out.println("Lastet ikke planet");
//		}	
//		return loadedimage;
//	}
//	
//	public BufferedImage getPanel(int level){
//		try {
//			loadedimage = ImageIO.read( new File( "images/panel.png" ) );
//		System.out.println("Lastet panel.");
//		} catch (Exception e) {
//			System.out.println("Lastet ikke panel");
//		}	
//		return loadedimage;
//	}
//	
//	public static BufferedImage transPNG(){		
//		try {
//			loadedimage = ImageIO.read( new File( "M:/workspace/Gametest/images/rgba16.png" ) );
//		System.out.println("Lastet PNG");
//		} catch (Exception e) {
//			System.out.println("Lastet ikke PNG");
//		}	
//		return loadedimage;
//	}
}
