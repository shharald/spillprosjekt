package game;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class GameGui implements Runnable {
  
	GameData gameData;
	GameFrame mainFrame;
	List<GuiObject> guiObjects = new ArrayList<GuiObject>();
	GraphicsDevice device = null;
	DisplayMode currentDisplayMode = null;
	DisplayMode modeToPaint = null;
	DisplayMode nativeMode = new DisplayMode(1280,1024,32,0);
	int offset = 0;
	boolean run = true;
	double xRatio = 1;
	double yRatio = 1;
	
	//debug stuff
	boolean debug = true;
    long fpsCounter = 1;
    long frameDrawStart = 0;
    long frameDrawStop = 0;
    String str = "";
	
    private static Color[] COLORS = new Color[] {
        Color.red, Color.blue, Color.green, Color.white, Color.black,
        Color.yellow, Color.gray, Color.cyan, Color.pink, Color.lightGray,
        Color.magenta, Color.orange, Color.darkGray };
    

    
    public GameGui(GameData gameData) {
    	this.gameData = gameData;
	    GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    device = env.getDefaultScreenDevice();	
    	currentDisplayMode = device.getDisplayMode();
    	if(currentDisplayMode.equals(nativeMode)) modeToPaint = nativeMode;
    	else {
	    	modeToPaint  = new DisplayMode((int)(device.getDisplayMode().getHeight()/3)*4,device.getDisplayMode().getHeight(),device.getDisplayMode().getBitDepth(),0);
	    	offset = (int)(currentDisplayMode.getWidth()+-modeToPaint.getWidth())/2;
	    	xRatio = (double)modeToPaint.getWidth()/1280; // 0.8
	    	yRatio = (double)modeToPaint.getHeight()/1024; //
	    }
    }

    public void doshit (){
		try {
	        GraphicsConfiguration gc = device.getDefaultConfiguration();
	        mainFrame = new GameFrame(gc);
	        mainFrame.setUndecorated(true);
	        mainFrame.setIgnoreRepaint(true);
	        device.setFullScreenWindow(mainFrame);
	        if (debug) {
		        System.out.println(currentDisplayMode.getHeight()+"x"+currentDisplayMode.getWidth());
		        System.out.println(modeToPaint.getHeight()+"x"+modeToPaint.getWidth());
		        System.out.println("Offset: "+offset+" Ratio: "+xRatio+" Ratio: "+yRatio);
	        }
	        mainFrame.createBufferStrategy(4);
	        BufferStrategy bufferStrategy = mainFrame.getBufferStrategy();
	        Graphics g = bufferStrategy.getDrawGraphics();
	        g.translate(offset, 0);
	        while(run) {
	    		gameData.setCurrentLine(mainFrame.getCurrentLine());
	                if (!bufferStrategy.contentsLost()) {
	                	if (debug) {
		                	if (fpsCounter!=0) {
		                		fpsCounter = 1000/fpsCounter;
		                	}
		                	str = "FPS: "+String.valueOf(fpsCounter);
	                	}
	                	// Iterate over en greie med alle guiObjects ELLER
	                	// Tegn bakgrunn
	                	// Tegn targets
	                 	for(GuiObject go:gameData.getObjectsOnScreen()){
	                 		if ((go instanceof Target) && (((Target)go).getStatus() != 1)){
	                 			continue;
	                 		}
	                 		g.drawImage(go.getBufferedImage(), (int)(go.getXLocation()*xRatio), (int)(go.getYLocation()*yRatio), (int) ((go.getXLocation()+go.getBufferedImage().getWidth())*xRatio), (int)((go.getYLocation()+go.getBufferedImage().getHeight())*yRatio), 
	                 				0, 0, go.getBufferedImage().getWidth(), go.getBufferedImage().getHeight(), null);
	                 	}
	                 	g.setColor(COLORS[5]);
	            		if (offset > 0){
	            			g.fillRect(-offset, 0, offset, modeToPaint.getHeight());
	            			g.fillRect(modeToPaint.getWidth(), 0, offset, modeToPaint.getWidth());
	            		}
	                 	// Tegn panel
	                 	// Tegn score
	            		g.drawString(Integer.toString(gameData.getPlayer().getScore()), 900, 100);
	                  	int tekstHoyde = 500;
	            		for(GuiObject go:gameData.getObjectsOnScreen()){
	                  		if (!(go instanceof Target)) continue;
	                  		tekstHoyde += 30;	            
	                  		if(((Target)go).getStatus() == 0){
	                 			g.setColor(COLORS[1]);
	                 		} else {
	                 			g.setColor(COLORS[8]);
	                 		}
	                 		            		
	                  		g.drawString(((Target)go).getStringToWrite(), 900, tekstHoyde);
	                  		if (((Target)go).getStatus() == 1) g.drawString(Integer.toString(((Target)go).getPointsForClear()), 30, 30);
	                  		g.setColor(COLORS[2]);
                 		}
	                  	
	            		// Tegn tekst keylistener
	            		if (debug){
	            			Font def = new Font(null, 20, 20);
	            			g.setFont(def);
	            			g.setColor(COLORS[2]);
	       
	            			g.drawString(str, (int)(1000*yRatio), 20);
	          //  			g.drawString(mainFrame.getCurrentLine(), (int)(900*yRatio), (int)(20*xRatio));
	            			g.drawString(mainFrame.getCurrentString(), (int)(200*yRatio), (int)(900*xRatio));
	            		}
	                	bufferStrategy.show();
	                	if (debug) {
	                	frameDrawStop = System.currentTimeMillis();
	                	fpsCounter = frameDrawStop - frameDrawStart;
	                	frameDrawStart = System.currentTimeMillis();                 		             
	                	}
	                }
	                try {
	                	Thread.sleep((int) 15);
	                } catch (InterruptedException e) {}
	        }
	        g.dispose();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        device.setFullScreenWindow(null);
	    }
    }

	public void run() {
	       try {
	            doshit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        System.exit(0);		
	}
	
	public void stop () {
		run = false;
	}
}