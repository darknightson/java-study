package FunctionInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        Function<Integer, Integer> integerIntegerFunction = (Integer x) -> {
          return x + 10;
        };

        System.out.println("integerIntegerFunction =" + integerIntegerFunction.apply(5));

        BiFunction<Integer, Integer,Integer> biFunction = (Integer x, Integer y) -> {
          return x + y + 10;  
        };

        System.out.println("biFunction.apply(10,10) = " + biFunction.apply(10,10));

    }
}
