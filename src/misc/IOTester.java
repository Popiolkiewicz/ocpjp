package misc;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class IOTester {
	public static void main(String[] args) {
//		test1();
		test2();
	}

	private static void test1() {
		Path file1 = Paths.get("test1");   
		Path file2 = Paths.get("myDirectory/test1");        
		try {
			Files.copy(file1, file2);
			Files.copy(file1, file2, StandardCopyOption.REPLACE_EXISTING);
			Files.copy(file1, file2, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void test2() {
		Path file1 = Paths.get("test1");   
		Path file2 = Paths.get("myDirectory/test1");
		try {
			Files.newBufferedWriter(file1, Charset.forName("UTF-8"),
					new OpenOption[] {StandardOpenOption.WRITE, StandardOpenOption.DSYNC});
			Files.newBufferedWriter(file1, Charset.forName("UTF-8"),
					new OpenOption[] {StandardOpenOption.WRITE, StandardOpenOption.DSYNC});
//			OutputStream newOutputStream = Files.newOutputStream(file2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
