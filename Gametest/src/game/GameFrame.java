package game;

import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends Frame implements KeyListener{

		private String currentLine = "";
		private String currentString = "";

		
		public GameFrame ( String s )   {  
	       super ( s ) ; 
	       setLayout ( null ) ; 
	       addKeyListener ( this ) ; 
	     }  
		
		public GameFrame ( GraphicsConfiguration g )   {  
		       super ( g ) ; 
		       setLayout ( null ) ; 
		       addKeyListener ( this ) ; 
		     }  
	  
	  
	 	public void keyTyped(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
	 	public void keyPressed(KeyEvent e)
	 	{
	        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	        	currentLine = currentString;
	            currentString = "";
//	        	System.out.println(currentLine.toLowerCase());
	           }
	        if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
	        	e.consume();
	        	if (currentString.length() > 0) {
	        		currentString = currentString.substring(0, currentString.length()-1);
	        	}
	        } else {
	        	currentString += e.getKeyChar();
	        }
	       // System.out.println(currentLine.toLowerCase());
	 	}
	 	
	 	public String getCurrentString () {
	 		return currentString;
	 	}
	 	
	 	public String getCurrentLine() {
	 		return currentLine;
	 	}
}
