package fastcampusModenJava.part06;

import java.math.BigDecimal;

public class OrderLine {

    private long id;
    private OrderLineType orderLineType;
    private long productId;
    private int quantity;
    private BigDecimal amount;

    public OrderLine(long id, OrderLineType orderLineType, BigDecimal amount) {
        this.id = id;
        this.orderLineType = orderLineType;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", orderLineType=" + orderLineType +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderLineType getOrderLineType() {
        return orderLineType;
    }

    public void setOrderLineType(OrderLineType orderLineType) {
        this.orderLineType = orderLineType;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
