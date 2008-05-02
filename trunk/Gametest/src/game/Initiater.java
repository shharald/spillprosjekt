package game;

/**
 * 
 * 
 * @author Per Arne Vidar Sjønøst, Harald Schmidt-Horix, Sondre Morten Steen, Vidar Kristoffer Strat
 *
 */

public class Initiater {
    
	private static GameData gameData = new GameData();
    
	public static void main(String[] args) {
		Engine gameMenu = new Engine(gameData);
		Thread menu = new Thread(gameMenu);
		menu.start();
		gameData.loadMenu();
		gameData.loadHighScore();
		gameData.setObjectsOnScreen(gameData.getMenu());
		gameData.loadAllLevels();
		
		/*
		while (game.isAlive() || gui.isAlive()){
			if (!gui.isAlive() && gameEngine.getgraphicsLoaded()) {
				gui.start();
				System.out.println("starter gui");
			}
			if (!game.isAlive()) {
				System.out.println("game ikke lenger i live, stopper gui");
				gameGui.stop();
			}
			try {
	         	Thread.sleep((int) 100);
			} catch (InterruptedException e) {}
		}*/
	 }
}
