package misc;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 */

/**
 * Created on 8 maj 2016 - 21:30:26
 *
 * @author Hubert
 */
public class QueuesTester {

	public static void main(String[] args) {
		testPriorityQueue();
		testArrayDeque();
	}

	/**
	 * 0 <br>[1]<br> [1, 2]<br> [1, 2, 3]<br> [1, 2, 3, 4]<br> [1, 2, 3, 4]<br> [2, 4, 3] <br>[3, 4] <br>[4]<br> []
	 */
	private static void testPriorityQueue() {
		Queue<Integer> pq = new PriorityQueue<Integer>();
		System.out.println(pq.size());
		pq.add(1);
		System.out.println(pq);
		pq.add(2);
		System.out.println(pq);
		pq.add(3);
		System.out.println(pq);
		pq.add(4);
		System.out.println(pq);
		pq.peek();
		System.out.println(pq);
		pq.poll();
		System.out.println(pq);
		pq.poll();
		System.out.println(pq);
		pq.poll();
		System.out.println(pq);
		pq.poll();
		System.out.println(pq);
	}

	private static void testArrayDeque() {
		Deque<Integer> d = new ArrayDeque<>(); 
		d.push(1); 
		System.out.println(d);
		d.add(2); 
		System.out.println(d);
		d.addFirst(3); 
		System.out.println(d);
		d.addLast(4); 
		System.out.println(d);
		d.offer(5); 
		System.out.println(d);
		d.offerFirst(6); 
		System.out.println(d);
		d.offerLast(7); 
		System.out.println(d);
		System.out.println(d.peekFirst());
		System.out.println(d);
		System.out.println(d.peekLast());
		System.out.println(d);
		System.out.println(d.removeFirst());
		System.out.println(d);
		System.out.println(d.removeLast());
		System.out.println(d);
		System.out.println(d.pop());
		System.out.println(d);
		System.out.println(d.poll());
		System.out.println(d);
		System.out.println(d.pollFirst());
		System.out.println(d);
		System.out.println(d.pollLast());
		System.out.println(d);
	}
}
