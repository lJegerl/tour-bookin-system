package tourbooking.orderservice.dto;

public class CreateOrderRequest {
    private String userId;
    private String flightId;
    private String hotelId;

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
