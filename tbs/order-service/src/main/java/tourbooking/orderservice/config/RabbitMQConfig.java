package tourbooking.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;

@Configuration
public class RabbitMQConfig {

    public static final String ORDER_EXCHANGE = "order.exchange";
    public static final String FLIGHT_QUEUE = "flight.reserve.queue";
    public static final String ROUTING_KEY = "order.created";

    @Bean
    public TopicExchange orderExchange() {
        return new TopicExchange(ORDER_EXCHANGE);
    }

    @Bean
    public Queue flightReserveQueue() {
        return new Queue(FLIGHT_QUEUE);
    }

    @Bean
    public Binding binding(Queue flightReserveQueue, TopicExchange orderExchange) {
        return BindingBuilder
                .bind(flightReserveQueue)
                .to(orderExchange)
                .with(ROUTING_KEY);
    }
}