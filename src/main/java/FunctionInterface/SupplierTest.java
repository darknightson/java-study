package FunctionInterface;

import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> {
            return "Hello world";
        };

        System.out.println("stringSupplier.get() = " + stringSupplier.get());
        
        Supplier<Double> longSupplier = () -> {
            return Math.random();
        };
        System.out.println("longSupplier.get() = " + longSupplier.get());
        supplierDouble(longSupplier, 5);
    }

    public static void supplierDouble(Supplier<Double> doubleSupplier, int count) {
        for ( int i=0; i<count; i++ ) {
            System.out.println("doubleSupplier = " + doubleSupplier.get());
        }
    }
    
}
