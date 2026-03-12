package tourbooking.flightservice.events;

public class FlightReservedEvent {

    private String orderId;
    private String flightId;

    public FlightReservedEvent(String orderId, String flightId) {
        this.orderId = orderId;
        this.flightId = flightId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getFlightId() {
        return flightId;
    }
}