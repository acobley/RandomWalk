import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class RandomWalk {
	static int ActualNoWalkers = 6;
	static int numberInPool=1000;
		
	//static ExecutorService pool = Executors.newFixedThreadPool(numberInPool);
	public static void main(String[] args) throws InterruptedException {
		long now=new Date().getTime();
		System.out.println("Start " +now );
		double TotalDistance=0.0;
		CountDownLatch startSignal = new CountDownLatch(1);
	    CountDownLatch doneSignal = new CountDownLatch(numberInPool);
        double distances[]=new double[numberInPool];
				for (int i=0;i<numberInPool;i++){
					new Thread(new Walker(startSignal, doneSignal,i,distances)).start();
				}
					startSignal.countDown();
					doneSignal.await();


		for (int i=0;i<numberInPool;i++){
			System.out.println(distances[i]);
			TotalDistance=TotalDistance+distances[i];
		}
		long elapsed=new Date().getTime()- now;
		System.out.println("Average Distance="+TotalDistance/(double)(numberInPool)+" : "+elapsed);

	}

}
