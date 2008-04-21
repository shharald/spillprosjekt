package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameData {
	private List<Level> levels = new ArrayList<Level>();
	private List<GuiObject> menu = new ArrayList<GuiObject>();
	private Player player = new Player();
    private List<GuiObject> objectsOnScreen = new ArrayList<GuiObject>();
    private String currentLine = "";
	
	public void loadAllLevels() {
	levels = Load.LoadLevels(player);
	}
	
	public void loadMenu() {
	menu = Load.LoadMenu();
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
		return currentLine;
	}

	public void setCurrentLine(String currentLine) {
		String s = this.currentLine;
		this.currentLine = currentLine.trim();
		this.currentLine = this.currentLine.toLowerCase();
		if (!(this.currentLine.equals(s))) {
			checkString();
		}
	}
	
	public void checkString () { 
		for (GuiObject g: getObjectsOnScreen()){
			if ((g instanceof Target) && (((Target)g).getStatus() == 1 )) {
				if (this.currentLine.equals(((Target)g).getStringToWrite().toLowerCase())) {
					System.out.println("Setter "+((Target)g).getStringToWrite()+" til 0");
					((Target)g).setStatus(0);
				}
			}
		}
	}
}
