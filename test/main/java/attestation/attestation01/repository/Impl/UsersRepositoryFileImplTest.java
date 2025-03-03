package main.java.attestation.attestation01.repository.Impl;

import main.java.attestation.attestation01.model.User;
import main.java.attestation.attestation01.repository.imp.UsersRepositoryFileImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
class UsersRepositoryFileImplTest {

    private final Path outputPath = Paths.get("src\\main\\java\\attestation\\attestation01\\resources\\output.txt");
    private static UsersRepositoryFileImpl usersRepository;
    User firstUser;
    User secondUser;

    @BeforeEach
    void setUp() throws IOException {
        usersRepository = new UsersRepositoryFileImpl();
        firstUser = new User (UUID.randomUUID().toString(), LocalDateTime.now(), "firstUserTest", "PasswordTest_1", "PasswordTest_1",
                "firstUserLastNameTest", "firstUserFirstNameTest", "firstUserMiddleNameTest", 30, true);
        usersRepository.create(firstUser);
        User secondUser = new User (UUID.randomUUID().toString(), LocalDateTime.now(), "secondUserTest", "PasswordTest_2", "PasswordTest_2",
                "secondUserLastNameTest", "secondUserFirstNameTest", "secondUserMiddleNameTest", 40, false);
        usersRepository.create(secondUser);
    }

    @AfterEach
    void AfterEach () {
        usersRepository.deleteAll();
    }

    @Test
    void create() throws IOException {
        User user = new User (UUID.randomUUID().toString(), LocalDateTime.now(), "LoginCreateTest", "PasswordCreateTest", "PasswordCreateTest",
                "LastNameCreateTest", "FirstNameCreateTest", "MiddleCreateNameTest", 50, true);
        usersRepository.create(user);
        List<String> lines = Files.readAllLines(outputPath);
        assertEquals(3, lines.size());
        assertTrue(lines.get(2).contains(user.getId()));
    }

    @Test
    void findById() {
        User foundUser = usersRepository.findById(firstUser.getId());
        assertEquals(firstUser.getId(), foundUser.getId());
    }

    @Test
    void findAll() {
        List<User> usersForFindALl = usersRepository.findAll();
        assertEquals(2, usersForFindALl.size());
        assertTrue(usersForFindALl.stream().anyMatch(e -> e.getId().equals(firstUser.getId())));
    }

    @Test
    void update() throws IOException {
        User user = new User ("someIDForUpdateTest_1", LocalDateTime.now(), "123123123", "PasswordUpdateTest", "PasswordUpdateTest",
                "LastNameUpdateTest", "FirstNameUpdateTest", "MiddleUpdateNameTest", 60, false);
        usersRepository.update(user);
        List<String> lines = Files.readAllLines(outputPath);
        assertTrue(lines.get(2).contains(user.getId()));
    }
}
