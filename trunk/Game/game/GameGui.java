package game;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class GameGui implements Runnable {
    
	List<GuiObject> guiObjects = new ArrayList<GuiObject>();
	GraphicsDevice device = null;
	
    private static Color[] COLORS = new Color[] {
        Color.red, Color.blue, Color.green, Color.white, Color.black,
        Color.yellow, Color.gray, Color.cyan, Color.pink, Color.lightGray,
        Color.magenta, Color.orange, Color.darkGray };
    private static DisplayMode[] BEST_DISPLAY_MODES = new DisplayMode[] {
        new DisplayMode(1280, 1024, 32, 0),
        new DisplayMode(1280, 1024, 16, 0),
        new DisplayMode(1280, 1024, 8, 0)};
    
    Frame mainFrame;
    
    public GameGui(List<GuiObject> guiObjects) {
    	this.guiObjects = guiObjects;
    }
    private void doshit (){
	    GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsDevice device = env.getDefaultScreenDevice();	
		try {
			// lager graphic configuration til mainFrame
	        GraphicsConfiguration gc = device.getDefaultConfiguration();
	        // setter frame til device.getDefaultConfiguration
	        mainFrame = new Frame(gc);
	        //fjerner typ vistaskin fra vindu
	        mainFrame.setUndecorated(true);
	        // slå av paint fra OS
	        mainFrame.setIgnoreRepaint(true);
	        // setter mainFrame til å kjøre i fullscreen
	        device.setFullScreenWindow(mainFrame);
	        // hvis den støtter fullscreen, finn oppløsning
	        if (device.isDisplayChangeSupported()) {
	            chooseBestDisplayMode(device);
	        }
	//		Rectangle bounds = mainFrame.getBounds();
	        mainFrame.createBufferStrategy(4);
	        BufferStrategy bufferStrategy = mainFrame.getBufferStrategy();
	        
	        
	        Graphics g = bufferStrategy.getDrawGraphics();
	//  	 myImages.add(LoadImages.transPNG());
	//        for (float lag = 1000.0f; lag > 0.00000006f; lag = lag / 1.66f) {
	        long lol = 1;
	        long start = 0;
	        long stop = 0;
	        //int offset = 0;
	        String str = "";
	        
	        for (int counter = 1; counter < 700; counter++) {
	                if (!bufferStrategy.contentsLost()) {
	                   
	                   //g.fillRect(0,0,200, 200);
	                	g.setColor(COLORS[2]);
	                	if (lol!=0) {
	                		lol = 1000/lol;
	                	}
	                	str = "FPS: "+String.valueOf(lol);
	                 	for(GuiObject go:guiObjects){
	                 		g.drawImage(go.getBufferedImage(), go.getXLocation(), go.getYLocation(), go.getXLocation()+go.getBufferedImage().getWidth(), go.getYLocation()+go.getBufferedImage().getHeight(), 
	                 				0, 0, go.getBufferedImage().getWidth(), go.getBufferedImage().getHeight(), null);
	                 	}
	                 	g.drawString(str, 1000, 20);             	
	                	bufferStrategy.show();
	                	stop = System.currentTimeMillis();
	                	lol = stop - start;
	                	start = System.currentTimeMillis();                 	
	                }
	                try {
	                	//timer2 = System.currentTimeMillis();
	
	
	                	Thread.sleep((int) 10);
	                } catch (InterruptedException e) {}
	
	        }
	        g.dispose();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        device.setFullScreenWindow(null);
	    }
    }
    
    private static DisplayMode getBestDisplayMode(GraphicsDevice device) {
        for (int x = 0; x < BEST_DISPLAY_MODES.length; x++) {
        	//modes får alle oppløsninger som display støtter
            DisplayMode[] modes = device.getDisplayModes();
            DisplayMode currentmode = device.getDisplayMode();
            System.out.println(currentmode.getHeight()+"x"+currentmode.getWidth());
            //finner den beste av modes opp mot ønska oppløsinger
            for (int i = 0; i < modes.length; i++) {
                if (modes[i].getWidth() == BEST_DISPLAY_MODES[x].getWidth()
                   && modes[i].getHeight() == BEST_DISPLAY_MODES[x].getHeight()
                   && modes[i].getBitDepth() == BEST_DISPLAY_MODES[x].getBitDepth()
                   ) {
                    return BEST_DISPLAY_MODES[x];
                }
            }
        }
        return null;
    }
    
    public static void chooseBestDisplayMode(GraphicsDevice device) {
        DisplayMode best = getBestDisplayMode(device);
        if (best != null) {
            device.setDisplayMode(best);
        }
    }
    
    public static void main(String[] args) {
 
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
		device.setFullScreenWindow(null);
	}
}
