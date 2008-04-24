package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
import java.util.*;

public class UpdateHighScore {
	
	//updates the List
	public static List<HighScoreEntity> update(Player player, List<HighScoreEntity> highScore){
		if(player.getHighScoreEntity().compareTo(highScore.get(highScore.size() - 1))<0){
			highScore.remove(highScore.size()-1);
			highScore.add(player.getHighScoreEntity());
		}
		Collections.sort(highScore);
		return highScore;
	}
	
	//Writes the score to file
	public static void commit(List<HighScoreEntity> highScore){
		BufferedWriter highScoreWriter;
		try {
			highScoreWriter = new BufferedWriter(new FileWriter("resources/highScore.sco"));
			highScoreWriter.write(Integer.toString(highScore.size()));
			for (int i = 0; i < highScore.size(); i++) {
				highScoreWriter.newLine();
				highScoreWriter.write(highScore.get(i).getHighScoreEntityName());
				highScoreWriter.newLine();
				highScoreWriter.write(Long.toString(highScore.get(i).getHighScoreEntityValue()));
			}
			
			highScoreWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	//Resets the highScore to Anonymous: 0
	public static void reset(){
		BufferedWriter highScoreWriter;
		try {
			//Getting the standard number of scores
			int numberOfScores;
			BufferedReader highScoreReader = new BufferedReader(new FileReader("resources/highScore.sco"));
			numberOfScores = (int)Integer.parseInt(highScoreReader.readLine());
			highScoreReader.close();
			
			//Writing the zero scores
			highScoreWriter = new BufferedWriter(new FileWriter("resources/highScore.sco"));
			highScoreWriter.write(Integer.toString(numberOfScores));
			for (int i = 0; i < numberOfScores; i++) {
				highScoreWriter.newLine();
				highScoreWriter.write("Anonymous");
				highScoreWriter.newLine();
				highScoreWriter.write("0");
			}
			
			highScoreWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
}
