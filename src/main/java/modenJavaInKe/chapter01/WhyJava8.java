package modenJavaInKe.chapter01;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class WhyJava8 {

    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // exercise
        // 1 : 2 : 3 .... 마지막 : 는 어떻게 지울까?
        // old code 1
        StringBuilder builder = new StringBuilder();
        for ( Integer number : numbers ) {
            builder.append(number).append(" : ");
        }
        // old code 2
        for ( int i=0; i< numbers.size(); i++ ) {
            builder.append(numbers.get(i));
            if ( i < numbers.size() -1  ) {
                builder.append(" : ");
            }
        }
        System.out.println("builder = " + builder);

        // new code
        final String result = numbers.stream()
                                     .map(String::valueOf)
                                     .collect(joining( " : "));

        System.out.println("result = " + result);
    }
}
