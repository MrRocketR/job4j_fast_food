package service;

import ru.fastfood.model.Dish;
import ru.fastfood.model.Kitchen;

import java.util.List;

public interface SortDish {
    List<Dish> sortByKitchen(Kitchen kitchen);

    List<Dish> sortPortion(int people);

    List<Dish> showAllDishes();

}
