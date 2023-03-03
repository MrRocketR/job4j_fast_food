package ru.fastfood.order.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fastfood.model.Order;
import ru.fastfood.order.service.StartOrderService;




import java.util.Optional;

@Data
@RestController
@RequestMapping("/order")
public class OrderController {
    private final StartOrderService orderService;

    @PutMapping("/")
    public ResponseEntity<Void> createOrder(@RequestBody Order order) {
        Optional<Order> optionalPerson = orderService.createOrder(order);
        return optionalPerson.isPresent() ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
