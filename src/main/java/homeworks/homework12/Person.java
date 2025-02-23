package main.java.homeworks.homework12;

import main.java.homeworks.homework12.Exception.WrongFormatException;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private String lastNamePerson;
    private String firstnamePerson;
    private String patronymicPerson;
    private LocalDate dateOfBirthPerson;
    private Long phoneNumberPerson;
    private String genderPerson;
    private Integer oldPerson;

    public Person() {
    }

    public String getLastNamePerson() {
        return lastNamePerson;
    }

    public void setLastNamePerson(String lastNamePerson) {
        if (containsDigits(lastNamePerson)) {
            throw new WrongFormatException("Фамилия не может быть пустой или содержать цифры");
        } else {
            this.lastNamePerson = lastNamePerson;
        }
    }

    public String getFirstnamePerson() {
        return firstnamePerson;
    }

    public void setFirstnamePerson(String firstnamePerson) {
        if (containsDigits(firstnamePerson)) {
            throw new WrongFormatException("Имя не может быть пустым или содержать цифры");
        } else {
            this.firstnamePerson = firstnamePerson;
        }
    }

    public String getPatronymicPerson() {
        return patronymicPerson;
    }

    public void setPatronymicPerson(String patronymicPerson) {
        if (containsDigits(patronymicPerson)) {
            throw new WrongFormatException("Отчество не может быть пустым или содержать цифры");
        } else {
            this.patronymicPerson = patronymicPerson;
        }
    }

    public LocalDate getDateOfBirthPerson() {
        return dateOfBirthPerson;
    }

    public void setDateOfBirthPerson(LocalDate dateOfBirthPerson) {
        if (LocalDate.now().isAfter(dateOfBirthPerson)) {
            this.dateOfBirthPerson = dateOfBirthPerson;
        } else {
            throw new WrongFormatException("Дата рождения не может быть позднее, сегодняшней даты");
        }
    }

    public Long getPhoneNumberPerson() {
        return phoneNumberPerson;
    }

    public void setPhoneNumberPerson(Long phoneNumberPerson) {
        if (String.valueOf(phoneNumberPerson).matches("\\d{11}")) {
            this.phoneNumberPerson = phoneNumberPerson;
        } else {
            throw new WrongFormatException("Номер телефона не может быть короче 11 цифр");
        }
    }

    public String getGenderPerson() {
        return genderPerson;
    }

    public void setGenderPerson(String genderPerson) {
        if (genderPerson.equalsIgnoreCase("f") || genderPerson.equalsIgnoreCase("m")) {
            this.genderPerson = genderPerson;
        }
        else {
            throw new WrongFormatException("Неверный формат пола! Выберите один из двух предложенных вариантов: f или m")  ;
        }
    }

    public Integer getOldPerson() {
        return oldPerson;
    }

    public void setOldPerson(Integer oldPerson) {
        if (oldPerson > 0) {
            this.oldPerson = oldPerson;
        } else {
            throw new WrongFormatException("Возраст не должен быть отрицательным!");
        }
    }

    private boolean containsDigits(String str) {
        if (str == null || str.isEmpty()) {return false;}
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstnamePerson, person.firstnamePerson) && Objects.equals(lastNamePerson, person.lastNamePerson) && Objects.equals(patronymicPerson, person.patronymicPerson) && Objects.equals(dateOfBirthPerson, person.dateOfBirthPerson) && Objects.equals(phoneNumberPerson, person.phoneNumberPerson) && Objects.equals(genderPerson, person.genderPerson) && Objects.equals(oldPerson, person.oldPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstnamePerson, lastNamePerson, patronymicPerson, dateOfBirthPerson, phoneNumberPerson, genderPerson, oldPerson);
    }

    @Override
    public String toString() {
        return
                "Фамилия - " + lastNamePerson + "; " +
                        "Имя - " + firstnamePerson + "; " +
                        "Отчество - " + patronymicPerson + "; " +
                        "День Рождения - " + dateOfBirthPerson + "; " +
                        "Номер Телефона - " + phoneNumberPerson + "; " +
                        "Пол - " + genderPerson + "; " +
                        "Возраст - " + oldPerson + "; ";
    }
}
