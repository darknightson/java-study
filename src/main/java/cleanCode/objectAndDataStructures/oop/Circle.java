package cleanCode.objectAndDataStructures.oop;

import java.awt.*;

public class Circle implements Sharp {

    private Point center;
    private double radius;
    private final double PI = 3.141592653589793;

    @Override
    public double area() {
        return PI * radius * radius;
    }
}
