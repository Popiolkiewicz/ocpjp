package misc;

//@formatter:off
public class OverloadedMethodsTester {

	public static void main(String[] args) {
		test(1); // In int, In long, In Integer, In Object, problem(commenting
					// out Integer..., Object...), In int..., In long..., not
					// applicable
		test(1L); // In long, In Long, In Object problem(commenting
					// out Long..., Object...), In long..., not applicable
		test((byte) 1); //In byte, In int, In long, In Byte, In Object, problem(commenting
						// out Byte..., Object...),In byte..., In int..., In long..., not
						// applicable
		//etc, for primitives
		test(new int[] { 1, 2, 3 }); // In int..., In Object, In Object..., Not
										// applicable
		test(new Object[] { new Object(), new Object() }); // In Object..., In Object, not applicable
		test(new Integer[] { 1, 2, 3});  //In Integer...,  In Object..., In Object, not applicable
		//etc. for Arrays
		
		test(new Object()); //In Object, In Object..., not applicable
		test(new Integer(123)); //In Integer, In Object, in int, in long, problem(commenting
		// out Integer..., Object...), in int..., in long..., not applicable
		test(new Long(1)); // In Long, In Object, in long, problem(commenting
		//out Long..., Object...),
	}

	static void test(Object object) {System.out.println("In Object");}
	static void test(Integer integer) { System.out.println("In Integer"); }
	static void test(Byte byte1) { System.out.println("In Byte"); }
	static void test(Long long1) {System.out.println("In Long");	}
	static void test(byte byte1) {System.out.println("In byte");}
	static void test(int int1) {System.out.println("In int");}
	static void test(long long1) {System.out.println("In long");}
	static void test(Object... objects) {System.out.println("In Object...");}
	static void test(Byte... bytes) {System.out.println("In Byte...");}
	static void test(Integer... integers) {System.out.println("In Integer...");}
	static void test(Long... longs) {System.out.println("In Long...");}
	static void test(byte... bytes) {System.out.println("In byte...");}
	static void test(int... ints) {System.out.println("In int...");}
	static void test(long... longs) {System.out.println("In long...");}

	// maj¹c argument Integer i metody Integer... Object... int... long... to muszê wykomentowaæ trzy z nich ¿eby siê skompilowa³o
}
