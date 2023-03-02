package ru.fastfood.order.service;

import org.springframework.stereotype.Service;
import ru.fastfood.order.model.Order;

import java.util.Optional;

@Service
public interface OrderService {
    Optional<Order> createOrder(String customer);
}
