package ru.job4j.fastfood.dish.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.fastfood.model.Dish;
import ru.job4j.fastfood.dish.service.DishServices;
import java.util.List;
import java.util.Optional;
@RequestMapping("/dishes")
@RestController
public class DishController {

    private final DishServices service;

    public DishController(DishServices service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Dish> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> findById(@PathVariable int id) {
        var dish = this.service.findById(id);
        return dish.isPresent()
                ? new ResponseEntity<>(dish.get(), HttpStatus.OK)
                : ResponseEntity.notFound().build();

    }

    @PutMapping("/")
    public ResponseEntity<Void> add(@RequestBody Dish dish) {
        service.addDish(dish);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/")
    public ResponseEntity<String> update(@RequestBody Dish dish) {
        Optional<Dish> updated = service.updateDish(dish);
        if (updated.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No person found for update");
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        return service.deleteById(id).isPresent()
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

}

