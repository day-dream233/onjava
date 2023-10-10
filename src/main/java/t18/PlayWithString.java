package t18;

import java.util.Arrays;

public class PlayWithString {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = " World!";

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s1.length() = " + s1.length());
        System.out.println("s1.charAt(1) = " + s1.charAt(1));
        System.out.println("---- TEST getChars ----");
        char[] chars = new char[3];
        s1.getChars(0, 3, chars, 0);
        System.out.println("s1.getChars(0, 3, chars, 0);");
        for (char aChar : chars) {
            System.out.printf(String.valueOf(aChar));
        }
        System.out.println();
        System.out.println("---- END TEST getChars ----");
        System.out.println("s1.toCharArray() = " + Arrays.toString(s1.toCharArray()));
        System.out.println("s1.concat(s2) = " + s1.concat(s2));
        System.out.println("s2.strip() = " + s2.strip());
        String s3 = "hello";
        System.out.println("s3 = " + s3);
        System.out.println("s1.compareTo(s3) = " + s1.compareTo(s3));
        System.out.println("s1.compareToIgnoreCase(s3) = " + s1.compareToIgnoreCase(s3));
        System.out.println("s3.contains(\"e\") = " + s3.contains("e"));
        System.out.println("s3.contains(\"ee\") = " + s3.contains("ee"));
        System.out.println("s1.contentEquals(\"Hello\") = " + s1.contentEquals("Hello"));
        String s4 = "";
        System.out.println("s4 = " + s4);
        System.out.println("s4.isEmpty() = " + s4.isEmpty());
        System.out.println("s1.regionMatches(1, s3, 1, 4) = " + s1.regionMatches(1, s3, 1, 4));
        System.out.println("s1.regionMatches(true, 0, s3, 0, 5) = " + s1.regionMatches(true, 0, s3, 0, 5));
        System.out.println("s1.startsWith(\"H\") = " + s1.startsWith("H"));
        System.out.println("s3.endsWith(\"ello\") = " + s3.endsWith("ello"));
        System.out.println("s1.indexOf(101) = " + s1.indexOf(101));
        System.out.println("s1.indexOf('e') = " + s1.indexOf('e'));
        System.out.println("s3.indexOf('l') = " + s3.indexOf('l'));
        System.out.println("s3.lastIndexOf('l') = " + s3.lastIndexOf('l'));
        System.out.println("s3.substring(1) = " + s3.substring(1));
        System.out.println("s3.substring(1, 4) = " + s3.substring(1, 4));
        System.out.println("s3.replace('l', 'L') = " + s3.replace('l', 'L'));
        System.out.println("s3.replaceAll(\"l\",\"abc\") = " + s3.replaceAll("l", "abc"));
        System.out.println("s2.trim() = " + s2.trim());
        System.out.println("Arrays.toString(chars) = " + Arrays.toString(chars));
        System.out.println("String.valueOf(chars) = " + String.valueOf(chars));


    }
}
