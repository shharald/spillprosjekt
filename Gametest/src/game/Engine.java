package game;

import java.util.List;
import javax.swing.JFrame;

public class Engine implements Runnable{
	private static JFrame ramme = new JFrame("BlackHole!");
	private GameData gameData;
	
	public Engine (GameData gameData) {
		this.gameData = gameData;
	}
	
	public static void kill(){
		ramme.dispose();
	}

	public void run() {
		ButtonPanel panel = new ButtonPanel("menubackground_menu.jpg");
		panel.addButton(new StartButton("StartKnapp", 475, 370, "start.jpg", "startPressed.jpg",panel, gameData));
		panel.addButton(new ExitButton("ExitKnapp", 900, 600, "exit.JPG", "exitPressed.JPG"));
		panel.addButton(new CreditsButton("CreditsKnapp", 800, 370, "credits.jpg", "creditsPressed.jpg", panel, gameData));
		panel.addButton(new HighScoreButton("HighScoreKnapp", 150, 370, "highscore.jpg", "highscorePressed.jpg", panel, gameData));
		
		ramme.add(panel);
		ramme.setSize(1270, 760);
		ramme.setResizable(false);
		ramme.setLocationRelativeTo(null);
		ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ramme.setVisible(true);
		
	}
}
