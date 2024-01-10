package modenjava_20220517_start;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WhyJava8 {

    public static void main(String[] args) {
        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        final String collect = integers.stream()
                .map(String::valueOf) // Type 변경
                .collect(Collectors.joining(":")); // 변경된 String Type 에 문자 결합

        System.out.println("collect = " + collect);

    }
}
