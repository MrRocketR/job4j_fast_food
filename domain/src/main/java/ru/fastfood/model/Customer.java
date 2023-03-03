package ru.fastfood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int id;
    private String username;
    private String password;
}
