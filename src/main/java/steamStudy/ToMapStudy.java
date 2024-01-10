package steamStudy;

import fastcampusModenJava.part06.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class ToMapStudy {

    public static void main(String[] args) {
        // Stream 아늬 데이터를 map 형태로 반환해주는 collector
        // KeyMapper - 데이터를 map 의 key 로 반환하는 함수
        // valueMapper - 데이터를 map 의 value 로 반환하는 함수
        // list 와 함께 가장 많이 사용하는 함수

//        List<Product> products = productRepository.findAllByProductNumberIn(productNumbers);
//        Map<String, Product> productMap = products.stream()
//                .collect(toMap(Product::getProductNumber, p -> p));

        List<Integer> integers = List.of(2, 3, -4, 6, 5);
        Map<Integer, String> collect = integers.stream()
                .collect(toMap(integer -> integer, integer -> "Number is" + integer));
        System.out.println("collect = " + collect);

        // TODO 유저의 id를 키로 하고 값을 USER 객체로 하는 map을 만들어라
        List<User> users = List.of(
                new User(101, "anthony", "anthony.son@kakaoent.com", true),
                new User(102, "robin", "robin.kts@kakaoent.com", true),
                new User(103, "henry", "henry@kakaoent.com", false),
                new User(104, "tom", "tom@kakaoent.com", false)
        );

        Map<Integer, User> collect1 = users.stream()
                .collect(toMap(User::getId, Function.identity()));
        System.out.println("collect1 = " + collect1);

    }
}
