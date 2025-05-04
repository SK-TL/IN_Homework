package ru.innopolis.dto;

import lombok.Data;

import java.util.List;

@Data
public class UpdateOrderRequest {
    private Long customerId;
    private List<Long> pizzaIds;
    private Integer quantity;
}
