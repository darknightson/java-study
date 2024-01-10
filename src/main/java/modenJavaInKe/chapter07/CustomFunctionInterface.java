package modenJavaInKe.chapter07;

public class CustomFunctionInterface {

    public static void main(String[] args) {

        final String println = println(1, 2, 3, (i1, i2, i3) -> String.valueOf(i1 + i2 + i3));
        System.out.println("println = " + println);
    }
    public static <T1, T2, T3, R> R println(T1 t1, T2 t2, T3 t3, CustomFunction<T1, T2, T3, R> function) {
        return function.apply(t1, t2, t3);
    }
}

@FunctionalInterface
interface CustomFunction<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
}