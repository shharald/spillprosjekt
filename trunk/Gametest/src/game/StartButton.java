package game;

public class StartButton extends GraphicsButton {
	private GameData gameData;
	
//	public StartButton(String name, int xLocation, int yLoaction, String imageFileName, String imageFileNamePressed, GameData gameData){
		public StartButton(String name, int xLocation, int yLoaction, String imageFileName, String imageFileNamePressed, ButtonPanel panel, GameData gameData){
		super(name,xLocation, yLoaction,imageFileName, imageFileNamePressed);
		this.gameData = gameData;
	}
	
	@Override
	public void clicked() {
	//	System.out.println(this.name + "ble trykket på. Vi har desverre ikke noe spille enda.");
		Engine.kill();
		GameGui gameGui = new GameGui(gameData);
		GameEngine gameEngine = new GameEngine(gameData);	
		Thread gui = new Thread(gameGui);
		Thread game = new Thread(gameEngine);
		gui.start();
		game.start();
	}

}
