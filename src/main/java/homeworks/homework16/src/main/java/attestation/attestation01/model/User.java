package attestation.attestation01.model;



import attestation.attestation01.exceptions.InvalidInputDataFormatException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class User {

    private String id;
    private LocalDateTime localDateTime;
    private String login;
    private String password;
    private String confirmPassword;
    private String lastName;
    private String firstName;
    private String middleName;
    private Integer age;
    private boolean isWorker = false;

    public User(String id, LocalDateTime localDateTime, String login, String password, String confirmPassword,
                String lastName, String firstName, String middleName, Integer age, boolean isWorker) {

        this.id = id;
        this.localDateTime = LocalDateTime.parse(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")));
        if (login.matches("^[0-9]+$") || login.length() > 20) {
            throw new InvalidInputDataFormatException("Неверный формат логина!");
        } else this.login = login;
        if (password.matches("^[0-9]+$") || password.length() > 20) {
            throw new InvalidInputDataFormatException("Неверный формат пароля!");
        } else this.password = password;
        if(password.equals(confirmPassword)) {
            this.confirmPassword = confirmPassword;
        } else throw new InvalidInputDataFormatException("Пароли не совпадают!");
        if (lastName.matches("^[a-zA-Zа-яА-Я]+$")){
            this.lastName = lastName;
        } else throw new InvalidInputDataFormatException("Фамилия должна состоять только из букв!");
        if (firstName.matches("^[a-zA-Zа-яА-Я]+$")){
            this.firstName = firstName;
        } else throw new InvalidInputDataFormatException("Имя должно состоять только из букв!");
        if (middleName.matches("^[a-zA-Zа-яА-Я]+$")){
            this.middleName = middleName;
        } else throw new InvalidInputDataFormatException("Отчество должно состоять только из букв!");
        if(age > 0) {
            this.age = age;
        } else throw new InvalidInputDataFormatException("Возраст не может быть отрицательным!");
        this.isWorker = isWorker;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    public static User fromString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length < 9) {
            throw new IllegalArgumentException("Неверный формат строки информации пользователя!");
        }
        String id = parts[0];
        LocalDateTime localDateTime = LocalDateTime.parse(parts[1]);
        String login = parts[2];
        String password = parts[3];
        String confirmPassword = parts[4];
        String lastName = parts[5];
        String firstName = parts[6];
        String middleName = parts[7].isEmpty() ? null : parts[7];
        Integer age = parts[8].isEmpty() ? null : Integer.parseInt(parts[8]);
        boolean isWorker = Boolean.parseBoolean(parts[9]);

        return new User (id, localDateTime, login, password, confirmPassword, lastName, firstName, middleName, age, isWorker);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isWorker == user.isWorker && Objects.equals(id, user.id) && Objects.equals(localDateTime, user.localDateTime) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(confirmPassword, user.confirmPassword) && Objects.equals(lastName, user.lastName) && Objects.equals(firstName, user.firstName) && Objects.equals(middleName, user.middleName) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, localDateTime, login, password, confirmPassword, lastName, firstName, middleName, age, isWorker);
    }

    @Override
    public String toString() {
        return  id + "|" +
                localDateTime + "|" +
                login + "|" +
                password + "|" +
                confirmPassword + "|" +
                lastName + "|" +
                firstName + "|" +
                middleName + "|" +
                age + "|" +
                isWorker + "|";
    }
}
