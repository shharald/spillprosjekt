package game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Object;

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
		List<Thread> movingTargetThreads = new ArrayList<Thread>();
		LoadImages loadImages = new LoadImages();
		File file = new File("resources/eksempel.lvl");
		Level brett1;
		Player kalle = new Player();
		kalle.setXLocation(450);
		kalle.setYLocation(450);
		kalle.setBufferedImage(loadImages.getImage("eksempel", "player.png"));
		try {
			brett1 = new Level(file, loadImages, kalle);
			guiObjects.add(brett1.getBackground());
			for (int i = 0; i < brett1.getTargets().size();i++){
				guiObjects.add(brett1.getTargets().get(i));
				movingTargetThreads.add(new Thread(new MovingTarget(brett1.getTargets().get(i), (int)(((Math.random()*6000)+6000)))));
			}
			guiObjects.add(kalle);
			guiObjects.add(brett1.getPanel());
			graphicsLoaded = true;
			
			System.out.println("Target: "+brett1.getTargets().get(0).getXLocation()+"x"+brett1.getTargets().get(0).getYLocation());
			System.out.println("Target: "+brett1.getTargets().get(1).getXLocation()+"x"+brett1.getTargets().get(1).getYLocation());
			System.out.println("Player: "+kalle.getXLocation()+"x"+kalle.getYLocation());
			System.out.println("Theta "+brett1.getTargets().get(0).getTheta());
			System.out.println("Theta "+brett1.getTargets().get(1).getTheta());
			for (int i = 0; i < movingTargetThreads.size(); i++){
			movingTargetThreads.get(i).start();
			}
			try {
				for (int i = 0; i < movingTargetThreads.size(); i++) movingTargetThreads.get(i).join();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	
}