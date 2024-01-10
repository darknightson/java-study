package modenjava_20220517_start;

import java.util.function.Function;

public class FunctionInterfaceExample {
    public static void main(String[] args) {

       Function<String, Integer> function = new Function<String, Integer>() {
           @Override
           public Integer apply(String s) {
               return Integer.parseInt((s));
           }
       };
        final Integer apply = function.apply("100");
        System.out.println("apply = " + apply);
        
        Function<String, Integer> f = ( value ) -> Integer.parseInt(value);
        System.out.println("f.apply(\"200\") = " + f.apply("200"));
    }

}
