package ru.job4j.ff.kitchen.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.fastfood.model.Order;
import ru.job4j.ff.kitchen.repository.KitchenOrderRepository;

@Data
@Service
public class KitchenServiceKafka {

    private final KafkaTemplate<Integer, Order> template;
    private final KitchenOrderRepository repository;

    @KafkaListener(topics = "orderToKitchen", groupId = "fastFood")
    public void orderListener(Order order) {
        try {
            order.setStatus("cooking");
            pause();
            order.setStatus("done");
            repository.save(order);
            template.send("kitchenToOrder", order.getId(), order);
        } catch (Exception e) {
            order.setStatus("canceled");
            repository.save(order);
            template.send("kitchenToOrder", order.getId(), order);
            System.out.println("Что-то пошло не так! :( ");
        }
    }

    private void pause() {
        int i = 0;
        while(i < 6000) {
            i++;
        }
    }
}
