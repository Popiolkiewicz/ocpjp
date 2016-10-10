package misc;
/**
 * Created on 3 maj 2016 - 19:30:34
 *
 * @author Hubert
 */
public class NestedClassesTester {

	public static void main(String[] args) {
		Outer.Inner.class.getName();
//		Outer.new Inner();
//		new Outer.Inner();
		Outer.Inner inner = new Outer().new Inner();

		Outer.Nested.class.getName();
//		Outer.new Nested();
		Outer.Nested nested = new Outer.Nested();
//		new Outer().new Nested();
	}
	
	public void main2() {
		
	}
}

class Outer {
	
	private int value = 7;
	private static int staticValue = 7;
	
	public void initClasses() {
		new Inner();
		new Outer.Inner();
		new Outer().new Inner();

		new Nested();
		new Outer.Nested();
//		new Outer().new Nested();
		
		value = 10;
		staticValue = 10;
	}
	
	public static void staticInitClasses() {
//		new Inner();
//		new Outer.Inner();
		new Outer().new Inner();

		new Nested();
		new Outer.Nested();
//		new Outer().new Nested();
		
//		value = 10;
		staticValue = 10;
	}
	
	public class Inner {

		private int innerValue = 70;
		private final int innerFinalValue = 70;
//		private static int staticInnerValue = 70;
		private static final int STATIC_FINAL_INNER_VALUE = 70;
		
		public void innerDo() {
			staticInitClasses();
			Outer.staticInitClasses();
			initClasses();
			Outer.this.initClasses();
		}
//		public static void staticInnerDo() {}
		public final void nestedFinalDo() {}
//		public static final void staticFinalNestedDo() {}
		
		public class InnerInner {}
//		public static class InnerNested{}
	}

	public static class Nested {

		private int nestedValue = 70;
		private final int nestedFinalValue = 70;
		private static int staticNestedValue = 70;
		private static final int STATIC_FINAL_NESTED_VALUE = 70;
		
		public void nestedDo() {
			staticInitClasses();
			Outer.staticInitClasses();
//			initClasses();
//			Outer.this.initClasses();
		}
		public static void staticNestedDo() {
			staticInitClasses();
			Outer.staticInitClasses();
//			initClasses();
//			Outer.this.initClasses();
		}
		public final void nestedFinalDo() {}
		public static final void staticFinalNestedDo() {}
		
		public class NestedInner {}
		public static class NestedNested{}
	}

	public interface InnerInterface {
		public class InnerInterfaceInner {}
		public static class InnerInterfaceNested{}
		public interface InnerInterfaceInnerInterface {}
		public static interface InnerInterfaceNestedInterface {}
	}

	public static interface NestedInterface {
		public class NestedInterfaceInner {}
		public static class NestedInterfaceNested{}
		public interface NestedInterfaceInnerInterface {}
		public static interface NestedInterfaceNestedInterface {}
	}
}