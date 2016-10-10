package misc;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class RBTest {
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("someBundle");
		String string = bundle.getString("someString");
		Enumeration<String> keys = bundle.getKeys();
		Object object = bundle.getObject("someObject");
		String[] stringArray = bundle.getStringArray("someSA");
		Locale locale = bundle.getLocale();
		ResourceBundle.clearCache();
	}
}
