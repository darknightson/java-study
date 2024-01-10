package fastcampusModenJava.part06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample07 {

    public static void main(String[] args) {
        final String[][] strings = {
                {
                    "seoul", "busan"
                },
                {
                    "san francisco", "barcelona"
                }
        };

        final Stream<String[]> cityStream = Arrays.stream(strings);
        final List<String> collect = cityStream.flatMap(strings1 -> Arrays.stream(strings1)).collect(Collectors.toList());

        System.out.println("collect = " + collect);
    }
}
