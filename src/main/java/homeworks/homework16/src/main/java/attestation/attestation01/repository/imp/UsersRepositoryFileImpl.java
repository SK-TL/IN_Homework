package attestation.attestation01.repository.imp;


import attestation.attestation01.model.User;
import attestation.attestation01.repository.UsersRepository;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class UsersRepositoryFileImpl implements UsersRepository {

    private static final List<User> USERS = new ArrayList<>();
    private static final String FILE_PATH = "src\\main\\java\\attestation\\attestation01\\resources\\output.txt";
    private static final Function<String, User> userMapper = User::fromString;


    public static void clearUsers() {
        synchronized (USERS) {
            USERS.clear();
        }
    }

    @Override
    public void create(User user) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))) {
            USERS.add(user);
            writeUsersToFile(USERS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findById(String id) {

        if (USERS.isEmpty()) {
            findAll();
        }
        return USERS.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Пользователь не найден!"));
    }

    @Override
    public List<User> findAll() {
        if (USERS.isEmpty()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
                List<User> usersFromFile = bufferedReader.lines()
                        .map(userMapper)
                        .toList();
                USERS.addAll(usersFromFile);
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла!" + e.getMessage());
                return Collections.emptyList();
            }
        }
        return USERS;
    }

    @Override
    public void update(User user) {
        if (USERS.isEmpty()) {
            findAll();
        }
        boolean found = false;
        for (int i = 0; i < USERS.size(); i++) {
            if (USERS.get(i).getId().equals(user.getId())) {
                USERS.set(i, user);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Пользователь с id " + user.getId() + " не найден, создаем нового пользователя!");
            create(user);
        } else {
            writeUsersToFile(USERS);
        }
    }

    @Override
    public void deleteById(String id) {
        boolean findId = USERS.removeIf(user -> user.getId().equals(id));
        if(!findId) {
            throw new NoSuchElementException("Пользователь не найден!");
        }
        writeUsersToFile(USERS);
    }

    @Override
    public void deleteAll() {
        USERS.clear();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bufferedWriter.write("");
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeUsersToFile(List<User> USERS) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : USERS) {
                writer.write(user.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
