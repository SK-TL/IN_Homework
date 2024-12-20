package homeworks.homework01.task01;

// Содержимое: Первая программа на Java(тема «Подготовка рабочего места. Среда разработки для Java»);
// Задача 1.Составить программу вывода на экран в одну строку четырех любых чисел с тремя пробела мимежду ними
public class Main {
    public static void main(String[] args) {
        System.out.println(getRandom() + space() + getRandom() + space() + getRandom() + space() + getRandom());
    }

    public static int getRandom () {
        return (int) (Math.random() * 10);
    }

    public static String space () {
        return "   ";
    }
}
