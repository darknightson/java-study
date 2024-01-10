package FunctionInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// 이거 중요함
public class PredicateTest {
    public static void main(String[] args) {
        Math.random();
        List<Integer> integers = Arrays.asList(10, 20, -2, -3);
        Predicate<Integer> predicatePlus = ( Integer x ) -> {
            return x > 0;
        };

    }

    public static <T> List<T> filter(List<T> inputs, Predicate<T> predicate) {
        List<T> outputs = new ArrayList<>();
        for ( T input : inputs ) {
            if ( predicate.test(input) ) {
                outputs.add(input);
            }
        }
        return outputs;
    }
}
