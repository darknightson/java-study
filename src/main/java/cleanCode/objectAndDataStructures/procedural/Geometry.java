package cleanCode.objectAndDataStructures.procedural;

import cleanCode.objectAndDataStructures.NoSuchShapeException;

import java.awt.*;

/**
 * 절차작인 도형
 * 도형이 추가 될때마다 Geometry 클래스를 수정해야 한다.
 * 반대로 도형은 아무런 영향을 받지 않는다.
 */
public class Geometry {
    public final double PI = 3.141592653589793;

    public double area(Object shape) throws NoSuchShapeException {

        String outputDir = "";

        if ( shape instanceof Square ) {
            Square s = (Square) shape;
            return s.side * s.side;
        }
        else if ( shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            return r.height * r.width;
        }
        throw new NoSuchShapeException();
    }
}
