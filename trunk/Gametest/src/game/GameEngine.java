package game;

import java.util.ArrayList;
import java.util.List;

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
			Thread.sleep(500);
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
			movingTargetThreads.add(new Thread(new MovingTarget(gameData.getLevel(0).getTargets().get(i), (int)(((Math.random()*1000)+10000)))));
		}
		gameData.setLevelOnScreen(gameData.getLevel(0));

//		for (int i = 0; i < movingTargetThreads.size(); i++){
//			movingTargetThreads.get(i).start();
//		}
		
		//makes an order
		int[] order = new int [movingTargetThreads.size()];
		for(int i = 0; i < order.length; i++){	
			order[i] = i;
		}
		
		//shuffles
		for(int i = 0; i < 500; i++){
			int one = (int)(Math.random()*movingTargetThreads.size());
			int other = (int)(Math.random()*movingTargetThreads.size());
			int temp = order[one];
			order[one] = order[other];
			order[other] = temp;
		}
		for (int i = 0; i < order.length; i++){
			movingTargetThreads.get(order[i]).start();
			try {
				movingTargetThreads.get(order[i]).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
		try {
			for (int i = 0; i < movingTargetThreads.size(); i++) movingTargetThreads.get(i).join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	
	}
	
}