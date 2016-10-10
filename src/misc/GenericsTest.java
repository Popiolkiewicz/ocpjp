package misc;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 9 maj 2016 - 10:59:39
 *
 * @author Hubert Popio³kiewicz
 */
public class GenericsTest {

	public static void main(String[] args) {
	}

	public List<?> m1(ArrayList<?> someList) {
		List<?> newList = new ArrayList<>();
		newList.add(new String("asdf"));
		newList.add(new Object());
		newList.addAll(someList);
		Object x = someList.get(0);
		return newList;
	}

	public List<? extends Object> m6(ArrayList<? extends Object> someList) {
		List<? extends Object> newList = new ArrayList<>();
		newList.add(new String("asdf"));
		newList.add(new Object());
		newList.addAll(someList);
		Object x = someList.get(0);
		return newList;
	}

	public List<? extends Number> m2(ArrayList<? extends Number> someList) {
		List<? extends Number> newList = new ArrayList<>();
		newList.add(new Long(1));
		newList.add(new Object());
		newList.addAll(someList);
		Number number = someList.get(0);
		Object object = someList.get(0);
		Long longg = someList.get(0);
		return newList;
	}

	public List<? super String> m3(ArrayList<? super String> someList) {
		List<? super String> newList = new ArrayList<>();
		newList.add(new String("asdf"));
		newList.add(new Object());
		newList.addAll(someList);
		return newList;
	}

	public List<Number> m4(ArrayList<Number> someList) {
		List<Number> newList = new ArrayList<>();
		newList.add(new Integer(1));
		newList.add(new Long(2));
		newList.addAll(someList);
		Number number = newList.get(0);
		Long longg = newList.get(0);
		return newList;
	}

	public List<? extends Number> m7(ArrayList<Number> someList) {
		List<? extends Number> newList = new ArrayList<>();
		newList.add(new Integer(1));
		newList.add(new Long(2));
		newList.addAll(someList);
		Object object = newList.get(0);
		Number number = newList.get(0);
		Long longg = newList.get(0);
		return newList;
	}

	public List<? super Number> m8(ArrayList<Number> someList) {
		List<? super Number> newList = new ArrayList<>();
		newList.add(new Integer(1));
		newList.add(new Long(2));
		newList.add(new Object());
		newList.addAll(someList);
		Object object = newList.get(0);
		Number number = newList.get(0);
		Long longg = newList.get(0);
		return newList;
	}

	public List<Number> m9(ArrayList<? extends Number> someList) {
		List<Number> newList = new ArrayList<>();
		newList.addAll(someList);
		Object object = newList.get(0);
		Number number = newList.get(0);
		Long longg = newList.get(0);
		return newList;
	}

	public List<Number> m10(ArrayList<? super Number> someList) {
		List<Number> newList = new ArrayList<>();
		newList.addAll(someList);
		Object object = newList.get(0);
		Number number = newList.get(0);
		Long longg = newList.get(0);
		return newList;
	}
}
