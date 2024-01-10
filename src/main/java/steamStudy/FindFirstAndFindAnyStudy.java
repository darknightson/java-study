package steamStudy;

import java.util.List;
import java.util.Optional;

public class FindFirstAndFindAnyStudy {
    public static void main(String[] args) {
        // findFirst - Stream 안의 첫번째 데이터를 반환. Stream 이 비어있다면 비어있는 Optional 반환
        // findAny - Stream 안의 아무 데이터나 리턴. 순서가 중요하지 않고 Parallel Stream 을 사용할 때 최적화를 할 수 있다.
        // 마친가지로 Stream 이 비어 있다면 Optional 반환
        List<Integer> integers = List.of(1, 3, 4, -1, 10);
        Optional<Integer> any = integers.stream()
                .filter(integer -> integer < 0)
                .findAny();
        System.out.println("any = " + any);

        Optional<Integer> first = integers.stream()
                .filter(integer -> integer > 0)
                .findFirst();

        System.out.println("first = " + first);
    }
}
