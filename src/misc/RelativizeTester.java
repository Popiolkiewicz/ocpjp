package misc;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 */

/**
 * Created on 7 maj 2016 - 16:57:01
 *
 * @author Hubert
 */
public class RelativizeTester {

	public static void main(String[] args) {
		try { test1(); } catch (Exception e) { e.printStackTrace(); }
		try { test2(); } catch (Exception e) { e.printStackTrace(); }
	}

	private static void test1() {
		Path absolute1 = Paths.get("/home/java");
		Path absolute2 = Paths.get("/usr/local");
		Path absolute3 = Paths.get("/home/java/temp/music.mp3");
		Path relative1 = Paths.get("temp");
		Path relative2 = Paths.get("temp/music.pdf");
		Path relative3 = Paths.get("mydir/mydoc.doc");
		System.out.println("1: " + absolute1.relativize(absolute3)); //   temp/music.mp3
		System.out.println("2: " + absolute3.relativize(absolute1)); //   ../..
		System.out.println("3: " + absolute1.relativize(absolute2)); //   ../../usr/local
		System.out.println("4: " + relative1.relativize(relative2)); //   music.pdf
		//System.out.println("5: " + absolute1.relativize(relative1)); //   java.lang.IllegalArgumentException: 'other' is different type of Path
		//System.out.println("6: " + relative1.relativize(absolute1)); //   java.lang.IllegalArgumentException: 'other' is different type of Path
		System.out.println("7: " + relative3.relativize(relative1)); //   ..\..\temp
		System.out.println("8: " + relative3.relativize(relative2)); //   ..\..\temp\music.pdf
	}
	
	private static void test2() {
		Path p1 = Paths.get("c:\\personal\\.\\photos\\..\\readme.txt"); 
		Path p2 = Paths.get("c:\\personal\\index.html");
		Path p3 = Paths.get("c:\\personal\\.\\..\\index.html");
		Path p4 = Paths.get("c:\\personal\\..\\.\\index.html");
		System.out.println("1: " + p1.relativize(p2)); //  ..\..\..\..\index.html
		System.out.println("2: " + p2.relativize(p1)); //  ..\.\photos\..\readme.txt
		System.out.println("3: " + p1.relativize(p3)); //  ..\..\..\..\index.html
		System.out.println("4: " + p1.relativize(p4)); //  ..\..\..\..\..\.\index.html
	}
}
