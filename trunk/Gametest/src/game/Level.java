package game;

import java.util.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Level {
	private List<Target> targets = new ArrayList<Target>();
	private String levelName;
	private GuiObject background;
	private GuiObject panel;
	private int yLocation, xLocation = 0;
	
	public Level (File file, LoadImages imageLoader, Player player) throws IOException{
		
		if(file == null){
			throw new IOException();
		}
		
		try{
			BufferedReader levelReader = new BufferedReader(new FileReader(file));
			this.setLocations();
			//Setting levelName
			this.levelName = levelReader.readLine();
			
			//Setting the background
			this.background = new GuiObject();
			this.background.setBufferedImage(imageLoader.getImage(this.levelName, levelReader.readLine()));
			//Setting the panel
			this.panel = new GuiObject();
			this.panel.setBufferedImage(imageLoader.getImage(this.levelName, levelReader.readLine()));
			
			//Getting the number of targets and setting the targets
			int antallTargets = (int) Integer.parseInt(levelReader.readLine());
			for(int i = 0; i < antallTargets; i++){
				String myString =  levelReader.readLine();
				BufferedImage myImage = imageLoader.getImage(this.levelName, levelReader.readLine());
				
				Target t = new Target(i, myString, myImage, xLocation, yLocation, player);
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
	
	private void setLocations() {
		int random = (int)(Math.random()*4);
		if (random < 2) {
			if (random < 1) xLocation = 600;
			else xLocation = 100;
			yLocation = (int)((Math.random()*500)+101);
		}
		else{
			if (random < 3) {
				yLocation = 600;
			}
			else yLocation = 100;
			xLocation = (int)((Math.random()*500)+101);
		}
		
	}
}
