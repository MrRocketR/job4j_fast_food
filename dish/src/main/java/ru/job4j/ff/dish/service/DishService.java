package ru.job4j.ff.dish.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.fastfood.model.Dish;
import ru.job4j.ff.dish.repository.DishRepository;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class DishService {
    private final DishRepository repository;

    public List<Dish> findAll() {
        return repository.findAll();
    }

    public Optional<Dish> findById(int id) {
        return repository.findById(id);
    }

    public Optional<Dish> save(Dish dish) {
        return Optional.of(repository.save(dish));
    }

    public Optional<Dish> findByName(String name) {
        return repository.findByName(name);
    }

    public boolean deleteByName(String name) {
        return repository.deleteByName(name);
    }

    public boolean deleteById(int id) {
        return repository.deleteById(id);
    }

}
