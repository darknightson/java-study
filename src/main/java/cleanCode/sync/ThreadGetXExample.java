package cleanCode.sync;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadGetXExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        MyCallable callable1 = new MyCallable(1);
        MyCallable callable2 = new MyCallable(2);

        Future<Integer> future1 = executorService.submit(callable1);
        Future<Integer> future2 = executorService.submit(callable2);

        try {
            int result1 = future1.get();
            int result2 = future2.get();
            System.out.println("Result from Thread 1: " + result1);
            System.out.println("Result from Thread 2: " + result2);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}

class MyCallable implements Callable<Integer> {
    private final int threadNumber;

    public MyCallable(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public Integer call() {
        int x = getX(); // getX 메서드를 호출하여 결과 값을 얻습니다.
        System.out.println("Thread " + threadNumber + ": getX = " + x);
        return x;
    }

    private int getX() {
        // getX 메서드의 로직을 구현합니다.
        // 여기에서 실제 계산이나 처리를 수행하고 결과를 반환합니다.
        return 42; // 예시로 임의의 값을 반환
    }
}
