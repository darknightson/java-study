package oop.section2_4;

import java.util.List;

public class ForAndIfFilterAdvanceExampleMain {

    public static void main(String[] args) {
        User user1 = new User("a", "name1");
        User user2 = new User("b", "name2");

        List<User> users = List.of(user1, user2);

        users.stream()
                .filter(user -> user.isSame("c"))
                .findAny()
                .ifPresentOrElse(
                        user -> System.out.println("user = " + user),
                        () -> System.out.println("user is not found"));

    }
}
