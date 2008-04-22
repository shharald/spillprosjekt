package game;

public class Player extends GuiObject {
	
	private String playerName;
	private HighScoreEntity entity;
	
	public Player(){
		super();
		this.entity = new HighScoreEntity(this.playerName, 0);
	}

	public long getScore() {
		return this.entity.getHighScoreEntityValue();
	}

	public void setScore(long score) {
		this.entity.setHighScoreEntityValue(score);
	}
	
	public HighScoreEntity getHighScoreEntity(){
		return this.entity;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public void increaseScore(long pointsToIncrease) {
		this.setScore(this.getScore() + pointsToIncrease); 
	}
	
	public double getLength () {
		return Math.sqrt((Math.pow(this.XLocation-450, 2))+(Math.pow(this.YLocation-450, 2)));		
	}
	
}
