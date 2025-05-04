package ru.innopolis.service;

import ru.innopolis.dto.PizzaDto;
import ru.innopolis.entity.PizzaEntity;

import java.util.List;
import java.util.Optional;

public interface PizzaService {

    PizzaDto createPizza (PizzaEntity pizzaEntity);

    Optional<PizzaDto> findById(Long id);

    List<PizzaDto> findAll();

    PizzaDto updatePizza(Long id, PizzaEntity updatedPizza);

    void deleteById (Long id);
}
