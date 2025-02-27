package main.java.homeworks.homework14;

import main.java.homeworks.homework05.Person;
import main.java.homeworks.homework05.Product;

import java.util.Arrays;
import java.util.List;

public class methodsFromPerson {

    public List<Person> convertStringToPerson (String infoPerson) {
        if (infoPerson == null || infoPerson.isEmpty()) throw new IllegalArgumentException("Строка не может быть пустой");

        return Arrays.stream(infoPerson.split(";"))
                .map(e -> {
                    String[] parts = e.split("=");
                    return new Person(parts[0], Integer.parseInt(parts[1].trim()));
                })
                .toList();
    }

    public List<Product> convertStringToProduct (String infoProduct) {
        // if (infoProduct == null || infoProduct.isEmpty()) throw new IllegalArgumentException("Строка не может быть пустой");

        return Arrays.stream(infoProduct.split(";"))
                .map(e -> {
                    String[] parts = e.split("=");
                    return new Product(parts[0], Integer.parseInt(parts[1].trim()));
                })
                .toList();
    }
}
