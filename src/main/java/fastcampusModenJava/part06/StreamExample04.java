package fastcampusModenJava.part06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample04 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 6, -4);

        final List<Integer> collect = list.stream()
                .map(integer -> integer * 2)
                .collect(Collectors.toList());

        System.out.println("collect = " + collect);

        final List<String> collect1 = list.stream()
                .map(integer -> "number is " + integer)
                .collect(Collectors.toList());

        System.out.println("collect1 = " + collect1);

        List<User> users = Arrays.asList(
                new User(100, "anthony", "anthony.son@kakaoent.com", true),
                new User(101, "robin", "robin.kts@kakaoent.com", true),
                new User(102, "henry", "anthony.son@kakaoent.com", false)
        );

        final List<String> collect2 = users.stream()
                //.map(user -> user.getEmailAddress()) // 이거나 아래거나 똑같다.
                .map(User::getEmailAddress) // 메서드레퍼런스
                .distinct()
                .collect(Collectors.toList());
        System.out.println("collect2 = " + collect2);
    }
}
