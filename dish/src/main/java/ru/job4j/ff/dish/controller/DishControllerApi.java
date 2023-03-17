package ru.job4j.ff.dish.controller;


import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fastfood.model.Dish;
import ru.job4j.ff.dish.service.DishService;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("/dishes")
public class DishControllerApi {

    private final DishService service;

    @GetMapping("/all")
    public List<Dish> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> findById(@PathVariable int id) {
        var dish = service.findById(id);
        return dish.isPresent()
                ? new ResponseEntity<>(dish.get(), HttpStatus.OK)
                : ResponseEntity.notFound().build();

    }

    @GetMapping("/{name}")
    public ResponseEntity<Dish> findById(@PathVariable String name) {
        var dish = service.findByName(name);
        return dish.isPresent()
                ? new ResponseEntity<>(dish.get(), HttpStatus.OK)
                : ResponseEntity.notFound().build();

    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Dish dish) {
        Optional<Dish> optional = service.save(dish);
        return optional.isPresent()
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        return service.deleteById(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

}
