package ru.innopolis.service;

import ru.innopolis.entity.TV;

import java.util.List;
import java.util.Optional;

public interface TvService {

    TV createTV (TV tv);

    Optional<TV> findById(Long id);

    List<TV> findAll();

    TV updateTv(Long id, TV data);

    void deleteTv(Long id);
}
