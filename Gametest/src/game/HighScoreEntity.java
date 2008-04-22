package game;
	
public class HighScoreEntity {
	
	private String highScoreEntityName;
	private long highScoreEntityValue;
	
	public HighScoreEntity(String name, long value){
		this.highScoreEntityName = name;
		this.highScoreEntityValue = value;
	}
	
	public HighScoreEntity(){
		
	}
		
	public String getHighScoreEntityName() {
		return highScoreEntityName;
	}
	public void setHighScoreEntityName(String highScoreEntityName) {
		this.highScoreEntityName = highScoreEntityName;
	}
	public long getHighScoreEntityValue() {
		return highScoreEntityValue;
	}
	public void setHighScoreEntityValue(long highScoreEntityValue) {
		this.highScoreEntityValue = highScoreEntityValue;
	}
	
	public String toString(){
		return this.highScoreEntityName + " " + this.highScoreEntityValue;
	}

	
	
	
}
