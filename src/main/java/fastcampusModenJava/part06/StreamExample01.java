package fastcampusModenJava.part06;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamExample01 {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("anthony", "kevin");
        //System.out.println("stringStream.collect(toList()) = " + stringStream.collect(toList()));
        List<String> collect = stringStream.collect(toList());
        System.out.println("collect = " + collect);
    }
}
