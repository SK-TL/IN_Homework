package ru.innopolis.utils;

import org.springframework.stereotype.Service;
import ru.innopolis.dto.CustomerDto;
import ru.innopolis.entity.CustomerEntity;

@Service
public class CustomerMappingUtils {

    public CustomerDto mapToCustomerDto (CustomerEntity customerEntity) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customerEntity.getId());
        customerDto.setCustomerName(customerEntity.getCustomerName());
        customerDto.setCustomerCash(customerEntity.getCustomerCash());
        return customerDto;
    }

    public CustomerEntity mapToCustomerEntity (CustomerDto customerDto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerDto.getId());
        customerEntity.setCustomerName(customerDto.getCustomerName());
        customerEntity.setCustomerCash(customerDto.getCustomerCash());
        return customerEntity;
    }
}
