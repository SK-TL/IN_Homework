package main.java.homeworks.homework08;

import java.io.*;
import java.util.*;

public class Person {
    private String namePerson;
    private Integer cashPerson;
    private List<Product> basket;
    String outputFilePath = "C:\\Users\\wyche.DESKTOP-AT7CLDI\\IdeaProjects\\SandBox\\src\\Test1\\output.txt";

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
        try (FileWriter fileWriter = new FileWriter(outputFilePath)) {
            if (this.cashPerson > product.getPriceProduct()) {
                this.cashPerson -= product.getPriceProduct();
                fileWriter.write(this.namePerson + " купил " + product.getNameProduct());
                fileWriter.flush();
                basket.add(product);
            } else
                fileWriter.write(this.namePerson + " не может позволить себе " + product.getNameProduct());
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
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

    public List<Product> getBasket() {
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