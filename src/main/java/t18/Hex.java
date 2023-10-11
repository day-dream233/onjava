package t18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Hex {
    public static String formatHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : bytes) {
            if (n % 16 == 0) {
                result.append(String.format("%05X: ", n));
            }
            result.append(String.format("%02X ", b));
            n++;
            if (n % 16 == 0) {
                result.append("\n");
            }
        }
        result.append("\n");
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src", "main", "java", "t18", "Hex.java");
        System.out.println(formatHex(Files.readAllBytes(path)));
    }
}
