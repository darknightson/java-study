package modenJavainaction.chapter03;

import modenJavainaction.chapter01.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.SimpleFormatter;

public class Example {

    public static void main(String[] args) {

        List<Apple> list = Arrays.asList(new Apple("20", "RED"), new Apple("30", "BLUE"));
        final List<Apple> filter = filter(list, a -> a.getWeight().equals("30"));
        System.out.println("filter = " + filter);

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> rList = new ArrayList<>();
        for (T t : list) {
            if ( predicate.test(t)) {
                rList.add(t);
            }
        }
        return  rList;
    }
}
