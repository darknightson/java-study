package FunctionInterface.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest1 {

    public static void main(String[] args) {
        List<Integer> inputs = Arrays.asList(10, 20, 30, -1, 0, -3);
        List<Integer> results = new ArrayList<>();
        
        System.out.println("filters(inputs, integerPredicate) = " + filters(inputs, (x -> x > 0)));
    }

    
    
    public static <T> List<T> filters(List<T> inputs, Predicate<T> predicate) {
        List<T> results = new ArrayList<>();
        
        for ( T input : inputs ) {
            if ( predicate.test(input) ) {
                results.add(input);
            }
        }
        return results;
    } 
}
