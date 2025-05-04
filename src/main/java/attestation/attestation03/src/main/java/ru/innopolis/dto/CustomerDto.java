package ru.innopolis.dto;

import lombok.Data;

@Data
public class CustomerDto {
    Long id;
    String customerName;
    Integer customerCash;
}
