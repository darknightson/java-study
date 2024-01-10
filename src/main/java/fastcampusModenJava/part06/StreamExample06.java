package fastcampusModenJava.part06;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class StreamExample06 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, -5, 7, 4, -3, 7);

        final List<Integer> collect = numbers.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("collect = " + collect);


        // 중복 제거 1
        final Set<Integer> collect2 = numbers.stream()
                .collect(Collectors.toSet());

        System.out.println("collect2 = " + collect2);

        // 중복 제거 2
        final List<Integer> collect3 = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("collect3 = " + collect3);


        List<User> users = Arrays.asList(
                new User(101, "anthony", "anthony.son@kakaoent.com", true),
                new User(102, "robin", "robin.kts@kakaoent.com", true),
                new User(103, "henry", "henry@kakaoent.com", false),
                new User(104, "tom", "tom@kakaoent.com", false)
        );

        //users.sort(Comparator.comparing(User::getName));
        final List<User> collect1 = users.stream()
                .sorted((u1, u2) -> u1.getName().compareTo(u2.getName()))
                .collect(Collectors.toList());

        System.out.println("collect1 = " + collect1);

//        Collections.sort(users, new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });



        System.out.println("users = " + users);
        final LocalDateTime now = LocalDateTime.now(ZoneId.of(("Asia/Seoul")));
        final List<Order> orders = Arrays.asList(
                new Order(1001, 101, OrderStatus.ERROR, now.minusHours(20)),
                new Order(1002, 102, OrderStatus.ERROR, now.minusHours(15)),
                new Order(1003, 102, OrderStatus.IN_PROGRESS, now.minusHours(35)),
                new Order(1004, 104, OrderStatus.PROCESSED, now.minusHours(50))
        );

        final List<Long> collect4 = orders.stream()
                .map(order -> order.getCreatedByUserId())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("collect4 = " + collect4);


    }
}
