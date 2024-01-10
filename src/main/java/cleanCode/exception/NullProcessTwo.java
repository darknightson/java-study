package cleanCode.exception;


import java.awt.*;

public class NullProcessTwo {

    public static void main(String[] args) {

        //double v = xProjection(null, new Point(12, 13));
        double v1 = xProjection1(null, new Point(12, 13));
        System.out.println("v = " + v1);
    }

    // 방법 1, 이것도 좋은 방법이 아니다.
    public static double xProjection(Point p1, Point p2) {

        if ( p1 == null || p2 == null ) {
            throw new IllegalArgumentException("null generation");
        }

        return  ( p2.x - p1.x) * 1.5;
    }

    // 방법 2
    // 이 방법이 위에 방법보다는 좋다. 하지만 null 을 근본 적으로 해결할 수 있는 방법은없다.
    // 따라서, null 을 넘기지 못하도록 금지하는 정책이 합리적이다.
    public static double xProjection1(Point p1, Point p2) {

        // assert condition:message -> condition true 이면 아래 구문을 실행하고 아니면 AssertionException(message)를 발생 한다.

        assert p1 != null : "p1 should not be null";
        assert p2 != null : "p2 should not be null";

        return  ( p2.x - p1.x) * 1.5;
    }
}
