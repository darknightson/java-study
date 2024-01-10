package fastcampusModenJava.part06;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample05 {

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(101, "anthony", "anthony.son@kakaoent.com", true),
                new User(102, "robin", "robin.kts@kakaoent.com", true),
                new User(103, "henry", "henry@kakaoent.com", false),
                new User(104, "tom", "tom@kakaoent.com", false)
        );
        final LocalDateTime now = LocalDateTime.now(ZoneId.of(("Asia/Seoul")));
        final List<Order> orders = Arrays.asList(
                new Order(1001, 101, OrderStatus.ERROR, now.minusHours(20)),
                new Order(1002, 102, OrderStatus.ERROR, now.minusHours(15)),
                new Order(1003, 103, OrderStatus.IN_PROGRESS, now.minusHours(35)),
                new Order(1004, 104, OrderStatus.PROCESSED, now.minusHours(50))
        );

        final List<String> collect = users.stream()
                .filter(user -> user.isVerified())
                .map(User::getEmailAddress)
                .collect(Collectors.toList());

        System.out.println("collect = " + collect);

        // find orders in error status, and extract createByUserIds as a list
        final List<Long> collect1 = orders.stream()
                .filter(order -> OrderStatus.ERROR == order.getStatus())
                //.map(order -> order.getCreatedByUserId())
                .map(order ->  {
                    return order.getCreatedByUserId();
                })
                .collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);

    }
}
