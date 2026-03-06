package tourbooking.orderservice.domain;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {
    @Id
    private String id;

    private String userId;
    private String flightId;
    private String hotelId;

    private OrderStatus status;
    private Instant createAt;

    public Order() {
    }

    public Order(String userId, String flightId, String hotelId) {
        this.userId = userId;
        this.flightId = flightId;
        this.hotelId = hotelId;
        this.status = OrderStatus.CREATED;
        this.createAt = Instant.now();
    }

}
