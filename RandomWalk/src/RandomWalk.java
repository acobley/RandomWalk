
public class RandomWalk {
	static int ActualNoSteps = 500;	// Actual number of steps for this run. Up to 5,000 and 22,000 walkers seems to work fine.
	static int ActualNoWalkers = 6000; 	// Actual number of Walkers for this run.

	public static void main(String[] args) {
		Walker Walkers[]=new Walker[ActualNoWalkers];
		for (int WalkerCount=0; WalkerCount<ActualNoWalkers; WalkerCount++){	//Walkers count from zero, so we drop out of the loop at ActualNoWalkers - 1	
			if (Walkers[WalkerCount] == null) {
				Walkers[WalkerCount] = new Walker();
			}
			for (int StepCount = 1; StepCount <= ActualNoSteps; StepCount++) { 
			// move and record the new position in the array called Position
				Walkers[WalkerCount].ChangePosition();

			}
		}
		//Now they have all moved
		double TotalDistance=0.0;
		for (int WalkerCount=0; WalkerCount<ActualNoWalkers; WalkerCount++){	//Walkers count from zero, so we drop out of the loop at ActualNoWalkers - 1	
		    double Distance=Walkers[WalkerCount].distanceFromCenter();
			
			TotalDistance=TotalDistance+Distance;
		}
		System.out.println("Average Distance="+TotalDistance/(double)ActualNoWalkers);
	}

}
