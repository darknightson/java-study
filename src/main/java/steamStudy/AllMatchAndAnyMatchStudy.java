package steamStudy;

import java.util.List;

public class AllMatchAndAnyMatchStudy {

    public static void main(String[] args) {
        // allMatch - Stream 안의 모든 데이터가 predicate 을 만족하면 true
        // anyMatch - Stream 안의 모든 데이터가 하나라도 predicate 를 만족하면 true
        // TODO 해당 배열 안에 모든 데이터가 양수인가?
        List<Integer> integers = List.of(1, 3, 4, -1, 10);
        boolean result = integers.stream()
                .allMatch(integer -> integer > 0);
        System.out.println("result = " + result);

        // TODO 해당 배열 안의 데이터 중에 음수가 있는가?
        boolean result1 = integers.stream()
                .anyMatch(integer -> integer < 0);
        System.out.println("result1 = " + result1);


        

    }
}
