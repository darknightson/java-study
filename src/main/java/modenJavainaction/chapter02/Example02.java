package modenJavainaction.chapter02;

import modenJavainaction.chapter01.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Example02 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" Hello world " );
            }
        });

        t.run();

        // Thread 인터페이스 Runnable 는 FunctionInterface 이다.
        Thread t1 = new Thread(() -> System.out.println(" void empty runnable"));
        t1.run();

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadName = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });
        System.out.println("threadName = " + threadName);

        Future<String> tname = executorService.submit(() -> Thread.currentThread().getName());
        System.out.println("tname = " + tname);


        List<Apple> list = Arrays.asList(new Apple("20", "RED"), new Apple("10", "GREEN"));

        final List<Apple> collect = list.stream()
                .filter(apple -> Color.GREEN.toString().equals(apple.getColor()))
                .collect(toList());

        System.out.println("collect = " + collect);

        final List<Apple> filter = filter(list, apple -> {
            final boolean equals = Color.RED.toString().equals(apple.getColor());
            return equals;
        });
        System.out.println("filter = " + filter);
    }
    
    public static List<Apple> filter(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> appleList = new ArrayList<>();
        for ( Apple a : inventory ) {
            if ( predicate.test(a)) {
                appleList.add(a);
            }
        }
        return appleList;
    }
}
