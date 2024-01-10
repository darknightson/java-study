package oop.encapsulation;

public class ProductA {

    public String name;
    public Integer price;
    public Integer amount;
}
class A {
    public void aMethod(ProductA product) {
        Integer totalAmount = product.price * product.amount;
        // ...
    }
}
class B {
    public void bMethod(ProductA product) {
        Integer totalAmount = product.price * product.amount;
        // ...
    }
}
