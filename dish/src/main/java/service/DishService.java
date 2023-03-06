package service;

import ru.fastfood.model.Dish;

public interface DishService {
    void addDish(Dish dish);
    void updateDish(Dish dish);

    Dish getDishById(int id);

    Dish findByDish(Dish dish);

}
