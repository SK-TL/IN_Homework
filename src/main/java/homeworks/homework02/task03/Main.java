package homeworks.homework02.task03;

// Содержимое: Базовый синтаксис Java(тема «Точка входа в программу. JVM структура»);
// Задача 3*. Напишите Java-программу для объединения данной строки ссамим собой заданное количество раз.

public class Main {
    public static void main(String[] args) {
        String str = "Java";
        int Count = 8;
        String repeat = str.repeat(Count);
        System.out.println("После повторения 8 раз: " + repeat);
    }
}
