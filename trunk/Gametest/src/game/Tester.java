package game;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LoadImages imageLoader = new LoadImages();
		Player player = new Player();
		LoadLevels levelLoader = new LoadLevels(imageLoader, player);

	}

}
