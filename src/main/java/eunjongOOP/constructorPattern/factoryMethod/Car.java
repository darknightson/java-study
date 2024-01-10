package eunjongOOP.constructorPattern.factoryMethod;

public class Car {

    public static final String SONATA = "Sonata";
    public static final String GRANDEUR = "Grandeur";

    private final String productName;

    public Car(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "productName='" + productName + '\'' +
                '}';
    }
}
