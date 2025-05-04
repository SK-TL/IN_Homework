package ru.innopolis.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.innopolis.dto.PizzaDto;
import ru.innopolis.entity.PizzaEntity;
import ru.innopolis.repository.PizzaRepository;
import ru.innopolis.utils.PizzaMappingUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = PizzaServiceImpl.class)
public class PizzaServiceImplTest {

    @MockitoBean
    private PizzaRepository pizzaRepository;

    @MockitoBean
    private PizzaMappingUtils pizzaMappingUtils;

    @Autowired
    private PizzaServiceImpl pizzaServiceImpl;

    @Test
    void createPizza() {
        // Создаем экземпляр pizzaEntity без id
        PizzaEntity pizzaEntity = new PizzaEntity();
        pizzaEntity.setNamePizza("TESTPIZZANAME");
        pizzaEntity.setPricePizza(9999);
        pizzaEntity.setDeleted(false);

        // Создаем экземпляр pizzaEntity с id
        PizzaEntity savedPizzaEntity = new PizzaEntity();
        savedPizzaEntity.setId(1L);
        savedPizzaEntity.setNamePizza("TESTPIZZANAME");
        savedPizzaEntity.setPricePizza(9999);
        savedPizzaEntity.setDeleted(false);

        // Создаем экземпляр pizzaDto
        PizzaDto expectedPizzaDto = new PizzaDto();
        expectedPizzaDto.setId(1L);
        expectedPizzaDto.setNamePizza("TESTPIZZANAME");
        expectedPizzaDto.setPricePizza(9999);

        // Проверка корректности работоспособности БД
        Mockito.when(pizzaRepository.save(pizzaEntity)).thenReturn(savedPizzaEntity);

        // Проверка метода конвертации из entity в dto
        Mockito.when(pizzaMappingUtils.mapToPizzaDto(savedPizzaEntity)).thenReturn(expectedPizzaDto);

        PizzaDto actualPizzaDto = pizzaServiceImpl.createPizza(pizzaEntity);

        assertThat(actualPizzaDto, is(equalTo(expectedPizzaDto)));
        verify(pizzaRepository, times(1)).save(pizzaEntity);
        verify(pizzaMappingUtils, times(1)).mapToPizzaDto(savedPizzaEntity);
    }

    @Test
    void findById() {
        PizzaEntity pizzaEntity = new PizzaEntity();
        pizzaEntity.setId(1L);
        pizzaEntity.setNamePizza("TESTPIZZANAME");
        pizzaEntity.setPricePizza(9999);
        pizzaEntity.setDeleted(false);

        PizzaDto expectedPizzaDto = new PizzaDto();
        expectedPizzaDto.setId(1L);
        expectedPizzaDto.setNamePizza("TESTPIZZANAME");
        expectedPizzaDto.setPricePizza(9999);

        Mockito.when(pizzaRepository.findById(1L)).thenReturn(Optional.of(pizzaEntity));
        Mockito.when(pizzaMappingUtils.mapToPizzaDto(pizzaEntity)).thenReturn(expectedPizzaDto);

        Optional<PizzaDto> actualPizzaDto = pizzaServiceImpl.findById(1L);

        assertTrue(actualPizzaDto.isPresent());
        assertThat(actualPizzaDto.get(), is(equalTo(expectedPizzaDto)));
        verify(pizzaRepository, times(1)).findById(1L);
        verify(pizzaMappingUtils, times(1)).mapToPizzaDto(pizzaEntity);
    }

    @Test
    void findAll () {
        PizzaEntity pizzaEntity1 = new PizzaEntity();
        pizzaEntity1.setId(1L);
        pizzaEntity1.setNamePizza("TESTPIZZANAME_1");
        pizzaEntity1.setPricePizza(9999);

        PizzaDto pizzaDto1 = new PizzaDto();
        pizzaDto1.setId(1L);
        pizzaDto1.setNamePizza("TESTPIZZANAME_1");
        pizzaDto1.setPricePizza(9999);

        PizzaEntity pizzaEntity2 = new PizzaEntity();
        pizzaEntity2.setId(2L);
        pizzaEntity2.setNamePizza("TESTPIZZANAME_2");
        pizzaEntity2.setPricePizza(8888);

        PizzaDto pizzaDto2 = new PizzaDto();
        pizzaDto2.setId(2L);
        pizzaDto2.setNamePizza("TESTPIZZANAME_2");
        pizzaDto2.setPricePizza(8888);

        List<PizzaEntity> pizzaEntities = Arrays.asList(pizzaEntity1, pizzaEntity2);
        List<PizzaDto> expectedPizzaDtos = Arrays.asList(pizzaDto1, pizzaDto2);

        Mockito.when(pizzaRepository.findAll()).thenReturn(pizzaEntities);
        Mockito.when(pizzaMappingUtils.mapToPizzaDto(pizzaEntity1)).thenReturn(pizzaDto1);
        Mockito.when(pizzaMappingUtils.mapToPizzaDto(pizzaEntity2)).thenReturn(pizzaDto2);

        List<PizzaDto> actualPizzaDtos = pizzaServiceImpl.findAll();

        assertThat(actualPizzaDtos, is(equalTo(expectedPizzaDtos)));
        verify(pizzaRepository, times(1)).findAll();
        verify(pizzaMappingUtils, times(1)).mapToPizzaDto(pizzaEntity1);
        verify(pizzaMappingUtils, times(1)).mapToPizzaDto(pizzaEntity2);
    }


    @Test
    void updatePizza() {
        PizzaEntity existingPizzaEntity = new PizzaEntity();
        existingPizzaEntity.setId(1L);
        existingPizzaEntity.setNamePizza("OLD_TESTPIZZANAME");
        existingPizzaEntity.setPricePizza(9999);
        existingPizzaEntity.setDeleted(false);

        PizzaEntity updatedPizza = new PizzaEntity();
        updatedPizza.setNamePizza("NEW_TESTPIZZANAME");
        updatedPizza.setPricePizza(1111);

        PizzaEntity savedPizzaEntity = new PizzaEntity();
        savedPizzaEntity.setId(1L);
        savedPizzaEntity.setNamePizza("NEW_TESTPIZZANAME");
        savedPizzaEntity.setPricePizza(1111);
        savedPizzaEntity.setDeleted(false);

        PizzaDto expectedPizzaDto = new PizzaDto();
        expectedPizzaDto.setId(1L);
        expectedPizzaDto.setNamePizza("NEW_TESTPIZZANAME");
        expectedPizzaDto.setPricePizza(1111);

        Mockito.when(pizzaRepository.findById(1L)).thenReturn(Optional.of(existingPizzaEntity));
        Mockito.when(pizzaRepository.save(existingPizzaEntity)).thenReturn(savedPizzaEntity);
        Mockito.when(pizzaMappingUtils.mapToPizzaDto(savedPizzaEntity)).thenReturn(expectedPizzaDto);

        PizzaDto actualPizzaDto = pizzaServiceImpl.updatePizza(1L, updatedPizza);

        assertThat(actualPizzaDto, is(equalTo(expectedPizzaDto)));
        assertThat(existingPizzaEntity.getNamePizza(), is(equalTo("NEW_TESTPIZZANAME")));
        assertThat(existingPizzaEntity.getPricePizza(), is(equalTo(1111)));
        verify(pizzaRepository, times(1)).findById(1L);
        verify(pizzaRepository, times(1)).save(existingPizzaEntity);
        verify(pizzaMappingUtils, times(1)).mapToPizzaDto(savedPizzaEntity);
    }

    @Test
    void deleteById () {
        PizzaEntity pizzaEntity = new PizzaEntity();
        pizzaEntity.setId(1L);
        pizzaEntity.setNamePizza("TESTPIZZANAME");
        pizzaEntity.setPricePizza(9999);
        pizzaEntity.setDeleted(false);

        Mockito.when(pizzaRepository.findById(1L)).thenReturn(Optional.of(pizzaEntity));
        Mockito.when(pizzaRepository.save(pizzaEntity)).thenReturn(pizzaEntity);

        pizzaServiceImpl.deleteById(1L);

        verify(pizzaRepository, times(1)).findById(1L);
        verify(pizzaRepository, times(1)).save(pizzaEntity);
        assert(pizzaEntity.isDeleted());
    }
}
