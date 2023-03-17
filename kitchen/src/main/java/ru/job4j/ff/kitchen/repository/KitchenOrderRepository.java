package ru.job4j.ff.kitchen.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.fastfood.model.Order;
@Repository
public interface KitchenOrderRepository extends CrudRepository<Order, Integer> {
}
