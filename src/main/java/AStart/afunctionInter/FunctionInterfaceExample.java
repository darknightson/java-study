package AStart.afunctionInter;

import java.util.function.Function;

public class FunctionInterfaceExample {

    public static void main(String[] args) {

        /*
        T, R T를 받아서 R을 리턴한다.
         */

        Function<String, Integer> toInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };
        final Integer apply = toInt.apply("100");
        System.out.println("apply = " + apply);

        Function<String, Integer> toInt1 = s -> Integer.parseInt(s);
        final Integer apply1 = toInt1.apply("100");
        System.out.println("apply1 = " + apply1);
    }
}
