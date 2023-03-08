package ru.fastfood.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OrderServiceSpringApplication {

    public static void main(String[] args)  {
        SpringApplication.run(OrderServiceSpringApplication.class, args);
    }
}
