package modenJavainaction.chapter02;

import modenJavainaction.chapter01.Apple;

import java.util.function.Predicate;

public class Example03 {

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(" hello world1");
            }
        };

        Runnable r2 = () -> System.out.println(" Hello world2");
        process(r1);
        process(r2);
        // void 는 리턴이 없기 때문에 body를 표현하는 {} 을 쓰지 않는다.
        process(() -> System.out.println(" test " )  );

        execute(() -> {} );


    }

    public static void execute(Runnable r) {
        r.run();
    }

    public static void process(Runnable r) {
        r.run();
    }
}
