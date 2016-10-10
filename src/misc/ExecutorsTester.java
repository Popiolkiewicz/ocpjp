package misc;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 */

/**
 * Created on 12 maj 2016 - 01:14:45
 *
 * @author Hubert
 */
public class ExecutorsTester {

	public static void main(String[] args) {
//		test1();
//		test2();
//		test3();
		test4();
		termination();
	}

	private static void test1() {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(4);
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
	}

	private static void test2() {
		Executor ex = Executors.newFixedThreadPool(2);
		ex.execute(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++)
					System.out.println("from ex run: " + i);
			}
		});
		for (int i = 0; i < 100; i++)
			System.out.println("from main: " + i);
	}

	private static void test3() {
		ExecutorService ex = Executors.newFixedThreadPool(2);
		Future<String> future1 = ex.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				for (int i = 0; i < 100; i++)
					System.out.println("from future 1 : " + i);
				return "Some string";
			}
		});
		Future<String> future2 = ex.submit(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++)
					System.out.println("from future 2 : " + i);
			}
		}, "Completed successfully");
		Future<?> future3 = ex.submit(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++)
					System.out.println("from future 3 : " + i);
			}
		});
		try {
			String string1 = future1.get();
			System.out.println(string1);
			String string2 = future2.get(100, TimeUnit.NANOSECONDS);
			System.out.println(string2);
			String string3 = future3.get(100, TimeUnit.NANOSECONDS);
			System.out.println(string3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	private static void test4() {
		Runnable r = new Runnable() {@Override public void run() {System.out.println("Done something");}};
		Runnable r2 = new Runnable() {@Override public void run() {System.out.println("Done something 2 ");}};
		Runnable r3 = new Runnable() {@Override public void run() {System.out.println("Done something 3 ");}};
		ScheduledExecutorService ftses = Executors.newScheduledThreadPool(4); // multi-threaded version
		ftses.schedule(r, 5, TimeUnit.SECONDS); // run once after a delay
		ftses.scheduleAtFixedRate(r2, 2, 5, TimeUnit.SECONDS); 	// begin after a 2sec delay and begin again every 5 seconds
		ScheduledFuture<?> scheduleWithFixedDelay = ftses.scheduleWithFixedDelay(r3, 2, 5, TimeUnit.SECONDS); // begin after 2sec delay
		// and begin again 5 seconds *after* completing the last execution
	}

	private static void termination() {
		ExecutorService ex = Executors.newSingleThreadExecutor();
		ex.shutdown(); // no more new tasks
				               // but finish existing tasks
		try {
			boolean term = ex.awaitTermination(2, TimeUnit.SECONDS);
			// wait 2 seconds for running tasks to finish
		} catch (InterruptedException ex1) {
			// did not wait the full 2 seconds
		} finally {
			if (!ex.isTerminated()) // are all tasks done?
			{
				List<Runnable> unfinished = ex.shutdownNow();
				// a collection of the unfinished tasks
			}
		}
	}
}
