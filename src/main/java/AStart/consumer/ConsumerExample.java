package AStart.consumer;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {

        // 입력값만 있고 리턴은 없다.
        Consumer<String> print = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s = " + s);
            }
        };

        print.accept("hello");
        ///////////////////////////////////
        Consumer<String> print1 = t -> System.out.println("s = " + t);
        print1.accept("hello1");


    }
}
