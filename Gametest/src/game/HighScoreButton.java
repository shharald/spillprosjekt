package game;

public class HighScoreButton extends GraphicsButton{
	
	public HighScoreButton(String name, int xlocation, int ylocation,
			String imageFileName, String imageFileNamePressed) {
		super(name, xlocation, ylocation, imageFileName, imageFileNamePressed);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void clicked() {
		System.out.println("Knappen "+this.name+" ble tykket på. Her skal det stå hvem som er best");
		
	}

}
