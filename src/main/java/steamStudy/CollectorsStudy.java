package steamStudy;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsStudy {

    public static void main(String[] args) {
        // 1. Collectors.toList -> List
        // 2. Collectors.toSet -> Set
        // 3. Collectors.mapping -> 매핑
        // 4. Collectors.reducing -> reduce

        List<Integer> integers = List.of(3, 5, -3, 3, 4, 5);

        Set<Integer> collect = integers.stream()
                .filter(integer -> integer > 0)
                .collect(Collectors.toSet());

        List<Integer> collect1 = integers.stream()
                .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toList())); // mapping(값, 노출 형태)

        System.out.println("collect1 = " + collect1);

        Set<Integer> collect2 = integers.stream()
                .collect(Collectors.mapping(x -> Math.abs(x), Collectors.toSet()));

        System.out.println("collect2 = " + collect2);

        Integer collect3 = integers.stream()
                .collect(Collectors.reducing(0, (x, y) -> x + y)); //
        System.out.println("collect3 = " + collect3);


    }
}
