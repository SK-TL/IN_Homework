package ru.innopolis.service;

import ru.innopolis.dto.CustomerDto;
import ru.innopolis.entity.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    CustomerDto createCustomer (CustomerEntity pizzaEntity);

    Optional<CustomerDto> findById(Long id);

    List<CustomerDto> findAll();

    CustomerDto updateCustomer(Long id, CustomerEntity updatedCustomer);

    void deleteById (Long id);
}
