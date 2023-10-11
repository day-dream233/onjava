package t18;

/**
 * 字符串中：1个反斜杠需要2个反斜杠来表示
 * 正则表达式中：需要4个！
 */
public class BackSlashes18_7_1 {
    public static void main(String[] args) {
        String one = "\\";
        String two = "\\\\";
        String three = "\\\\\\";
        System.out.println("one = " + one);
        System.out.println("two = " + two);
        System.out.println("three = " + three);
        System.out.println("one.matches(\"\\\\\\\\\") = " + one.matches("\\\\"));
        System.out.println("two.matches(\"\\\\\\\\\\\\\\\\\") = " + two.matches("\\\\\\\\"));
        System.out.println("three.matches(\"\\\\\\\\\\\\\\\\\\\\\\\\\") = " + three.matches("\\\\\\\\\\\\"));
    }
}
