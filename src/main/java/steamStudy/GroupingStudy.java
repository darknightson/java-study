package steamStudy;

import fastcampusModenJava.part06.Order;
import fastcampusModenJava.part06.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static fastcampusModenJava.part06.OrderStatus.ERROR;
import static fastcampusModenJava.part06.OrderStatus.IN_PROGRESS;
import static java.util.stream.Collectors.*;

public class GroupingStudy {

    public static void main(String[] args) {
        // stream 안의 데이터에 classifier 를 적용 했을 때 결과값이 같은 값끼리 List 로 모아서 Map 형태로 반환해주는 collector
        // 이 때 key 는 classifier 의 결과 값, value 는 그 결과 값을 갖는 데이터
        // 예를 들어, stream 안에 { 1,2,5,7,9,12,13} 이 있을 때 classifier 가 x -> x % 3 이라면 반환되는 map 는
        // { 0 = [9,12], 1 = [1,7,3], 2 =[2,5] }
        // 결론은 결과 값과 일치하는 그룹을 묶는다.

        final LocalDateTime now = LocalDateTime.now(ZoneId.of(("Asia/Seoul")));
        final List<Order> orders = List.of(
                new Order(1001, ERROR, BigDecimal.valueOf(1000)),
                new Order(1002, ERROR, BigDecimal.valueOf(2000)),
                new Order(1003, OrderStatus.IN_PROGRESS, BigDecimal.valueOf(4000)),
                new Order(1004, OrderStatus.PROCESSED, BigDecimal.valueOf(3000)),
                new Order(1005, IN_PROGRESS, BigDecimal.valueOf(6000))
        );

        // OrderStatus 별로 묶는 그룹핑
        Map<OrderStatus, List<Order>> collect = orders.stream()
                .collect(groupingBy(Order::getStatus));

        System.out.println("collect = " + collect);

        // OrderStatus 별로 총 합은 얼마인가
        Map<OrderStatus, BigDecimal> collect1 = orders.stream()
                .collect(groupingBy(Order::getStatus, // 상태별로 그룹핑하고
                                mapping(Order::getAmount, // 그룹핑한 상태에 값을 매핑하고
                                        reducing(BigDecimal.ZERO, BigDecimal::add) // 매핑한 값을 연산하고
                                )

                        )
                );
        System.out.println("collect1 = " + collect1);



    }
}
