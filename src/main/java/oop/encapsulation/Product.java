package oop.encapsulation;

public class Product {

    public String name;
    public Integer price;
    public Integer amount;
}

class ProductFunction {
    public static Integer getTotalAmount(Product product) {
        return product.price * product.amount;
    }
}

class SomeClass {
    public void someMethod(Product product) {
        Integer totalAmount = ProductFunction.getTotalAmount(product);
        // 추가 로직
    }

    public void anotherMethod(Product product) {
        Integer totalAmount = ProductFunction.getTotalAmount(product);
        // 추가 로직
    }
}