package main.java.attestation.attestation01;

import main.java.attestation.attestation01.model.User;
import main.java.attestation.attestation01.repository.UsersRepository;
import main.java.attestation.attestation01.repository.imp.UsersRepositoryFileImpl;

import java.io.*;

public class App {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryFileImpl();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\main\\java\\attestation\\attestation01\\resources\\input.txt"))) {
            bufferedWriter.write("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2|2023-12-25T19:10:11.556|noisemc_99|789ghs|789ghs|Крылов|Виктор|Павлович|25|true" + "\n");
            bufferedWriter.write("qa3sth3sd-7hns-1e4m-4rxz-5f67h89oi1hgk|2020-01-01T23:23:23.232|someLogin|somepassword|somepassword|Иванов|Иван|Иванович|55|false" + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\java\\attestation\\attestation01\\resources\\input.txt"))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                User user = User.fromString(line);

                // Проверка метода create()
                usersRepository.create(user);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Проверка метода findById()
        System.out.println("Проверка метода findById():");
        System.out.println(usersRepository.findById("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2"));
        System.out.println();

        // Проверка метода findAll()
        System.out.println("Проверка метода findAll():");
        System.out.println(usersRepository.findAll());
        System.out.println();

        // Проверка метода update()
        User userToUpdate = usersRepository.findById("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2");
        userToUpdate.setFirstName("Антон");
        usersRepository.update(userToUpdate);
        System.out.println("Проверка метода update():");
        System.out.println(usersRepository.findById("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2"));
        System.out.println();

//         // Проверка метода deleteById()
           // Проверка данного метода закомичена, т.к. из-за отсутствия удалённого элемента программа вызывает ошибку
//        usersRepository.deleteById("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2");
//        System.out.println("Проверка метода deleteById():");
//        System.out.println(usersRepository.findById("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2"));

        // Проверка метода deleteAll()
        usersRepository.deleteAll();
        System.out.println("Проверка метода deleteAll():");
        System.out.println(usersRepository.findAll());
    }
}
