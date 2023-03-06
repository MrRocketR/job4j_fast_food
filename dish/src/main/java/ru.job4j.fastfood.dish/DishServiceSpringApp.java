package ru.job4j.fastfood.dish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DishServiceSpringApp {
    public static void main(String[] args)  {
        SpringApplication.run(DishServiceSpringApp.class, args);
    }
}
