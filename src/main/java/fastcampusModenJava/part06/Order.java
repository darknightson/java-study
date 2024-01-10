package fastcampusModenJava.part06;

import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


public class Order {

    private long id;
    private LocalDateTime createdAt;
    private long createdByUserId;
    private OrderStatus status;
    private BigDecimal amount;
    private List<OrderLine> orderLines; //

    public Order() {
    }

    public Order(long id, OrderStatus status, BigDecimal amount) {
        this.id = id;
        this.status = status;
        this.amount = amount;
    }

    public Order(long id, List<OrderLine> orderLines) {
        this.id = id;
        this.orderLines = orderLines;
    }

    public Order(long id, long createdByUserId, OrderStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.createdByUserId = createdByUserId;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Order(long id, LocalDateTime createdAt, long createdByUserId, OrderStatus status, BigDecimal amount, List<OrderLine> orderLines) {
        this.id = id;
        this.createdAt = createdAt;
        this.createdByUserId = createdByUserId;
        this.status = status;
        this.amount = amount;
        this.orderLines = orderLines;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public long getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(long createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", createdByUserId=" + createdByUserId +
                ", status=" + status +
                ", amount=" + amount +
                ", orderLines=" + orderLines +
                '}';
    }
}
