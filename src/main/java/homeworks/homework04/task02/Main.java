package homeworks.homework04.task02;

// Содержимое:  Класс   String  (темы«Классы: поля, свойства, методы» и «Класс Object. Класс String»).
// Задача 2. Задана последовательность, состоящая только из символов ‘>’, ‘<’ и ‘-‘.
// Требуется найти количество стрел, которые спрятаны в этой последовательности.
// Стрелы – это подстроки вида ‘>>-->’ и ‘<--<<’.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String someSymbol = ">>-->>>--><--<<<--<<";
        int count = 0;

        Pattern pattern = Pattern.compile(">>-->|<--<<");
        Matcher matcher = pattern.matcher (someSymbol);

        while (matcher.find()) {
            count ++;
        }
        System.out.println(count);
    }
}
