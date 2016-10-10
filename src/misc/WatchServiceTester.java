package misc;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

public class WatchServiceTester {

	public static void main(String[] args) throws IOException {
		Path dir = Paths.get("dir"); // get directory containing
										// file/directory we care about
		WatchService watcher = FileSystems.getDefault() // file system specific
														// code
				.newWatchService(); // create empty watch service
		dir.register(watcher, ENTRY_DELETE); // needs a static import!
		// start watching for
		// deletions
		while (true) { // loop until say to stop
			WatchKey key;
			try {
//				key = watcher.poll();
//				key = watcher.take();
				key = watcher.poll(10, TimeUnit.SECONDS); // wait for a deletion
			} catch (InterruptedException x) {
				return; // give up if something goes
				// wrong
			}
			for (WatchEvent<?> event : key.pollEvents()) {
				WatchEvent.Kind<?> kind = event.kind();
				System.out.println(kind.name()); // create/delete/modify
				System.out.println(kind.type()); // always a Path for us
				System.out.println(event.context()); // name of the file
				String name = event.context().toString();
				if (name.equals("directoryToDelete")) { // only delete right
														// directory
					System.out.format("Directory deleted, now we can proceed");
					return; // end program, we found what
					// we were waiting for
				}
			}
			key.reset(); // keep looking for events
		}
	}
}
