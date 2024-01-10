package modenJavaInKe.chapter01;

public class OopAnotherExample {

    public static void main(String[] args) {
        FpCalculatorService service = new FpCalculatorService();
        System.out.println(service.calculate(new AdditionCalculation(), 1, 1));
        System.out.println(service.calculate(new SubCalculation(), 2, 1));

        System.out.println(service.calculate((i1, i2) -> i1 + i2, 11,4));
    }
}


