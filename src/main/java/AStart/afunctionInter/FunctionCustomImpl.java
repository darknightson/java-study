package AStart.afunctionInter;

public class FunctionCustomImpl {

    public static void main(String[] args) {

        FunctionCustom<Integer, Integer, Integer> functionCustom = (t, o) -> t + o;

        final Integer apply = functionCustom.apply(1, 2);
        System.out.println("apply = " + apply);
    }
}
