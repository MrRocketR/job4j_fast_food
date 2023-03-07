package ru.job4.fastfood.service;

import org.springframework.stereotype.Service;
import ru.fastfood.model.Order;
import ru.job4.fastfood.repository.NotificationRepository;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public void addOrder(Order order) {
        repository.addOrder(order);
    }
}
