package com.br.produto_externo_a.domain.order.service.impl;

import com.br.produto_externo_a.domain.enums.Status;
import com.br.produto_externo_a.domain.order.OrderRequest;
import com.br.produto_externo_a.domain.order.service.OrderService;
import com.br.produto_externo_a.domain.order.status.StatusResponse;
import com.br.produto_externo_a.domain.product.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    private final RabbitTemplate rabbitTemplate;

    @Override
    public StatusResponse sendOrder(OrderRequest order) {
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, resolveOrderRequest(order));
        return StatusResponse.builder().status(Status.IN_PROCESSING).time(LocalDateTime.now()).build();
    }

    private OrderRequest resolveOrderRequest(OrderRequest orderRequest) {
        if (orderRequest != null) return orderRequest;

        return OrderRequest.builder()
                .id(UUID.randomUUID())
                .products(generateRandomProducts())
                .build();
    }

    private List<ProductRequest> generateRandomProducts() {
        return IntStream.range(0, random(1, 4))
                .mapToObj(i -> ProductRequest.builder()
                        .id(UUID.randomUUID())
                        .name("Product " + (i + 1))
                        .price(BigDecimal.valueOf(randomDouble(10.0, 100.0)))
                        .quantity(random(1, 10))
                        .build())
                .toList();
    }

    private int random(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    private double randomDouble(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }
}
