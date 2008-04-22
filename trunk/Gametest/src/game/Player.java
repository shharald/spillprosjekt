package game;

public class Player extends GuiObject {
	
	private long score;
	private String playerName;
	
	public Player(){
		super();
	}

	public long getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public void increaseScore(int pointsToIncrease) {
		score += pointsToIncrease; 
	}
	
	public double getLength () {
		return Math.sqrt((Math.pow(this.XLocation-450, 2))+(Math.pow(this.YLocation-450, 2)));		
	}
	
}
