package cleanCode.nameingrule;

public class Complex {
    private double real;

    // 생성자 사용을 제한한다.
    private Complex(double real) {
        this.real = real;
    }

    // 생성자를 중복 정의할때에는 정적 팩토리 메서드를 사용하는 것이 좋다.
    public static Complex FromRealNumber(double real) {
        return new Complex(real);
    }

    public double getReal() {
        return real;
    }
}
