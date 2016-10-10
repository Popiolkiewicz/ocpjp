package misc;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 */

/**
 * Created on 8 maj 2016 - 18:41:07
 *
 * @author Hubert
 */
public class NormalizeTester {

	public static void main(String[] args) {
		try { test1(); } catch (Exception e) { e.printStackTrace(); }
		try { test2(); } catch (Exception e) { e.printStackTrace(); }
	}

	private static void test1() {
		System.out.println(Paths.get("/a/./b/./c").normalize()); // \a\b\c
		System.out.println(Paths.get(".classpath").normalize()); // .classpath
		System.out.println(Paths.get("/a/b/c/..").normalize()); // /a/b
		System.out.println(Paths.get("/a/b/c/../d/e").normalize()); // \a\b\d\e
		System.out.println(Paths.get("../a/b/c").normalize()); // ..\a\b\c
		System.out.println(Paths.get("../a/./b/c").normalize()); // ..\a\b\c
		System.out.println(Paths.get("./a/./b/c").normalize()); // a\b\c
		System.out.println(Paths.get(".classpath/..").normalize()); // 
	}

	private static void test2() {
		Path p1 = Paths.get("c:\\..\\temp\\test.txt"); 
		System.out.println(p1.normalize()); // c:\temp\test.txt
		System.out.println(p1.normalize().toUri()); // file:///c:/temp/test.txt
		Path p2 = Paths.get("..\\temp\\test.txt"); 
		System.out.println(p2.normalize()); // ..\temp\test.txt
		System.out.println(p2.normalize().toUri()); // file:///C:/Users/Hubert/LearningRepository/LearningJava/OCPJP/../temp/test.txt
		Path p3 = Paths.get(".\\temp\\.\\test.txt"); 
		System.out.println(p3.normalize()); // temp\test.txt
		System.out.println(p3.normalize().toUri()); // file:///C:/Users/Hubert/LearningRepository/LearningJava/OCPJP/temp/test.txt
	}
}
