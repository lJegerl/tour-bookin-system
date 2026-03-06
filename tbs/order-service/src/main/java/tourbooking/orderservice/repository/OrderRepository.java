package tourbooking.orderservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import tourbooking.orderservice.domain.Order;

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {

}