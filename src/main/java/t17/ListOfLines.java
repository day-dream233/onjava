package t17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ListOfLines {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src", "main", "java", "t17", "Motto.txt");
        List<String> strings = Files.readAllLines(path);

        strings.forEach(System.out::println);

        // 如果文件非常大，为避免耗尽内存就需要通过Stream来操作
        Files.lines(path).skip(1).findFirst().ifPresent(System.out::println);
    }
}
