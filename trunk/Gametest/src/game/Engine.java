package game;

import java.util.List;

import javax.swing.JFrame;

public class Engine{
	private static JFrame ramme = new JFrame("BlackHole!");
	
	public static void main(String[] args) {
		ButtonPanel panel = new ButtonPanel("menubackground_menu.jpg");
		panel.addButton(new StartButton("StartKnapp", 475, 370, "start.jpg", "startPressed.jpg"));
		panel.addButton(new ExitButton("ExitKnapp", 900, 600, "exit.JPG", "exitPressed.JPG"));
		panel.addButton(new CreditsButton("CreditsKnapp", 800, 370, "credits.jpg", "creditsPressed.jpg"));
		panel.addButton(new HighScoreButton("HighScoreKnapp", 150, 370, "highscore.jpg", "highscorePressed.jpg"));
		ramme.add(panel);
		ramme.setSize(1270, 760);
		ramme.setResizable(false);
		ramme.setLocationRelativeTo(null);
		ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ramme.setVisible(true);
		
	}
	
	public static void kill(){
		ramme.dispose();
	}
}
