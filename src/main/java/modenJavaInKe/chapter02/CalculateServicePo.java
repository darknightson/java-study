package modenJavaInKe.chapter02;

class CalculateServicePo {
    private final Calculation calculation;

    public CalculateServicePo(Calculation calculation) {
        this.calculation = calculation;
    }

    public int calculate(int num1, int num2) {
        return calculation.calculate(num1, num2);
    }
}
