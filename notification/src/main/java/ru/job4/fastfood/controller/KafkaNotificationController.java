package ru.job4.fastfood.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.fastfood.model.Order;
import ru.job4.fastfood.service.NotificationService;

//@Component
@EnableKafka
public class KafkaNotificationController {

    private final NotificationService service;

    public KafkaNotificationController(NotificationService service) {
        this.service = service;
    }

    @KafkaListener(topics = {"messenger"})
    public void onApiCall(ConsumerRecord<Integer, Order> input) {
        Order value = input.value();
        service.addOrder(value);
    }

}
