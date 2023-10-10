package t18;

/**
 * 对于代码的读者来说，参数一般是给方法提供信息的，
 * 而不是要被修改的。这种不变性是一个重要的保证，
 * 因为它使代码更易于编写和理解。
 */
public class Immutable {
    static String upper(String origin) {
        return origin.toUpperCase();
    }

    public static void main(String[] args) {
        String s = "Hello World!";
        String ss = upper(s);

        System.out.println("s = " + s);
        System.out.println("ss = " + ss);
    }
}
