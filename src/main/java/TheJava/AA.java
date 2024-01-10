package TheJava;

import java.util.function.Function;


public class AA implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
