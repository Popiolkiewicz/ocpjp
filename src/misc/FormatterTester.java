package misc;


import java.util.Locale;

/**
 * %[arg_index$][flags][width][.precision]conversion char <br><Br>
 * 
 * Created on 3 maj 2016 - 13:57:16
 *
 * @author Hubert
 */
class FormatterTester {

	static boolean b = true;
	static int i1 = 100;
	static int i2 = -200;
	static double d = -23.20;
	static char ch = 'm';
	static String str = "hello";
	
	public static void main(String[] args) {
	    testb();
	    System.out.println();
	    testc();
	    System.out.println();
		testd();
	    System.out.println();
		testf();
	    System.out.println();
		tests();
	    System.out.println();
		testWidth();
	    System.out.println();
		testLeftJustify();
	    System.out.println();
		testPlus();
	    System.out.println();
	    testBracket();
	    System.out.println();
	    testPlusBracket();
	    System.out.println();
	    testPrecission();
	    System.out.println();
	    testPlusBracketZeroPad();
	    System.out.println();
	    examples();
	}

	private static void testb() {
		System.out.printf("\"%b\"", b); // "true"
		System.out.printf("\"%b\"", i1); // "true"
		System.out.printf("\"%b\"", i2); // "true"
		System.out.printf("\"%b\"", d); // "true"
	    System.out.printf("\"%b\"", ch); // "true"
		System.out.printf("\"%b\"", str); // "true"
	}

	private static void testc() {
		// System.out.printf("\"%c\"", b); // java.util.IllegalFormatConversionException: c != java.lang.Boolean
		System.out.printf("\"%c\"", i1); // "d"
		// System.out.printf("\"%c\"", i2); // java.util.IllegalFormatCodePointException: Code point = 0xffffff38
		// System.out.printf("\"%c\"", d); // java.util.IllegalFormatConversionException: c != java.lang.Double
	    System.out.printf("\"%c\"", ch); // "m"
	    // System.out.printf("\"%c\"", str); // java.util.IllegalFormatConversionException: c != java.lang.String
	}

	private static void testd() {
		// System.out.printf("\"%d\"", b); // java.util.IllegalFormatConversionException: d != java.lang.Boolean
		System.out.printf("\"%d\"", i1); // "100"
		System.out.printf("\"%d\"", i2); // "-200"
		// System.out.printf("\"%d\"", d); // java.util.IllegalFormatConversionException: d != java.lang.Double
		// System.out.printf("\"%d\"", ch); // java.util.IllegalFormatConversionException: d != java.lang.Character
		// System.out.printf("\"%d\"", str); // java.util.IllegalFormatConversionException: d != java.lang.String
	}

	private static void testf() {
		// System.out.printf("\"%f\"", b); // java.util.IllegalFormatConversionException: f != java.lang.Boolean
		// System.out.printf("\"%f\"", i1); // java.util.IllegalFormatConversionException: f != java.lang.Integer
		// System.out.printf("\"%f\"", i2); // java.util.IllegalFormatConversionException: f != java.lang.Integer
		System.out.printf("\"%f\"", d); // "-23,200000"
	    // System.out.printf("\"%f\"", ch); // java.util.IllegalFormatConversionException: f != java.lang.Character
		// System.out.printf("\"%f\"", str); // java.util.IllegalFormatConversionException: f != java.lang.String
	}

	private static void tests() {
		System.out.printf("\"%s\"", b); // "true"
		System.out.printf("\"%s\"", i1); // "100"
		System.out.printf("\"%s\"", i2); // "-200"
		System.out.printf("\"%s\"", d); // "-23.2"
	    System.out.printf("\"%s\"", ch); // "m"
		System.out.printf("\"%s\"", str); // "hello"
	}

	private static void testWidth() {
		System.out.printf("\"%6b\"", b); // "  true"
		System.out.printf("\"%6c\"", ch); // "     m"
		System.out.printf("\"%6d\"", i1); // "   100"
		System.out.printf("\"%6d\"", i2); // "  -200"
		System.out.printf("\"%6f\"", d); // "-23,200000"
		System.out.printf("\"%6s\"", str); // " hello"
	}

	private static void testLeftJustify() {
		// System.out.printf("\"%-b\"", b); // java.util.MissingFormatWidthException: %-b
		System.out.printf("\"%-6b\"", b); // "true  "
		System.out.printf("\"%-6c\"", ch); // "m     "
		System.out.printf("\"%-6d\"", i1); // "100   "
		System.out.printf("\"%-6d\"", i2); // "-200  "
		System.out.printf("\"%-6f\"", d); // "-23,200000"
		System.out.printf("\"%-6s\"", str); // "hello "
	}
	
	private static void testPlus() {
		// System.out.printf("\"%-+6b\"", b); // java.util.FormatFlagsConversionMismatchException: Conversion = b, Flags = +
		// System.out.printf("\"%-+6c\"", ch); // java.util.FormatFlagsConversionMismatchException: Conversion = c, Flags = +
		System.out.printf("\"%-+6d\"", i1); // "+100  "
		System.out.printf("\"%-+6d\"", i2); // "-200  "
		System.out.printf("\"%-+6f\"", d); // "-23,200000"
		// System.out.printf("\"%-+6s\"", str); // java.util.FormatFlagsConversionMismatchException: Conversion = s, Flags = +
	}
	
	private static void testBracket() {
		// System.out.printf("\"%(b\"", b); // java.util.FormatFlagsConversionMismatchException: Conversion = b, Flags = (
		// System.out.printf("\"%(c\"", ch); // java.util.FormatFlagsConversionMismatchException: Conversion = c, Flags = (
		System.out.printf("\"%(d\"", i1); // "100"
		System.out.printf("\"%(d\"", i2); // "(200)"
		System.out.printf("\"%(f\"", d); // "(23,200000)"
		// System.out.printf("\"%(s\"", str); // java.util.FormatFlagsConversionMismatchException: Conversion = s, Flags = (
	}
	
	private static void testPlusBracket() {
		System.out.printf("\"%+(d\"", i1); // "+100"
		System.out.printf("\"%+(d\"", i2); // "(200)"
		System.out.printf("\"%+(f\"", d); // "(23,200000)"
		System.out.printf("\"%+(f\"", 123.2d); // "+123,200000"
	}

	private static void testPrecission() {
		// System.out.printf("\"%+(2.2d\"", i1); // java.util.IllegalFormatPrecisionException: 2
		// System.out.printf("\"%+(2.2d\"", i2); // java.util.IllegalFormatPrecisionException: 2
		System.out.printf("\"%+(2.0f\"", d); // "(23)"
		System.out.printf("\"%+(2.1f\"", d); // "(23,2)"
		System.out.printf("\"%+(2.2f\"", d); // "(23,20)"
		System.out.printf("\"%+(2.20f\"", d); // "(23,20000000000000000000)"
		System.out.printf("\"%+(2.2f\"", -12.234); // "(12,23)"
		System.out.printf("\"%+(2.2f\"", -12.235); // "(12,24)"
		System.out.printf("\"%+(2.2f\"", 12.235); // "+12,24"
	}
	
	private static void testPlusBracketZeroPad() {
		// System.out.printf("\"%+(0d\"", i1); // java.util.MissingFormatWidthException: %+0(d
		System.out.printf("\"%+(08d\"", i1); // "+0000100"
		System.out.printf("\"%+(08d\"", i2); // "(000200)"
		System.out.printf("\"%+(08f\"", d); // "(23,200000)"
		System.out.printf("\"%+(08.3f\"", d); // "(23,200)"
		System.out.printf("\"%+(08.4f\"", d); // "(23,2000)"
		System.out.printf("\"%+(08.3f\"", d); // "(23,200)"
	}

	private static void examples() {
		System.out.printf("\"%-+5d4\"", i1); // "+100 4"
		System.out.printf("\"%(d+10\"", i2); // "(200)+10"
		
		System.out.println();

		System.out.printf("\"$%.2f\"", d); // "$-23,20"
		Locale plLoc = Locale.getDefault();
		Locale.setDefault(Locale.US);
		System.out.printf("\"$%.2f\"", d); // "$-23.20"
		Locale.setDefault(plLoc);
		System.out.printf("\"%2$c + %1$d\"", i1, ch); // "m + 100"
		
		System.out.println();
		
		System.out.printf("%1$s %s %<s", "A", "B", "C"); // A A A
		System.out.printf("%1$s %<s %s", "A", "B", "C"); // A A A
		System.out.printf("%1$s %<s %<s", "A", "B", "C"); // A A A
		System.out.printf("%3$s %<s %s", "A", "B", "C"); // C C A
		System.out.printf("%3$s %s %s %<s", "A", "B", "C"); // C A B B
		
		System.out.println();

		System.out.printf("\"%d\"", -2222); // "-2 222"
		System.out.printf("\"%,d\"", -2222); // "-2 222"
		Locale.setDefault(Locale.US);
		System.out.printf("\"%,d\"", -2222); // "-2,222"
		Locale.setDefault(plLoc);
		System.out.printf("\"%,.2f\"", -2222.22); // "-2 222,22"
		Locale.setDefault(Locale.US);
		System.out.printf("\"%,.2f\"", -2222.22); // "-2,222.22"
		Locale.setDefault(plLoc);
	}
}