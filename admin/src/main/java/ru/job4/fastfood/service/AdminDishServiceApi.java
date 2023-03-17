package ru.job4.fastfood.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.fastfood.model.Dish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AdminDishServiceApi {

    private final RestTemplate template = new RestTemplate();

    public List<Dish> findAll() {
        String url = "http://localhost:8080/dishes/all";
        List<Dish> body = template.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Dish>>() {
                }).getBody();
        return body == null ? Collections.emptyList() : body;
    }

    public Dish findById(int id) {
        String url = "http://localhost:8080/dishes/" + id;
        ResponseEntity<Dish> response
                = template.getForEntity(url, Dish.class);
        return response.getBody();
    }

    public Dish addDish(Dish dish) {
        String url = "http://localhost:8080/";
        HttpEntity<Dish> request = new HttpEntity<>(dish);
        Dish created = template.postForObject(url, request, Dish.class);
        return created;
    }

    public boolean updateDish(Dish dish) {
        String url = "http://localhost:8080/dishes/id";
        return template.exchange(
                url,
                HttpMethod.PUT,
                new HttpEntity<>(dish),
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    public boolean deleteById(int id) {
        String url = "http://localhost:8080/dishes/" + id;
        return template.exchange(
                url,
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }
}



