package homeworks.homework02.task01;

import java.util.Scanner;

// Содержимое: Базовый синтаксис Java(тема «Точка входа в программу. JVM структура»);
// Задача 1. Напишите Java-программу для преобразования температуры изФаренгейта в градусы Цельсия

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        System.out.print("Введите степень в градусах Фаренгейта: ");
        double DegreesFahrenheit = Scanner.nextDouble();
        double DegreesCelsius = 0;

        System.out.println(DegreesFahrenheit + " градусов по Фаренгейту равна " + fahrenheitInCelsius(DegreesFahrenheit, DegreesCelsius) + " градусов по Цельсию");
    }
    public static double fahrenheitInCelsius (double DegreesFahrenheit, double DegreesCelsius ) {
        return DegreesCelsius = (DegreesFahrenheit - 32) / 1.8;
    }
}
