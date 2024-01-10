package oop.encapsulation;

public class ProductCorrect {

    private String name;
    private Integer price;
    private Integer amount;

    public Integer getTotalAmount() {
        return price * amount;
    }
}
class ProductFunctionCorrect {
    public void someMethod(ProductCorrect product) {
        Integer totalAmount = product.getTotalAmount();
        // 추가로직
    }
    public void anotherMethod(ProductCorrect product) {
        Integer totalAmount = product.getTotalAmount();
        // 추가 로직
    }
}
