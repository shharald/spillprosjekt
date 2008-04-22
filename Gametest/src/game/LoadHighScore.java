package game;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.sql.*;


public class LoadHighScore {

	public static List<HighScoreEntity> loadHigh(){
		List<HighScoreEntity> highScore = new ArrayList<HighScoreEntity>();
		
		try{
			File file = new File("resources/highScore.sco");
			BufferedReader highScoreReader = new BufferedReader(new FileReader(file));
			//Getting the number of targets and setting the targets
			
			int antallScores = (int) Integer.parseInt(highScoreReader.readLine());
					
			for(int i = 0; i < antallScores; i++){
				HighScoreEntity entity = new HighScoreEntity();
				entity.setHighScoreEntityName(highScoreReader.readLine());
				entity.setHighScoreEntityValue(Long.parseLong(highScoreReader.readLine()));
				highScore.add(entity);
			}
			highScoreReader.close();
		}catch(Exception e){
			System.out.println("HighScore was not loaded because of: " + e);
		}
		
		return highScore;
	}
}
