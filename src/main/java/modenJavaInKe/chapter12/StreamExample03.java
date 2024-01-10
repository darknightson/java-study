package modenJavaInKe.chapter12;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamExample03 {
    public static void main(String[] args) {
        // stream 의 경우 두 종류의 메소드가 있다.
        // 보통은 이미 만들어진 list 에서 스트림을 사용한다.
        // 또한, stream 에서 static 메소드를 많이 제공하기 때문에 직접 스트림을 만들 수 있다.
        // 예를 들어... 이건 그냥 알아 두자
        final Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        // 보편적으로 이렇게 많이 하겠지..
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // list 로 받아보자.
        final List<String> collect = numbers.stream()
                .filter(number -> number > 2)
                .map(number -> number * 2)
                .map(number -> "#" + number)
                .collect(toList());

        System.out.println("collect = " + collect);

        // set 으로 받아보자. ( 중복을 허용하지 않는다. 그리고 셋은 순서를 보장하지 않는다. )
        final Set<Integer> stream = Stream.of(1, 3, 3, 5, 5)
                .collect(toSet());

        System.out.println("stream = " + stream);

        // joining 으로 받아보자
        final String collect1 = Stream.of(1, 3, 3, 5, 5)
                .filter(i -> i > 2)
                .map(i -> i * 2)
                .map(i -> "#" + i)
                .collect(Collectors.joining(", "));
        System.out.println("collect1 = " + collect1);

        // joining 맨 앞과 뒤에 먼가 char 을 넣고 싶다면?
        final String collect2 = Stream.of(1, 3, 3, 5, 5)
                .filter(i -> i > 2)
                .map(i -> i * 2)
                .map(i -> "#" + i)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("collect2 = " + collect2);

        // string 으로 리턴 받고 싶고 중복을 없애고 싶다면?
        final String collect3 = Stream.of(1, 3, 3, 5, 5)
                .filter(i -> i > 2)
                .map(i -> i * 2)
                .map(i -> "#" + i)
                .distinct()
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("collect3 = " + collect3);

        // list 에서도? 중복을 없애는게 가능할까?
        final List<String> collect4 = Stream.of(1, 3, 3, 5, 5)
                .filter(i -> i > 2)
                .map(i -> i * 2)
                .map(i -> "#" + i)
                .distinct()
                .collect(toList());
        System.out.println("collect4 = " + collect4);

        // 찾아라
        final Optional<Integer> first = Stream.of(1, 2, 3, 4, 5)
                .filter(i -> i > 2)
                .findFirst();
        System.out.println("first = " + first);

        final Optional<Integer> first1 = Stream.of(1, 2, 3, 4, 5)
                .filter(integer -> {
                    final Integer i = 4;
                    if ( integer == i ) {
                        return true;
                    }
                    return false;
                })
                .findFirst();
        System.out.println("first1 = " + first1);

        final long count1 = Stream.of(1, 2, 3, 4, 5)
                .count();
        System.out.println("count1 = " + count1);

        // forEach
        numbers.stream().forEach(integer -> {
            System.out.println("integer = " + integer);
        });
    }
}
