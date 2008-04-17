package game;

/**
 * This LoadLevels class is a class both me and Arni are very proud of :)
 * 
 * @author Vidar K Strat
 */

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Load {


	public static List<Level> LoadLevels(Player player){
	    List<Level> levels = new ArrayList<Level>();
		File resources = new File("resources");
		String [] levelNames = resources.list();
		for(int i = 0; i < levelNames.length; i++){
			if(levelNames[i].endsWith(".lvl")){
				try{
					levels.add(new Level(new File("resources/"+levelNames[i]), player));
					System.out.println("Level: "+ levelNames[i] + " was loaded sucsessfully");
				} catch (Exception e){
					System.out.println("Det er skjedd en feil under innlasting av " + levelNames[i]);
				}
			}
		}
		return levels;
	}
	
	public static List<GuiObject> LoadMenu() {
		 List<GuiObject> menu = new ArrayList<GuiObject>();
		 menu.add(new GuiObject());
		 menu.get(0).setBufferedImage(LoadImages.getMenu("menu.png"));
		 return menu;
		
	}
}
