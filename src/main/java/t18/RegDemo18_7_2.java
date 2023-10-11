package t18;

import java.util.Arrays;

/**
 * ChaiSequence 接口 对 CharBuffer、String、StringBuffer 或 StringBuilder 等类进行了抽象，给出了一个字符序列的通用定义：
 */
public class RegDemo18_7_2 {
    public static void main(String[] args) {
        String s = """
                jkfdsdj fsaldjl\ffdklsjkfdl a0x12
                fdsajkl""";
        String[] split = s.split("\\f");
        System.out.println("Arrays.toString(split) = " + Arrays.toString(split));
        System.out.println("s.matches(\".+\") = " + s.matches(".+"));
        System.out.println("s.split(\"\\\\s\") = " + Arrays.toString(s.split("\\s")));
        System.out.println();

        for (String string : new String[]{"Rudolph", "[rR]udolph", "[rR][aeiou][a-z]ol.*", "R.*"}) {
            System.out.println("\"Rudolph\".matches(string) = " + "Rudolph".matches(string));
        }

        String testS = "abcabcabcabc";
        // + 表示一个或多个
        // ? 表示一个或一个也没有
        // * 表示零个或多个
        // {n,m} 表示至少n个,不超过m个(可省m,不可省n)
        System.out.println("\"abcabcabcabc\".matches(\"(abc)+\") = " + testS.matches("(abc)+"));  // 一个或多个
        System.out.println("\"\".matches(\"(abc)+\") = " + "".matches("(abc)+"));
        System.out.println("\"\".matches(\"(abc)*\") = " + "".matches("(abc)*"));  // 零个或多个
        System.out.println("\"abcabcabcabc\".matches(\"(abc){5,}\") = " + testS.matches("(abc){5,}"));  // 大于等于5,如果在花括号中写第二个参数m,则表示不超过m
    }
}
