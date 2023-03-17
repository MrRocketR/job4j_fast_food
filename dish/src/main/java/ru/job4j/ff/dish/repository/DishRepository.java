package ru.job4j.ff.dish.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.fastfood.model.Dish;

import java.util.List;
import java.util.Optional;
@Repository
public interface DishRepository extends CrudRepository<Dish, Integer> {
    Optional<Dish> findByName(String name);

    boolean deleteByName(String name);

    boolean deleteById(int id);

    List<Dish> findAll();
}
