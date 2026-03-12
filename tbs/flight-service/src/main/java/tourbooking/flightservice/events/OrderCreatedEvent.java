package tourbooking.flightservice.events;

public class OrderCreatedEvent {

    private String orderId;
    private String userId;
    private String flightId;
    private String hotelId;

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