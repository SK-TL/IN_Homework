package ru.innopolis.service;

import ru.innopolis.dto.OrderDto;
import ru.innopolis.dto.UpdateOrderRequest;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    OrderDto createOrder (Long customerId, List<Long> pizzaIds, Integer quantity);

    Optional<OrderDto> findById(Long id);

    List<OrderDto> findAll();

    OrderDto updateOrder (Long id, UpdateOrderRequest request);

    void deleteById (Long id);
}
