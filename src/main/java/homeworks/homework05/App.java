package main.java.homeworks.homework05;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();

        while (true) {
            System.out.println("Введите имя покупателя (или END для завершения покупок): ");
            String namePerson = Scanner.nextLine();
            if (namePerson.equalsIgnoreCase("END")) {
                break;
            }

            while (true) {
                System.out.println("Введите сумму покупателя : ");
                Integer cashPerson = Scanner.nextInt();
                Scanner.nextLine();
                people.add(new Person(namePerson, cashPerson));
                break;
            }
        }

        while (true) {
            System.out.println("Введите название продукта (или END для завершения покупок): ");
            String nameProduct = Scanner.nextLine();
            if (nameProduct.equalsIgnoreCase("END")) {
                break;
            }

            while (true) {
                System.out.println("Введите стоимость продукта: ");
                Integer priceProduct = Scanner.nextInt();
                Scanner.nextLine();
                products.add(new Product(nameProduct, priceProduct));
                break;
            }
        }

        while (true) {
            System.out.print("Введите имя покупателя для которого покупается товар (или END для завершения покупок): ");
            String namePerson = Scanner.nextLine();

            if (namePerson.equalsIgnoreCase("END")) {
                break;
            }

            Person currentPerson = null;
            for (Person person : people) {
                if (person.getNamePerson().equals(namePerson)) {
                    currentPerson = person;
                    break;
                }
            }

            if (currentPerson == null) {
                System.out.println("Покупатель не найден: " + namePerson);
                continue;
            }

            while (true) {
                System.out.print("Введите название продукта для покупки (или END для завершения ввода продуктов для текущего покупателя): ");
                String productName = Scanner.nextLine();

                if (productName.equalsIgnoreCase("END")) {
                    break;
                }

                Product nameProductToBuy = null;
                for (Product product : products) {
                    if (product.getNameProduct().equals(productName)) {
                        nameProductToBuy = product;
                        break;
                    }
                }

                if (nameProductToBuy != null) {
                    currentPerson.addToBasket(nameProductToBuy);
                } else {
                    System.out.println("Продукт не найден: " + productName);
                }
            }
        }

        for (Person person : people) {
            System.out.print("Покупатель " + person.getNamePerson() + " купил: ");
            if (person.getBasket().isEmpty()) {
                System.out.println("ничего");
            } else {
                for (Product product : person.getBasket()) {
                    System.out.print(product.getNameProduct() + ", ");
                }
                System.out.println();

            }
        }
    }
}
