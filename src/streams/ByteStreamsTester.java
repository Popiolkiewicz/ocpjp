package streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamsTester {

	public static void main(String[] args) throws IOException {
		FileInputStream fis= null;
		FileOutputStream fos= null;
		try {
			fis = new FileInputStream("streams/xanadu.txt");
			fos = new FileOutputStream("streams/xanaduout1.txt");
			int c;
			
			while((c=fis.read()) != -1)
				fos.write(c);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(fis != null)
				fis.close();
			if(fos != null)
				fos.close();
		}
	}

}
