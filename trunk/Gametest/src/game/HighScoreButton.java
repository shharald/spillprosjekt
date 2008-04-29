package game;

public class HighScoreButton extends GraphicsButton{
	
	private ButtonPanel panel;
	private GameData gameData;

//	public HighScoreButton(String name, int xlocation, int ylocation,
//			String imageFileName, String imageFileNamePressed, ButtonPanel panel) {
		public HighScoreButton(String name, int xlocation, int ylocation,
				String imageFileName, String imageFileNamePressed, ButtonPanel panel, GameData gameData) {
		super(name, xlocation, ylocation, imageFileName, imageFileNamePressed);
		this.panel = panel;
		this.gameData = gameData;
		// TODO Auto-generated constructor stub
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
			System.out.println(gameData.getHighScore().get(i));			
		}
	}

}
