package modenJavainaction.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionSection {

    public static void main(String[] args) {

        // 문자열 배열에서 각 문자열의 길이를 반환하는 배열을 리턴 받게 만들어 보자
        final List<String> strings = Arrays.asList("acb", "anthony");
        Function<String, Integer> function = s -> s.length();
        final List<Integer> map = map(strings, function);
        System.out.println("map = " + map);

        final List<Integer> map1 = map(strings, s -> {
            final int length = s.length();
            return length;
        });
        System.out.println("map1 = " + map1);

        final List<Integer> map2 = map(strings, s -> s.length());
        System.out.println("map2 = " + map2);

    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for ( T t : list ) {
            result.add(function.apply(t));
        }
        return result;
    }
}
