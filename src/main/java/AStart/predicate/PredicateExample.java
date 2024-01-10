package AStart.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

    public static void main(String[] args) {

        final List<Integer> integers = Arrays.asList(1, 2, 3, -1, -2, -3);

        Predicate<Integer> predicate = integer -> integer > 0;

        integers.forEach(integer -> {
            final boolean test = predicate.test(integer);
            System.out.println("test = " + integer +" :: "+ test);
        });

        final List<Integer> collect = integers.stream()
                .filter(integer -> integer > 0)
                .collect(Collectors.toList());

        final List<Integer> collect1 = integers.stream()
                .map(integer -> {
                    if (integer > 0) {
                        return integer + 1;
                    }
                    return integer;
                })
                .collect(Collectors.toList());
        ;
        System.out.println("collect1 = " + collect1);
        
        collect.forEach(integer -> System.out.println("integer = " + integer));

        final List<Integer> filter = filter(integers, predicate);
        System.out.println("filter = " + filter);

    }

    private static <T> List<T> filter(List<T> lists, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T list : lists) {
            if (predicate.test(list) ) {
                result.add(list);
            }
        }
        return result;
    }
}
