package ru.innopolis.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.dto.OrderDto;
import ru.innopolis.entity.OrderEntity;

@Service
public class OrderMappingUtils {

    @Autowired
    private CustomerMappingUtils customerMappingUtils;

    public OrderDto mapToOrderDto (OrderEntity orderEntity) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(orderEntity.getId());
        orderDto.setPizzas(orderEntity.getPizzas());
        orderDto.setQuantity(orderEntity.getQuantity());
        orderDto.setCustomer(customerMappingUtils.mapToCustomerDto(orderEntity.getCustomer()));
        orderDto.setTotalPrice(orderEntity.getTotalPrice());
        return orderDto;
    }

    public OrderEntity mapToOrderEntity (OrderDto orderDto) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(orderDto.getId());
        orderEntity.setPizzas(orderDto.getPizzas());
        orderEntity.setQuantity(orderDto.getQuantity());
        orderEntity.setCustomer(customerMappingUtils.mapToCustomerEntity(orderDto.getCustomer()));
        return orderEntity;
    }
}
