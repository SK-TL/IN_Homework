package ru.innopolis.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.OrderDto;
import ru.innopolis.dto.UpdateOrderRequest;
import ru.innopolis.entity.CustomerEntity;
import ru.innopolis.entity.OrderEntity;
import ru.innopolis.entity.PizzaEntity;
import ru.innopolis.repository.CustomerRepository;
import ru.innopolis.repository.OrderRepository;
import ru.innopolis.repository.PizzaRepository;
import ru.innopolis.service.OrderService;
import ru.innopolis.utils.OrderMappingUtils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private OrderMappingUtils orderMappingUtils;

    @Override
    public OrderDto createOrder(Long customerId, List<Long> pizzaIds, Integer quantity) {
        CustomerEntity customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));

        List<PizzaEntity> pizzas = pizzaRepository.findAllById(pizzaIds);

        if (pizzas.size() != pizzaIds.size()) {
            throw new EntityNotFoundException("One or more pizzas not found");
        }
        OrderEntity order = new OrderEntity();
        order.setCustomer(customer);
        order.setPizzas(pizzas);
        order.setQuantity(quantity);
        OrderEntity savedOrder = orderRepository.save(order);
        return orderMappingUtils.mapToOrderDto(savedOrder);
    }

    @Override
    public Optional<OrderDto> findById(Long id) {
        return orderRepository.findById(id)
                .map(orderMappingUtils::mapToOrderDto);
    }

    @Override
    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream()
                .map(orderMappingUtils::mapToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto updateOrder(Long id, UpdateOrderRequest request) {
        OrderEntity existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Order not found with id: " + id));

        if (request.getCustomerId() != null) {
            CustomerEntity customer = customerRepository.findById(request.getCustomerId())
                    .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + request.getCustomerId()));
            existingOrder.setCustomer(customer);
        }

        if (request.getPizzaIds() != null) {
            List<PizzaEntity> pizzas = pizzaRepository.findAllById(request.getPizzaIds());
            if (pizzas.size() != request.getPizzaIds().size()) {
                throw new EntityNotFoundException("One or more pizzas not found");
            }
            existingOrder.setPizzas(pizzas);
        }

        if (request.getQuantity() != null) {
            existingOrder.setQuantity(request.getQuantity());
        }

        OrderEntity savedOrder = orderRepository.save(existingOrder);
        return orderMappingUtils.mapToOrderDto(savedOrder);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid pizza ID: " + id);
        }
        orderRepository.findById(id)
                .ifPresent(order -> {
                    order.setDeleted(true);
                    orderRepository.save(order);
                });
    }
}
