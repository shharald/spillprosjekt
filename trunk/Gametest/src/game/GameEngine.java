package game;

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
		GuiObject bakgrunn = new GuiObject();
		bakgrunn.setBufferedImage(loadImages.getBG(1));
		guiObjects.add(bakgrunn);
		GuiObject panel = new GuiObject();
		panel.setBufferedImage(loadImages.getPanel(1));
		GuiObject bilde1 = new Target(1,1);
		bilde1.setXLocation(-50);
		bilde1.setYLocation(-50);
		bilde1.setBufferedImage(loadImages.getTarget(1,1));
		GuiObject bilde2 = new Target(1,1);
		bilde2.setXLocation(-50);
		bilde2.setYLocation(-50);
		bilde2.setBufferedImage(loadImages.getTarget(1,1));
		guiObjects.add(bakgrunn);
		guiObjects.add(bilde1);
		guiObjects.add(bilde2);
		guiObjects.add(panel);
		bilde1.setXLocation(250);
		bilde1.setYLocation(350);
		bilde2.setXLocation(350);
		bilde2.setYLocation(350);
		System.out.println(Math.cos(Math.PI));
		System.out.println(Math.cos(300*((2*Math.PI)/300)));
		graphicsLoaded = true;
		double radioslol = 3;
			for (int i = -900; i < 3000; i++) {
				bilde1.setXLocation(bilde1.getXLocation()+(1*radioslol*((Math.sin((double)(i*((2*Math.PI)/300)))))));
				bilde1.setYLocation(bilde1.getYLocation()+(1*radioslol*((Math.cos((double)(i*((2*Math.PI)/300)))))));
				bilde2.setXLocation(bilde2.getXLocation()-(1*radioslol*((Math.sin((double)(i*((2*Math.PI)/300)))))));
				bilde2.setYLocation(bilde2.getYLocation()-(1*radioslol*((Math.cos((double)(i*((2*Math.PI)/300)))))));
				radioslol = radioslol * 0.999; 
				try {
		         	Thread.sleep((int) 2);
		         } catch (InterruptedException e) {}
			}
	}
	
}