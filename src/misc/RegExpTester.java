package misc;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Search, parse, and replace strings by using regular expressions, using
 * expression patterns for matching limited to . (dot), * (star), + (plus), ?,
 * \d, \D, \s, \S, \w, \W, \b, \B, [], and (). (5.2) <br>
 * <br>
 * Created on 3 maj 2016 - 15:02:21
 *
 * @author Hubert
 */
public class RegExpTester {
	public static void main(String[] args) {
		check("aba", "ababababababab"); // 0 4 8 
		check("ab", "abdashjfabaadjfabdsfab"); // 0 8 15 20 

					//01234567890
		check("\\d", "a12c3e456f"); // 1 2 4 6 7 8
		check("\\D", "a12c3e456f"); // 0 3 5 9

					//01234567890
		check("\\w", "a 1 56 _Z&^%"); // 0 2 4 5 7 8
		check("\\W", "a 1 56 _Z&^%"); // 1 3 6 9 10 11

					//01234567890
		check("\\s", "w1w w$ &#w1"); // 3 6
		check("\\S", "w1w w$ &#w1"); // 0 1 2 4 5 7 8 9 10
		
					//01234567890
		check("\\b", "w2w w$ &#w2"); // 0 3 4 5 9 11
		check("\\B", "w2w w$ &#w2"); // 1 2 6 7 8 10
		check("\\b", "#ab de#"); // 1 3 4 6
		check("\\B", "#ab de#"); // 0 2 5 7

						 //01234567890
		check("[a-cA-C]", "cafeBABE"); // 0 1 4 5 6
		check("0[xX][0-9a-fA-F]", "12 0x 0x12 0Xf 0xg"); // 6(0x1) 11(0Xf)
		
					 //01234567890
		check("\\d+", "1 a12 234b"); // 0 3 6
		check("0[xX]([0-9a-fA-F])+", "12 0x 0x12 0Xf 0xg"); // 6(0x12) 11(0Xf)
		
		                     //01234567890123456789012345678901234567890123456789
		check("proj1([^,])*", "proj3.txt,proj1sched.pdf,proj1,proj2,proj1.java"); // 10 25 37
		
		 			  //012345678901234567890
		check("\\da?", "b1a2b3d567xa7aa8"); // 1 3 5 7 8 9 12 15
		            //0123456789012
		check("a.c", "ac abc a c"); // 3 7
		
		check(".*xx", "yyxxxyxx"); // 0 
		check(".*?xx", "yyxxxyxx"); // 0 4
		
		check("\\d\\w", "ab4 56_7ab"); // 4 7
	}

	private static void check(String expression, String source) {
	    Pattern p = Pattern.compile(expression);
	    Matcher m = p.matcher(source);                     			// string to search
	    System.out.println("\nsource: " + source);
	    System.out.println(" index: 0123456789012345678901\n");  	// the index
	    System.out.println("expression: " + m.pattern());   		// the search expression
	    System.out.println("matches (start, end, group): ");        // matches positions
	    while(m.find()) {
	    	System.out.println(m.start() + " " + m.end() + " " + m.group());
	    }
	    System.out.println("");
	}
}