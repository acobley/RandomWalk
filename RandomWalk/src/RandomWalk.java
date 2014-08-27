import java.util.Date;


public class RandomWalk {
	static int ActualNoWalkers = 6000
			; 	// Actual number of Walkers for this run.

	public static void main(String[] args) {
		long now=new Date().getTime();
		System.out.println("Start " +now );
		Walker Walkers[]=new Walker[ActualNoWalkers];
		for (int WalkerCount=0; WalkerCount<ActualNoWalkers; WalkerCount++){	//Walkers count from zero, so we drop out of the loop at ActualNoWalkers - 1	
			if (Walkers[WalkerCount] == null) {
				Walkers[WalkerCount] = new Walker();
			}
			Walkers[WalkerCount].walk();
		}
		//Now they have all moved
		double TotalDistance=0.0;
		for (int WalkerCount=0; WalkerCount<ActualNoWalkers; WalkerCount++){	//Walkers count from zero, so we drop out of the loop at ActualNoWalkers - 1	
		    double Distance=Walkers[WalkerCount].distanceFromCenter();
			
			TotalDistance=TotalDistance+Distance;
		}
		long elapsed=new Date().getTime()- now;
		System.out.println("Average Distance="+TotalDistance/(double)ActualNoWalkers+" : "+elapsed);
	}

}
