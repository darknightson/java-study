package TheJava;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {
        RunSomething runSomething = (number) -> {
            return number + 1;
        };

        final AA aa = new AA();
        System.out.println(aa.apply(1));

        Function<Integer, Integer> plus10 = (i) -> i + 10;
        System.out.println(plus10.apply(1));

        // 람다
        // xxx xxx = () <- () 인자 받는부분
        // xxx xxx = () -> x x x <- 화살표 오른쪽 부분이 body

        // 받기만 하고 리턴이 없다. void
        Supplier<Integer> get10 = () -> 10;
        // 인자 값이 모두 같은 type 라면 하나의 타입으로 통일 할 수 있따. 2개까지
        BinaryOperator<Integer> binaryOperator = (a, b) ->  a + b;
        System.out.println("binaryOperator.apply(1,2) = " + binaryOperator.apply(1,2));
    }

    public void run() {
        final int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                System.out.println("local baseNumber = " + baseNumber);
            }
        }
        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println("익명 baseNumber = " + baseNumber);
            }
        };
        // 람다
        IntConsumer printInt = (i) -> {
            System.out.println("i + baseNumber = " + i + baseNumber);
        };
    }
}
