package misc;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created on 12 maj 2016 - 22:48:26
 *
 * @author Hubert
 */
public class ForkJoinTester {

	public static void main(String[] args) {
//		recursiveActionTest();
		recursiveTaskTest();
	}

	private static void recursiveActionTest() {
		int[] data = new int[10_000_000];
		ForkJoinPool fjPool = new ForkJoinPool();
		RandomInitRecursiveAction action = new RandomInitRecursiveAction(data, 0, data.length);
		fjPool.invoke(action);
	}

	private static void recursiveTaskTest() {
		int[] data = new int[10_000_000];
		ForkJoinPool fjPool = new ForkJoinPool();
		RandomInitRecursiveAction action = new RandomInitRecursiveAction(data, 0, data.length);
		fjPool.invoke(action);
		// new code begins here
		FindMaxPositionRecursiveTask task = new FindMaxPositionRecursiveTask(data, 0, data.length);
		Integer position = fjPool.invoke(task);
		System.out.println("Position: " + position + ", value: " + data[position]);
	}
}

class RandomInitRecursiveAction extends RecursiveAction {

	private static final long serialVersionUID = -8408759380131718965L;
	private static final int THRESHOLD = 10000;
	private int[] data;
	private int start;
	private int end;

	public RandomInitRecursiveAction(int[] data, int start, int end) {
		this.data = data;
		this.start = start; // where does our section begin at?
		this.end = end; // how large is this section?
	}

	@Override
	protected void compute() {
		if (end - start <= THRESHOLD) { // is it a manageable amount of work?
			// do the task
			for (int i = start; i < end; i++) {
				data[i] = ThreadLocalRandom.current().nextInt();
			}
		} else { // task too big, split it
			int halfWay = ((end - start) / 2) + start;
			RandomInitRecursiveAction a1 = new RandomInitRecursiveAction(data, start, halfWay);
			a1.fork(); // queue left half of task
			RandomInitRecursiveAction a2 = new RandomInitRecursiveAction(data, halfWay, end);
			a2.compute(); // work on right half of task
			a1.join(); // wait for queued task to be complete
		}
	}
}

class FindMaxPositionRecursiveTask extends RecursiveTask<Integer> {
	private static final int THRESHOLD = 10000;
	private int[] data;
	private int start;
	private int end;

	public FindMaxPositionRecursiveTask(int[] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() { // return type matches the <generic> type
		if (end - start <= THRESHOLD) { // is it a manageable amount of work?
			int position = 0; // if all values are equal, return position 0
			for (int i = start; i < end; i++) {
				if (data[i] > data[position]) {
					position = i;
				}
			}
			return position;
		} else { // task too big, split it
			int halfWay = ((end - start) / 2) + start;
			FindMaxPositionRecursiveTask t1 = new FindMaxPositionRecursiveTask(data, start, halfWay);
			t1.fork(); // queue left half of task
			FindMaxPositionRecursiveTask t2 = new FindMaxPositionRecursiveTask(data, halfWay, end);
			int position2 = t2.compute(); // work on right half of task
			int position1 = t1.join(); // wait for queued task to be complete
			// out of the position in two subsection which is greater?
			if (data[position1] > data[position2]) {
				return position1;
			} else if (data[position1] < data[position2]) {
				return position2;
			} else {
				return position1 < position2 ? position1 : position2;
			}
		}
	}
}