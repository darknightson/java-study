package modenJavaInKe.chapter08;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionExample {

    public static void main(String[] args) {
        final Product productA = new Product(1l, "a", new BigDecimal("10.00"));
        final Product productB = new Product(2l, "a", new BigDecimal("55.00"));
        final Product productC = new Product(3l, "a", new BigDecimal("17.00"));
        final Product productD = new Product(4l, "a", new BigDecimal("20.00"));
        final Product productE = new Product(5l, "a", new BigDecimal("110.00"));
        List<Product> products = Arrays.asList(
                  productA,
                  productB,
                  productC,
                  productD,
                  productE
        );

        // old 방식
        final List<Product> results = new ArrayList<>();
        final BigDecimal bigDecimal = new BigDecimal("20.00");
        for ( Product p : products ) {
            if ( p.getPrice().compareTo(bigDecimal) >= 0 ) {
                results.add(p);
            }
        }
        // new 방식
        final List<Product> productListFilter = filter(products, (Product product) -> product.getPrice().compareTo(bigDecimal) >= 0 );
        System.out.println("productListFilter = " + productListFilter);
        // a 항목에 대해서 50프로 할인을 해준다.
        final List<DiscountProduct> discountProducts = map(productListFilter
                , product -> new DiscountProduct(product.getId(), product.getName(), product.getPrice().multiply(new BigDecimal("0.5"))));
        System.out.println("discountProducts = " + discountProducts);

        // product.getPrice().compareTo(bigDecimal) >= 0 이 함수를 자주 사용 하기 때문에 만들어 놓고 해당 함수를 쓰자
        // 아래 내용을 잘 보면 product 객체와 하위 클래스인 discountProduct 를 어떻게 푸냐도 중점 적으로 보자 Predicate<? super T>
        Predicate<Product> predicate = p -> p.getPrice().compareTo(bigDecimal) >= 0;
        System.out.println("filter(products, predicate) = " + filter(products, predicate));
        System.out.println("filter(products, predicate) = " + filter(discountProducts, predicate));

        // products 의 price total 을 구해보자
        BigDecimal totalAmt = totFilter(products, product -> product.getPrice());
        System.out.println("totalAmt = " + totalAmt);
        BigDecimal discountTotalAmt = totFilter(discountProducts, product -> product.getPrice());
        System.out.println("discountTotalAmt = " + discountTotalAmt);

        Order order = new Order(
                1l, "a", Arrays.asList(
                new OrderItem(1l, productA, 2),
                new OrderItem(2l, productC, 1),
                new OrderItem(3l, productD, 10)
        )
        );

        System.out.println("order.totalPrice() = " + order.totalPrice());

    }
    public static <T> BigDecimal totFilter(List<T> inputs, Function<T, BigDecimal> function) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for ( T input : inputs ) {
            bigDecimal = bigDecimal.add(function.apply(input));
        }

        return bigDecimal;
    }

    //필터 T 타입의 하위 타입은 모두 predicate 를 사용할 수 있다.
    public static <T> List<T> filter(List<T> inputs, Predicate<? super T> predicate) {
        final List<T> results = new ArrayList<>();
        for ( T t : inputs ) {
            if ( predicate.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

    // T 타입을 R 타입으로 담아서 리턴한다.
    public static <T, R> List<R> map(List<T> list, Function<T, R> function ) {
        List<R> result = new ArrayList<>();
        for (T t : list ) {
            result.add(function.apply(t));
        }
        return result;
    }
}




