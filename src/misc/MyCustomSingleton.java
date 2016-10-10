package misc;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 
 */

/**
 * Created on 12 maj 2016 - 23:15:08
 *
 * @author Hubert
 */
public class MyCustomSingleton {

	private static MyCustomSingleton mySingleton;

	private MyCustomSingleton() {
	}

	public static final MyCustomSingleton getInstance() {
		if (mySingleton == null)
			mySingleton = new MyCustomSingleton();
		return mySingleton;
	}

	private List<String> usersEmails;
	private List<Integer> availableAccountNumbers;
	private TimeUnit defaultApplicationTimeUnit;

	public List<String> getUsersEmails() {
		return usersEmails;
	}

	public void setUsersEmails(List<String> usersEmails) {
		this.usersEmails = usersEmails;
	}

	public List<Integer> getAvailableAccountNumbers() {
		return availableAccountNumbers;
	}

	public void setAvailableAccountNumbers(List<Integer> availableAccountNumbers) {
		this.availableAccountNumbers = availableAccountNumbers;
	}

	public TimeUnit getDefaultApplicationTimeUnit() {
		return defaultApplicationTimeUnit;
	}

	public void setDefaultApplicationTimeUnit(TimeUnit defaultApplicationTimeUnit) {
		this.defaultApplicationTimeUnit = defaultApplicationTimeUnit;
	}

}
