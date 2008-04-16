package game;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class StringReader extends Window implements KeyListener {


	public StringReader(List<GuiObject> guiObjects) {
		super(guiObjects);
		addKeyListener(this);
	}
	private String currentLine; // holds the text of the string we are typing
	
	public void init() {
		currentLine = ""; // initialise the string to be empty
//		addKeyListener(this); // so the following methods are called when
				      // a key is pressed
	}

	public void paint(Graphics g) {}
 	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
 	public void keyPressed(KeyEvent e)
 	{
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
           System.out.println(currentLine.toLowerCase());
           currentLine = "";
  //         repaint();
           }
        if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
        	e.consume();
        	if (currentLine.length() > 0) {
        		currentLine = currentLine.substring(0, currentLine.length()-1);
    //    		repaint();
        	}
        } else {
        	currentLine += e.getKeyChar(); // add the typed character to the string
        }
        System.out.println(currentLine.toLowerCase());
 //       Graphics g = getGraphics(); // so we can draw
   //     g.setColor(Color.black); // make the text black
	//	g.drawString(currentLine, 10, 10); // draw the typed string at (10,10)
 	} 

}
