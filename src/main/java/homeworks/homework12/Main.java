package main.java.homeworks.homework12;

/*
Домашнее задание по теме «Иерархия исключений в Java. Работа программиста с исключениями»
1. Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
разделенные пробелом: Фамилия Имя Отчество дата рождения номер телефона пол возраст
2. Приложение должно проверить введенные данные.
3. Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры
4. сли всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные
5. Дополнительно. Однофамильцы должны записаться в один и тот же файл, в отдельные строки
 */
// Ivanov Ivan Ivanovich 01.01.1970 79999999999 m 55
// Ivanov Maksim Maksimovich 10.10.2000 78888888888 m 25
// Maksimov Ivan Ivanovich 12.12.2012 77777777777 m 13

import main.java.homeworks.homework12.Exception.WrongCountException;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("Введите Ваши данные (Формат: Фамилия Имя Отчество Дата Рождения Номер Телефона(11 цифр) Пол(f/m) Возраст");
        String infoAboutPerson = scanner.nextLine();
        Person person = new Person();
        String[] splitParts = infoAboutPerson.split(" ");

        if (splitParts.length < 7) {
            throw new WrongCountException("Вы ввели недостаточно информации о себе!");
        }
        else if (splitParts.length > 7) {
            throw new WrongCountException("Вы ввели слишком много информации о себе!");}
        else {
            person.setLastNamePerson(splitParts[0]);
            person.setFirstnamePerson(splitParts[1]);
            person.setPatronymicPerson(splitParts[2]);
            person.setDateOfBirthPerson(LocalDate.parse(splitParts[3], formatter));
            person.setPhoneNumberPerson(Long.valueOf(splitParts[4]));
            person.setGenderPerson(splitParts[5]);
            person.setOldPerson(Integer.valueOf(splitParts[6]));

            try (FileWriter fileWriter = new FileWriter(person.getLastNamePerson() + ".txt", true);){
                fileWriter.write(String.valueOf(person) + System.lineSeparator());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
