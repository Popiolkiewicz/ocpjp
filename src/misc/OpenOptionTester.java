package misc;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;

import java.io.IOException;
import java.nio.charset.Charset;

public class OpenOptionTester {

	//TODO
	public static void main(String[] args) throws IOException {
//		fileDoesntExists();
//		fileDoesntExistsCombinations();
		fileExistsReadTest();
	}

	private static void fileExistsReadTest() {
		Path path = Paths.get("sampleFile.txt");
//		Files.newInputStream(path, READ); //OK
		try {
			Files.createFile(path);
//			Files.newInputStream(path, READ, SYNC);//java.lang.UnsupportedOperationException: 'SYNC' not allowed
			Files.delete(path);
		} catch (IOException e) {
			try {
				Files.deleteIfExists(path);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
	}

	private static void fileDoesntExistsCombinations() throws IOException {
		Path path = Paths.get("sampleFile.txt");
//		Files.newBufferedWriter(path, Charset.defaultCharset(), CREATE, APPEND); //OK
//		Files.newBufferedWriter(path, Charset.defaultCharset(), CREATE, CREATE_NEW); // OK
//		Files.newBufferedWriter(path, Charset.defaultCharset(), CREATE, DELETE_ON_CLOSE); // OK
//		Files.newBufferedWriter(path, Charset.defaultCharset(), CREATE, DSYNC); // OK
//		Files.newBufferedWriter(path, Charset.defaultCharset(), CREATE, READ); // java.lang.IllegalArgumentException: READ not allowed
		
//		Files.newBufferedWriter(path, Charset.defaultCharset(), CREATE_NEW); //OK
//		Files.newBufferedWriter(path, Charset.defaultCharset(), CREATE_NEW, CREATE); // OK
		Files.deleteIfExists(path);
	}

	private static void fileDoesntExists() throws IOException {
		Path path = Paths.get("sampleFile.txt");
//		Files.newBufferedWriter(path, Charset.defaultCharset(), APPEND); //java.nio.file.NoSuchFileException: sampleFile.txt
		Files.newBufferedWriter(path, Charset.defaultCharset(), CREATE); //OK
		Files.newBufferedWriter(path, Charset.defaultCharset(), CREATE_NEW); //OK
//		Files.newBufferedWriter(path, Charset.defaultCharset(), DELETE_ON_CLOSE); //java.nio.file.NoSuchFileException: sampleFile.txt
//		Files.newBufferedWriter(path, Charset.defaultCharset(), DSYNC); //java.nio.file.NoSuchFileException: sampleFile.txt
//		Files.newBufferedWriter(path, Charset.defaultCharset(), READ); //java.lang.IllegalArgumentException: READ not allowed
//		Files.newBufferedWriter(path, Charset.defaultCharset(), SPARSE); //java.nio.file.NoSuchFileException: sampleFile.txt
//		Files.newBufferedWriter(path, Charset.defaultCharset(), SYNC); //java.nio.file.NoSuchFileException: sampleFile.txt
//		Files.newBufferedWriter(path, Charset.defaultCharset(), TRUNCATE_EXISTING); //java.nio.file.NoSuchFileException: sampleFile.txt
//		Files.newBufferedWriter(path, Charset.defaultCharset(), WRITE); //java.nio.file.NoSuchFileException: sampleFile.txt
		Files.deleteIfExists(path);
	}

}
