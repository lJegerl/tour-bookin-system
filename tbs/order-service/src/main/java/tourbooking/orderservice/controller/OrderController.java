package tourbooking.orderservice.controller;

import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;
import tourbooking.orderservice.domain.Order;
import tourbooking.orderservice.dto.CreateOrderRequest;
import tourbooking.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Mono<Order> createOrder(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping
    public Mono<Order> getOrder(@PathVariable String id) {
        return orderService.getOrder(id);
    }
}
