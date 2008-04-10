package game;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class GameGui implements Runnable {
  
	Frame mainFrame;
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
    

    
    public GameGui(List<GuiObject> guiObjects) {
    	this.guiObjects = guiObjects;
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
	        mainFrame = new Frame(gc);
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
	                 	for(GuiObject go:guiObjects){
	                 		g.drawImage(go.getBufferedImage(), (int)(go.getXLocation()*xRatio), (int)(go.getYLocation()*yRatio), (int) ((go.getXLocation()+go.getBufferedImage().getWidth())*xRatio), (int)((go.getYLocation()+go.getBufferedImage().getHeight())*yRatio), 
	                 				0, 0, go.getBufferedImage().getWidth(), go.getBufferedImage().getHeight(), null);
	                 	}
	                 	g.setColor(COLORS[2]);
	            		if (offset > 0){
	            			g.fillRect(-offset, 0, offset, modeToPaint.getHeight());
	            			g.fillRect(modeToPaint.getWidth(), 0, offset, modeToPaint.getWidth());
	            		}
	                 	// Tegn panel
	                 	// Tegn score
	            		// Tegn tekst
	            		if (debug){
	            			g.setColor(COLORS[6]);
	            			g.drawString(str, (int)(1000*yRatio), 20);
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