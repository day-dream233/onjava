package t17;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Random;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class hw {
    static Random random = new Random();

    public static void main(String[] args) throws IOException, InterruptedException {
        // 1. 在项目根目录刷新一个"t17hw"和"backup"文件夹(存在则删除,保证创建出该文件夹)
        // 2. 监视t17hw文件夹，如果有创建操作则为该文件创建一个备份（分别放到第一步的文件夹中）
        // 3. 创建一个临时文件,并插入随机二进制内容,文件名以.bk为后缀
        Path path = Paths.get("t17hw");
        Path backup = Paths.get("backup");
        refreshThePath(path);
        refreshThePath(backup);

        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.register(watchService, ENTRY_MODIFY);

//        Executors.newSingleThreadScheduledExecutor().schedule(() -> {
//            try {
//            } catch (IOException | InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }, 0, TimeUnit.MILLISECONDS);

        byte[] bytes = new byte[100];
        random.nextBytes(bytes);
        try {
            Files.write(path.resolve("abc.dat"), "hello world!".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (WatchEvent<?> pollEvent : watchService.take().pollEvents()) {
            Path source = path.resolve(String.valueOf(pollEvent.context())).toAbsolutePath();
            Files.copy(source, backup.resolve(pollEvent.context().toString()));
            System.exit(0);
        }
    }

    static void refreshThePath(Path path) throws IOException {
        rmdir(path);

        Files.createDirectories(path);
    }

    static void rmdir(Path path) throws IOException {
        if (Files.exists(path)) {
            Files.walkFileTree(path, new SimpleFileVisitor<>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return super.visitFile(file, attrs);
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    return super.postVisitDirectory(dir, exc);
                }
            });
        }
    }
}
