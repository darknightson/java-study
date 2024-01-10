package modenJavaInKe.chapter01;

public class SubCalculation implements Calculation {

    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}
