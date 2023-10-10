package t18;

/**
 * 当创建toString()方法时，如果操作很简单，通常可以依赖编译器，让它以
 * 合理的方式自行构建结果。但是如果涉及循环，并且对性能也有一定要求，那就需要在
 * toString()中显式使用StringBuilder了
 * java不支持操作符重载，但String的加和加等内部会通过StringBuilder完成操作
 * 【IDEA会提示优化循环中的'+='】
 */
public class UsingStringBuilder {
    static String implicit(String[] strings) {
        String result = "";
        for (String string : strings) {
            result += string;
        }

        return result;
    }

    static String explicit(String[] strings) {
        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string);
        }

        return result.toString();
    }
    public static void main(String[] args) {
        int loopTime = (int)1e7;
        String[] strings = "01,23,45,67,89".split(",");

        long l = System.currentTimeMillis();
        for (int i = 0; i < loopTime; i++) {
            String s = implicit(strings);
        }
        long x = System.currentTimeMillis() - l;
        System.out.println(x);
        l = System.currentTimeMillis();

        for (int i = 0; i < loopTime; i++) {
            String s = explicit(strings);
        }
        long y = System.currentTimeMillis() - l;
        System.out.println(y);
        System.out.println("结论：使用StringBuilder优化后的循环字符串操作效率提高了 " +
                String.format("%.2f", (x-y) / (double)x * 100)
                + " %!");
    }
}
