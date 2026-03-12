package tourbooking.flightservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import tourbooking.flightservice.domain.FlightReservation;

public interface FlightReservationRepository
        extends ReactiveMongoRepository<FlightReservation, String> {

}