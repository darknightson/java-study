package steamStudy;


import fastcampusModenJava.part06.Order;
import fastcampusModenJava.part06.OrderStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamFilter {

    public static void main(String[] args) {
        // 만족하는 데이터만 걸러 내는데 사용
        // Predicate true 반환하는 데이터만 존재하는 stream
        // 양수만 걸러내는 stream filter
        List<Integer> integers = List.of(1,2,3,-4,-7);

        List<Integer> integersList = integers.stream()
                .filter(x -> x > 0)
                .collect(toList());

        System.out.println("integersList = " + integersList);

        LocalDateTime now = LocalDateTime.now();
        final List<Order> orders = List.of(
                new Order(1001, 101, OrderStatus.ERROR, now.minusHours(20)),
                new Order(1002, 102, OrderStatus.ERROR, now.minusHours(15)),
                new Order(1003, 102, OrderStatus.IN_PROGRESS, now.minusHours(35)),
                new Order(1004, 104, OrderStatus.PROCESSED, now.minusHours(50)),
                new Order(1005, 105, OrderStatus.IN_PROGRESS, now.minusHours(50)));



        List<Order> orderStatus = orders.stream()
                .filter(x -> x.getStatus() == OrderStatus.ERROR)
                .collect(toList());

        System.out.println("orderStatus = " + orderStatus);

    }
}
