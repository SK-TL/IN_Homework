package ru.innopolis.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.CreateOrderRequest;
import ru.innopolis.dto.OrderDto;
import ru.innopolis.dto.UpdateOrderRequest;
import ru.innopolis.service.OrderService;
import ru.innopolis.service.impl.OrderServiceImpl;
import ru.innopolis.utils.OrderMappingUtils;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/Orders")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @Autowired
    private final OrderServiceImpl orderServiceImpl;

    @Autowired
    private final OrderMappingUtils orderMappingUtils;

    @PostMapping("/create")
    @Operation(summary = "Создание заказа")
    public ResponseEntity<OrderDto> createOrder (@RequestBody CreateOrderRequest request) {
        OrderDto createdOrder = orderService.createOrder(
                request.getCustomerId(),
                request.getPizzaIds(),  // Pass the List of pizzaIds
                request.getQuantity());
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/findOrder/{id}")
    @Operation(summary = "Поиск заказа")
    public ResponseEntity<OrderDto> getById (@PathVariable Long id) {
        return orderService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/allOrders")
    @Operation(summary = "Все заказы")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderServices = orderServiceImpl.findAll();
        return ResponseEntity.ok(orderServices);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Обновление заказа")
    public ResponseEntity<OrderDto> updatedOrder(@PathVariable Long id, @RequestBody UpdateOrderRequest request){
        OrderDto updateOrder = orderService.updateOrder(id, request);
        return ResponseEntity.ok(updateOrder);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Удаление заказа")
    public ResponseEntity<Void> deleteOrder (@PathVariable Long id) {
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
