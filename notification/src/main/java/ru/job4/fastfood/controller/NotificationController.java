package ru.job4.fastfood.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fastfood.model.Order;
import ru.job4.fastfood.service.NotificationService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @KafkaListener(topics = "messengers")
    public void orderListener(ConsumerRecord<Integer, Order> input) {
        Order order = input.value();
        service.addOrder(order);
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return service.findAll();
    }
}
