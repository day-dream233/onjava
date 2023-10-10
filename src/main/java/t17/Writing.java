package t17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Writing {
    static Random random = new Random();

    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[233];
        random.nextBytes(bytes);

        Path path = Paths.get("text.txt");
        Files.write(path, bytes);
        System.out.println("Files.size(path) = " + Files.size(path));
        System.out.println("Files.size(Paths.get(\"pom.xml\")) = " + Files.size(Paths.get("pom.xml")));
    }
}
