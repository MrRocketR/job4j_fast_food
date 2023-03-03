package ru.fastfood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private Customer customer;
    private Kitchen kitchen;
    private Dish dish;
    private String paymentType;

}
