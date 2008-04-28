package game;

public class MovingTarget implements Runnable{
	private Target target;
	private int timeToUse;
	private double scoreDecrease;
	private int startScore;
	private GameData gameData;
	
	public MovingTarget (Target target, int timeToUse, GameData gameData){
	this.target = target;	
	this.timeToUse = timeToUse;	
	this.gameData = gameData;
	}

	public void run() {
		startScore = target.getPointsForClear();
		double thetaIncrease = (8*Math.PI)/timeToUse;
		double lenghtIncrease = -(target.getLength()/timeToUse);
		scoreDecrease = (startScore*2/timeToUse);
		for (int i = 1; i < timeToUse; i++) {
			target.increasePolar(thetaIncrease, lenghtIncrease);
			target.increasePolar(thetaIncrease, lenghtIncrease);
			target.setPointsForClear(target.getPointsForClear() - (int)scoreDecrease);
			if (target.getLength() < 1) {
				target.setStatus(0);
				timeToUse = 0;
				return;
			}
			if (target.getStatus() == 0) {

				target.getVector().setPolar(0, 0);
			}
			if ((target.getStatus() == 1 )) {
				if (gameData.getCurrentLine().trim().equals(target.getStringToWrite().toLowerCase())) {
					System.out.println("Setter "+(target.getStringToWrite()+" til 0"));
					target.setStatus(0);
					target.getPlayer().increaseScore(target.getPointsForClear());
					timeToUse = 0;
					return;
				}
			}
			
			try {
	         	Thread.sleep((int) 2);
	         } catch (InterruptedException e) {}
		}
	}

}
