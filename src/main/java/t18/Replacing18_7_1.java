package t18;

public class Replacing18_7_1 {
    public static void main(String[] args) {
        String s = """
                大家好，我是一名喜欢programming的程序猿
                大家好，我是一名professor，想成为歌手
                """;
        System.out.println(s.replaceFirst("p\\w+", "唱跳rap打篮球")  // 表示跟任意单词字符
                .replaceAll("程序猿|歌手|篮球运动员", "练习时长两年半的练习生"));  // 或|

    }
}
