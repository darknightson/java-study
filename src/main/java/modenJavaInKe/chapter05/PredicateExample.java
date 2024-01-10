package modenJavaInKe.chapter05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {

        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("s");
            }
        };

        System.out.println("predicate.test(\"s\") = " + predicate.test("s"));
        System.out.println("predicate.test(\"a\") = " + predicate.test("a"));

        Predicate<String> stringPredicate = s -> s.equals(s);

        System.out.println(" = " + stringPredicate.test("s"));

        List<TestVo> testVos = Arrays.asList(new TestVo("apple"), new TestVo("banana"), new TestVo("apple"));
        Predicate<TestVo> testVoPredicate = testVo -> testVo.getName().equals("banana");

        List<TestVo> results = filter(testVos, testVoPredicate);

        for ( TestVo testVo : results ) {
            System.out.println("testVo.getName() = " + testVo.getName());
        }
    }

    public static <T> List<T> filter(List<T> inputs, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for ( T input : inputs ) {
            if ( predicate.test(input)) {
                result.add(input);
            }
        }
        return result;
    }
}
