package modenJavaInKe.chapter04;

import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        // 입력만 받고 출력 값이 없다.
        Consumer<String> print = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s = " + s);
            }
        };
       print.accept("hello");

       Consumer<String> consumer = s -> System.out.println("s = " + s);
       consumer.accept("fn");
    }
}
