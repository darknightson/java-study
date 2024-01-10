package steamStudy;

import fastcampusModenJava.part06.User;

import java.util.Optional;

public class OptionalStudy {

    public static void main(String[] args) {

        // Optional 있을 수도 있고, 없을 수도 있다.
        // Null 일수도, 아닐 수도 있는 오브젝트를 담은 상자
        String someEmail = "some@email.com";
        String nullEmail = null;
        String defaultEmail = "default@email.com";

        Optional<String> maybeEmail = Optional.of(someEmail);
        Optional<String> maybeEmail2 = Optional.empty();
        Optional<String> maybeEmail3 = Optional.ofNullable(someEmail);
        String maybeEmail4 = Optional.ofNullable(someEmail).orElseGet(() -> test());
        System.out.println("maybeEmail4 = " + maybeEmail4);

        Optional<User> user = Optional.ofNullable(maybeGetUser(false));
        // 해당 객체가 null이 아닐때 실행
        user.ifPresent(user1 -> System.out.println("user1 = " + user1.getName()));

        Optional<String> s1 = Optional.ofNullable(maybeGetUser(true))
                .map(User::getName)
                .map(s -> "the name is" + s);


        System.out.println("s1 = " + s1.get());
    }

    public static User maybeGetUser(boolean returnUser) {
        if ( returnUser ) {
            return new User(1, "name", "email", false);
        }
        return null;
    }

    public static String test() {
        System.out.println(" call reference");
        return "aaaa";
    }
}
