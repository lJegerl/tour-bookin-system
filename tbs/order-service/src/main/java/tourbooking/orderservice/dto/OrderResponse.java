package tourbooking.orderservice.dto;

import tourbooking.orderservice.domain.OrderStatus;

public class OrderResponse {
    private String orderId;
    private OrderStatus status;

    public OrderResponse(String orderId, OrderStatus status) {
        this.orderId = orderId;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
