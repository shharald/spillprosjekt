package game;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    private static List<GuiObject> guiObjects = new ArrayList<GuiObject>();

    
	public static void main(String[] args) {
		LoadImages loadImages = new LoadImages(); 
		GuiObject bakgrunn = new GuiObject();
		bakgrunn.setBufferedImage(loadImages.getBG(1));
		GuiObject panel = new GuiObject();
		panel.setBufferedImage(loadImages.getPanel(1));
		GuiObject bilde1 = new Target(1,1);
		bilde1.setXLocation(-50);
		bilde1.setYLocation(-50);
		bilde1.setBufferedImage(loadImages.getTarget(1,1));
		GuiObject bilde2 = new Target(1,1);
		bilde2.setXLocation(1000);
		bilde2.setYLocation(-50);
		bilde2.setBufferedImage(loadImages.getTarget(1,1));
		GuiObject bilde3 = new Target(1,1);
		bilde3.setXLocation(-50);
		bilde3.setYLocation(1000);
		bilde3.setBufferedImage(loadImages.getTarget(1,1));
		GuiObject bilde4 = new Target(1,1);
		bilde4.setXLocation(1000);
		bilde4.setYLocation(1000);
		bilde4.setBufferedImage(loadImages.getTarget(1,1));
		guiObjects.add(bakgrunn);
		guiObjects.add(bilde1);
		guiObjects.add(panel);
		GameGui gameGui = new GameGui(guiObjects);
		Thread gui = new Thread(gameGui);
		gui.start();
        try {
         	Thread.sleep((int) 1000);
         } catch (InterruptedException e) {}
		
		for (int i = 0; i < 1000; i++) {
			bilde1.setXLocation(bilde1.getXLocation()+1);
			bilde1.setYLocation(bilde1.getYLocation()+1);
			bilde2.setXLocation(bilde2.getXLocation()-1);
			bilde2.setYLocation(bilde2.getYLocation()+1);
			bilde3.setXLocation(bilde3.getXLocation()+1);
			bilde3.setYLocation(bilde3.getYLocation()-1);
			bilde4.setXLocation(bilde4.getXLocation()-1);
			bilde4.setYLocation(bilde4.getYLocation()-1);
	        try {
	         	Thread.sleep((int) 10);
	         } catch (InterruptedException e) {}
		}
		
	 }
	

	

}
