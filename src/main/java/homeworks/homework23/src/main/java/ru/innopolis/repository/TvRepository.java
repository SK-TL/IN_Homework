package ru.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.entity.TV;

public interface TvRepository extends JpaRepository <TV, Long> {
}
