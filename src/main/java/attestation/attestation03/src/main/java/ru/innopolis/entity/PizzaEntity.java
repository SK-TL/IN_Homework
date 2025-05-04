package ru.innopolis.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Pizzas")
public class PizzaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namePizza;

    private Integer pricePizza;

    @ManyToMany(mappedBy = "pizzas", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<OrderEntity> orders;

    private boolean deleted;
}
