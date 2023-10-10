package t18;

import java.util.stream.Stream;

public class InfiniteRecursion {
    @Override
    public String toString() {
        return "address: " + super.toString() + "\n";
//        自动类型转换
//        return "address: " + this + "\n";

    }

    public static void main(String[] args) {
        // 如果是直接调用this - 会抛出很长的异常栈 - 因为this也还是调用自身的toString方法 - 所以需要换成super.toString()
        Stream.generate(InfiniteRecursion::new).limit(10).forEach(System.out::println);
    }
}
