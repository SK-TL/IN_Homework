package homeworks.homework02.task02;

import java.util.Scanner;

// Содержимое: Базовый синтаксис Java(тема «Точка входа в программу. JVM структура»);
// Задача 2.  Напишите программу на Java, которая принимает два целыхчисла от пользователя,
// а затем печатает сумму, разницу, произведение, среднеезначение, расстояние (разница между целыми числами),
// максимум (большее издвух целых чисел), минимум (меньшее из двух целых чисел).

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        System.out.print("Введите 1-е целое число: ");
        int FirstNumber = Scanner.nextInt();

        System.out.print("Введите второе целое число: ");
        int SecondNumber = Scanner.nextInt();

        System.out.println("Сумма двух целых чисел: " + additionTwoNumbers(FirstNumber, SecondNumber));
        System.out.println("Разница двух целых чисел: " + subtractionTwoNumbers(FirstNumber, SecondNumber));
        System.out.println("Произведение из двух целых чисел: " + multiplicationTwoNumbers(FirstNumber, SecondNumber));
        System.out.println("Среднее из двух целых чисел: " + averageTwoNumbers(FirstNumber, SecondNumber));
        System.out.println("Расстояние двух целых чисел: " + distanceTwoNumbers(FirstNumber, SecondNumber));
        System.out.println("Максимальное целое число: " + maxTwoNumbers(FirstNumber, SecondNumber));
        System.out.println("Минимальное целое число: " + minTwoNumbers(FirstNumber, SecondNumber));
    }
    public static int additionTwoNumbers (int FN, int SN) {
        //return FN+SN;
        return Math.addExact(FN, SN);
    }

    public static int subtractionTwoNumbers (int FN, int SN) {
        //return FN-SN;
        return Math.subtractExact(FN, SN);
    }

    public static int multiplicationTwoNumbers (int FN, int SN) {
        //return FN*SN;
        return Math.multiplyExact(FN, SN);
    }

    public static double averageTwoNumbers (int FN, int SN) {
        return ((double) (FN + SN) / 2);
    }

    public static int distanceTwoNumbers (int FN, int SN) {
        //return ((FN-SN) < 0 ? -(FN-SN): (FN-SN));
        return Math.abs(FN - SN);
    }

    public static int maxTwoNumbers (int FN, int SN) {
        //return (FN < SN ? SN : FN);
        return Math.max(FN, SN);
    }

    public static int minTwoNumbers (int FN, int SN) {
        //return (FN < SN ? FN : SN);
        return Math.min(FN, SN);
    }
}
