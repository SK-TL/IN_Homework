package ru.innopolis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.PizzaDto;
import ru.innopolis.entity.PizzaEntity;
import ru.innopolis.repository.PizzaRepository;
import ru.innopolis.service.PizzaService;
import ru.innopolis.utils.PizzaMappingUtils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private PizzaMappingUtils pizzaMappingUtils;

    @Override
    public PizzaDto createPizza(PizzaEntity pizzaEntity) {
        PizzaEntity savedPizzaEntity = pizzaRepository.save(pizzaEntity);
        return pizzaMappingUtils.mapToPizzaDto(savedPizzaEntity);
    }

    @Override
    public Optional<PizzaDto> findById(Long id) {
        return pizzaRepository.findById(id)
                .map(pizzaMappingUtils::mapToPizzaDto);
    }

    @Override
    public List<PizzaDto> findAll() {
        return pizzaRepository.findAll().stream()
                .map(pizzaMappingUtils::mapToPizzaDto)
                .collect(Collectors.toList());
    }

    @Override
    public PizzaDto updatePizza(Long id, PizzaEntity updatedPizza) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid pizza ID: " + id);
        }
        if (updatedPizza == null) {
            throw new IllegalArgumentException("Pizza data cannot be null");
        }

        return pizzaRepository.findById(id)
                .map(existingPizza -> {
                    existingPizza.setNamePizza(updatedPizza.getNamePizza());
                    existingPizza.setPricePizza(updatedPizza.getPricePizza());
                    PizzaEntity savedPizza = pizzaRepository.save(existingPizza);
                    return pizzaMappingUtils.mapToPizzaDto(savedPizza);
                })
                .orElseThrow(() -> new NoSuchElementException("Pizza not found by ID" + id));
    }

    @Override
    public void deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid pizza ID: " + id);
        }
        pizzaRepository.findById(id)
                .ifPresent(pizza -> {
                    pizza.setDeleted(true);
                    pizzaRepository.save(pizza);
                });
    }
}
