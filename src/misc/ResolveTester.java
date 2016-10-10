package misc;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 */

/**
 * Created on 7 maj 2016 - 16:57:10
 *
 * @author Hubert
 */
public class ResolveTester {

	public static void main(String[] args) {
		try { test1(); } catch (Exception e) { e.printStackTrace(); }
		try { test2(); } catch (Exception e) { e.printStackTrace(); }
		try { resolveSiblingTest(); } catch (Exception e) { e.printStackTrace(); }
	}

	private static void test1() {
		Path absolute = Paths.get("/home/java");
		Path relative = Paths.get("dir");
		Path file = Paths.get("Model.pdf");
		System.out.println("1: " + absolute.resolve(relative)); //   /home/java/dir
		System.out.println("2: " + absolute.resolve(file)); //   /home/java/Model.pdf
		System.out.println("3: " + relative.resolve(file)); //   dir/Model.pdf
		System.out.println("4: " + relative.resolve(absolute));  //   /home/java
		System.out.println("5: " + file.resolve(absolute));      //   /home/java
		System.out.println("6: " + file.resolve(relative));      //   Model.pdf/dir
	}

	private static void test2() {
		 Path p1 = Paths.get("\\photos\\vacation"); 
		 Path p2 = Paths.get("\\yellowstone"); 
		 System.out.println(p1.resolve(p2)+"  "+p1.relativize(p2)); //   \yellowstone  ..\..\yellowstone
	}

	private static void resolveSiblingTest() {
		Path p1 = Paths.get("c:\\temp\\test1.txt"); 
		System.out.println(p1.resolveSibling("text2.txt"));  //   c:\temp\text2.txt
		Path p2 = Paths.get("c:\\temp\\..\\.\\test1.txt"); 
		System.out.println(p2.resolveSibling("text2.txt"));  //   c:\temp\..\.\text2.txt
		Path p3 = Paths.get("..\\.\\test1.txt"); 
		System.out.println(p3.resolveSibling("text2.txt"));  //   ..\.\text2.txt
	}
}
