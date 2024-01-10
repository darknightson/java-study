package oop.section2_3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStream {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("C", 3);
        map.put("A", 1);
        map.put("B", 2);

        map.keySet().forEach(System.out::println); // 모든 키 출력
        map.values().forEach(System.out::println); // 모든 값 출력

        // 특정 조건에 만족하는 엔트리 (키와 값) 출력하기
        List<Map.Entry<String, Integer>> collect = map.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toList());

        System.out.println("collect = " + collect);

        // 값에 따라 정렬 후 키와 값 출력하기
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        // 키를 기준으로 정렬 후 출력하기
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        // 스트림을 이용하여 새로운 HashMap 만들기
        Map<String, Integer> newMap = map.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("newMap = " + newMap);
    }
}
