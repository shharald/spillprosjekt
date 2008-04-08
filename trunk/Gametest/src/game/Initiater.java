package game;

import java.util.ArrayList;
import java.util.List;

public class Initiater {
    private static List<GuiObject> guiObjects = new ArrayList<GuiObject>();

    
	public static void main(String[] args) {

		GameGui gameGui = new GameGui(guiObjects);
		GameEngine gameEngine = new GameEngine(guiObjects);
		Thread gui = new Thread(gameGui);
		Thread game = new Thread(gameEngine);
		gui.start();
		game.start();
		while (game.isAlive() || gui.isAlive()){
			if (!game.isAlive()) {
				System.out.println("game ikke lenger i live, stopper gui");
				gameGui.stop();
			}
			if (!gui.isAlive()) {
				game.interrupt();
				System.out.println("gui ikke lenger i live, stopper game");
			}
			try {
	         	Thread.sleep((int) 100);
	         } catch (InterruptedException e) {}
		}
	 }
}
