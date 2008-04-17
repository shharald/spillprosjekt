package game;

public class Initiater {
    private static GameData gameData = new GameData();
    
	public static void main(String[] args) {
		gameData.loadMenu();
		gameData.setObjectsOnScreen(gameData.getMenu());
		GameGui gameGui = new GameGui(gameData);
		GameEngine gameEngine = new GameEngine(gameData);
		Thread gui = new Thread(gameGui);
		Thread game = new Thread(gameEngine);
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
