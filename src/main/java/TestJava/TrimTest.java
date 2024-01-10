package TestJava;

import org.apache.commons.lang3.StringUtils;

public class TrimTest {
    public static void main(String[] args) {
        String s = " Hello World! ";
        System.out.println("s.length() = " + s.length());
        String s1 = StringUtils.trimToEmpty(s);
        System.out.println("s1.length() = " + s1.length());
        System.out.println("s = " + s1);
    }
}
