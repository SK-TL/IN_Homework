package main.java.homeworks.homework10;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {6666, 777, 888, 999, 1111};
        int[] checkArrayForParity = Sequence.filter(array, number -> number % 2 == 0);
        int[] checkSumElementArrayForParity= Sequence.filter(array, number -> {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            return sum % 2 == 0;
        });
        System.out.println("Чётные элементы массива: " + Arrays.toString(checkArrayForParity));
        System.out.println("Чётная сумма элемента в массиве: " + Arrays.toString(checkSumElementArrayForParity));
    }
}
