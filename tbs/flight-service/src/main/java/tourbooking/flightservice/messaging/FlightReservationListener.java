package tourbooking.flightservice.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import tourbooking.flightservice.domain.FlightReservation;
import tourbooking.flightservice.events.FlightReservedEvent;
import tourbooking.flightservice.events.OrderCreatedEvent;
import tourbooking.flightservice.repository.FlightReservationRepository;

@Service
public class FlightReservationListener {

    private final FlightReservationRepository repository;
    private final RabbitTemplate rabbitTemplate;

    public FlightReservationListener(
            FlightReservationRepository repository,
            RabbitTemplate rabbitTemplate) {
        this.repository = repository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "flight.reserve.queue")
    public void handleOrderCreated(OrderCreatedEvent event) {

        FlightReservation reservation = new FlightReservation(
                event.getOrderId(),
                event.getFlightId());

        repository.save(reservation)
                .doOnSuccess(saved -> {

                    FlightReservedEvent response = new FlightReservedEvent(
                            event.getOrderId(),
                            event.getFlightId());

                    rabbitTemplate.convertAndSend(
                            "flight.exchange",
                            "flight.reserved",
                            response);

                })
                .subscribe();
    }
}