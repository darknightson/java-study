package AStart.afunctionInter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionInterfaceSample {

    public static void main(String[] args) {
        final List<Product> products = Arrays.asList(
                new Product(1l, "A", new BigDecimal("10.00")),
                new Product(2l, "B", new BigDecimal("20.00")),
                new Product(3l, "C", new BigDecimal("30.00")),
                new Product(4l, "D", new BigDecimal("40.00")),
                new Product(5l, "E", new BigDecimal("50.00"))
        );

        // 30 이상의 금액만 추출
        final List<Product> filter = filter(products, product -> product.getPrice().compareTo(new BigDecimal("20.00")) > 0);
        filter.forEach(product -> {
            System.out.println("product = " + product.getPrice());
        });

        final List<Product> collect = products.stream()
                .filter(product -> product.getPrice().compareTo(new BigDecimal("20.00")) > 0)
                .collect(Collectors.toList());
        collect.forEach(product -> product.getPrice());

    }

    private static <T> List<T> filter(List<T> inputs, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        inputs.forEach(t -> {
            if (predicate.test(t) ) {
                result.add(t);
            }
        });
        return result;
    }
}
