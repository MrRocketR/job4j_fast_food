package ru.job4j.ff.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fastfood.model.Order;
import ru.job4j.ff.order.service.OrderServiceKafkaProducer;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServiceKafkaProducer service;

    @PostMapping("/")
    public ResponseEntity<HttpStatus> addOrder(@RequestBody Order order) throws ExecutionException, InterruptedException {
        service.sendOrderToNotification(order);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Order> findAll() {
        return service.findAll();
    }
}
