package TestJava;

import java.util.Arrays;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        final List<String> strings = Arrays.asList("1", "2");

        String[] array = new String[]{"1","2"};

        try {
            final String s = strings.get(3);
        } catch (ArrayIndexOutOfBoundsException e ) {

            System.out.println("e.getMessage()1 = " + e.getMessage());
        } catch ( Exception e ) {

            System.out.println("e.getMessage()2 = " + e.getMessage());
        }



    }
}
