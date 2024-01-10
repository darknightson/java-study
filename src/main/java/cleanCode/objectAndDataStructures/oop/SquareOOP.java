package cleanCode.objectAndDataStructures.oop;

import java.awt.*;

public class SquareOOP implements Sharp {

    private Point topLeft;
    private double side;

    @Override
    public double area() {
        return side * side;
    }
}
