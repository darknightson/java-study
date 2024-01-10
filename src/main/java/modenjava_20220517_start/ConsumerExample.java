package modenjava_20220517_start;

import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s = " + s);
            }
        };
        consumer.accept("then");

        Consumer<String> abc = s -> System.out.println("s = " + s);

        abc.accept("good");

    }
}
