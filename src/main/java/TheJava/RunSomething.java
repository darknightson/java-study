package TheJava;

@FunctionalInterface
public interface RunSomething {

    int doIt(int number);

    static void printName() {
        System.out.println("test");
    }

    default void printAge() {
        System.out.println("11");
    }

}
