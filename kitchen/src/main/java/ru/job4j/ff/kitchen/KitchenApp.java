package ru.job4j.ff.kitchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class KitchenApp {

    public static void main(String[] args) {
        SpringApplication.run(KitchenApp.class);
    }
}
