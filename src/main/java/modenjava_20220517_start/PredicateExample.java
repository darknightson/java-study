package modenjava_20220517_start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

    public static void main(String[] args) {
        Predicate<Integer> predicate = integer -> integer > 0;
        System.out.println("predicate.test(1) = " + predicate.test(1));

        // 양수만 찾아보자
        final List<Integer> integers = Arrays.asList(-1, -2, -3, 0, 1, 2, 3);
        Predicate<Integer> predicate1 = integer -> integer > 0;
        final List<Integer> filter = filter(integers, predicate1);
        System.out.println("filter.toString() = " + filter.toString());

        final List<Integer> collect = filter.stream()
                .filter(integer -> integer > 0)
                .collect(Collectors.toList());

        System.out.println("collect = " + collect);

    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> tList = new ArrayList<>();
        for (T t : list) {
            if ( predicate.test(t)) {
                tList.add(t);
            }
        }
        return tList;
    }

}
