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
//		gameData.loadAllLevels();
		System.out.println("antall lvler: " + gameData.getNumberOfLevels());
		gameData.getPlayer().setPlayerName("Spiller");
		gameData.getPlayer().setXLocation(450);
		gameData.getPlayer().setYLocation(450);
		gameData.getPlayer().setBufferedImage(LoadImages.getImage("eksempel", "player.png"));
		for (int j = 0; j < gameData.getNumberOfLevels(); j++){
			List<Thread> movingTargetThreads = new ArrayList<Thread>();
			for (int i = 0; i < gameData.getLevel(j).getTargets().size();i++){
				movingTargetThreads.add(new Thread(new MovingTarget(gameData.getLevel(j).getTargets().get(i), (int)(((Math.random()*1000)+10000)), gameData)));
			}
			gameData.setLevelOnScreen(gameData.getLevel(j));
			
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
			//starting threads in order
			for (int i = 0; i < order.length; i++){
				movingTargetThreads.get(order[i]).start();
				gameData.getLevel(j).getTargets().get(order[i]).setStatus(1);
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
		GameGui.stop();
		UpdateHighScore.update(gameData.getPlayer(), gameData.getHighScore());
		UpdateHighScore.commit(gameData.getHighScore());
		Engine gameMenu = new Engine(gameData);
		Thread menu = new Thread(gameMenu);
		menu.start();
	}
	
}