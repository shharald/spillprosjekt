package game;

import java.util.*;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Level {
	private List<Target> targets = new ArrayList<Target>();
	private String levelName;
	private GuiObject background;
	private GuiObject panel;
	
	public Level (File file, LoadImages imageLoader) throws IOException{
		
		if(file == null){
			throw new IOException();
		}
		
		try{
			BufferedReader levelReader = new BufferedReader(new FileReader(file));
			
			//Setting levelName
			this.levelName = levelReader.readLine();
			
			//Setting the background
			this.background = new GuiObject();
			this.background.setBufferedImage(imageLoader.getImage(levelReader.readLine()));
			
			//Setting the panel
			this.panel = new GuiObject();
			this.panel.setBufferedImage(imageLoader.getImage(levelReader.readLine()));
			
			//Getting the number of targets and setting the targets
			int antallTargets = (int) Integer.parseInt(levelReader.readLine());
			for(int i = 0; i < antallTargets; i++){
				this.targets.add(new Target(i, levelReader.readLine(), imageLoader.getImage(levelReader.readLine())));
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
