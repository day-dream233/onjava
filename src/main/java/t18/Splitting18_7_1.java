package t18;

import java.util.Arrays;

public class Splitting18_7_1 {
    public static void main(String[] args) {
        String s = """
                Hello, everyone!
                Today is a sunny day,
                I hope everybody have a good day.
                """;
        String[] split = s.split(" ");  // 正则表达式不必包含特殊字符
        System.out.println(Arrays.toString(split));

        System.out.println();

        // String.split()有一个重载版本可以限制拆分发生的次数。
        String[] split1 = s.split(" ", 3);
        System.out.println(Arrays.toString(split1));

        System.out.println();

        String[] wordSplit = s.split("\\W+");  // 不是单词的字符
        System.out.println(Arrays.toString(wordSplit));

        System.out.println();

        String[] yAndNotWordSplit = s.split("y\\W+");  // y后面跟不是单词的字符
        System.out.println(Arrays.toString(yAndNotWordSplit));

    }
}
