package io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;

public class FileTester {
	private static boolean b;
	private static String[] sa;
	private static File[] fa;
	private static String s;
	private static File f;
	private static Path p;
	private static URI u;

	public static void main(String[] args) throws IOException {
		File file = new File("io/sampleFile.txt");
		b = file.mkdirs();
		b = file.mkdir();
		b = file.createNewFile();
		b = file.exists();
		b = file.isDirectory();
		b = file.isFile();
		sa = file.list();
		fa = file.listFiles();
		b = file.renameTo(new File("io/someOtherFile.txt"));
		b = file.delete();
		s = file.getAbsolutePath();
		s = file.getName();
		s = file.getParent();
		f = file.getParentFile();
		p = file.toPath();
		u = file.toURI();
	}
}
