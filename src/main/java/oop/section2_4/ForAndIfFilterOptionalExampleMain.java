package oop.section2_4;

import java.util.List;

public class ForAndIfFilterOptionalExampleMain {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer integer1 = integerList.stream()
                .filter(integer -> {
                    return integer.equals(1234);
                })
                .findAny() // optional 반환 (값이 없을 수도 있음)
                .orElseThrow(); // NoSuchElementException 발생

        System.out.println("integer1 = " + integer1);
    }
}
