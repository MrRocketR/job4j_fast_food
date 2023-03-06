package ru.job4j.fastfood.dish.service;

import org.springframework.stereotype.Service;
import ru.fastfood.model.Dish;

import java.util.List;
import java.util.Optional;

@Service
public interface DishService {
    void addDish(Dish dish);

    Optional<Dish> updateDish(Dish dish);

    Optional<Dish> findById(int id);

    Optional<Dish> deleteById(int id);

    List<Dish> showAllDishes();
}
