package modenJavaInKe.chapter14;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class StreamExample06 {
    public static void main(String[] args) {
        // 스트림은 함수형 인터페이스는 병렬 프로그래밍을 위한 것이다..
        int[] sum = {0};
        IntStream.range(0,100);

        // parallel stream 을 사용하면 코어의 갯수 만큼 스레드를 작동 시키므로 속도가 빨라진다.
        // 아래 예제에서 확인해 보자
        // parallel 을 사용 안하면 코어 갯수 만큼 9초가 걸린다.
        final List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        final long start = System.currentTimeMillis();
        integers.stream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i -> {
                    System.out.println("i = " + i);
                });

        final long l = System.currentTimeMillis() - start;
        System.out.println("l = " + l);

        // 그럼 parallel 을 사용 한다면? 1초가 걸릴 것이다.
        // 그런데 처리 순서는 보장 못한다.
        // 코어 갯수도 조절 할 수 있다.
        // System.setProperties("java.util.concurrent.ForkJoinPool.common.parallelism", "3");
        final long start1 = System.currentTimeMillis();
        integers.parallelStream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i -> {
                    System.out.println("i = " + i);
                });

        final long l1 = System.currentTimeMillis() - start1;
        System.out.println("l1 = " + l1);

    }
}
