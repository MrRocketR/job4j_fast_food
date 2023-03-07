package ru.job4.fastfood.repository;

import org.springframework.stereotype.Repository;
import ru.fastfood.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class NotificationRepository {
    private final AtomicInteger ids = new AtomicInteger(0);
    private final ConcurrentHashMap<Integer, Order> db = new ConcurrentHashMap<>();

    public void addOrder(Order order) {
        order.setId(ids.incrementAndGet());
        db.put(order.getId(), order);
    }

    public List<Order> findAll() {
        return new ArrayList<>(db.values());
    }
}
