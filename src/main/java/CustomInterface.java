@FunctionalInterface
public interface CustomInterface<T> {

    T myCall();

    default void printDefault() {
        System.out.println(" hello Default ");
    }

    static void printStatic() {
        System.out.println(" hello static ");
    }
}


