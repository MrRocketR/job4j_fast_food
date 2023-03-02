package ru.fastfood.order.service;

import ru.fastfood.order.model.Order;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class StartOrderService implements OrderService {
    AtomicInteger id = new AtomicInteger();

    @Override
    public Optional<Order> createOrder(String customer) {
        Order order = new Order(id.incrementAndGet(), customer);
        return Optional.of(order);
    }
}
