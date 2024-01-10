package fastcampusModenJava.part06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample02 {
    public static void main(String[] args) {
        // 양수만 걸러 내는 Stream 을 만들어 보자.
        final List<Integer> integers = Arrays.asList(-1, 1, 2, -3, 5);

        System.out.println(integers.stream()
                .filter(i -> i >= 0)
                .collect(Collectors.toList()));

    }
}
