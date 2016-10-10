package misc;
import java.util.Arrays;

/**
 * Created on 9 maj 2016 - 22:28:57
 *
 * @author Hubert
 */
public class BinarySearchTester {

	/**
	 * white space < digits < uppercase < lowercase
	 * @param args
	 */
	public static void main(String[] args) {
		String [] sa = {"aa", "aaa", "aaaa", "aaaaa"};
		Arrays.sort(sa);
		System.out.println(Arrays.binarySearch(sa, "a")); // -1
		System.out.println(Arrays.binarySearch(sa, "aa")); // 0
		System.out.println(Arrays.binarySearch(sa, "aaa")); // 1
		System.out.println(Arrays.binarySearch(sa, "aaaa")); // 2
		System.out.println(Arrays.binarySearch(sa, "aaaaa")); // 3
		
		System.out.println(Arrays.binarySearch(sa, "b")); // -5
		System.out.println(Arrays.binarySearch(sa, "bb")); // -5
		System.out.println(Arrays.binarySearch(sa, "bbb")); // -5
		System.out.println(Arrays.binarySearch(sa, "bbbb")); // -5
		System.out.println(Arrays.binarySearch(sa, "bbbbb")); // -5
		
		System.out.println(Arrays.binarySearch(sa, "aA")); // -1
		System.out.println(Arrays.binarySearch(sa, "aaA")); // -2
		System.out.println(Arrays.binarySearch(sa, "aaaA")); // -3
		System.out.println(Arrays.binarySearch(sa, "aaaaA")); // -4
		System.out.println(Arrays.binarySearch(sa, "aaaaaA")); // -5
		
		System.out.println(Arrays.binarySearch(sa, "ab")); // -5
		System.out.println(Arrays.binarySearch(sa, "aab")); // -5
		System.out.println(Arrays.binarySearch(sa, "aaab")); // -5
		System.out.println(Arrays.binarySearch(sa, "aaaab")); // -5
		System.out.println(Arrays.binarySearch(sa, "aaaaab")); // -5
		
		System.out.println(Arrays.binarySearch(sa, "aZ")); // -1
		System.out.println(Arrays.binarySearch(sa, "aaZ")); // -2
		System.out.println(Arrays.binarySearch(sa, "aaaZ")); // -3
		System.out.println(Arrays.binarySearch(sa, "aaaaZ")); // -4
		System.out.println(Arrays.binarySearch(sa, "aaaaaZ")); // -5
		
		System.out.println(Arrays.binarySearch(sa, " a")); // -1
		System.out.println(Arrays.binarySearch(sa, " aa")); // -1
		System.out.println(Arrays.binarySearch(sa, " aaa")); // -1
		System.out.println(Arrays.binarySearch(sa, " aaaa")); // -1
		System.out.println(Arrays.binarySearch(sa, " aaaaa")); // -1
		
		System.out.println(Arrays.binarySearch(sa, "1a")); // -1
		System.out.println(Arrays.binarySearch(sa, "1aa")); // -1
		System.out.println(Arrays.binarySearch(sa, "1aaa")); // -1
		System.out.println(Arrays.binarySearch(sa, "1aaaa")); // -1
		System.out.println(Arrays.binarySearch(sa, "1aaaaa")); // -1
		
		System.out.println(Arrays.binarySearch(sa, "Aa")); // -1
		System.out.println(Arrays.binarySearch(sa, "Aaa")); // -1
		System.out.println(Arrays.binarySearch(sa, "Aaaa")); // -1
		System.out.println(Arrays.binarySearch(sa, "Aaaaa")); // -1
		System.out.println(Arrays.binarySearch(sa, "Aaaaaa")); // -1
		
	}

}
