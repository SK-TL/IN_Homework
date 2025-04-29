package ru.innopolis.service;

import ru.innopolis.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser (User user);

    Optional<User> findById(Long id);

    List<User> findAll();

    User updateUser(Long id, User userDetails);

    void deleteUser(Long id);

}
