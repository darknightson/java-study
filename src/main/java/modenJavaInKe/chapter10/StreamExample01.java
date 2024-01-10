package modenJavaInKe.chapter10;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample01 {

    public static void main(String[] args) {

        IntStream.range(0, 10).forEach(i -> System.out.println("i = " + i));
        // 무한대로..
        Stream
                .iterate(BigInteger.ONE, i -> i.add(BigInteger.ONE))
                .forEach(i -> System.out.println("i = " + i));

    }
}
