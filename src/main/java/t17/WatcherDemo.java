package t17;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

/**
 * 不包括子目录下的文件！
 */
public class WatcherDemo {
    static Path test = Paths.get("watcher");
    static Path resolve = test.resolve("不让你删.txt");

    public static void main(String[] args) throws IOException, InterruptedException {
        if (Files.notExists(test)) {
            Files.createDirectory(test);
        }

        createTestFile();

        WatchService watchService = FileSystems.getDefault().newWatchService();

        test.register(watchService, ENTRY_DELETE);
//        Thread.sleep(4000);
        // watchService.take()的调用会停掉一切工作，直到某个事情发生才恢复
        for (WatchEvent<?> pollEvent : watchService.take().pollEvents()) {
            if (pollEvent.context().equals(resolve.getFileName())) {
                createTestFile();
            }
            System.out.println("pollEvent.context() = " + pollEvent.context());
            System.out.println("pollEvent.count() = " + pollEvent.count());
            System.out.println("pollEvent.kind() = " + pollEvent.kind());
            System.exit(0);  // 防止一直监视
        }
    }

    static void createTestFile() throws IOException {
        if (Files.notExists(resolve)) {
            Files.createFile(resolve);
        }
    }
}
