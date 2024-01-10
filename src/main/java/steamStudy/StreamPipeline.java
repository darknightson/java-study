package steamStudy;

import fastcampusModenJava.part06.Order;
import fastcampusModenJava.part06.OrderStatus;
import fastcampusModenJava.part06.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPipeline {

    public static void main(String[] args) {
        List<User> users = List.of(
                new User(101, "anthony", "anthony.son@kakaoent.com", true),
                new User(102, "robin", "robin.kts@kakaoent.com", true),
                new User(103, "henry", "henry.hong1@kakaoent.com", false),
                new User(104, "tom", "tom@kakaoent.com", false)
        );

        // 검증되지 않은 사용자의 이메일을 추출 ( 중간 필터 filter map 등 함께 사용 )
        List<String> userEmailAddress = users.stream()
                .filter(user -> !user.isVerified())
                .map(User::getEmailAddress)
                .collect(Collectors.toList());

        System.out.println("userEmailAddress = " + userEmailAddress);


        final LocalDateTime now = LocalDateTime.now(ZoneId.of(("Asia/Seoul")));
        final List<Order> orders = List.of(
                new Order(1001, 101, OrderStatus.ERROR, now.minusHours(20)),
                new Order(1002, 102, OrderStatus.ERROR, now.minusHours(15)),
                new Order(1003, 102, OrderStatus.IN_PROGRESS, now.minusHours(35)),
                new Order(1004, 104, OrderStatus.PROCESSED, now.minusHours(50)),
                new Order(1005, 105, OrderStatus.IN_PROGRESS, now.minusHours(50)));

        List<Long> createByUserIds = orders.stream()
                .filter(order -> order.getStatus() == OrderStatus.ERROR)
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());

        System.out.println("createByUserIds = " + createByUserIds);


    }
}
