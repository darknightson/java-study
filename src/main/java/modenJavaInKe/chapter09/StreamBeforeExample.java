package modenJavaInKe.chapter09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StreamBeforeExample {

    public static void main(String[] args) {
        // identity function 을 설명 하기 위해..
        // 다른 값을 넣어도 결과는 똑같다.
        final int abs1 = Math.abs(-1);
        final int abs2 = Math.abs(-1);

        System.out.println("abs1 = " + abs1);
        System.out.println("abs2 = " + abs2);
        System.out.println("(abs1 == abs2) = " + (abs1 == abs2));

        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);

        final int minInt = Math.abs(Integer.MIN_VALUE);
        System.out.println("minInt = " + minInt);

        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(" = " + mapOld(numbers, x -> x * 2));
        // 만약 map 함수를 그대로 통과해도 기존 값을 그대로 들고 있고 싶다면
        // 아래 코드를 변형해서 한다면 ?
        System.out.println(" = " + mapOld(numbers, null));
        // 위 처럼 이렇게 하는게 맘에 안든다..
        // 아래 처럼 함수를 넘기면 identity function 이 완성된다.
        System.out.println("mapOld(numbers, i -> i) = " + mapOld(numbers, i -> i));
        // 또다른 함수가 있다.
        System.out.println("mapOld(numbers, Function.identity()) = " + mapOld(numbers, Function.identity()));
        
    }

    public static <T, R> List<R> mapOld(List<T> list, Function<T, R> mapper ) {
        List<R> result = new ArrayList<>();
        if ( mapper != null ) {
            for (T t : list) {
                result.add(mapper.apply(t));
            }
        }
        else {
            result = (List<R>) list;
        }
        return result;
    }
}
