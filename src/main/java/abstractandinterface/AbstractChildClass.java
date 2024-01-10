package abstractandinterface;

public class AbstractChildClass extends AbstractClass implements InterfaceClass {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void makeRabbit() {
        System.out.println(" i am AbstractClass ");
    }

    @Override
    public void makeRabbitInterface() {
        System.out.println(" i am interface in abstract class");
    }
}
