package t19;


class A {
    static {
        System.out.println("loading class A...");
    }
}
class B {
    static {
        System.out.println("loading class B...");
    }
}
class C {
    static {
        System.out.println("loading class C...");
    }
}
public class ClassLoadDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        new B();
        new A();
        new C();
        System.out.println(Class.forName("t19.A"));
    }
}
