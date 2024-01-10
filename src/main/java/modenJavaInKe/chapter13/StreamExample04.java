package modenJavaInKe.chapter13;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StreamExample04 {
    public static void main(String[] args) {
         // 좀더 실용적인 예
        final List<Product> products = Arrays.asList(
                  new Product(1l, "A", new BigDecimal("100.50"))
                , new Product(2l, "B", new BigDecimal("23.50"))
                , new Product(3l, "C", new BigDecimal("31.45"))
                , new Product(4l, "D", new BigDecimal("80.20"))
                , new Product(5l, "E", new BigDecimal("7.50"))
        );

        // 30달러 이상인 것 을 리스트로 반환 하라. ( stream )
        final List<Product> collect = products.stream()
                .filter(product -> product.getPrice().compareTo(new BigDecimal("30.00")) >= 0)
                .collect(toList());
        System.out.println("collect = " + collect);

        // 30달러 이상인 것 을 리스트로 반환 하고 한줄에 하나씩 나오게 하라. joining 를 사용하네.. 맵으로 타입 캐스팅하자..( stream )
        final String collect2 = products.stream()
                .filter(product -> product.getPrice().compareTo(new BigDecimal("30.00")) >= 0)
                .map(product -> product.toString())
                .collect(joining("\n"));

        System.out.println("" + collect2);


        // 합계를 구하라. IntStream 은 타입이 추론 가능하기 때문에 sum 이라는 함수가 있어서 아래처럼 편한데.. 그냥 stream 에서는..어떻게...
        final int sum = IntStream.of(1, 2, 3, 4, 5).sum();
        System.out.println("sum = " + sum);

        final BigDecimal reduce = products.stream()
                // Function(T,R)
                .map(product -> product.getPrice())
                // BiFunction 으로 인자 값 2개를 받아서 하나의 인자로 리턴한다.
                .reduce(BigDecimal.ZERO, (product1, product2) -> product1.add(product2));

        System.out.println("reduce = " + reduce);

        final Stream<BigDecimal> bigDecimalStream = products.stream()
                .map(product -> {
                    BigDecimal bigDecimal = new BigDecimal("20");
                    return product.getPrice().add(bigDecimal);

                });
        bigDecimalStream.forEach(bigDecimal -> System.out.println("bigDecimal = " + bigDecimal));

    }
}
