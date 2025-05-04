package ru.innopolis.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.CustomerDto;
import ru.innopolis.entity.CustomerEntity;
import ru.innopolis.repository.CustomerRepository;
import ru.innopolis.service.CustomerService;
import ru.innopolis.utils.CustomerMappingUtils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMappingUtils customerMappingUtils;

    @Override
    public CustomerDto createCustomer(CustomerEntity customerEntity) {
        CustomerEntity savedCustomerEntity = customerRepository.save(customerEntity);
        return customerMappingUtils.mapToCustomerDto(savedCustomerEntity);
    }

    @Override
    public Optional<CustomerDto> findById(Long id) {
        return customerRepository.findById(id)
                .map(customerMappingUtils::mapToCustomerDto);
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerRepository.findAll().stream()
                .map(customerMappingUtils::mapToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerEntity updatedCustomer) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid customer ID: " + id);
        }
        if (updatedCustomer == null) {
            throw new IllegalArgumentException("Customer data cannot be null");
        }

        return customerRepository.findById(id)
                .map(existingCustomer -> {
                    existingCustomer.setCustomerName(updatedCustomer.getCustomerName());
                    existingCustomer.setCustomerCash(updatedCustomer.getCustomerCash());
                    CustomerEntity savedCustomer = customerRepository.save(existingCustomer);
                    return customerMappingUtils.mapToCustomerDto(savedCustomer);
                })
                .orElseThrow(() -> new NoSuchElementException("Customer not found by ID" + id));
    }

    @Override
    public void deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid customer ID: " + id);
        }
        customerRepository.findById(id)
                .ifPresent(customer -> {
                    customer.setDeleted(true);
                    customerRepository.save(customer);
                });
    }
}
