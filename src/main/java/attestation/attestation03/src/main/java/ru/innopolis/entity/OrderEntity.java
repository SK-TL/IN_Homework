package ru.innopolis.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "Orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, foreignKey = @ForeignKey(name = "FK_ORDER_CUSTOMER"))
    private CustomerEntity customer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "order_pizza",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id"),
            foreignKey = @ForeignKey(name = "FK_ORDER_PIZZA"),
            inverseForeignKey = @ForeignKey(name = "FK_PIZZA_ORDER")
    )
    @JsonManagedReference
    private List<PizzaEntity> pizzas;

    private Integer quantity;

    public Integer getTotalPrice() {
        int totalPrice = 0;
        for (PizzaEntity pizza : pizzas) {
            totalPrice += pizza.getPricePizza() * quantity; // quantity - количество каждой пиццы в заказе
        }
        return totalPrice;
    }

    private boolean deleted;
}
