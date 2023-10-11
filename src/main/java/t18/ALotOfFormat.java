package t18;

import java.util.Formatter;

/**
 * 1. new Formatter().format()
 * 2. String.format()
 * 3. string.formatted()
 * (4. System.out.printf()/format())
 * EXTRA: 文本块的缩进
 */
public class ALotOfFormat {
    public static void main(String[] args) {
        int a = 1, b = 233;
        double c = 123.456;
        String s = "Hello World!";

        Formatter formatter = new Formatter(System.out);
        formatter.format("%d %d %.2f %s%n", a, b, c, s);

        String format = String.format("%d %d %.2f %s%n", a, b, c, s);
        System.out.println(format);

        String formatted = """
                %d %d %.2f %s%n
                """.formatted(a, b, c, s);
        System.out.println(formatted);

        String s1 = """
                                        HelloWorld!
                """;
        System.out.println("s1 = " + s1);
        System.out.println("文本块的缩进与第二个三双引号的位置相关");
    }
}
