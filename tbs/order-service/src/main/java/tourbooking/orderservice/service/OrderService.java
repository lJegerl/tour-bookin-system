package tourbooking.orderservice.service;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;
import tourbooking.orderservice.domain.Order;
import tourbooking.orderservice.dto.CreateOrderRequest;
import tourbooking.orderservice.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Mono<Order> createOrder(CreateOrderRequest request) {
        Order order = new Order(
                request.getUserId(),
                request.getFlightId(),
                request.getHotelId());
        return orderRepository.save(order);
    }

    public Mono<Order> getOrder(String id) {
        return orderRepository.findById(id);
    }
}
