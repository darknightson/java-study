package modenJavaInKe.chapter13;

import java.util.List;

public class Order {

    private Long id;
    private List<OrderedItem> items;

    public Order(Long id, List<OrderedItem> items) {
        this.id = id;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderedItem> getItems() {
        return items;
    }

    public void setItems(List<OrderedItem> items) {
        this.items = items;
    }
}
