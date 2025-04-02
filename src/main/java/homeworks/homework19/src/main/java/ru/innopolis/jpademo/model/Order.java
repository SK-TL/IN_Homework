package ru.innopolis.jpademo.model;

import lombok.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Order {
    private Long id;
    private User user;
    private LocalDate dateTime;
    private Long count;
    private Long discount;
}
