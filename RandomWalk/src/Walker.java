
public class Walker {

	private double X=0;
	private double Y=0;
	//private double Distance[];
	private double TotalDistance=0;
	int StepCount=0;
	public Walker(int Steps){ //Constructor
		//Distance= new double[Steps];
	}
	
	public double getX(){
		return X;
	}
	
	public double getY(){
		return Y;
	}
	
	public void ChangePosition() {
		//X=X+2.0*(0.5-Math.random());
		//Y=Y+2.0*(0.5-Math.random());
	
		double DecideDirection = Math.random();
		if (DecideDirection < 0.25) {
			X = X + 1;

		} else if (DecideDirection < 0.50) {
			X = X - 1;

		} else if (DecideDirection < 0.75) {
			Y = Y + 1;

		} else if (DecideDirection < 1.00) {
			Y = Y - 1;
		}
		// Calculate and store distance in the distance Array
		//double TempX = Math.abs(X);
		//double TempY = Math.abs(Y);
		//Distance[StepCount] = Math.sqrt((TempX * TempX) + (TempY * TempY)); // The
																			// old
																			// "Square on the hypotenuse"
																			// trick
		//TotalDistance = TotalDistance + Distance[StepCount];
		//StepCount++;
	}
	
	public double averagedistance(){
		return TotalDistance/StepCount;
	}
	public double distanceFromCenter(){
		double distance= Math.sqrt((double)(X*X+Y*Y));
		return distance;
	}
	
}
