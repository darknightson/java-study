package abstractandinterface;

public class MainClass {

    public static void main(String[] args) {
        AbstractClass abstractClass = new AbstractChildClass();
        abstractClass.makeRabbit();

        InterfaceClass interfaceClass = new InterChildClass();
        interfaceClass.makeRabbitInterface();


    }
}
