package ru.job4.fastfood.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.fastfood.model.Dish;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DishController {

    @GetMapping("/dishes")
    private String showDishes(Model model) {
        List<Dish> dishes = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/dish/";
        ResponseEntity<Dish[]> response =
                restTemplate.getForEntity(
                        url,
                        Dish[].class);
        Dish[] dishesArr = response.getBody();
        for (int i = 0; i < dishesArr.length; i++) {
            dishes.add(dishesArr[i]);
        }
        model.addAttribute("dishes", dishes);
        return "dishes";

    }

    @GetMapping("delete/{id]")
    private String deleteDish(@PathVariable int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/dish/" + id;
        return "redirect:dishes";
    }

    @GetMapping("/add")
    private String createDish() {
        return "add";
    }

    @PostMapping("/createDish")
    private String createDish(@ModelAttribute Dish dish) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Dish> request = new HttpEntity<>(dish);
        String url = "http://localhost:8080/dish/";
        restTemplate.postForObject(url, request, Dish.class);
        return "redirect:/dishes";
    }

}
