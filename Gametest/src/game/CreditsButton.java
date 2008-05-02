package game;

public class CreditsButton extends GraphicsButton {

	private ButtonPanel panel;
	private GameData gameData;

	public CreditsButton(String name, int xlocation, int ylocation,
			String imageFileName, String imageFileNamePressed, ButtonPanel panel, GameData gameData) {
		super(name, xlocation, ylocation, imageFileName, imageFileNamePressed);
		this.panel = panel;
		this.gameData = gameData;
		// TODO Auto-generated constructor stub
	}
 
	@Override
	public void clicked() {
		
		panel.removeAllButtons();

		panel.setBackground("menubackground_creds.jpg");
		panel.addButton(new StartButton("StartKnapp", 8, 2, "blank.jpg", "startPressed.jpg",panel, gameData));
		panel.addButton(new ExitButton("ExitKnapp", 6, 2, "blank.JPG", "exitPressed.JPG"));
		panel.addButton(new BackToMenuButton("TilbakeTilMenyenKnapp", 470, 600, "exit.JPG", "exitPressed.JPG", panel, gameData));
		System.out.println("Knappen "+this.name+" ble tykket på. Her skal det stå skaperne av dette spillet");
	}

}
