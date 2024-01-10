package AStart.supplier;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
//        final long start = System.currentTimeMillis();
//        printInValidIndex(0, getVeryExpensiveValue());
//        printInValidIndex(-1, getVeryExpensiveValue());
//        printInValidIndex(-2, getVeryExpensiveValue());
//        System.out.println("System.currentTimeMillis() - start / 1000 = " + (System.currentTimeMillis() - start) / 1000);

        final long start1 = System.currentTimeMillis();
        printInValidIndex1(-1, () -> getVeryExpensiveValue());
        printInValidIndex1(-1,() -> getVeryExpensiveValue());
        printInValidIndex1(0,() -> getVeryExpensiveValue());
        System.out.println("System.currentTimeMillis() - start / 1000 = " + (System.currentTimeMillis() - start1) / 1000);
    }

    private static String getVeryExpensiveValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "dark";
    }

    private static void printInValidIndex(int number, String value) {
        if ( number >= 0 ) {
            System.out.println("The value is = " + value + ".");
        }
        else {
            System.out.println("Invalid");
        }
    }

    private static void printInValidIndex1(int number, Supplier<String> supplierValue) {
        if ( number >= 0 ) {
            System.out.println("The value is = " + supplierValue.get() + ".");
        }
        else {
            System.out.println("Invalid");
        }
    }
}
