package ru.job4j.ff.order.service;

import lombok.Data;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.fastfood.model.Order;
import ru.job4j.ff.order.repository.OrderRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Data
@Service
public class OrderServiceKafkaProducer {

    private final KafkaTemplate<Integer, Order> orderKafkaTemplate;
    private final OrderRepository repository;

    public void sendOrderToNotification(Order order) throws ExecutionException, InterruptedException {
        repository.save(order);
        orderKafkaTemplate.send("notification", order).get().getProducerRecord();

    }

    public List<Order> findAll() {
        return repository.findAll();
    }

}
