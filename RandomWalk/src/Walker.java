import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;


public class Walker implements Runnable{

	private double X=0;
	private double Y=0;

	private double TotalDistance=0;
	static int ActualNoSteps = 500;	// Actual number of steps for this run. Up to 5,000 and 22,000 walkers seems to work fine.
    int i=-1;
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    static int numberInPool=100;
    double distances[]=new double[numberInPool];
	Walker(CountDownLatch startSignal, CountDownLatch doneSignal,int i,double distances[]){ //Constructor
		this.startSignal = startSignal;
	      this.doneSignal = doneSignal;
	      this.i=i;
	      this.distances=distances;
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
	
	public void run(){
		try{
		String name = Thread.currentThread().getName();
		startSignal.await();
		System.out.println("Starting Walker "+name +" : "+i);
		walk();
		System.out.println("Stopping Walker"+name+" : "+i+" : "+distanceFromCenter());
		this.distances[i]=distanceFromCenter();
		doneSignal.countDown();
		}
		catch (InterruptedException ie)
	      {
	         System.out.println("interrupted");
	      }
	}
	
}
