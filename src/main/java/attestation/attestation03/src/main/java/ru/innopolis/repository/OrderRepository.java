package ru.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
