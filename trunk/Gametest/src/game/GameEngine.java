package game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Object;

public class GameEngine implements Runnable {

	GameData gameData;
	List<GuiObject> guiObjects = new ArrayList<GuiObject>();
	boolean graphicsLoaded = false;
	
	public GameEngine (GameData gameData) {
		this.gameData = gameData;
	}
	
	public boolean getgraphicsLoaded (){
		return graphicsLoaded;
	}

	public void run() {
		graphicsLoaded = true;
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gameData.loadAllLevels();
		gameData.getPlayer().setXLocation(400);
		gameData.getPlayer().setYLocation(400);
		gameData.getPlayer().setBufferedImage(LoadImages.getImage("bane1", "player.png"));
		List<Thread> movingTargetThreads = new ArrayList<Thread>();
		for (int i = 0; i < gameData.getLevel(0).getTargets().size();i++){
			movingTargetThreads.add(new Thread(new MovingTarget(gameData.getLevel(0).getTargets().get(i), (int)(((Math.random()*1000)+30000)))));
		}
		gameData.setLevelOnScreen(gameData.getLevel(0));
		
//		System.out.println("Target: "+brett1.getTargets().get(0).getXLocation()+"x"+brett1.getTargets().get(0).getYLocation());
//		System.out.println("Target: "+brett1.getTargets().get(1).getXLocation()+"x"+brett1.getTargets().get(1).getYLocation());
//		System.out.println("Theta "+brett1.getTargets().get(0).getTheta());
//		System.out.println("Theta "+brett1.getTargets().get(1).getTheta());
		for (int i = 0; i < movingTargetThreads.size(); i++){
		movingTargetThreads.get(i).start();
		}
		try {
			for (int i = 0; i < movingTargetThreads.size(); i++) movingTargetThreads.get(i).join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	
	}
	
}