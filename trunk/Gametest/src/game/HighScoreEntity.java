package game;
	
public class HighScoreEntity implements Comparable<HighScoreEntity> {
	
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

	public int compareTo(HighScoreEntity arg0) {
		if(this.highScoreEntityValue > arg0.getHighScoreEntityValue()){
			return 1;
		} else if(this.highScoreEntityValue < arg0.getHighScoreEntityValue()){
			return -1;
		} else {
			return this.highScoreEntityName.compareTo(arg0.getHighScoreEntityName());
		}
	}
	
	
	
}
