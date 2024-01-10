package modenJavainaction.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class PredicateSection {

    /*
    java.util.function.Predicate<T> 인터페이스
     */
    public static void main(String[] args) {
        PredicateSection predicateSection = new PredicateSection();
        Predicate<String> s = s1 -> !s1.isEmpty();
        List<String> strings = Arrays.asList("a", "b", "c", "", "");

        final List<String> filter = predicateSection.filter(strings, s);
        System.out.println("filter = " + filter);

        strings.stream()
                .filter(s1 -> !s1.isEmpty())
                .forEach(s1 -> System.out.println(s));

        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if ( !s.isEmpty() ) {
                    return false;
                }
                return true;
            }
        };
    }

    public <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for ( T t : list ) {
            if ( predicate.test(t) ) {
                result.add(t);
            }
        }
        return result;
    }
}
