package modenJavainaction.chapter03;

import modenJavainaction.chapter01.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Example02 {

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("30", "RED"), new Apple("20", "BLUE"));

//        list.sort(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.getWeight().compareTo(o2.getWeight());
//            }
//        });
//        System.out.println("list = " + list);
        list.sort(Comparator.comparing(Apple::getWeight));
        System.out.println("list = " + list);
        
        Apple a1 = new Apple("40", "YELLOW");
        
        String string = "abcd";
        Integer i = 2;
        BiFunction<String, Integer, String> biFunction = (String str, Integer size) -> str.substring(2);
        BiFunction<String, Integer, String> biFunction1 = String::substring;

        System.out.println("map(string, 2, biFunction) = " + map(string, 2, String::substring));
        System.out.println("isV = " + isValidName("abc"));
        List<String> strings = Arrays.asList("a", "b","A", "B");
        System.out.println("strings = " + strings);

        strings.sort((String s1, String s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("strings = " + strings);

        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        System.out.println("strings = " + strings);
    }

    private static boolean isValidName(String string) {
        System.out.println("Character.isUpperCase(string.charAt(0)); = " + Character.isUpperCase(string.charAt(0)));
        return Character.isUpperCase(string.charAt(0));
    }

    public static <T, U, R> R map(T t, U u, BiFunction<T, U, R> biFunction ) {
        return biFunction.apply(t, u);
    }
}
