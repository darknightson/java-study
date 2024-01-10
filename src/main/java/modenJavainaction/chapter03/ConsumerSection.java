package modenJavainaction.chapter03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerSection {
    public static void main(String[] args) {
        // Integer 1,2,3,4,5를 받아서 출력 하는 컨슈머
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("integer = " + integer);
            }
        };

//        list.stream()
//                .forEach(x -> System.out.println("x = " + x));

        accept(list, consumer);

        list.stream()
                .forEach(i -> System.out.println("list = " + i));

        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("test = " + integer);

            }
        };

        for ( Integer i : list ) {
            integerConsumer.accept(i);
        }

    }
    public static <T> void accept(List<T> list, Consumer<T> consumer) {
        for ( T t : list ) {
            consumer.accept(t);
        }
    }

}
