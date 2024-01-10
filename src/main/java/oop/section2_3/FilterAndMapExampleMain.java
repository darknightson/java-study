package oop.section2_3;

import java.util.List;
import java.util.stream.Collectors;

public class FilterAndMapExampleMain {

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println("integerList = " + integerList);

        List<Integer> result = integerList.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * 10)
                .collect(Collectors.toList());

        System.out.println("result = " + result);
    }
}
