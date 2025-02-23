package main.java.homeworks.homework08;

// Добавить работу с файлом для домашнего задания 6 «Понятия ООП:инкапсуляция»
// Данные Покупателей и Продукты считываются из файла.
// Продукты в цикле выбираются покупателями по очереди и, пока не введено слово END, наполняется пакет.
// Результат работы программы выводится в файл.

import main.java.homeworks.homework08.util.ProcessingDataInput;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";
        int count = 0;

        try (Scanner Scanner = new Scanner(Path.of(inputFilePath));
             FileWriter fileWriter = new FileWriter(outputFilePath)) {
            while (Scanner.hasNextLine()) {
                if (count == 0) {
                    String line = Scanner.nextLine();
                    for (String parts : line.split(";")) {
                        String[] partsMassive = parts.split("=");
                        String namePerson = partsMassive[0].trim();
                        // Изменено преобразование полученной строки на ProcessingDataInput.parseCount()
                        Integer cashPerson = ProcessingDataInput.parseCount(partsMassive[1].trim());
                        persons.add(new Person(namePerson, cashPerson));
                    }
                    count++;
                }
                if (count == 1) {
                    String line = Scanner.nextLine();
                    for (String parts : line.split(";")) {
                        String[] partsMassive = parts.split("=");
                        String nameProduct = partsMassive[0].trim();
                        // Изменено преобразование полученной строки на ProcessingDataInput.parseCount()
                        Integer priceProduct = ProcessingDataInput.parseCount(partsMassive[1].trim());
                        products.add(new Product(nameProduct, priceProduct));
                    }
                    count++;
                }
                if (count == 2) {
                    while (true) {
                        String line = Scanner.nextLine();
                        if (line.equalsIgnoreCase("END")) {
                            break;
                        }
                        String[] inputMassive = line.split("=");
                        String nameInput = inputMassive[0].trim();
                        String productInput = inputMassive[1].trim();

                        Person currentPerson = null;
                        for (Person person : persons) {
                            if (person.getNamePerson().equals(nameInput)) {
                                currentPerson = person;
                                continue;
                            }
                        }

                        Product currentProduct = null;
                        for (Product product : products) {
                            if (product.getNameProduct().equals(productInput)) {
                                currentProduct = product;
                                continue;
                            }
                        }
                        currentPerson.addToBasket(currentProduct);
                    }
                }
            }
            for (Person person : persons) {

                if (person.getBasket().isEmpty()) {
                    fileWriter.write("Покупатель " + person.getNamePerson() + " купил: ");
                    fileWriter.write("ничего\n");
                }else {
                    for (Product product : person.getBasket()) {
                        fileWriter.write(person.getNamePerson() + " купил: ");
                        fileWriter.write(product.getNameProduct() + "");
                        fileWriter.write("\n");
                    }
                }
            }

            for (Person person : persons) {
                fileWriter.write("Покупатель " + person.getNamePerson() + " купил: ");
                if (person.getBasket().isEmpty()) {
                    fileWriter.write("ничего\n");
                }else {
                    for (Product product : person.getBasket()) {
                        fileWriter.write(product.getNameProduct() + " ");
                    }
                    fileWriter.write("\n");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}