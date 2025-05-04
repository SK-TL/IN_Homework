package ru.innopolis.utils;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.PizzaDto;
import ru.innopolis.entity.PizzaEntity;

@Service
@Component
public class PizzaMappingUtils {

    public PizzaDto mapToPizzaDto (PizzaEntity pizzaEntity) {
        PizzaDto pizzaDto = new PizzaDto();
        pizzaDto.setId(pizzaEntity.getId());
        pizzaDto.setNamePizza(pizzaEntity.getNamePizza());
        pizzaDto.setPricePizza(pizzaEntity.getPricePizza());
        return pizzaDto;
    }

    public PizzaEntity mapToPizzaEntity (PizzaDto pizzaDto) {
        PizzaEntity pizzaEntity = new PizzaEntity();
        pizzaEntity.setId(pizzaDto.getId());
        pizzaEntity.setNamePizza(pizzaDto.getNamePizza());
        pizzaEntity.setPricePizza(pizzaDto.getPricePizza());
        return pizzaEntity;
    }
}
