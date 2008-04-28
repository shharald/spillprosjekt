package game;

public class StartButton extends GraphicsButton {
	
	public StartButton(String name, int xLocation, int yLoaction, String imageFileName, String imageFileNamePressed){
		super(name,xLocation, yLoaction,imageFileName, imageFileNamePressed);
	}
	
	@Override
	public void clicked() {
		System.out.println(this.name + "ble trykket på. Vi har desverre ikke noe spille enda.");

	}

}
