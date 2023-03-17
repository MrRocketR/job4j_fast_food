package ru.job4.fastfood.controller;


import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.fastfood.model.Dish;
import ru.job4.fastfood.service.AdminDishServiceApi;


import java.util.List;

@Data
@Controller
public class DishAdminController {

    private final AdminDishServiceApi service;

    @GetMapping("/dishes")
    private String showDishes(Model model) {
        List<Dish> dishes = service.findAll();
        model.addAttribute("dishes", dishes);
        return "dishes";
    }

    @GetMapping("/addDish")
    private String createPage(Model model) {
        model.addAttribute("dish", new Dish());
        return "addDish";
    }

    @PostMapping("/addDish")
    private String create(@ModelAttribute Dish dish) {
        service.addDish(dish);
        return "dishes";
    }

    @GetMapping("/formEditDish/{id}")
    private String updatePage(Model model, @PathVariable int id) {
        model.addAttribute("dish", service.findById(id));
        return "editDish";
    }

    @PostMapping("editDish")
    private String update(@ModelAttribute Dish dish) {
        service.updateDish(dish);
        return "dishes";
    }

    @DeleteMapping("/delete/{id}")
    private String delete(@PathVariable int id) {
        service.deleteById(id);
        return "dishes";
    }
}
