package main.java.homeworks.homework07;
import main.java.homeworks.homework07.Person.Person;
import main.java.homeworks.homework07.Product.DiscountProduct;
import main.java.homeworks.homework07.Product.Product;

// 1. Создать классы Покупатель (Person) и Продукт (Product).
// 2. Поля в классах должны быть private, доступ к полям осуществляется через геттеры и сеттеры или конструктор класса
// 3. В классах переопределены методы toString(), equals(), hashcode().
// 4. Создать в классе App метод main и проверить работу приложения.
// Данные Покупателей и Продукты вводятся с клавиатуры или задаются случайным образом.
// Продукты в цикле выбираются покупателями по очереди, пока не введено слово END, наполняется пакет.
// 5. Обработать следующие ситуации

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        System.out.println("Введите данные о покупателях: ");
        String infoPerson = Scanner.nextLine();

        for (String parts : infoPerson.split(";")) {
            String[] partsMassive = parts.split("=");
            String namePerson = partsMassive[0].trim();
            Integer cashPerson = Integer.parseInt(partsMassive[1].trim());
            persons.add(new Person(namePerson, cashPerson));
        }

        System.out.println("Введите данные о продуктах: ");
        String infoProduct = Scanner.nextLine();

        for (String parts : infoProduct.split(";")) {
            if (parts.contains("%")) {
                String[] partsMassive = parts.split("=");
                String nameProduct = partsMassive[0].trim();
                String[] partMassiveDiscount = partsMassive[1].split(",");
                Integer priceProduct = Integer.parseInt(partMassiveDiscount[0].trim());
                Integer discountPriceProduct = Integer.parseInt(partMassiveDiscount[1].trim().replace("%", ""));
                products.add(new DiscountProduct(nameProduct, priceProduct, discountPriceProduct));
            } else {
                String[] partsMassive = parts.split("=");
                String nameProduct = partsMassive[0].trim();
                Integer priceProduct = Integer.parseInt(partsMassive[1].trim());
                products.add(new Product(nameProduct, priceProduct));
            }
        }

        while (true) {
            System.out.println("Введите покупателя и продукты для покупки (или END для завершения покупок): ");
            String input = Scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            String[] inputMassive = input.split("=");
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

        for (Person person : persons) {
            System.out.print("Покупатель " + person.getNamePerson() + " купил: ");
            if (person.getBasket().isEmpty()) {
                System.out.println("ничего");
            } else {
                for (Product product : person.getBasket()) {
                    System.out.print(product.getNameProduct() + " ");
                }
                System.out.println();
            }
        }

        System.out.println("\nОбычные продукты:");
        for (Product product : products) {
            if (!(product instanceof DiscountProduct)) {
                System.out.println(" - " + product.getNameProduct());
            }
        }
        System.out.println("\nПродукты со скидкой:");
        for (Product product : products) {
            if (product instanceof DiscountProduct) {
                System.out.println(" - " + product.getNameProduct());
            }
        }
    }
}
//        Информация для ввода в консоль:
//        Покупатель и сумма: "Павел Андреевич = 10000; Анна Петровна = 2000; Борис = 10";
//        Продукты и их стоимость (со скидочными продуктами): "Хлеб = 40; Молоко = 60; Торт = 800, 15%; Кофе растворимый = 432, 50%; Масло = 150";
//        Покупки:
//        "Павел Андреевич = Хлеб";
//        "Павел Андреевич = Масло";
//        "Анна Петровна = Кофе растворимый";
//        "Анна Петровна = Молоко"
//        "Анна Петровна = Молоко"
//        "Анна Петровна = Молоко"
//        "Анна Петровна = Торт"
//        "Борис = Торт";
//        "Павел Андреевич = Торт";
