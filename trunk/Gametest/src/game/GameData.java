package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameData {
	private GameFrame mainFrame;
	private List<Level> levels = new ArrayList<Level>();
	private List<GuiObject> menu = new ArrayList<GuiObject>();
	private Player player = new Player();
    private List<GuiObject> objectsOnScreen = new ArrayList<GuiObject>();
    private String currentLine = "";
	private List<HighScoreEntity> highScore;
    
	public void loadAllLevels() {
		levels = Load.LoadLevels(player);
	}
	
	public void loadMenu() {
		menu = Load.LoadMenu();
	}
	
	public void loadHighScore(){
		highScore = Load.LoadHighScore();
	}
	
	public Level getLevel(int levelNr) {
		return levels.get(levelNr);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setObjectsOnScreen(List<GuiObject> guiObjects) {
		objectsOnScreen.clear();
		for(GuiObject g: guiObjects){
			objectsOnScreen.add(g);
		}
		
	}
	
	public void setLevelOnScreen(Level level){
		objectsOnScreen.clear();
		objectsOnScreen.add(level.getBackground());
		for (Target g: level.getTargets()){
			objectsOnScreen.add(g);
		}
		objectsOnScreen.add(level.getPanel());		
	}
	
	public List<GuiObject> getObjectsOnScreen() {
		return objectsOnScreen;
	}
	
	public List<GuiObject> getMenu (){
		return menu;
	}

	public String getCurrentLine() {
		return mainFrame.getCurrentLine();
	}

	/*public void setCurrentLine(String currentLine) {
		String s = this.currentLine;
		if ((this.currentLine.equals("exit"))) {
			exitGame();
		}
		this.currentLine = currentLine.trim();
		this.currentLine = this.currentLine.toLowerCase();
		
		if (!(this.currentLine.equals(s))) {
			checkString();
		}
	}
	
	
	*/
	
	public void exitGame() {
		for (GuiObject g: getObjectsOnScreen()){
			if ((g instanceof Target)) {
				((Target)g).setStatus(0);
			}
			
		}
	}

	public GameFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(GameFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public int getNumberOfLevels() {
		return levels.size();
	}
}
