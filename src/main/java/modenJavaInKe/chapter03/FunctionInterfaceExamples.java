package modenJavaInKe.chapter03;

import java.util.function.Function;

public class FunctionInterfaceExamples {

    /*
        FunctionInterface
     */
    public static void main(String[] args) {
        // old
        final Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };

        // 람다 사용 법
        final Function<String, Integer> toInt = ( final String s) -> {
            return Integer.parseInt(s);
        };
        
        // 람다 간단한 사용 법, 이미 인자값의 타입은 알고 있으므로 생략이 가능하다.
        final Function<String, Integer> toIntSimple = s -> Integer.parseInt(s);

        System.out.println("function.apply = " + function.apply("3"));
        System.out.println("function.apply = " + toInt.apply("5"));
        System.out.println("toIntSimple.apply(\"10\") = " + toIntSimple.apply("10"));
    }
}
