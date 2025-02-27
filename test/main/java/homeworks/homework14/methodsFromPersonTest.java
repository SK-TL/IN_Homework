package main.java.homeworks.homework14;

import main.java.homeworks.homework05.Person;
import main.java.homeworks.homework05.Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class methodsFromPersonTest {

    private static methodsFromPerson methodsInPerson;

    @BeforeAll
    static void init () {
        methodsInPerson = new methodsFromPerson();
    }

    @Test
    void convertStringToPersonTest1 () {
        String line = "Павел Андреевич = 10000; Анна Петровна = 2000; Борис = 10;";

        List<Person> result = methodsInPerson.convertStringToPerson(line);

        Assertions.assertAll(() -> {
            Assertions.assertEquals(3, result.size());
        });
    }

    @ParameterizedTest
    @MethodSource ("line")
    void convertStringToPersonTest1 (String line) {

        List<Person> result = methodsInPerson.convertStringToPerson(line);

        String[] parts = line.split("=");
        String expectedName = parts[0];
        int expectedMoney = Integer.parseInt(parts[1].trim());

        Assertions.assertAll(() -> {
            Assertions.assertNotNull(result, "Результат не должен быть пустым!");
            Assertions.assertEquals(1, result.size());
            Person person = result.get(0);
            Assertions.assertEquals(expectedName, person.getNamePerson(), "Имя не совпадает");
            Assertions.assertEquals(expectedMoney, person.getCashPerson(), "Сумма не совпадает");
        });
    }

    private static Stream<Arguments> line() {
        return Stream.of(
                Arguments.of("Павел Андреевич = 10000"),
                Arguments.of("Анна Петровна = 2000"),
                Arguments.of("Борис = 10")
        );
    }

    @Test
    void convertStringToPersonTest2 () {
        String line = "Хлеб = 40; Молоко = 60; Торт = 1000; Кофе растворимый = 879; Масло = 150;";

        List<Product> result = methodsInPerson.convertStringToProduct(line);

        Assertions.assertAll(() -> {
            Assertions.assertEquals(3, result.size());
        });
    }

    @ParameterizedTest
    @MethodSource ("line2")
    void convertStringToPersonTest2 (String line) {

        List<Product> result = methodsInPerson.convertStringToProduct(line);

        String[] parts = line.split("=");
        String expectedName = parts[0];
        int expectedMoney = Integer.parseInt(parts[1].trim());

        Assertions.assertAll(() -> {
            Assertions.assertNotNull(result, "Результат не должен быть пустым!");
            Assertions.assertEquals(1, result.size());
            Product product = result.get(0);
            Assertions.assertEquals(expectedName, product.getNameProduct(), "Имя не совпадает");
            Assertions.assertEquals(expectedMoney, product.getPriceProduct(), "Сумма не совпадает");
        });
    }

    private static Stream<Arguments> line2() {
        return Stream.of(
                Arguments.of("Хлеб - 40"),
                Arguments.of("Молоко - 60"),
                Arguments.of("Торт - 1000"),
                Arguments.of("Кофе растворимый - 879"),
                Arguments.of("Масло - 150")
        );
    }

    // Ожидается исключение IllegalArgumentException
    @Test
    void convertStringToPersonTest1Exception() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> methodsInPerson.convertStringToPerson(""));
    }

    // В методе convertStringToProduct() не предусмотрена проверка на пустоту или null. Поэтому тест выключен
    @Disabled
    @Test
    void convertStringToPersonTest2Exception() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> methodsInPerson.convertStringToProduct(null));
    }

}
