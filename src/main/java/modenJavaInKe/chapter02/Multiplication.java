package modenJavaInKe.chapter02;

class Multiplication implements Calculation {

    @Override
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}