package tourbooking.orderservice.service;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tourbooking.orderservice.domain.Order;
import tourbooking.orderservice.dto.CreateOrderRequest;
import tourbooking.orderservice.events.OrderCreatedEvent;
import tourbooking.orderservice.messaging.OrderEventPublisher;
import tourbooking.orderservice.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderEventPublisher publisher;

    public OrderService(OrderRepository orderRepository,
            OrderEventPublisher publisher) {
        this.orderRepository = orderRepository;
        this.publisher = publisher;
    }

    public Mono<Order> createOrder(CreateOrderRequest request) {

        Order order = new Order(
                request.getUserId(),
                request.getFlightId(),
                request.getHotelId());

        return orderRepository.save(order)
                .doOnSuccess(saved -> {

                    OrderCreatedEvent event = new OrderCreatedEvent(
                            saved.getId(),
                            saved.getUserId(),
                            saved.getFlightId(),
                            saved.getHotelId());

                    publisher.publishOrderCreated(event);

                });
    }

    public Mono<Order> getOrder(String id) {
        return orderRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Order not found")));
    }

    public Flux<Order> getOrders() {
        return orderRepository.findAll();
    }
}