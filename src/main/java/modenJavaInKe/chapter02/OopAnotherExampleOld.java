package modenJavaInKe.chapter02;

public class OopAnotherExampleOld {
    public static void main(String[] args) {
        final CalculateService calculateService = new CalculateService();
        final int additionResult = calculateService.calculate(1, 1, '+');
        System.out.println("additionResult = " + additionResult);
        // 뺄셈을 요구하는 요청이 새롭게 들어왔다.
        final int subtractionResult = calculateService.calculate(1, 1, '-');
        System.out.println("subtractionResult = " + subtractionResult);
        // 곱셈을 요구하는 요청이 새롭게 들어왔다.
        final int multiplication = calculateService.calculate(2, 2, '*');
    }

}

class CalculateService {
    public int calculate(int num1, int num2, char calculation) {
        if ( calculation == '+') {
            // 주어진 두개의 값을 더해서 리턴한다.
            return num1 + num2;
        } else if ( calculation == '-') {
            return num1 - num2;
        } else if ( calculation == '*') {
            return num1 * num2;
        }
        else {
            throw new IllegalArgumentException("Unknown calculation : " + calculation);
        }
    }
}
