package TheJava;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        // 메소드레퍼런스 static 메소드를 사용 ( :: <- 해당 클래스의 메소드를 참조하는 방식 )
        UnaryOperator<String> hi = Greeting::hi; // UnaryOperator 입력 타입과 출력 타입이 같은 경우 사용
        // 만역 static이 아니고 특정한 인스턴스 메소드를 사용해야 한다면..
        final Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;

        System.out.println("hi.apply(\"sonsungyong\") = " + hi.apply("sonsungyong"));
        System.out.println("hello.apply(\"sonsungyong\") = " + hello.apply("sonsungyong"));

        // 입력 값은 있는데 리턴 값은 없는 거, 객체를 생성하는 과정
        Supplier<Greeting> gree = Greeting::new;
        System.out.println("gree = " + gree);
        System.out.println("gree.get() = " + gree.get());

        Function<String, Greeting> son = Greeting::new;
        
        Greeting sonsungyong = son.apply("sonsungyong");
        System.out.println("sonsungyong.getName() = " + sonsungyong.getName());

        String[] names = {"toby", " ssy", "anthoby"};
        Arrays.sort(names, String::compareToIgnoreCase);

        System.out.println("Arrays.toString(names) = " + Arrays.toString(names));

    }
}
