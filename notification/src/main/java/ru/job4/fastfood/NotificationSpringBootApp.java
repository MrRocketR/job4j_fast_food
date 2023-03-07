package ru.job4.fastfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class NotificationSpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(NotificationSpringBootApp.class, args);
    }

}
