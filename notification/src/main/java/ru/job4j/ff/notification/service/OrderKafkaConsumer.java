package ru.job4j.ff.notification.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.fastfood.model.Notification;
import ru.fastfood.model.Order;
import ru.job4j.ff.notification.repository.NotificationRepository;

@Service
@RequiredArgsConstructor
public class OrderKafkaConsumer {

    private final NotificationRepository repository;

    @KafkaListener(topics = "notification", groupId = "fastFood")
    public void consumeOrderAndCreateNotification(Order order) {
        Notification notification = Notification.builder()
                .orderNumber(order.getId())
                .status(order.getStatus().toString())
                .message(order.toString())
                .orderCreatedAt(order.getCreatedAt())
                .build();
        repository.save(notification);

    }

}
