package pl.jkanclerz.voucherstore.sales.offer;

import java.math.BigDecimal;
import java.util.List;

public class Offer {
    private final List<OrderLine> orderItems;
    private final BigDecimal total;

    public Offer(List<OrderLine> orderItems, BigDecimal total) {

        this.orderItems = orderItems;
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<OrderLine> getOrderItems() {
        return orderItems;
    }
}
