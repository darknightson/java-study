package FunctionInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,2,3);
        Consumer<Integer> integerConsumer = (Integer x) -> {
            System.out.println("x = " + x);
        };
        List<String> strings = Arrays.asList("a","b","c");

        Consumer<String> stringConsumer  = (String x) -> {
            System.out.println("x = " + x);
        };

        process(integerConsumer, integers);
        process(stringConsumer, strings);
    }

    public static <T> void process(Consumer<T> processor, List<T> inputs) {
        for ( T input : inputs ) {
            processor.accept(input);
        }
    }
}
