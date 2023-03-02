package ru.fastfood.order.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fastfood.order.*;
import ru.fastfood.order.service.StartOrderService;
import ru.fastfood.order.model.Order;



import java.util.Optional;

@Data
@RestController
@RequestMapping("/order")
public class OrderController {
    private final StartOrderService orderService;

    @PutMapping("/")
    public ResponseEntity<Void> createOrder(@RequestBody Order order) {
        Optional<Order> optionalPerson = orderService.createOrder(order.getCostumer());
        return optionalPerson.isPresent() ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
