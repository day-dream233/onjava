package t17;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Directories {
    static Path test = Paths.get("test");
    static String sep = FileSystems.getDefault().getSeparator();
    static List<String> parts = Arrays.asList("a", "b", "c");

    public static void main(String[] args) throws IOException {
        refreshTestDir();
        Files.createFile(test.resolve("Hello.txt"));
        Path path = makeVariant();
        try {
            Files.createDirectory(path);
        } catch (IOException e) {
            System.out.println("无法创建目录");
        }
        Path dir = Files.createTempDirectory(test, "DIR_");
        Files.createTempFile(dir, "suffix", ".non");
        Files.createTempFile(dir, null, null);  // 不指定后缀时默认为tmp
        populateDir();

        Files.newDirectoryStream(test).forEach(System.out::println);
        System.out.println("************************");
        Files.walk(test).forEach(System.out::println);
    }

    static Path makeVariant() {
        Collections.rotate(parts, 1);
        return Paths.get("test", String.join(sep, parts));
    }

    static void refreshTestDir() throws IOException {
        if (Files.exists(test)) {
            rmdir(test);
        }

        if (Files.notExists(test)) {
            Files.createDirectory(test);
        }
    }

    static void rmdir(Path path) throws IOException {
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

    static void populateDir() throws IOException {
        Path path = makeVariant();
        if (Files.notExists(path)){
            // 使用createDirectories()创建了完整的目录路径
            Files.createDirectories(path);
            Files.copy(Paths.get("pom.xml"), path.resolve("pom_xml.backup"));
            Files.createTempFile(path, null, null);
        }
    }
}
