package oop.section2_4;

import java.util.Arrays;
import java.util.List;

public class ForAndIfFilterExampleMain {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer findNumber = null;

        for (int i = 0; i < integerList.size(); i++) {
            if(integerList.get(i).equals(1234)) {
                findNumber = integerList.get(i);
                break;
            }
        }

        if(findNumber == null)
            throw new RuntimeException();

        System.out.println("findNumber=" + findNumber);
    }
}
