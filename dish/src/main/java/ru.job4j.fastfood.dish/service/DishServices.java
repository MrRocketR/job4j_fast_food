package ru.job4j.fastfood.dish.service;

import org.springframework.stereotype.Service;
import ru.fastfood.model.Dish;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DishServices implements DishService {

    private AtomicInteger ids = new AtomicInteger(0);
    private Map<Integer, Dish> dishes = new HashMap<>();

    @Override
    public void addDish(Dish dish) {
        dish.setId(ids.incrementAndGet());
        dishes.put(dish.getId(), dish);
    }

    @Override
    public Optional<Dish> findById(int id) {
        return Optional.of(dishes.get(id));
    }

    @Override
    public Optional<Dish> updateDish(Dish dish) {
        Optional<Dish> old = Optional.of(dishes.get(dish.getId()));
        if (old.isPresent()) {
            dishes.put(dish.getId(), dish);
            return Optional.of(dish);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Dish> deleteById(int id) {
        Optional<Dish> deleted = Optional.of(dishes.get(id));
        if (deleted.isPresent()) {
            dishes.remove(id);
            return deleted;

        }
        return Optional.empty();
    }

    @Override
    public List<Dish> showAllDishes() {
        return new ArrayList<>(dishes.values());
    }
}
