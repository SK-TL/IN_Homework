package ru.innopolis.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {
    private Long customerId;
    private List<Long> pizzaIds;
    private Integer quantity;
}
