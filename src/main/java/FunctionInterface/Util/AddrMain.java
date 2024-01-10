package FunctionInterface.Util;

import java.util.function.BiFunction;
import java.util.function.Function;

public class AddrMain {

    public static void main(String[] args) {
        Function<Integer, Integer> addr = new Addr();
        int result =  addr.apply(5);
        System.out.println("result = " + result);

        // 함수형으로 변환시
        Function<Integer, Integer> myaddr = (Integer x) -> {
            return x + 10;
        };
        int result1 = myaddr.apply(10);
        System.out.println("result1 = " + result1);

        // 매개변수가 두개일때
        BiFunction<Integer, Integer, Integer> add = ( x, y ) -> {
            return x + y;
        };
        int result3 = add.apply(3 , 8);
        System.out.println("result3 = " + result3);

        Function<Integer, Integer> test = (Integer x) -> {
            return x + 10;
        };

        System.out.println("test.apply(10) = " + test.apply(10));
    }
}
