package misc;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.concurrent.TimeUnit;

/**
 * 
 */

/**
 * @author Hubert
 *
 */
public class SetAttributeTester {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("someOtherFile.txt");
		if (!Files.exists(path))
			Files.createFile(path);
		// Files.setAttribute(path, "hidden", true); //java.lang.IllegalArgumentException: 'basic:hidden' not recognized
		Files.setAttribute(path, "dos:hidden", true);
		Files.setAttribute(path, "posix:group", "afasdf");
		FileTime lastModifiedTime = FileTime.from(1, TimeUnit.HOURS);
		Files.setAttribute(path, "lastModifiedTime", lastModifiedTime);
		
		UserPrincipalLookupService userPrincipalLookupService = FileSystems.getDefault().getUserPrincipalLookupService();
//		userPrincipalLookupService.lookupPrincipalByGroupName("admin");
		
		PosixFileAttributeView pfav = Files.getFileAttributeView(path, PosixFileAttributeView.class);
		pfav.setPermissions(PosixFilePermissions.fromString("r--r--r--"));
		
	}
}
