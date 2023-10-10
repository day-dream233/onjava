package t18;

public class Print {
    public static void main(String[] args) {
        int a = 1, b = 2;
        double c = 0d;
        System.out.printf("%d%d%.2f%n", a, b, c);
        System.out.format("%d%d%.2f%n", a, b, c);
        System.out.println("结论：format()和printf()是等价的。");
    }
}
