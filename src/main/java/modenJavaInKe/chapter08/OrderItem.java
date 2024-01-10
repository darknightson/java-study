package modenJavaInKe.chapter08;

import java.math.BigDecimal;

public class OrderItem {

    private Long id;
    private Product product;
    private int quantity;

    public OrderItem() {
    }

    public BigDecimal getTotalPrice() {
        return product.getPrice().multiply(new BigDecimal(String.valueOf(quantity)));
    }

    public OrderItem(Long id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
