package game;

import java.util.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Level {
	private List<Target> targets = new ArrayList<Target>();
	private String levelName;
	private GuiObject background;
	private GuiObject panel;
	
	public Level (File file, Player player) throws IOException{
		
		if(file == null){
			throw new IOException();
		}
		
		try{
			BufferedReader levelReader = new BufferedReader(new FileReader(file));
			//Setting levelName
			this.levelName = levelReader.readLine();
			
			//Setting the background
			this.background = new GuiObject();
			this.background.setBufferedImage(LoadImages.getImage(this.levelName, levelReader.readLine()));
			//Setting the panel
			this.panel = new GuiObject();
			this.panel.setBufferedImage(LoadImages.getImage(this.levelName, levelReader.readLine()));
			
			//Getting the number of targets and setting the targets
			int antallTargets = (int) Integer.parseInt(levelReader.readLine());
			for(int i = 0; i < antallTargets; i++){
				String myString =  levelReader.readLine();
				BufferedImage myImage = LoadImages.getImage(this.levelName, levelReader.readLine());
				Target t = new Target(i, myString, myImage, (double)(Math.random()*((4*Math.PI))), player);
				this.targets.add(t);
			}
			
		} catch (Exception e){
			System.err.println(e);
		}
	}
	
	public List<Target> getTargets() {
		return this.targets;
	}
	
	public String getLevelName() {
		return levelName;
	}
	public GuiObject getBackground() {
		return background;
	}
	public GuiObject getPanel() {
		return panel;	
	}
}
