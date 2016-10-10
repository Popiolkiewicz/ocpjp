package misc;
/**
 * 
 */

/**
 * Created on 3 maj 2016 - 20:31:15
 *
 * @author Hubert
 */
public class MethodLocalInnerClassesTester {

}

class Outer2 {
	
	void outerDo() {
		class MethodClass {
			private int innerValue = 70;
			private final int innerFinalValue = 70;
//			private static int staticInnerValue = 70;
			private static final int STATIC_FINAL_INNER_VALUE = 70;
		}
//		static class StaticMethodClass {
//			
//		}

	}
	
	static void staticOuterDo() {
		class MethodClass {
			private int innerValue = 70;
			private final int innerFinalValue = 70;
//			private static int staticInnerValue = 70;
			private static final int STATIC_FINAL_INNER_VALUE = 70;
		}
		
		MethodClass methodClass = new MethodClass();
		int staticFinalInnerValue = MethodClass.STATIC_FINAL_INNER_VALUE;
//		static class StaticMethodClass {
//			
//		}
	}
}