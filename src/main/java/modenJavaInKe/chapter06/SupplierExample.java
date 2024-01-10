package modenJavaInKe.chapter06;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        // 입력이 없고, 출력만 있다.
        // validation check 에 유용하다는데, lazy validation 을 줄인다.
        Supplier<String> supplier = () -> "hello";

        System.out.println("supplier.get() = " + supplier.get());

        // 이해 아래 로직은 총 9초가 소요된다. 실제 valid 를 통과 하는건 최초 하나 뿐이지만... 아래 함수형 프로그래밍과 비교 해보자..
        //printIfValidaIndex(0, getVeryExpensiveValue());
        //printIfValidaIndex(-1, getVeryExpensiveValue());
        //printIfValidaIndex(-2, getVeryExpensiveValue());

        // supplier 를 사용해서 처리해보자. 3초가 걸린다.
        printIfValidaIndexSupplier(0, () -> getVeryExpensiveValue());
        printIfValidaIndexSupplier(-1, () -> getVeryExpensiveValue());
        printIfValidaIndexSupplier(-2, () -> getVeryExpensiveValue());

    }
    public static String getVeryExpensiveValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Anthony";
    }
    public static void printIfValidaIndex(int number, String value) {
        if ( number >= 0 ) {
            System.out.println("the value is = " + value);
        } else {
            System.out.println("Invalid");
        }
    }

    public static void printIfValidaIndexSupplier(int number, Supplier<String> valueSupplier) {
        if ( number >= 0 ) {
            System.out.println("valueSupplier.get() = " + valueSupplier.get());
        }
        else {
            System.out.println("Invalid");
        }
    }
}
