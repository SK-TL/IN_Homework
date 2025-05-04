package ru.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.PizzaEntity;

@Repository
public interface PizzaRepository extends JpaRepository<PizzaEntity, Long> {
}
