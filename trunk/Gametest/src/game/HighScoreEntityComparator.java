package game;

import java.util.Comparator;

public class HighScoreEntityComparator implements Comparator<HighScoreEntity> {

	@Override
	public int compare(HighScoreEntity arg0, HighScoreEntity arg1) {
		return arg0.compareTo(arg1);
	}
	
}
