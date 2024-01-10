package modenJavaInKe.chapter13;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class StreamExample05 {

    public static void main(String[] args) {
        final List<Product> products = Arrays.asList(
                new Product(1l, "A", new BigDecimal("100.50"))
                , new Product(2l, "B", new BigDecimal("23.50"))
                , new Product(3l, "C", new BigDecimal("31.45"))
                , new Product(4l, "D", new BigDecimal("80.20"))
                , new Product(5l, "E", new BigDecimal("7.50"))
        );

        // 30 달러 이상이 되는 것을 찾아서 담아라
        final List<Product> collect = products.stream()
                .filter(product -> product.getPrice().compareTo(new BigDecimal("30.00")) >= 0)
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
        // 가격 만 꺼내서 담는다
        final List<BigDecimal> collect1 = products.stream()
                .map(product -> product.getPrice())
                .collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);

        // 가격에 $를 붙인다
        final String $ = products.stream()
                .map(product -> product.getPrice())
                .map(price -> price.toString())
                .collect(joining(", $", "[", "]"));
        System.out.println("$ = " + $);

        // IntStream 합계 구하기
        final int sum = IntStream.of(1, 2, 3, 4, 5)
                .sum();
        System.out.println("sum = " + sum);

        // Stream 에서의 합계
        final String s = products.stream()
                .map(product -> product.getPrice())
                .reduce(BigDecimal.ZERO, (p1, p2) -> p1.add(p2))
                .toString();

        System.out.println("s = " + s);
        List<Integer> integer = Arrays.asList(1, 2);
        BiFunction<Integer, Integer, Integer> function = (x, y) -> x + y;
        System.out.println("getSum(sum, ) = " + getSum(integer, 10, 10, function));

    }
    public static Integer getSum(List<Integer> list, Integer x, Integer y, BiFunction<Integer, Integer, Integer> integerIntegerIntegerBiFunction) {
        Integer apply = 0;
        for ( Integer i : list ) {
            apply = Integer.sum(i, integerIntegerIntegerBiFunction.apply(x, y));
        }
        System.out.println("apply = " + apply);
        return apply;
    }

}
