package ru.fastfood.order.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import ru.fastfood.model.Order;
import ru.fastfood.order.service.KafkaService;
import ru.fastfood.order.service.StartOrderService;


import java.util.Optional;

@Data
@RestController
@RequestMapping("/order")
public class OrderController {
    private final StartOrderService orderService;
    private final KafkaService kafkaService;

    @PutMapping("/")
    public ResponseEntity<Void> createOrder(@RequestBody Order order) {
        Optional<Order> optionalPerson = orderService.createOrder(order);
        if (optionalPerson.isPresent()) {
            kafkaService.sendMessage(order);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

