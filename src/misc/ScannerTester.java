package misc;
import java.util.Scanner;

class ScannerTester {
	public static void main(String[] args) {
		boolean b2, b;
		int i;
		String s, hits = " ";
		Scanner s1 = new Scanner("asdfasdfa true false 1 2 3");
		Scanner s2 = new Scanner("asdfasdfa true false 1 2 3");
		while (b = s1.hasNext()) {
			s = s1.next();
			hits += "s";
		}
		while (b = s2.hasNext()) {
			if (s2.hasNextInt()) {
				i = s2.nextInt();
				hits += "i";
			} else if (s2.hasNextBoolean()) {
				b2 = s2.nextBoolean();
				hits += "b";
			} else {
				s2.next();
				hits += "s2";
			}
		}
		System.out.println("hits " + hits);
	}
}