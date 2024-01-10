package modenJavaInKe.effectivejava;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static modenJavaInKe.effectivejava.EnumMapTest.TestEnum.*;

public class EnumMapTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    enum TestEnum {
        AAA, BBB, CCC, DDD
    }


@Test
    void testHashMap() throws Exception {
        // given
        ObjectMapper objectMapper = new ObjectMapper();
        final Map<TestEnum, Integer> map = new HashMap<>();

        map.put(AAA, 1);
        map.put(BBB, 2);
        map.put(CCC, 3);
        map.put(DDD, 4);

        // when
        String actual = objectMapper.writeValueAsString(map);

        // then
        System.out.println(actual);
    }
}
