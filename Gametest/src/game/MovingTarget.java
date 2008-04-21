package game;

public class MovingTarget implements Runnable{
	private Target target;
	private int timeToUse;
	private double scoreDecrease;
	
	public MovingTarget (Target target, int timeToUse){
	this.target = target;	
	this.timeToUse = timeToUse;		
	}

	public void run() {		
		double thetaIncrease = (8*Math.PI)/timeToUse;
		double lenghtIncrease = -(target.getLength()/timeToUse);
		scoreDecrease = (target.getPointsForClear()/timeToUse);
		for (int i = 1; i < timeToUse; i++) {
			target.increasePolar(thetaIncrease, lenghtIncrease);
			target.increasePolar(thetaIncrease, lenghtIncrease);
			target.setPointsForClear(target.getPointsForClear()-(int)scoreDecrease);
			if (target.getLength() < 1) {
				target.setStatus(0);
				timeToUse = 0;
				return;
			}
			if (target.getStatus() == 0) {
				target.getPlayer().increaseScore(target.getPointsForClear());
				target.getVector().setPolar(0, 0);
			}
			try {
	         	Thread.sleep((int) 2);
	         } catch (InterruptedException e) {}
		}
	}

}
