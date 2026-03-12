package tourbooking.flightservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("flight_reservations")
public class FlightReservation {

    @Id
    private String id;

    private String orderId;
    private String flightId;
    private FlightStatus status;

    public FlightReservation(String orderId, String flightId) {
        this.orderId = orderId;
        this.flightId = flightId;
        this.status = FlightStatus.RESERVED;
    }

    public String getId() {
        return id;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getFlightId() {
        return flightId;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }
}