package misc;
public class TestClass {
	
	private static TestClass instance;
	
	private TestClass() {
	}
	
	public static TestClass getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		TestClass testClass = getInstance();
		System.out.println(testClass.toString());
	}
}