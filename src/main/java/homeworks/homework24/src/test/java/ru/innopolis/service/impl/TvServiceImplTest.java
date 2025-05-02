package ru.innopolis.service.impl;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.innopolis.entity.TV;
import ru.innopolis.repository.TvRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = TvServiceImpl.class)
@ExtendWith(SpringExtension.class)
public class TvServiceImplTest {

    @MockitoBean
    private TvRepository tvRepository;

    @Autowired
    private TvServiceImpl tvServiceImpl;

    private TV testTv;

    @BeforeEach
    void setUp() {
        testTv = new TV();
        testTv.setId(1L);
        testTv.setModel("modelTest");
        testTv.setPrice(9999);
    }

    @Test
    void createTV() {

        Mockito.when(tvRepository.save(Mockito.any(TV.class))).thenReturn(testTv);

        TV createdTv = tvServiceImpl.createTV(testTv);
        
        assertNotNull(createdTv);
        assertEquals(testTv.getModel(), createdTv.getModel());
        assertEquals(testTv.getPrice(), createdTv.getPrice());
        verify(tvRepository, times(1)).save(Mockito.any(TV.class));
    }

    @Test
    void findById() {
        Mockito.when(tvRepository.findById(1L)).thenReturn(Optional.of(testTv));

        Optional<TV> foundTv = tvServiceImpl.findById(1L);

        assertTrue(foundTv.isPresent());
        assertEquals(testTv.getModel(), foundTv.get().getModel());
        verify(tvRepository, times(1)).findById(1L);
    }

    @Test
    void findAll() {
        Mockito.when(tvRepository.findAll()).thenReturn(List.of(testTv));

        List<TV> tvs = tvServiceImpl.findAll();

        assertNotNull(tvs);
        assertEquals(1, tvs.size());
        assertEquals(testTv.getModel(), tvs.get(0).getModel());
        verify(tvRepository, times(1)).findAll();
    }

    @Test
    void updateTv() {
        TV updateTv = new TV();
        updateTv.setModel("updatedModel");
        updateTv.setPrice(8888);
        Mockito.when(tvRepository.findById(1L)).thenReturn(Optional.of(testTv));
        Mockito.when(tvRepository.save(Mockito.any(TV.class))).thenReturn(updateTv);

        TV result = tvServiceImpl.updateTv(1L, updateTv);

        assertNotNull(result);
        assertEquals("updatedModel", result.getModel());
        assertEquals(8888, result.getPrice());
        verify(tvRepository, times(1)).findById(1L);
        verify(tvRepository, times(1)).save(Mockito.any(TV.class));
    }

    @Test
    void deleteById() {
        Mockito.when(tvRepository.findById(1L)).thenReturn(Optional.of(testTv));
        Mockito.doNothing().when(tvRepository).deleteById(1L);

        tvServiceImpl.deleteTv(1L);

        verify(tvRepository, times(1)).deleteById(1L);
    }
}
