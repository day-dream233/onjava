package t19;

interface i1 {}
interface i2 {}
interface i3 {}

class Iimplement implements i1,i2,i3{}

public class Demo19_2 {

    static void printInfo(String s, Class c) {
        System.out.println(s);
        System.out.println("c.getName() = " + c.getName());
        System.out.println("c.getSimpleName() = " + c.getSimpleName());
        System.out.println("c.isInterface() = " + c.isInterface());
        System.out.println("c.getCanonicalName() = " + c.getCanonicalName());
        System.out.println();
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("t19.Iimplement");

        printInfo("forName", aClass);

        for (Class<?> anInterface : aClass.getInterfaces()) {
            printInfo("interface", anInterface);
        }

        printInfo("getSuperclass", aClass.getSuperclass());

        Object obj = aClass.newInstance();
        printInfo("newInstance + 多态", obj.getClass());

        System.out.println();
        System.out.println("Integer.class.getSuperclass() = " + Integer.class.getSuperclass());
        System.out.println("结论：getSuperClass()是获取父类而非Object");
    }
}
