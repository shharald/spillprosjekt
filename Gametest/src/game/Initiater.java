package game;

public class Initiater {
    private static GameData gameData = new GameData();
    
	public static void main(String[] args) {
		gameData.loadMenu();
		gameData.loadHighScore();
		gameData.setObjectsOnScreen(gameData.getMenu());
		GameGui gameGui = new GameGui(gameData);
		GameEngine gameEngine = new GameEngine(gameData);
		GameMenu gameMenu = new GameMenu(gameData);
		
		Thread gui = new Thread(gameGui);
		Thread menu = new Thread(gameMenu);
		Thread game = new Thread(gameEngine);
		menu.start();
		menu.join();
		game.start();
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
		}
	 }
}
