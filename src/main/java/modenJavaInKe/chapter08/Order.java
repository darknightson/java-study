package modenJavaInKe.chapter08;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private Long id;
    private String orderNumber;
    private List<OrderItem> items;

    public Order() {
    }

    public Order(Long id, String orderNumber, List<OrderItem> items) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", items=" + items +
                '}';
    }
    // 총값
    public BigDecimal totalPrice() {
        return FunctionExample.totFilter(items, item -> item.getTotalPrice());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
