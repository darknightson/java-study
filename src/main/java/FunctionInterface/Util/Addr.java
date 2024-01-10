package FunctionInterface.Util;

import java.util.function.Function;

public class Addr implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer x) {
        return x + 10;
    }
}
