package homeworks.homework04.task03;

// Содержимое:  Класс   String  (темы«Классы: поля, свойства, методы» и «Класс Object. Класс String»).
// Задача 3*. Задана строка, состоящая из букв английского алфавита, разделенных одним пробелом.
// Необходимо каждую последовательность символов упорядочить по возрастанию и вывести слова в нижнем регистре.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String someSymbol = "qwe ewq";
        String[] someSymbolMassive = someSymbol.split(" "); //

//       Для себя. Через сплит короче.
//       String [] someSymbol = new String[2];
//       someSymbol[0] = "qweqwe";
//       someSymbol[1] = "ewqewq";

        StringBuilder result = new StringBuilder();
        for (String word : someSymbolMassive) {
            char[] chars = word.toLowerCase().toCharArray();
            Arrays.sort(chars);
            result.append(new String(chars)).append(" ");    // Append sorted chars as string to result
        }
        System.out.println(result);
    }
}
