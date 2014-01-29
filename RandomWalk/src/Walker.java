
public class Walker {

	private double X=0;
	private double Y=0;

	private double TotalDistance=0;

	public Walker(){ //Constructor
		
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
		
	}
	

	public double distanceFromCenter(){
		double distance= Math.sqrt((double)(X*X+Y*Y));
		return distance;
	}
	
}
