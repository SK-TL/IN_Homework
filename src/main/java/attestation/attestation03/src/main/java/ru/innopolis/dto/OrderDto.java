package ru.innopolis.dto;

import lombok.Data;
import ru.innopolis.entity.PizzaEntity;

import java.util.List;

@Data
public class OrderDto {
    Long id;
    List<PizzaEntity> pizzas;
    CustomerDto customer;
    Integer quantity;
    int totalPrice;
}
