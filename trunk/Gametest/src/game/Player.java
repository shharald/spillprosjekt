package game;

public class Player extends GuiObject {
	
	private HighScoreEntity entity;
	
	public Player(){
		super();
		this.entity = new HighScoreEntity(null, 0);
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
		return this.entity.getHighScoreEntityName();
	}

	public void setPlayerName(String playerName) {
		this.entity.setHighScoreEntityName(playerName);
	}
	
	public void increaseScore(long pointsToIncrease) {
		this.setScore(this.getScore() + pointsToIncrease); 
	}
	
	public double getLength () {
		return Math.sqrt((Math.pow(this.XLocation-450, 2))+(Math.pow(this.YLocation-450, 2)));		
	}
	
}
