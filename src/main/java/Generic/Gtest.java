package Generic;

import Fruit.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Gtest {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        Apple apple = new Apple("apple");
        apple.setYummy("best");
        apples.add(apple);


        List<? extends Fruit> fruits = apples;

    }
}


