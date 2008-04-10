package game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameEngine implements Runnable {

	List<GuiObject> guiObjects = new ArrayList<GuiObject>();
	boolean graphicsLoaded = false;
	
	public GameEngine (List<GuiObject> guiObjects) {
		this.guiObjects = guiObjects;
	}
	
	public boolean getgraphicsLoaded (){
		return graphicsLoaded;
	}

	public void run() {
		LoadImages loadImages = new LoadImages();
		File file = new File("resources/eksempel.lvl");
		Level brett1;
		Player kalle = new Player();
		kalle.setBufferedImage(loadImages.getImage("eksempel", "player.png"));
		try {
			brett1 = new Level(file, loadImages);
			guiObjects.add(brett1.getBackground());
			guiObjects.add(brett1.getTargets().get(0));
			guiObjects.add(kalle);
			guiObjects.add(brett1.getPanel());
			brett1.getTargets().get(1).setXLocation(350);
			brett1.getTargets().get(1).setYLocation(350);
			graphicsLoaded = true;
			
			//POLARKOORDINATER
			kalle.setXLocation(100);
			kalle.setYLocation(500);
			brett1.getTargets().get(0).setXLocation(200);
			brett1.getTargets().get(0).setYLocation(300);
			
			
			System.out.println("Target: "+brett1.getTargets().get(0).getXLocation()+"x"+brett1.getTargets().get(0).getYLocation());
			System.out.println("Player: "+kalle.getXLocation()+"x"+kalle.getYLocation());
			
			Vektor2D = 
			double theta = Math.atan2(, arg1)
			
			
			
//			double radioslol = 3;
//			for (int i = -900; i < 3000; i++) {
//				brett1.getTargets().get(0).setXLocation(brett1.getTargets().get(0).getXLocation()+(1*radioslol*((Math.sin((double)(i*((2*Math.PI)/300)))))));
//				brett1.getTargets().get(0).setYLocation(brett1.getTargets().get(0).getYLocation()+(1*radioslol*((Math.cos((double)(i*((2*Math.PI)/300)))))));
//				radioslol = radioslol * 0.999; 
//				try {
//		         	Thread.sleep((int) 2);
//		         } catch (InterruptedException e) {}
//			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	
}