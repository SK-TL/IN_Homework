package ru.innopolis.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.dto.CustomerDto;
import ru.innopolis.entity.CustomerEntity;
import ru.innopolis.service.CustomerService;
import ru.innopolis.service.impl.CustomerServiceImpl;
import ru.innopolis.utils.CustomerMappingUtils;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/Customers")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerServiceImpl customerServiceImpl;

    @Autowired
    private final CustomerService customerService;

    @Autowired
    private final CustomerMappingUtils customerMappingUtils;

    @PostMapping("/create")
    @Operation(summary = "Создание покупателя")
    public ResponseEntity<CustomerDto> createCustomer (@RequestBody CustomerDto customerDto) {
        CustomerEntity customerEntity = customerMappingUtils.mapToCustomerEntity(customerDto);
        CustomerDto createdCustomer = customerService.createCustomer(customerEntity);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/findCustomer/{id}")
    @Operation(summary = "Поиск покупателя")
    public ResponseEntity<CustomerDto> getById (@PathVariable Long id) {
        return customerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/allCustomers")
    @Operation(summary = "Все покупатели")
    public ResponseEntity<List<CustomerDto>> getAllCustomer() {
        List<CustomerDto> customerServices = customerServiceImpl.findAll();
        return ResponseEntity.ok(customerServices);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Обновление покупателя")
    public ResponseEntity<CustomerDto> updatedCustomer (@PathVariable Long id, @RequestBody CustomerDto updatedCustomer) {
        CustomerEntity customerEntity = customerMappingUtils.mapToCustomerEntity(updatedCustomer);
        CustomerDto updateCustomer = customerService.updateCustomer(id, customerEntity);
        return ResponseEntity.ok(updateCustomer);
    }

    @DeleteMapping("delete/{id}")
    @Operation(summary = "Удаление покупателя")
    public ResponseEntity<Void> deleteCustomer (@PathVariable Long id) {
        customerServiceImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
