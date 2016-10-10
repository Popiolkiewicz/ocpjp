package misc;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationTester {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Moo moo = new Moo();
		moo.moo = 10;
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serialFile.ser"));
		oos.writeObject(moo);
		oos.close();

		System.out.println();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serialFile.ser"));
		Moo moo2 = (Moo) ois.readObject();
		ois.close();
		System.out.println(moo2.moo);
	}

}
class Boo {
	public Boo() {
		System.out.println("In Boo");
	}
}

class BooBoo extends Boo {
	public BooBoo() {
		System.out.println("In BooBoo");
	}
}

class Moo extends BooBoo implements Serializable {
	int moo = 10;
	{
		System.out.println("moo set to 10");
	}

	public Moo() {
		System.out.println("In Moo");
	}
}