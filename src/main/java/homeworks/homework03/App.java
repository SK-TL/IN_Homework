package homeworks.homework03;

import java.util.Scanner;

// Содержимое: Работа с классами (темы«Классы: поля, свойства, методы» и «Класс Object. Класс String»);
// Реализовать класс Телевизор. У класса есть поля, свойства и методы.
// Проверить работу в классе App, методе main.
// Обратить внимание на переопределение метода toString

public class App {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner (System.in);

        System.out.println("Знаете ли Вы характеристики для телевизора?");
        System.out.println("1. Да");
        System.out.println("2. Нет. Предложите мне стандартный телевизор");
        String CheckCharacteristic = Scanner.next();

        if (CheckCharacteristic.equalsIgnoreCase("Да")) {

            System.out.println("Выберите пункт [1,2,3,4]");
            System.out.println("Выберите диагональ телевизора: ");
            System.out.println("1. 43 Дюйма");
            System.out.println("2. 50 Дюйма");
            System.out.println("3. 55 Дюйма");
            int DisplaySize = Scanner.nextInt();

            System.out.println("Полностью впишите нижеуказанные варианты.");
            System.out.println("Выберите разрешение телевизора: ");
            System.out.println("1. FHD");
            System.out.println("2. 4k");
            System.out.println("3. 8k");
            String DisplayResolution = Scanner.next();

            System.out.println("Выберите пункт [1,2,3,4]");
            System.out.println("Выберите ориентировочную цену телевизора: ");
            System.out.println("1. До 30.000 руб.");
            System.out.println("2. До 50.000 руб.");
            System.out.println("3. До 100.000 руб.");
            System.out.println("4. До 300.000 руб.");
            int Price = Scanner.nextInt();

            System.out.println("Полностью впишите нижеуказанные варианты.");
            System.out.println("Выберите производителя телевизора: ");
            System.out.println("1. SAMSUNG");
            System.out.println("2. HISENCE");
            System.out.println("3. LG");
            String Manufacturer = Scanner.next();

            Television TV1 = new Television(DisplaySize, DisplayResolution, Price, Manufacturer);
        } else if (CheckCharacteristic.equalsIgnoreCase("Нет")){
            Television TV1 = new Television();
            System.out.println(TV1.toString());;
        } else {
            System.out.println("Ошибка. Выберите из списка!");
        }

    }
}
