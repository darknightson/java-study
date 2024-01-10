package steamStudy;

import fastcampusModenJava.part06.Order;
import fastcampusModenJava.part06.OrderStatus;
import fastcampusModenJava.part06.User;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamMap {

    public static void main(String[] args) {
        // 데이터를 변형하는데 사용 Function Interface
        // 데이터에 해당 함수가 적용된 결과물을 제공하는 stream
        List<Integer> integers = List.of(2, 6, -4);

        List<String> convertString = integers.stream()
                .map(integer -> "anthony.son".concat(":::").concat(integer.toString()))
                .collect(toList());

        System.out.println("convertString = " + convertString);


        List<Integer> numbersMulti = integers.stream()
                .map(integer -> integer * 2)
                .collect(toList());

        System.out.println("numbersMulti = " + numbersMulti);


        List<User> users = Arrays.asList(
                new User(101, "anthony", "anthony.son@kakaoent.com", true),
                new User(102, "robin", "robin.kts@kakaoent.com", true),
                new User(103, "henry", "henry@kakaoent.com", false),
                new User(104, "tom", "tom@kakaoent.com", false)
        );

        // email 만 걸러내자
        List<String> collect = users.stream()
                .map(User::getEmailAddress)
                .collect(toList());

        System.out.println("collect = " + collect);


        LocalDateTime now = LocalDateTime.now();
        final List<Order> orders = List.of(
                new Order(1001, 101, OrderStatus.ERROR, now.minusHours(20)),
                new Order(1002, 102, OrderStatus.ERROR, now.minusHours(15)),
                new Order(1003, 102, OrderStatus.IN_PROGRESS, now.minusHours(35)),
                new Order(1004, 104, OrderStatus.PROCESSED, now.minusHours(50)),
                new Order(1005, 105, OrderStatus.IN_PROGRESS, now.minusHours(50)));

        List<Long> createByUserIds = orders.stream()
                .map(Order::getCreatedByUserId)
                .collect(toList());

        System.out.println("createByUserIds = " + createByUserIds);
    }
}
