package steamStudy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter6Section_1 {

    public static void main(String[] args) {
        Stream<String> nameStream = Stream.of("Alice", "Bob", "Charlie");
        List<String> nameCollect = nameStream.collect(Collectors.toList());
        System.out.println("nameCollect = " + nameCollect);

        String[] cityArrays = {"San Jose", "Seoul", "Tokyo"};
        Stream<String> cityList = Arrays.stream(cityArrays);
        List<String> cityCollect = cityList.collect(Collectors.toList());
        System.out.println("cityCollect = " + cityCollect);

        Set<Integer> numberSet = new HashSet<>(Arrays.asList(3, 5, 7));
        Stream<Integer> numberStream = numberSet.stream();
        List<Integer> numberCollect = numberStream.collect(Collectors.toList());
        System.out.println("numberCollect = " + numberCollect);

    }
}
