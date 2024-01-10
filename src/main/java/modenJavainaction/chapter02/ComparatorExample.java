package modenJavainaction.chapter02;

import modenJavainaction.chapter01.Apple;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

public class ComparatorExample {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("20", "RED"), new Apple("10", "GREEN"));

        Collections.sort(list, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println("list = " + list);

        list.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()) );
        System.out.println("list = " + list);


    }


}
