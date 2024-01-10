package AStart.afunctionInter;

@FunctionalInterface
public interface FunctionCustom<T1,T2, R> {
    R apply(T1 t, T2 t2);
}
