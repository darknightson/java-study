package modenJavainaction.chapter01;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Example01 {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("20", "RED"), new Apple("10", "GREEN"));
        List<Apple> list1 = Arrays.asList(new Apple("20", "RED"), new Apple("10", "GREEN"));

        // 예전에 정렬을 하려면.. 아래처럼..
        Collections.sort(list, new Comparator<Apple>() {
            // 익명 클래스
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println("list = " + list);
        // java8 에서의 정렬은 아래처럼..
        list1.sort(Comparator.comparing(Apple::getWeight));
        System.out.println("list1 = " + list1);
    }
}

