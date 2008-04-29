package game;

import java.util.List;

import javax.swing.JLabel;

public class HighScoreButton extends GraphicsButton{
	
	private ButtonPanel panel;
	private GameData gameData;
//	private JLabel j;
//	private List<String> stringlist;
//	private List<String> stringlist2;
		public HighScoreButton(String name, int xlocation, int ylocation,
				String imageFileName, String imageFileNamePressed, ButtonPanel panel, GameData gameData) {
		super(name, xlocation, ylocation, imageFileName, imageFileNamePressed);
		this.panel = panel;
		this.gameData = gameData;
//		for(int i = 0; i<gameData.getHighScore().size(); i++){
//			stringlist2.set(i, gameData.getHighScore().get(i).getHighScoreEntityName()+"  "
//					+gameData.getHighScore().get(i).getHighScoreEntityValue());				
//		}
		// TODO Auto-generated constructor stub
//		j = new JLabel("Håper dette funker nå da");
//		this.stringlist = stringlist2;
	}

	@Override
	public void clicked() {
		panel.removeAllButtons();

		panel.setBackground("menubackground_highscore.jpg");
		panel.addButton(new StartButton("StartKnapp", 2, 2, "blank.jpg", "startPressed.jpg"));
		panel.addButton(new ExitButton("ExitKnapp", 6, 2, "blank.jpg", "exitPressed.JPG"));
		panel.addButton(new ExitButton("ExitKnapp", 8, 2, "blank.jpg", "exitPressed.JPG"));
		panel.addButton(new BackToMenuButton("TilbakeTilMenyenKnapp", 470, 600, "exit.JPG", "exitPressed.JPG", panel));
		System.out.println("Knappen "+this.name+" ble tykket på. Her skal det stå hvem som er best");
		for(int i = 0; i<gameData.getHighScore().size(); i++){
			System.out.println(gameData.getHighScore().get(i).getHighScoreEntityName());			
			System.out.println(gameData.getHighScore().get(i).getHighScoreEntityValue());			
		}
		
		for(int i = 0; i<gameData.getHighScore().size(); i++){
		panel.addString(new HighScoreLabel(
				gameData.getHighScore().get(i).getHighScoreEntityName(), 350, 300+30*i));
		panel.addString(new HighScoreLabel((String) Long.toString(
				gameData.getHighScore().get(i).getHighScoreEntityValue()) , 700, 300+30*i));
		}
	}

}
