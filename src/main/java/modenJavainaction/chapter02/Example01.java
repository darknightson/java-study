package modenJavainaction.chapter02;

import TheJava.AA;
import modenJavaInKe.chapter05.TestVo;
import modenJavainaction.chapter01.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Example01 {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("20", "RED"), new Apple("10", "GREEN"));
        Predicate<Apple> predicate = apple -> Color.GREEN.toString().equals(apple.getColor());
        Predicate<Apple> predicate1 = apple -> Color.RED.toString().equals(apple.getColor());
        List<Apple> results = filter(apples, predicate);
        System.out.println("results = " + results);
        results = filter(apples, predicate1);
        System.out.println("results = " + results);
        // 위 내용을 익명의 클래스로 만든다면?

        final List<Apple> filter = filter(apples, new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                for (Apple a : apples) {
                    if (Color.GREEN.toString().equals(a.getColor())) {
                        return true;
                    }
                }
                return false;
            }
        });
        System.out.println("filter = " + filter);
        // 정말 간결하게 해볼까?
        List<Apple> appleList = filterGreenApple(apples, ( Apple apple ) -> apple.getColor().equals(Color.GREEN.toString()));
        System.out.println("appleList = " + appleList);

        final List<Apple> appleList1 = filterGen(apples, apple -> Color.RED.toString().equals(apple.getColor()));
        System.out.println("appleList1 = " + appleList1);

        final List<Apple> appleList2 = filterGen(apples, apple -> Integer.parseInt(apple.getWeight()) > 10);
        System.out.println("appleList2 = " + appleList2);
    }

    // 빨간 사과도 필터링 하고 싶어요
    // 제네릭하게 만들어 볼까? 어떤 타입으로 도 받을 수 있
    public static List<Apple> filterGreenApple(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> list = new ArrayList<>();
        for ( Apple apple : inventory ) {
            if ( predicate.test(apple) ) {
                list.add(apple);
            }
        }
        return list;
    }

    public static <T> List<T> filterGen(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for ( T t : list ) {
            if ( predicate.test(t) ) {
                result.add(t);
            }
        }
        return result;
    }

    public static <T> List<T> filter(List<T> inventory, Predicate<T> predicate) {
        final ArrayList<T> result = new ArrayList<>();
        for ( T t : inventory ) {
            if ( predicate.test(t) ) {
                result.add(t);
            }
        }
        return result;
    }
}

enum Color {
    RED, GREEN
}
