package game;

/**
 * This LoadLevels class is a class both me and Arni are very proud of :)
 * 
 * @author Vidar K Strat
 */

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class LoadLevels {
	private List<Level> levels = new ArrayList<Level>();

	public LoadLevels(LoadImages imageLoader, Player player){
		File resources = new File("resources");
		String [] levelNames = resources.list();
		for(int i = 0; i < levelNames.length; i++){
			if(levelNames[i].endsWith(".lvl")){
				try{
					levels.add(new Level(new File("resources/"+levelNames[i]), imageLoader, player));
					System.out.println("Level: "+ levelNames[i] + " was loaded sucsessfully");
				} catch (Exception e){
					System.out.println("Det er skjedd en feil under innlasting av " + levelNames[i]);
				}
			}
		}
	}

}
