package modenjava_20220517_start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionExample {

    public static void main(String[] args) {

        Function<Integer, Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return 10 + integer;
            }
        };

        System.out.println("function = " + function.apply(1));

        Function<Integer, Integer> fnc = integer -> integer + 1;
        System.out.println("fnc = " + fnc.apply(10));

        // Predicate
        Predicate<Integer> predicate = integer -> integer > 5;
        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        final List<Integer> function1 = function(integers, predicate);
        final List<Integer> function2 = function(integers, integer -> integer < 5);
        System.out.println("function1 = " + function1.toString());
        System.out.println("function2 = " + function2.toString());
    }

    public static <T> List<T> function(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }


}
