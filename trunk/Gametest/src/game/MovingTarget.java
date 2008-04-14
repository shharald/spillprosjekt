package game;

public class MovingTarget implements Runnable{
	private Target target;
	private int timeToUse;
	
	public MovingTarget (Target target, int timeToUse){
	this.target = target;	
	this.timeToUse = timeToUse;		
	}

	public void run() {		
		double thetaIncrease = (8*Math.PI)/timeToUse;
		double lenghtIncrease = -(target.getLength()/timeToUse);
		
		for (int i = 1; i < timeToUse; i++) {
			//thetaIncrease += 0.000005;
			target.increasePolar(thetaIncrease, lenghtIncrease);
			target.increasePolar(thetaIncrease, lenghtIncrease);
			if (target.getLength() < 1) {
				target.setStatus(0);
				return;
			}
			try {
	         	Thread.sleep((int) 2);
	         } catch (InterruptedException e) {}
		}
	}

}
