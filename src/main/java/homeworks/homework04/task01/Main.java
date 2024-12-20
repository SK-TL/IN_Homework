package homeworks.homework04.task01;

import java.util.Scanner;

// Содержимое:  Класс   String  (темы«Классы: поля, свойства, методы» и «Класс Object. Класс String»).
// Задача 1. Для введенной с клавиатуры буквы английского алфавита нужно вывести слева стоящую букву на стандартной клавиатуре.
// При этом клавиатура замкнута, т.е. справа от буквы «p» стоит буква «a», а слева от "а" буква "р",
// также соседними считаются буквы «l» и буква «z», а буква «m» с буквой «q».

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        System.out.println("Введите букву с клавиатуры: ");
        char chr = Scanner.next().charAt(0);

        System.out.println("Слева от введенного Вами символа находится символ: ");
        leftNeighbor(chr);
        System.out.println("Справа от введенного Вами символа находится символ: ");
        rightNeighbor(chr);
    }

    public static void leftNeighbor (char chr) {
        char[] charMassive = new char[]
                {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
                        'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
                        'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        for (int i = 0; i < charMassive.length; i++) {
            if (chr == 'q') {
                System.out.println(charMassive[25]);
                break;
            } else if (chr == charMassive[i]) {
                System.out.println(charMassive[i - 1]);
            }
        }
    }
    public static void rightNeighbor (char chr) {
        char[] charMassive = new char[]
                {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
                        'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
                        'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        for (int i = 0; i < charMassive.length; i++) {
            if (chr == 'm') {
                System.out.println(charMassive[0]);
                break;
            } else if (chr == charMassive[i]) {
                System.out.println(charMassive[i + 1]);
            }
        }
    }
}
