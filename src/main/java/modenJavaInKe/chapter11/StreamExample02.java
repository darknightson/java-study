package modenJavaInKe.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamExample02 {
    public static void main(String[] args) {
        // old, 3보다 큰 값을 담는다.
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> result = new ArrayList<>();
        Integer resultNumber = null;
        for ( final Integer number : numbers ) {
            if ( number > 3 && number < 9 ) {
                // 3보다 크고 9 보다 작고 이 수중에 * 2 그리고 가장 처음 찾은 10 큰 숫자 한개. 그럼 12가 나와야 함.
                // 2, 3, 4, 5, 6, 7 ,8
                final Integer i = number * 2;
                System.out.println(" " + i);
                if ( i > 10 ) {
                    resultNumber = i;
                    break;
                }
            }
        }

        // 위에 코딩을 Steam 으로 해보자.!
        // 함수형 프로그래밍에서는 null 이라는 개념이 존재하지 않는다
        Integer result1 = numbers.stream()
                .filter(x -> x > 3)
                .filter(x -> x < 9)
                .map(x -> x * 2)
                .filter(x -> x > 10)
                .findFirst().orElse(new Integer("0"));

        System.out.println("result1 = " + result1);


        // 위에 스트림을 모던 함수롤 바꾼다면? 머가 불편한지 알 수 있다. 한번 볼까?
        final List<Integer> filter1 = filter(numbers, x -> x > 3);
        final List<Integer> filter2 = filter(filter1, x -> x < 9);
        final List<Integer> map1 = map(filter2, x -> x * 2);

        System.out.println("filter2 = " + filter2);
        System.out.println("map1 = " + map1);
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for ( final T t : list ) {
            if ( predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for ( final T t : list ) {
            result.add(function.apply(t));
        }
        return result;
    }
}
