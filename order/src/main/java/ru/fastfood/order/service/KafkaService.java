package ru.fastfood.order.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.fastfood.model.Order;

@Service
@Data
public class KafkaService {

    @Autowired
    private KafkaTemplate<Integer, Order> template;

    public void sendMessage(Order order) {
        template.send("messengers", order);
    }
}

