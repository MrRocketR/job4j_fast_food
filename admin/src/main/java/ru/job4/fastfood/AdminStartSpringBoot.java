package ru.job4.fastfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AdminStartSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(AdminStartSpringBoot.class, args);
        System.out.println("Go to http://localhost:8080/dishes");
    }

}
