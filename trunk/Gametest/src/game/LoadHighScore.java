package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class LoadHighScore {

	public static List<HighScoreEntity> loadHigh(){
		List<HighScoreEntity> highScore = new ArrayList<HighScoreEntity>();
		
		try{
			File file = new File("c:/temp/highScore.sco");
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
			if (e instanceof FileNotFoundException) {
				File file = new File("c:/temp/highScore.sco");
				try {
					file.createNewFile();
					UpdateHighScore.reset();
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
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		return highScore;
	}
}
