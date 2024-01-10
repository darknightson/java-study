package cleanCode.objectAndDataStructures.oop;

import java.awt.*;

public class Rectangle implements Sharp {

    private Point topLeft;
    private double height;
    private double width;

    @Override
    public double area() {
        return height * width;
    }
}
