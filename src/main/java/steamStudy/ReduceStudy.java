package steamStudy;

import fastcampusModenJava.part06.Order;
import fastcampusModenJava.part06.OrderLine;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import static fastcampusModenJava.part06.OrderLineType.DISCOUNT;
import static fastcampusModenJava.part06.OrderLineType.PURCHASE;

public class ReduceStudy {

    public static void main(String[] args) {
        // 주어진 함수를 반복 적용해 Stream 안의 데이터를 하나의 값으로 합치는 작업
        // Max / Min / Count 도 사실 reduce 의 일종

        final List<Order> orders = List.of(
                new Order(1001, List.of(
                        new OrderLine(10001, PURCHASE, BigDecimal.valueOf(5000)),
                        new OrderLine(10002, PURCHASE, BigDecimal.valueOf(4000))
                )
                ),
                new Order(1002, List.of(
                        new OrderLine(10003, PURCHASE, BigDecimal.valueOf(2000)),
                        new OrderLine(10004, DISCOUNT, BigDecimal.valueOf(-1000))

                )
                ),
                new Order(1003, List.of(
                        new OrderLine(10005, PURCHASE, BigDecimal.valueOf(2000))

                )
                )
        );

        Integer integer = orders.stream()
                .map(Order::getOrderLines)
                .flatMap(Collection::stream)
                .map(OrderLine::getAmount)
                .map(BigDecimal::intValue)
                .reduce(Integer::sum)
                .get();

        System.out.println("integer = " + integer);


    }
}
