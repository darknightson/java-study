package effectivejava.chapter2;

import AStart.afunctionInter.Product;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 열거타입
 */
public class Order {

    private boolean prime;

    private boolean urgent;

    private Product product;

    private OrderStatus orderStatus;

    public static void main(String[] args) {
        // 열거타입은 values 에 배열로 가진다.
        Arrays.stream(OrderStatus.values()).forEach(o -> System.out.println(o.name()));
        // 열거타입은 생성자 및 메소드를 가지며 싱글톤이다.
        System.out.println("OrderStatus.DELIVERED.getNumber() = " + OrderStatus.DELIVERED.getNumber());

        // enum 비교는 == 을 써라
        Order order = new Order();
        if ( order.orderStatus == OrderStatus.DELIVERED) {
            System.out.println("DELIVERED");
        }
    }

}
