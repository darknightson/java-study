package method.reference;

import javax.print.DocFlavor;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Chapter5Section1 {

    public static int calculate(int x, int y, BiFunction<Integer, Integer, Integer> operator) {
        return operator.apply(x, y);
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static void main(String[] args) {
        Function<String, Integer> strToInt = Integer::parseInt;
        System.out.println("strToInt.apply(\"10\") = " + strToInt.apply("10"));

        String str = "hello";
        Predicate<String> predicate = str::equals;
        System.out.println("predicate.test(str) = " + predicate.test(str));

        int plusResult = calculate(10, 20, (Integer x, Integer y) -> {
            return x + y;
        });
        System.out.println("plusResult = " + plusResult);

        int plusResult1 = calculate(10, 20, (x, y) -> x + y);
        int minusResult = calculate(20, 10, ( Integer x, Integer y) -> x - y);
        System.out.println("plusResult1 = " + plusResult1);
        System.out.println("minusResult = " + minusResult);

        System.out.println(calculate(10,2, Chapter5Section1::multiply));
    }

}
