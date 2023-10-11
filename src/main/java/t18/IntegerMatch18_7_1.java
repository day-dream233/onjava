package t18;

/**
 * 如果要在表达式里表示 ''前面有一个或多个”，请使用+
 * 字符串中有+，用\\转义
 */
public class IntegerMatch18_7_1 {
    public static void main(String[] args) {
        String[] maybeNums = {"-241", "-012", "091241", "3O0", "0130j", "f023jfijsd"};

        for (String maybeNum : maybeNums) {
            System.out.printf("maybeNum = %-15s %10s%n", maybeNum, maybeNum.matches("^-?[1-9]\\d+"));
        }
        System.out.println();
        System.out.println("加号或减号");
        System.out.println("\"+\".matches(\"-|\\\\+\") = " + "+".matches("-|\\+"));
    }
}
