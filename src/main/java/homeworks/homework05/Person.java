package main.java.homeworks.homework05;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private String namePerson;
    private Integer cashPerson;
    private ArrayList<Product> basket;

    public Person(String namePerson, Integer cashPerson) {
        if (namePerson == null || namePerson.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (cashPerson < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.namePerson = namePerson;
        this.cashPerson = cashPerson;
        this.basket = new ArrayList<>();
    }


    public void addToBasket (Product product) {
        if (this.cashPerson > product.getPriceProduct()) {
            this.cashPerson -= product.getPriceProduct();
            basket.add(product);
        } else {
            System.out.println(this.namePerson + " не может позволить себе " + product.getNameProduct());
        }
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public Integer getCashPerson() {
        return cashPerson;
    }

    public void setCashPerson(Integer cashPerson) {
        this.cashPerson = cashPerson;
    }

    public ArrayList<Product> getBasket() {
        return basket;
    }

    public void setBasket(ArrayList<Product> basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Person{" +
                "namePerson='" + namePerson + '\'' +
                ", cashPerson=" + cashPerson +
                ", basket=" + basket +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(namePerson, person.namePerson) && Objects.equals(cashPerson, person.cashPerson) && Objects.equals(basket, person.basket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePerson, cashPerson, basket);
    }
}
