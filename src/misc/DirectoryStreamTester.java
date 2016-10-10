package misc;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamTester {

	public static void main(String[] args) {
		test1();
		test2();
	}

	private static void test1() {
		Path dir = Paths.get("dir");
		try (DirectoryStream<Path> stream =         // use try with resources
		      Files.newDirectoryStream(dir)) {      // so we don't have close()
		  for (Path path : stream)                  // loop through the stream
		      System.out.println(path.getFileName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test2() {
		Path dir = Paths.get("dir");
		try (DirectoryStream<Path> stream =      
		      Files.newDirectoryStream(dir, "[a]*")) {     
		  for (Path path : stream)                  
		      System.out.println(path.getFileName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
