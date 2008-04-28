package game;

public class CreditsButton extends GraphicsButton {

	public CreditsButton(String name, int xlocation, int ylocation,
			String imageFileName, String imageFileNamePressed) {
		super(name, xlocation, ylocation, imageFileName, imageFileNamePressed);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void clicked() {
		
		System.out.println("Knappen "+this.name+" ble tykket på. Her skal det stå skaperne av dette spillet");
	}

}
