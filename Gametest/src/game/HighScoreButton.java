package game;

public class HighScoreButton extends GraphicsButton{
	
	private ButtonPanel panel;

	public HighScoreButton(String name, int xlocation, int ylocation,
			String imageFileName, String imageFileNamePressed, ButtonPanel panel) {
		super(name, xlocation, ylocation, imageFileName, imageFileNamePressed);
		this.panel = panel;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void clicked() {
		panel.removeAllButtons();

		panel.setBackground("menubackground_highscore.jpg");
		panel.addButton(new StartButton("StartKnapp", 2, 2, "blank.jpg", "startPressed.jpg"));
		panel.addButton(new ExitButton("ExitKnapp", 6, 2, "blank.JPG", "exitPressed.JPG"));
		panel.addButton(new BackToMenuButton("TilbakeTilMenyenKnapp", 470, 600, "exit.JPG", "exitPressed.JPG", panel));
		System.out.println("Knappen "+this.name+" ble tykket på. Her skal det stå hvem som er best");
		
	}

}
