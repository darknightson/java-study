package steamStudy;

import fastcampusModenJava.part06.Order;
import fastcampusModenJava.part06.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static fastcampusModenJava.part06.OrderStatus.ERROR;
import static fastcampusModenJava.part06.OrderStatus.IN_PROGRESS;

public class MinMaxCountStudy {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1,2,3,4,5,6,7,8,9,10);

        Optional<Integer> max = integers.stream()
                .max(Integer::compareTo);
        System.out.println("max = " + max);

        final LocalDateTime now = LocalDateTime.now(ZoneId.of(("Asia/Seoul")));
        final List<Order> orders = List.of(
                new Order(1001, ERROR, BigDecimal.valueOf(1000)),
                new Order(1002, ERROR, BigDecimal.valueOf(2000)),
                new Order(1003, OrderStatus.IN_PROGRESS, BigDecimal.valueOf(4000)),
                new Order(1004, OrderStatus.PROCESSED, BigDecimal.valueOf(3000)),
                new Order(1005, IN_PROGRESS, BigDecimal.valueOf(6000))
        );

        // TODO STEP.01 ERROR 상태인 것 중에서 가장 큰 금액을 가진 주문의 금액을 구하시오.
        Order order1 = orders.stream()
                .filter(order -> order.getStatus() == ERROR)
                .max((o1, o2) -> o1.getAmount().compareTo(o2.getAmount()))
                .orElseGet(Order::new);
        System.out.println("order1 = " + order1);

        // TODO STEP.02 위 로직에서 amount 만 추출해서 가장 작은 값을 보여줘라
        Order order2 = orders.stream()
                .filter(order -> order.getStatus() == ERROR)
                .min((o1, o2) -> o1.getAmount().compareTo(o2.getAmount()))
                .orElseGet(Order::new);
        System.out.println("order2 = " + order2);

        // TODO ERROR의 총 갯수는?
        long count = orders.stream()
                .filter(order -> order.getStatus() == ERROR)
                .count();
        System.out.println("count = " + count);

        // TODO 총 주금 금액의 합을 구하시오
        BigDecimal reduce = orders.stream()
                .map(Order::getAmount)
                .reduce(BigDecimal::add)
                .orElseGet(() -> BigDecimal.ZERO);

        System.out.println("reduce = " + reduce);

        BigDecimal reduce1 = orders.stream()
                .map(Order::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("reduce1 = " + reduce1);

//        BigDecimal max1 = orders.stream()
//                .filter(order -> order.getStatus() == ERROR)
//                .map(Order::getAmount)
//                .max(BigDecimal::compareTo)
//                .orElseGet(() -> BigDecimal.ZERO);
//




    }
}
