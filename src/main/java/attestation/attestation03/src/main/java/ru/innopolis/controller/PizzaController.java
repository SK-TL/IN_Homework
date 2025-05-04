package ru.innopolis.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.PizzaDto;
import ru.innopolis.entity.PizzaEntity;
import ru.innopolis.service.PizzaService;
import ru.innopolis.service.impl.PizzaServiceImpl;
import ru.innopolis.utils.PizzaMappingUtils;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/Pizzas")
@RequiredArgsConstructor
public class PizzaController {

    @Autowired
    private final PizzaServiceImpl pizzaServiceImpl;
    @Autowired
    private final PizzaService pizzaService;
    @Autowired
    private final PizzaMappingUtils pizzaMappingUtils;

    @PostMapping("/create")
    @Operation(summary = "Создание пиццы")
    public ResponseEntity<PizzaDto> createPizza(@RequestBody PizzaDto pizzaDto) {
        PizzaEntity pizzaEntity = pizzaMappingUtils.mapToPizzaEntity(pizzaDto);
        PizzaDto createdPizzaDto = pizzaService.createPizza(pizzaEntity);
        return new ResponseEntity<>(createdPizzaDto, HttpStatus.CREATED);
    }

    @GetMapping("/findPizza/{id}")
    @Operation(summary = "Поиск пиццы")
    public ResponseEntity<PizzaDto> getById (@PathVariable Long id) {
        return pizzaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/allPizzas")
    @Operation(summary = "Все пиццы")
    public ResponseEntity<List<PizzaDto>> getAllPizza() {
        List<PizzaDto> pizzaServices = pizzaServiceImpl.findAll();
        return ResponseEntity.ok(pizzaServices);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Обновление покупателя")
    public ResponseEntity<PizzaDto> updatedPizza(@PathVariable Long id, @RequestBody PizzaDto updatedPizza) {
        PizzaEntity pizzaEntity = pizzaMappingUtils.mapToPizzaEntity(updatedPizza);
        PizzaDto updatePizza = pizzaService.updatePizza(id, pizzaEntity);
        return ResponseEntity.ok(updatePizza);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Удаление покупателя")
    public ResponseEntity<Void> deletePizza (@PathVariable Long id) {
        pizzaServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
