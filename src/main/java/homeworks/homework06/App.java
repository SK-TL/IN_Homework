package main.java.homeworks.homework06;

// 1. Создать классы Покупатель (Person) и Продукт (Product).
// 2. Поля в классах должны быть private, доступ к полям осуществляется через геттеры и сеттеры или конструктор класса
// 3. В классах переопределены методы toString(), equals(), hashcode().
// 4. Создать в классе App метод main и проверить работу приложения.
// Данные Покупателей и Продукты вводятся с клавиатуры или задаются случайным образом.
// Продукты в цикле выбираются покупателями по очереди, пока не введено слово END, наполняется пакет.
// 5. Обработать следующие ситуации

import main.java.homeworks.homework06.Person.Person;
import main.java.homeworks.homework06.Product.DiscountProduct;
import main.java.homeworks.homework06.Product.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        DiscountProduct DS1 = new DiscountProduct("Торт", 800, 15);
        DiscountProduct DS2 = new DiscountProduct("Кофе Растворимый", 432, 50);

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

// Код ниже нужен для демонстрации проверки условий на ввод названия\цены продукта\дисконт продукта.
// В программе инициализация объектов дисконт продуктов будет прописана выше.
//        System.out.println("Укажите имя, цену и процент скидки для продукта со скидкой №1: ");
//        System.out.println("Введите название продукта со скидкой (Обязательно): ");
//        String nameFirstDiscountProduct = Scanner.nextLine();
//        System.out.println("Введите цену продукта со скидкой (Обязательно): ");
//        Integer priceFirstDiscountProduct = Scanner.nextInt();
//        System.out.println("Введите процент скидки для продукта со скидкой (Обязательно): ");
//        Integer discountFirstDiscountProduct = Scanner.nextInt();
//        Scanner.nextLine();
//
//        DS1 = new DiscountProduct(nameFirstDiscountProduct, priceFirstDiscountProduct, discountFirstDiscountProduct);
//
//        System.out.println("Укажите имя, цену и процент скидки для продукта со скидкой №2: ");
//        System.out.println("Введите название продукта со скидкой (Обязательно): ");
//        String nameSecondDiscountProduct = Scanner.nextLine();
//        System.out.println("Введите цену продукта со скидкой (Обязательно): ");
//        Integer priceSecondDiscountProduct = Scanner.nextInt();
//        System.out.println("Введите процент скидки для продукта со скидкой (Обязательно): ");
//        Integer discountSecondDiscountProduct = Scanner.nextInt();
//        Scanner.nextLine();
//
//        DS2 = new DiscountProduct(nameSecondDiscountProduct, priceSecondDiscountProduct, discountSecondDiscountProduct);

        while (true) {
            System.out.println("Введите название продукта (или END для завершения покупок): ");
            String nameProduct = Scanner.nextLine();
            if (nameProduct.equalsIgnoreCase("END")) {
                break;
            }
            if (LocalDate.now().isBefore(DS1.getDiscountDate())) { // Добавлена проверка вводимого продукта на скидку.
                if (nameProduct.equals(DS1.getNameProduct())) {
                    nameProduct = DS1.getNameProduct();
                    System.out.println("Выбранный Вами продукт продается сейчас со скидкой!");
                }
                if (nameProduct.equals(DS2.getNameProduct())) {
                    nameProduct = DS2.getNameProduct();
                    System.out.println("Выбранный Вами продукт продается сейчас со скидкой!");
                }
            } else {
                nameProduct = nameProduct;
            }

            while (true) {
                System.out.println("Введите стоимость продукта: ");
                Integer priceProduct = Scanner.nextInt();
                Scanner.nextLine();

                if (nameProduct.equals(DS1.getNameProduct()) && LocalDate.now().isBefore(DS1.getDiscountDate())) { // Добавлена проверка вводимого продукта на скидку.
                    priceProduct = (int) DS1.getDiscountedPrice();
                } else {
                    priceProduct = priceProduct;
                }
                if (nameProduct.equals(DS2.getNameProduct()) && LocalDate.now().isBefore(DS1.getDiscountDate())) {
                    priceProduct = (int) DS2.getDiscountedPrice();
                } else {
                    priceProduct = priceProduct;
                }
                products.add(new Product(nameProduct, priceProduct));
                break;
            }
        }

        while (true) {
            System.out.print("Введите имя покупателя для которого покупается продукт (или END для завершения покупок): ");
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
                    System.out.print(product.getNameProduct() + " ");
                }
                System.out.println();
            }
        }
        System.out.print("Обычные продукты:"); // Добавлен вывод обычных и акционных товаров
        for (Product product : products) {
            if (product.getNameProduct().equals(DS1.getNameProduct()) || product.getNameProduct().equals(DS2.getNameProduct())) {
                continue;
            } else {
                System.out.print(" " + product.getNameProduct());
            }
        }
        System.out.println();
        System.out.println("Акционные продукты: " + DS1.getNameProduct() + " " + DS2.getNameProduct());
    }
}

