
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
		X=X+2.0*(0.5-Math.random());
		Y=Y+2.0*(0.5-Math.random());
		
	}

	public double distanceFromCenter(){
		double distance= Math.sqrt((double)(X*X+Y*Y));
		return distance;
	}
	
}
