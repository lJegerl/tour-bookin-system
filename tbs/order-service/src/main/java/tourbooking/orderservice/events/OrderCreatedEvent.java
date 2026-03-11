package tourbooking.orderservice.events;

public class OrderCreatedEvent {

    private String orderId;
    private String flightId;
    private String hotelId;
    private String userId;

    public OrderCreatedEvent(String orderId, String userId, String flightId, String hotelId) {
        this.orderId = orderId;
        this.userId = userId;
        this.flightId = flightId;
        this.hotelId = hotelId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getHotelId() {
        return hotelId;
    }
}