package streams;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StreamConstructSeen {

	public static void main(String[] args) throws FileNotFoundException {
		new DataInputStream(new BufferedInputStream(new FileInputStream("someFile")));
		new DataInputStream(new BufferedInputStream(new FileInputStream(new File("someFile"))));
//		new DataInputStream(new BufferedInputStream(new FileReader("adfdas")));
//		new BufferedReader(new FileInputStream("sdfas"));
		
	}

}
