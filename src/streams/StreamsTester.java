package streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;

public class StreamsTester {

	public static void main(String[] args) {
		// test1();
		// test2();
		// constructorsTest();
		testRandomAccesFile();
	}

	@SuppressWarnings("resource")
	private static void testRandomAccesFile() {
		RandomAccessFile raf;
		DataInput di;
		DataOutput dop;
		try {
			File someFile = new File("someFile");
			someFile.createNewFile();
			raf = new RandomAccessFile("someFile", "r");
			raf = new RandomAccessFile(someFile, "rwd");
			FileChannel channel = raf.getChannel();
			di = raf;
			dop = raf;
			raf.writeBoolean(false);
			raf.writeBoolean(true);
			raf.writeInt(-1234);
			channel.position(0);
			int read = raf.read();
			int read2 = raf.read();
			int read3 = raf.readInt();
			System.out.println(read);
			System.out.println(read2);
			System.out.println(read3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void test1() {
		File path = new File("asdf.txt");
		String contents = "hello world";
		try {
			OutputStream outStream = new FileOutputStream(path);
			outStream.write(contents.getBytes());
			outStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			String readLine = bufferedReader.readLine();
			System.out.println(readLine);
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void test2() {
		try {
			URL url = new URL("http://www.gutenberg.org/cache/epub/2265/pg2265.txt");
			InputStream is = url.openStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void constructorsTest() {
		try {
			FileInputStream fileInputStream = new FileInputStream(new File("sdfasdfas"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputStream();
		outputStream();
	}

	private static void inputStream() {
		InputStream is;
		try {
			is = new FileInputStream(new File("test.txt"));
			is = new FileInputStream("test.txt");
			is = new ObjectInputStream(is); // Takes only inputStream
			is = new DataInputStream(is); // Takes only inputStream
			is = new BufferedInputStream(is);
			is = new BufferedInputStream(is, 1234); // with size
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void outputStream() {
		OutputStream os;
		os = new FileOutputStream(new File("test.txt"));
		os = new FileOutputStream("test.txt");
		os = new FileOutputStream(new File("test.txt"), true); // if append
		os = new FileOutputStream("test.txt", true); // if append
		os = new ObjectOutputStream(os); // Takes only outputStream
		os = new DataOutputStream(os); // Takes only outputStream
		os = new BufferedOutputStream(os);
		os = new BufferedOutputStream(os, 1234); // with size
	}
}
