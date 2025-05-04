package ru.innopolis.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.innopolis.dto.CustomerDto;
import ru.innopolis.entity.CustomerEntity;
import ru.innopolis.repository.CustomerRepository;
import ru.innopolis.utils.CustomerMappingUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = CustomerServiceImpl.class)
@ExtendWith(SpringExtension.class)
public class CustomerServiceImplTest {

    @MockitoBean
    private CustomerRepository customerRepository;

    @MockitoBean
    private CustomerMappingUtils customerMappingUtils;

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @Test
    void createCustomer () {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerName("TESTCUSTOMERNAME");
        customerEntity.setCustomerCash(9999);
        customerEntity.setDeleted(false);

        CustomerEntity savedCustomerEntity = new CustomerEntity();
        savedCustomerEntity.setId(1L);
        savedCustomerEntity.setCustomerName("TESTCUSTOMERNAME");
        savedCustomerEntity.setCustomerCash(9999);
        savedCustomerEntity.setDeleted(false);

        CustomerDto expectedCustomerDto = new CustomerDto();
        expectedCustomerDto.setId(1L);
        expectedCustomerDto.setCustomerName("TESTCUSTOMERNAME");
        expectedCustomerDto.setCustomerCash(9999);

        Mockito.when(customerRepository.save(customerEntity)).thenReturn(savedCustomerEntity);
        Mockito.when(customerMappingUtils.mapToCustomerDto(savedCustomerEntity)).thenReturn(expectedCustomerDto);

        CustomerDto actualCustomerDto = customerServiceImpl.createCustomer(customerEntity);

        assertThat(actualCustomerDto, is(equalTo(expectedCustomerDto)));
        verify(customerRepository, times(1)).save(customerEntity);
        verify(customerMappingUtils, times(1)).mapToCustomerDto(savedCustomerEntity);
    }

    @Test
    void findById() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerName("TESTCUSTOMERNAME");
        customerEntity.setCustomerCash(9999);
        customerEntity.setDeleted(false);

        CustomerDto expectedCustomerDto = new CustomerDto();
        expectedCustomerDto.setId(1L);
        expectedCustomerDto.setCustomerName("TESTCUSTOMERNAME");
        expectedCustomerDto.setCustomerCash(9999);

        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customerEntity));
        Mockito.when(customerMappingUtils.mapToCustomerDto(customerEntity)).thenReturn(expectedCustomerDto);

        Optional<CustomerDto> actualCustomerDto = customerServiceImpl.findById(1L);

        assertTrue(actualCustomerDto.isPresent());
        assertThat(actualCustomerDto.get(), is(equalTo(expectedCustomerDto)));
        verify(customerRepository, times(1)).findById(1L);
        verify(customerMappingUtils, times(1)).mapToCustomerDto(customerEntity);
    }

    @Test
    void findAll () {
        CustomerEntity customerEntity1 = new CustomerEntity();
        customerEntity1.setCustomerName("TESTCUSTOMERNAME");
        customerEntity1.setCustomerCash(9999);
        customerEntity1.setDeleted(false);

        CustomerDto customerDto1 = new CustomerDto();
        customerDto1.setId(1L);
        customerDto1.setCustomerName("TESTCUSTOMERNAME_1");
        customerDto1.setCustomerCash(9999);

        CustomerEntity customerEntity2 = new CustomerEntity();
        customerEntity2.setId(2L);
        customerEntity2.setCustomerName("TESTCUSTOMERNAME_2");
        customerEntity2.setCustomerCash(8888);

        CustomerDto customerDto2 = new CustomerDto();
        customerDto2.setId(1L);
        customerDto2.setCustomerName("TESTCUSTOMERNAME_2");
        customerDto2.setCustomerCash(8888);

        List<CustomerEntity> customerEntities = Arrays.asList(customerEntity1, customerEntity2);
        List<CustomerDto> expectedCustomerDtos = Arrays.asList(customerDto1, customerDto2);

        Mockito.when(customerRepository.findAll()).thenReturn(customerEntities);
        Mockito.when(customerMappingUtils.mapToCustomerDto(customerEntity1)).thenReturn(customerDto1);
        Mockito.when(customerMappingUtils.mapToCustomerDto(customerEntity2)).thenReturn(customerDto2);

        List<CustomerDto> actualCustomerDtos = customerServiceImpl.findAll();

        assertThat(actualCustomerDtos, is(equalTo(expectedCustomerDtos)));
        verify(customerRepository, times(1)).findAll();
        verify(customerMappingUtils, times(1)).mapToCustomerDto(customerEntity1);
        verify(customerMappingUtils, times(1)).mapToCustomerDto(customerEntity1);
    }

    @Test
    void updateCustomer() {
        CustomerEntity existingCustomerEntity = new CustomerEntity();
        existingCustomerEntity.setId(1L);
        existingCustomerEntity.setCustomerName("OLD_TESTCUSTOMERNAME");
        existingCustomerEntity.setCustomerCash(9999);
        existingCustomerEntity.setDeleted(false);

        CustomerEntity updatedCustomer = new CustomerEntity();
        updatedCustomer.setCustomerName("NEW_TESTCUSTOMERNAME");
        updatedCustomer.setCustomerCash(1111);

        CustomerEntity savedCustomerEntity = new CustomerEntity();
        savedCustomerEntity.setId(1L);
        savedCustomerEntity.setCustomerName("NEW_TESTCUSTOMERNAME");
        savedCustomerEntity.setCustomerCash(1111);
        savedCustomerEntity.setDeleted(false);

        CustomerDto expectedCustomerDto = new CustomerDto();
        expectedCustomerDto.setId(1L);
        expectedCustomerDto.setCustomerName("NEW_TESTCUSTOMERNAME");
        expectedCustomerDto.setCustomerCash(1111);

        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(existingCustomerEntity));
        Mockito.when(customerRepository.save(existingCustomerEntity)).thenReturn(savedCustomerEntity);
        Mockito.when(customerMappingUtils.mapToCustomerDto(savedCustomerEntity)).thenReturn(expectedCustomerDto);

        CustomerDto actualCustomerDto = customerServiceImpl.updateCustomer(1L, updatedCustomer);

        assertThat(actualCustomerDto, is(equalTo(expectedCustomerDto)));
        assertThat(existingCustomerEntity.getCustomerName(), is(equalTo("NEW_TESTCUSTOMERNAME")));
        assertThat(existingCustomerEntity.getCustomerCash(), is(equalTo(1111)));
        verify(customerRepository, times(1)).findById(1L);
        verify(customerRepository, times(1)).save(existingCustomerEntity);
        verify(customerMappingUtils, times(1)).mapToCustomerDto(savedCustomerEntity);
    }

    @Test
    void deleteById () {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(1L);
        customerEntity.setCustomerName("TESTCUSTOMERNAME");
        customerEntity.setCustomerCash(9999);
        customerEntity.setDeleted(false);

        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customerEntity));
        Mockito.when(customerRepository.save(customerEntity)).thenReturn(customerEntity);

        customerServiceImpl.deleteById(1L);

        verify(customerRepository, times(1)).findById(1L);
        verify(customerRepository, times(1)).save(customerEntity);
        assert(customerEntity.isDeleted());
    }
}
