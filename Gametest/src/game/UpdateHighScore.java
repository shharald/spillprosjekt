package game;

import java.lang.*;
import java.util.*;

public class UpdateHighScore {
	
	public UpdateHighScore(){
		
	}
	
	public static boolean isHighScore(Player player, List<HighScoreEntity> highScore){
		if(player.getHighScoreEntity().compareTo(highScore.get(highScore.size()-1)) == 1){
			return true;
		}
		return false;
	}
	
	public static List<HighScoreEntity> update(Player player, List<HighScoreEntity> highScore){
		highScore.remove(highScore.size()-1);
		highScore.add(player.getHighScoreEntity());
		Collections.sort(highScore);
		return highScore;
	}
	
	
}
