package modenjava_20220517_start;

public class CustomFunctionInterfaceExample {

    public static void main(String[] args) {
        CustomFunction<Integer, Integer, Integer> function = ( (integer, integer2) ->  integer + integer2);
        System.out.println("function.apply(10,10) = " + function.apply(10,10));
    }
}


interface CustomFunction<T1, T2, R> {
    R apply(T1 t1, T2 t2);
}
