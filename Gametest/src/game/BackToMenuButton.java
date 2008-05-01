package game;

public class BackToMenuButton extends GraphicsButton{

	private ButtonPanel panel;
	private GameData gameData;

	public BackToMenuButton(String name, int xlocation, int ylocation,
			String imageFileName, String imageFileNamePressed, ButtonPanel panel) {
		super(name, xlocation, ylocation, imageFileName, imageFileNamePressed);
		this.panel = panel;
		
		// TODO Auto-generated constructor stub
	}
 
	@Override
	public void clicked() {
		panel.removeAllButtons();
		panel.removeAllStrings();
		panel.setBackground("menubackground_menu.jpg");
		panel.addButton(new StartButton("StartKnapp", 475, 370, "start.jpg", "startPressed.jpg"));
		panel.addButton(new ExitButton("ExitKnapp", 900, 600, "exit.JPG", "exitPressed.JPG"));
		panel.addButton(new CreditsButton("CreditsKnapp", 800, 370, "credits.jpg", "creditsPressed.jpg", panel));
		panel.addButton(new HighScoreButton("HighScoreKnapp", 150, 370, 
				"highscore.jpg", "highscorePressed.jpg", panel, gameData));
		System.out.println("Knappen "+this.name+" ble tykket på. Her skal det stå skaperne av dette spillet");
	}

}
