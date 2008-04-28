package game;

public class ExitButton extends GraphicsButton {
	
	public ExitButton(String name, int xLocation, int yLoaction, String imageFileName, String imageFileNamePressed){
		super(name,xLocation, yLoaction,imageFileName, imageFileNamePressed);
	}
	
	@Override
	public void clicked(){
		System.out.println(this.name + "Ble trykket på");
		Engine.kill();
	}
}
