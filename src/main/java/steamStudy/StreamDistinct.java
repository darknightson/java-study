package steamStudy;

import fastcampusModenJava.part06.Order;
import fastcampusModenJava.part06.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDistinct {
    public static void main(String[] args) {
        // distinct 중복 제거
        LocalDateTime now = LocalDateTime.now();
        final List<Order> orders = List.of(
                new Order(1001, 101, OrderStatus.ERROR, now.minusHours(20)),
                new Order(1002, 102, OrderStatus.ERROR, now.minusHours(15)),
                new Order(1003, 102, OrderStatus.IN_PROGRESS, now.minusHours(35)),
                new Order(1004, 101, OrderStatus.PROCESSED, now.minusHours(50)),
                new Order(1005, 105, OrderStatus.IN_PROGRESS, now.minusHours(50)));

        // createByUserId 를 뽑아내고, 중복 제거 후 정렬
        List<Long> collect = orders.stream()
                .map(Order::getCreatedByUserId)
                .distinct()
                .sorted(Long::compareTo)
                .collect(Collectors.toList());

        System.out.println("collect = " + collect);

    }
}
