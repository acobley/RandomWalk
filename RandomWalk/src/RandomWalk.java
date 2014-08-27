import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class RandomWalk {
	static int ActualNoWalkers = 6000;
	static int numberInPool=1000;
		
	static Executor pool = Executors.newFixedThreadPool(numberInPool);
	public static void main(String[] args) {
		long now=new Date().getTime();
		System.out.println("Start " +now );
		//final Walker Walkers[]=new Walker[ActualNoWalkers];
		for (int WalkerCount=0; WalkerCount<ActualNoWalkers; WalkerCount++){	//Walkers count from zero, so we drop out of the loop at ActualNoWalkers - 1	
			//if (Walkers[WalkerCount] == null) {
				
				Runnable r = new Runnable()
	            {
	               @Override
	               public void run()
	               {
	            	   Walker walker=new Walker();
	            	   walker.walk();
	               }
	            };
	            pool.execute(r);
			//}
			
			//Walkers[WalkerCount].walk();
		}
		//Now they have all moved
		double TotalDistance=0.0;
		/*
		for (int WalkerCount=0; WalkerCount<ActualNoWalkers; WalkerCount++){	//Walkers count from zero, so we drop out of the loop at ActualNoWalkers - 1	
		    double Distance=Walkers[WalkerCount].distanceFromCenter();
			
			TotalDistance=TotalDistance+Distance;
		}*/
		long elapsed=new Date().getTime()- now;
		System.out.println("Average Distance="+TotalDistance/(double)ActualNoWalkers+" : "+elapsed);
	}

}
