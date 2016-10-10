package misc;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 */

/**
 * Created on 8 maj 2016 - 20:14:32
 *
 * @author Hubert
 */
public class AtomicClassesTester {

	public static void main(String[] args) {
		testAtomicInteger();
	}

	private static void testAtomicInteger() {
		AtomicInteger ai = new AtomicInteger(1);
		ai.addAndGet(1);
		ai.decrementAndGet();
		ai.incrementAndGet();
		
		ai.getAndAdd(1);
		ai.getAndDecrement();
		ai.getAndIncrement();
		
		int expect = 1;
		int update = 21;
		ai.compareAndSet(expect, update);
		
		ai.doubleValue();
	}
}
