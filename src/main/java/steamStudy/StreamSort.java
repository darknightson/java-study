package steamStudy;

import fastcampusModenJava.part06.Order;
import fastcampusModenJava.part06.OrderStatus;
import fastcampusModenJava.part06.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamSort {
    public static void main(String[] args) {

        // 데이터가 순서대로 정렬된 Stream
        // 데이터의 종류에 따라 Comparator 필요할 수 있음
        List<Integer> integers = List.of(10, -2, 1, 0);
        List<Integer> integersSort = integers.stream().sorted().collect(toList());
        System.out.println("integersSort = " + integersSort);

        List<User> users = List.of(
                new User(101, "anthony", "anthony.son@kakaoent.com", true),
                new User(102, "robin", "robin.kts@kakaoent.com", true),
                new User(103, "henry", "henry.hong1@kakaoent.com", false),
                new User(104, "tom", "tom@kakaoent.com", false)
        );

        List<String> usernameSort = users.stream()
                .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .map(User::getName)
                .collect(toList());

        System.out.println("usernameSort = " + usernameSort);

        LocalDateTime now = LocalDateTime.now();
        final List<Order> orders = List.of(
                new Order(1001, 101, OrderStatus.ERROR, now.minusHours(20)),
                new Order(1002, 102, OrderStatus.ERROR, now.minusHours(15)),
                new Order(1003, 102, OrderStatus.IN_PROGRESS, now.minusHours(35)),
                new Order(1004, 104, OrderStatus.PROCESSED, now.minusHours(50)),
                new Order(1005, 105, OrderStatus.IN_PROGRESS, now.minusHours(50)));

        List<Order> createAtList = orders.stream()
                .sorted((o1, o2) -> o1.getCreatedAt().compareTo(o2.getCreatedAt()))
                .collect(toList());

        System.out.println("createAtList = " + createAtList);

    }
}
