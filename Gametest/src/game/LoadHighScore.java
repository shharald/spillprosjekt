package game;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.sql.*;


public class LoadHighScore {
	String [] highScoreName;
	int [] highScoreValue;
	
	public LoadHighScore(){
		try{
			
//			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
//			Connection db = java.sql.DriverManager.getConnection(
//				"jdbc:mysql://mysql.stud.ntnu.no/vidarkri_general","vidarkri_itgkbrk","passord");
//			Statement st = db.createStatement();
//			ResultSet rs;
//			rs = st.executeQuery("SELECT * FROM score ORDER BY value;");
//			while(rs.next()){
//				System.out.println(rs.getString("name") + " " + rs.getInt("value"));
//			}
			
			//Opens the highScore resource
			java.net.URL highScoreStore = new URL("http://folk.ntnu.no/vidarkri/blackHole/highScores.txt");
			InputStream instream = highScoreStore.openStream();
			BufferedReader buffreader = new BufferedReader(new InputStreamReader(instream));
			System.out.println(buffreader);
			
			//Gets the length of the score
			int numberOfLinesToRead = (int)(Integer.parseInt(buffreader.readLine()));
			System.out.println(numberOfLinesToRead);
			this.highScoreName = new String[numberOfLinesToRead/2];
			this.highScoreValue = new int[numberOfLinesToRead/2];
			for(int i = 0; i < numberOfLinesToRead; i++){
					this.highScoreName[i] = buffreader.readLine();
					System.out.println(this.highScoreName[i]);
					this.highScoreValue[i] = (int)(Integer.parseInt(buffreader.readLine()));
					System.out.println(this.highScoreValue[i]);
			}
			
		}catch(Exception e){
			System.out.println("HighScore was not loaded because of: " + e);
		}
	}
	
	public String getHighestScoreName(){
		return this.highScoreName[0];
	}
	
	public int getHighestScore(){
		return this.highScoreValue[0];
	}
	
	public void updateScore(){
		
	}

}
