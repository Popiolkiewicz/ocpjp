package misc;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 
 */

/**
 * @author Hubert
 *
 */
public class NavigableSetTester {

	public static void main(String[] args) {
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("a");
		treeSet.add("aa");
		treeSet.add("c");
		treeSet.add("cc");
		treeSet.add("b");
		treeSet.add("bb");
		System.out.println(treeSet);
		NavigableSet<String> descendingSet = treeSet.descendingSet();
		System.out.println(descendingSet);
		System.out.println("Ceiling for \"a\" : " + treeSet.ceiling("a"));
		System.out.println("Ceiling for \"aaa\" : " + treeSet.ceiling("aaa"));
		System.out.println();
		System.out.println("Higher for \"a\" : " + treeSet.higher("a"));
		System.out.println("Higher for \"aaa\" : " + treeSet.higher("aaa"));
		System.out.println();
		System.out.println("Floor for \"a\" : " + treeSet.floor("a"));
		System.out.println("Floor for \"aaa\" : " + treeSet.floor("aaa"));
		System.out.println();
		System.out.println("Lower for \"a\" : " + treeSet.lower("a"));
		System.out.println("Lower for \"aaa\" : " + treeSet.lower("aaa"));
		System.out.println();
		System.out.println();
		System.out.println("Ceiling for \"a\" : " + descendingSet.ceiling("a"));
		System.out.println("Ceiling for \"aaa\" : " + descendingSet.ceiling("aaa"));
		System.out.println();
		System.out.println("Higher for \"a\" : " + descendingSet.higher("a"));
		System.out.println("Higher for \"aaa\" : " + descendingSet.higher("aaa"));
		System.out.println();
		System.out.println("Floor for \"a\" : " + descendingSet.floor("a"));
		System.out.println("Floor for \"aaa\" : " + descendingSet.floor("aaa"));
		System.out.println();
		System.out.println("Lower for \"a\" : " + descendingSet.lower("a"));
		System.out.println("Lower for \"aaa\" : " + descendingSet.lower("aaa"));

		SortedSet<String> tailSet = treeSet.tailSet("b");
		System.out.println(tailSet);
		NavigableSet<String> tailSet2 = treeSet.tailSet("b", true);
//		tailSet2.add(" a"); // java.lang.IllegalArgumentException: key out of range
		System.out.println(tailSet2);
		NavigableSet<String> tailSet3 = treeSet.tailSet("b", false);
		System.out.println(tailSet3);
		String pollFirst = tailSet3.pollFirst();
		tailSet3.add("bb"); // Mo¿na dodaæ w tym przypadku
		System.out.println(pollFirst);
		System.out.println(tailSet);
		System.out.println(tailSet3);
		
	}
}
