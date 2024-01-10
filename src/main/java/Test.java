public class Test {

    public static void main(String[] args) {
        CustomInterface<String> customInterface = () -> "hello custom";

        String s = customInterface.myCall();
        System.out.println("s = " + s);

        customInterface.printDefault();
        CustomInterface.printStatic();
    }
}
