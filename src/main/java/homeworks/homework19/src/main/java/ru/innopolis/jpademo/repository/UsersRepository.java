package ru.innopolis.jpademo.repository;

import ru.innopolis.jpademo.model.Order;
import ru.innopolis.jpademo.model.User;

import java.time.LocalDate;
import java.util.List;

public interface UsersRepository {

    void findAll ();
    User findById (Long id);
    List<Order> findByDate(LocalDate date);
    void deleteAll ();
}
