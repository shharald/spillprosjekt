package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ButtonPanel extends JPanel implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage background;
	private List<GraphicsButton> buttons = new ArrayList<GraphicsButton>();
	private List<GraphicsHighScore> strings = new ArrayList<GraphicsHighScore>();
	
	public ButtonPanel(String backgroundFileName){
		this.setBackground(backgroundFileName);
		this.addMouseListener(this);
	}
	
	public void mouseClicked(MouseEvent e){
		for(int i = 0; i < this.buttons.size(); i++){
			//System.out.println("Checking");
			if(this.buttons.get(i).contains(e.getX(), e.getY())){
				this.buttons.get(i).clicked();
				this.buttons.get(i).setPressed(false);
				this.repaint();
			}
		}
	}
	
	public void mouseReleased(MouseEvent e){
		for(int i = 0; i < this.buttons.size(); i++){
		//	System.out.println("Checking");
			this.buttons.get(i).setPressed(false);
			this.repaint();
		}
	}
	
	public void mousePressed(MouseEvent e){
		for(int i = 0; i < this.buttons.size(); i++){
			//System.out.println("Checking");
			if(this.buttons.get(i).contains(e.getX(), e.getY())){
				this.buttons.get(i).setPressed(true);
				this.repaint();
			}
		}
	}
	
	public void mouseExited(MouseEvent e){
		
	}
	
	public void mouseEntered(MouseEvent e){
		
	}
	
	public void setBackground(String fileName){
		try{
			this.background = ImageIO.read( new File( "resources/" + fileName));
			System.out.println("The background was sucsessfully set!");
		} catch (Exception e){
			System.out.println("Could not load background because of " + e);
		}
	}
	
	public void addButton(GraphicsButton button){
		this.buttons.add(button);
	}
	public void addString(GraphicsHighScore ghs){
		this.strings.add(ghs);
	}
	public void removeAllButtons(){
		buttons.removeAll(this.getButtons());
	}
	public void removeAllStrings(){
		strings.removeAll(this.getStrings());
	}
	
	
	private List<GraphicsHighScore> getStrings() {
		// TODO Auto-generated method stub
		return this.strings;
	}

	public List<GraphicsButton> getButtons(){
		return this.buttons;
	}
	
	public void paintPanel(Graphics2D g){
		g.drawImage(this.background, null, 0, 0);	
		for(int i = 0; i < this.buttons.size(); i++){
			this.buttons.get(i).paint(g);
		}
		for(int i = 0; i < this.strings.size(); i++){
			this.strings.get(i).paint(g);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		requestFocusInWindow();
		// this cast is always safe, as all newer versions of
		// java are using Graphics2D objects internally
		Graphics2D g2d = (Graphics2D) g;
		Color oldColor = g2d.getColor();
		AffineTransform transform = g2d.getTransform();
		this.paintPanel(g2d);
		g2d.setTransform(transform);
		g2d.setColor(oldColor);
	}

}
