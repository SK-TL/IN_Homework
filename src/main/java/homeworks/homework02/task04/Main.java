package homeworks.homework02.task04;

import java.util.Scanner;

// Содержимое: Базовый синтаксис Java(тема «Точка входа в программу. JVM структура»);
// Задача 4*. Напишите программу на Java для печати сетки из заданных элементов.

public class Main {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        System.out.print("Введите число строк и столбцов сетки: ");
        int Count = Scanner.nextInt();

        System.out.print("Введите повторяемый элемент сетки: ");
        char str = Scanner.next().charAt(0);

        System.out.println("Сетка по запросу " + Count + " на " + Count + ": ");
        for (int i = 0; i < Count; i++) {
            for (int j = 1; j < Count; j++) {
                System.out.print(str);
            }
            System.out.println(str);
        }
    }
}
