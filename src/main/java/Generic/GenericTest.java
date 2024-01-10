package Generic;

import Fruit.Fruit;

public class GenericTest {

    public static void main(String[] args) {
        FruitBox<Banana> bananaFruitBox = new FruitBox(new Banana("banana"));
        System.out.println(" = " + bananaFruitBox.getFruit().getEngName());
        FruitBox<Apple> appleFruitBox = new FruitBox(new Apple("apple"));
        System.out.println(" = " + appleFruitBox.getFruit().getName());
    }
}

class FruitBox<T> {
    private T fruit;

    public FruitBox(T fruit) {
        this.fruit = fruit;
    }

    public T getFruit() {
        return fruit;
    }



    @Override
    public String toString() {
        return "FruitBox{" +
                "fruit=" + fruit +
                '}';
    }
}

class Banana {
    private String engName;

    public Banana(String engName) {
        this.engName = engName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }
}

class Apple extends Fruit {
    private String name;

    public Apple(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
