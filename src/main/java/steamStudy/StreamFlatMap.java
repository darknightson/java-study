package steamStudy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fastcampusModenJava.part06.Order;
import fastcampusModenJava.part06.OrderLine;
import fastcampusModenJava.part06.OrderLineType;
import fastcampusModenJava.part06.OrderStatus;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static fastcampusModenJava.part06.OrderLineType.DISCOUNT;
import static fastcampusModenJava.part06.OrderLineType.PURCHASE;
import static java.util.stream.Collectors.toList;

public class StreamFlatMap {

    public static void main(String[] args) throws JsonProcessingException {

        // Map + Flatten
        // 데이터에 함수를 적용한 후 중첩된 stream 을 연결하여 하나의 stream 으로 리턴

        String[][] cites = new String[][]{
                {"Seoul", "Busan"},
                {"San Francisco", "New York"},
                {"Madrid", "Barcelona"}
        };

        List<Integer> a1 = List.of(1,2,3);
        List<Integer> a2 = List.of(4,5,6);

        List<List<Integer>> a3 = List.of(a1, a2);

        List<Integer> collect = a3.stream()
                .flatMap(integers -> integers.stream())
                .collect(toList());

        System.out.println("collect = " + collect);


        LocalDateTime now = LocalDateTime.now();
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
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(orders);
        System.out.println("orders = " + s);

        List<OrderLine> result = orders.stream()
                .map(Order::getOrderLines)
                .flatMap(orderLines -> orderLines.stream())
                .collect(toList());

        String s1 = objectMapper.writeValueAsString(result);
        System.out.println("s1 = " + s1);


        List<String> animal = List.of("cat", "dog");


        List<String> collect1 = animal.stream()
                .map(a -> a.split(""))
                .flatMap(strings -> Arrays.stream(strings))
                .collect(toList());

        System.out.println("collect1 = " + collect1);


    }
}
