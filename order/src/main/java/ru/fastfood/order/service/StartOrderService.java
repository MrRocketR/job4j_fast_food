package ru.fastfood.order.service;

import org.springframework.stereotype.Service;
import ru.fastfood.model.Order;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StartOrderService implements OrderService {
    AtomicInteger id = new AtomicInteger();

    @Override
    public Optional<Order> createOrder(Order order) {
        order.setId(id.incrementAndGet());
        return Optional.of(order);
    }
}

