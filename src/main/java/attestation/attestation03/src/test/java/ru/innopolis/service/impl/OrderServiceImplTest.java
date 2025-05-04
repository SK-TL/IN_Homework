package ru.innopolis.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.innopolis.dto.OrderDto;
import ru.innopolis.dto.UpdateOrderRequest;
import ru.innopolis.entity.CustomerEntity;
import ru.innopolis.entity.OrderEntity;
import ru.innopolis.entity.PizzaEntity;
import ru.innopolis.repository.CustomerRepository;
import ru.innopolis.repository.OrderRepository;
import ru.innopolis.repository.PizzaRepository;
import ru.innopolis.utils.OrderMappingUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = OrderServiceImpl.class)
@ExtendWith(SpringExtension.class)
public class OrderServiceImplTest {

    @MockitoBean
    private CustomerRepository customerRepository;

    @MockitoBean
    private PizzaRepository pizzaRepository;

    @MockitoBean
    private OrderRepository orderRepository;

    @MockitoBean
    private OrderMappingUtils orderMappingUtils;

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    void createOrder() {
        List<Long> pizzaIds = Arrays.asList(1L, 2L);

        CustomerEntity customer = new CustomerEntity();
        customer.setId(1L);
        customer.setCustomerName("TESTCUSTOMERNAME");
        customer.setCustomerCash(9999);

        PizzaEntity pizza1 = new PizzaEntity();
        pizza1.setId(1L);
        pizza1.setNamePizza("TESTPIZZANAME_1");
        pizza1.setPricePizza(888);
        PizzaEntity pizza2 = new PizzaEntity();
        pizza2.setId(2L);
        pizza2.setNamePizza("TESTPIZZANAME_2");
        pizza2.setPricePizza(777);
        List<PizzaEntity> pizzas = Arrays.asList(pizza1, pizza2);

        OrderEntity orderToSave = new OrderEntity();
        orderToSave.setCustomer(customer);
        orderToSave.setPizzas(pizzas);
        orderToSave.setQuantity(2);

        OrderEntity savedOrder = new OrderEntity();
        savedOrder.setId(1L);
        savedOrder.setCustomer(customer);
        savedOrder.setPizzas(pizzas);
        savedOrder.setQuantity(2);

        OrderDto expectedOrderDto = new OrderDto();
        expectedOrderDto.setId(1L);
        expectedOrderDto.setId(1L);
        expectedOrderDto.setPizzas(pizzas);
        expectedOrderDto.setQuantity(2);

        Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        Mockito.when(pizzaRepository.findAllById(pizzaIds)).thenReturn(pizzas);
        Mockito.when(orderRepository.save(any(OrderEntity.class))).thenReturn(savedOrder);
        Mockito.when(orderMappingUtils.mapToOrderDto(savedOrder)).thenReturn(expectedOrderDto);

        OrderDto actualOrderDto = orderService.createOrder(1L, pizzaIds, 2);

        assertThat(actualOrderDto, is(equalTo(expectedOrderDto)));

        verify(customerRepository, times(1)).findById(1L);
        verify(pizzaRepository, times(1)).findAllById(pizzaIds);
        verify(orderRepository, times(1)).save(any(OrderEntity.class));
        verify(orderMappingUtils, times(1)).mapToOrderDto(savedOrder);
    }

    @Test
    void findById () {
        CustomerEntity customer = new CustomerEntity();
        customer.setId(1L);
        customer.setCustomerName("TESTCUSTOMERNAME");
        customer.setCustomerCash(9999);

        PizzaEntity pizza1 = new PizzaEntity();
        pizza1.setId(1L);
        pizza1.setNamePizza("TESTPIZZANAME_1");
        pizza1.setPricePizza(888);
        PizzaEntity pizza2 = new PizzaEntity();
        pizza2.setId(2L);
        pizza2.setNamePizza("TESTPIZZANAME_2");
        pizza2.setPricePizza(777);
        List<PizzaEntity> pizzas = Arrays.asList(pizza1, pizza2);

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(1L);
        orderEntity.setCustomer(customer);
        orderEntity.setPizzas(pizzas);
        orderEntity.setQuantity(2);

        OrderDto expectedOrderDto = new OrderDto();
        expectedOrderDto.setId(1L);
        expectedOrderDto.setId(1L);
        expectedOrderDto.setPizzas(pizzas);
        expectedOrderDto.setQuantity(2);

        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(orderEntity));
        Mockito.when(orderMappingUtils.mapToOrderDto(orderEntity)).thenReturn(expectedOrderDto);

        Optional<OrderDto> actualOrderDto = orderService.findById(1L);

        assertTrue(actualOrderDto.isPresent());
        assertThat(actualOrderDto.get(), is(equalTo(expectedOrderDto)));

        verify(orderRepository, times(1)).findById(1L);
        verify(orderMappingUtils, times(1)).mapToOrderDto(orderEntity);
    }

    @Test
    void findAll () {
        CustomerEntity customer = new CustomerEntity();
        customer.setId(1L);
        customer.setCustomerName("TESTCustomerNAME");
        customer.setCustomerCash(9999);

        PizzaEntity pizza1 = new PizzaEntity();
        pizza1.setId(1L);
        pizza1.setNamePizza("TESTPIZZANAME_1");
        pizza1.setPricePizza(888);

        PizzaEntity pizza2 = new PizzaEntity();
        pizza2.setId(2L);
        pizza2.setNamePizza("TESTPIZZANAME_2");
        pizza2.setPricePizza(777);

        List<PizzaEntity> pizzas = Arrays.asList(pizza1, pizza2);

        OrderEntity orderEntity1 = new OrderEntity();
        orderEntity1.setId(1L);
        orderEntity1.setCustomer(customer);
        orderEntity1.setPizzas(pizzas);
        orderEntity1.setQuantity(2);

        OrderEntity orderEntity2 = new OrderEntity();
        orderEntity2.setId(2L);
        orderEntity2.setCustomer(customer);
        orderEntity2.setPizzas(pizzas);
        orderEntity2.setQuantity(1);

        List<OrderEntity> orderEntities = Arrays.asList(orderEntity1, orderEntity2);

        OrderDto orderDto1 = new OrderDto();
        orderDto1.setId(1L);
        orderDto1.setId(1L);
        orderDto1.setPizzas(pizzas);
        orderDto1.setQuantity(2);

        OrderDto orderDto2 = new OrderDto();
        orderDto2.setId(2L);
        orderDto2.setId(1L);
        orderDto2.setPizzas(pizzas);
        orderDto2.setQuantity(1);

        List<OrderDto> expectedOrderDtos = Arrays.asList(orderDto1, orderDto2);

        Mockito.when(orderRepository.findAll()).thenReturn(orderEntities);
        Mockito.when(orderMappingUtils.mapToOrderDto(orderEntity1)).thenReturn(orderDto1);
        Mockito.when(orderMappingUtils.mapToOrderDto(orderEntity2)).thenReturn(orderDto2);

        List<OrderDto> actualOrderDtos = orderService.findAll();

        assertThat(actualOrderDtos, is(equalTo(expectedOrderDtos)));

        verify(orderRepository, times(1)).findAll();
        verify(orderMappingUtils, times(1)).mapToOrderDto(orderEntity1);
        verify(orderMappingUtils, times(1)).mapToOrderDto(orderEntity2);
    }

    @Test
    void updateOrder () {
        List<Long> pizzaIds = Arrays.asList(3L, 4L);

        UpdateOrderRequest updateRequest = new UpdateOrderRequest();
        updateRequest.setCustomerId(2L);
        updateRequest.setPizzaIds(pizzaIds);
        updateRequest.setQuantity(3);

        CustomerEntity customer = new CustomerEntity();
        customer.setId(2L);
        customer.setCustomerName("TESTCUSTOMERUPDATE");
        customer.setCustomerCash(9999);

        PizzaEntity pizza1 = new PizzaEntity();
        pizza1.setId(3L);
        pizza1.setNamePizza("TESTPIZZANAME_3");
        pizza1.setPricePizza(666);

        PizzaEntity pizza2 = new PizzaEntity();
        pizza2.setId(4L);
        pizza2.setNamePizza("TESTPIZZANAME_4");
        pizza2.setPricePizza(888);

        List<PizzaEntity> pizzas = Arrays.asList(pizza1, pizza2);

        OrderEntity existingOrder = new OrderEntity();
        existingOrder.setId(1L);
        existingOrder.setCustomer(new CustomerEntity());
        existingOrder.setPizzas(Arrays.asList(new PizzaEntity()));
        existingOrder.setQuantity(1);

        OrderEntity updatedOrder = new OrderEntity();
        updatedOrder.setId(1L);
        updatedOrder.setCustomer(customer);
        updatedOrder.setPizzas(pizzas);

        OrderDto expectedOrderDto = new OrderDto();
        expectedOrderDto.setId(1L);
        expectedOrderDto.setId(2L);
        expectedOrderDto.setPizzas(pizzas);
        expectedOrderDto.setQuantity(3);

        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(existingOrder));
        Mockito.when(customerRepository.findById(2L)).thenReturn(Optional.of(customer));
        Mockito.when(pizzaRepository.findAllById(pizzaIds)).thenReturn(pizzas);
        Mockito.when(orderRepository.save(any(OrderEntity.class))).thenReturn(updatedOrder);
        Mockito.when(orderMappingUtils.mapToOrderDto(updatedOrder)).thenReturn(expectedOrderDto);

        OrderDto actualOrderDto = orderService.updateOrder(1L, updateRequest);

        assertThat(actualOrderDto, is(equalTo(expectedOrderDto)));

        verify(orderRepository, times(1)).findById(1L);
        verify(customerRepository, times(1)).findById(2L);
        verify(pizzaRepository, times(1)).findAllById(pizzaIds);
        verify(orderRepository, times(1)).save(any(OrderEntity.class));
        verify(orderMappingUtils, times(1)).mapToOrderDto(updatedOrder);

        assertThat(existingOrder.getCustomer(), is(equalTo(customer)));
        assertThat(existingOrder.getPizzas(), is(equalTo(pizzas)));
        assertThat(existingOrder.getQuantity(), is(equalTo(3)));
    }

    @Test
    void deleteById () {
        CustomerEntity customer = new CustomerEntity();
        customer.setId(1L);
        customer.setCustomerName("TESTCUSTOMERNAME");
        customer.setCustomerCash(9999);

        PizzaEntity pizza1 = new PizzaEntity();
        pizza1.setId(1L);
        pizza1.setNamePizza("TESTPIZZANAME_1");
        pizza1.setPricePizza(888);

        PizzaEntity pizza2 = new PizzaEntity();
        pizza2.setId(2L);
        pizza2.setNamePizza("TESTPIZZANAME_2");
        pizza2.setPricePizza(777);

        List<PizzaEntity> pizzas = Arrays.asList(pizza1, pizza2);

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(1L);
        orderEntity.setCustomer(customer);
        orderEntity.setPizzas(pizzas);
        orderEntity.setQuantity(2);
        orderEntity.setDeleted(false);

        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(orderEntity));
        Mockito.when(orderRepository.save(orderEntity)).thenReturn(orderEntity);

        orderService.deleteById(1L);

        verify(orderRepository, times(1)).findById(1L);
        verify(orderRepository, times(1)).save(orderEntity);
        assert(orderEntity.isDeleted());
    }
}
