package Generic;

import Fruit.Fruit;

public class AppleFruit extends Fruit {

    String name;
    String color;

    public AppleFruit() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
