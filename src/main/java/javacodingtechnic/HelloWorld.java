package javacodingtechnic;

public class HelloWorld {

    public static void main(String[] args) {
        if (isEmpty(args)) {
            return;
        }
        System.out.println("Hello World!" + args[0]);
    }

    private static boolean isEmpty(String[] args) {
        return (args == null || args.length == 0);
    }
}
