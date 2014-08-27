
public class Walker {

	private double X=0;
	private double Y=0;

	private double TotalDistance=0;
	static int ActualNoSteps = 500000;	// Actual number of steps for this run. Up to 5,000 and 22,000 walkers seems to work fine.

	public Walker(){ //Constructor
		
	}
	
	public double getX(){
		return X;
	}
	
	public double getY(){
		return Y;
	}
	
	public void ChangePosition() {
		X=X+2.0*(0.5-Math.random());
		Y=Y+2.0*(0.5-Math.random());
		
	}
	public void walk(){
		for (int StepCount = 1; StepCount <= ActualNoSteps; StepCount++) { 
		
			this.ChangePosition();

		}

	}
	public double distanceFromCenter(){
		double distance= Math.sqrt((double)(X*X+Y*Y));
		return distance;
	}
	
}
