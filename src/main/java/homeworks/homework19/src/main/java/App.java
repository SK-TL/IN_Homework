import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.innopolis.jpademo.repository.impl.UsersRepositoryImpl;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setURL("jdbc:postgresql://localhost:5432/Database1"); // Замените на свои параметры
        dataSource.setUser("postgres");       // Замените на свои параметры
        dataSource.setPassword("1234");   // Замените на свои параметры

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        UsersRepositoryImpl usersRepository = new UsersRepositoryImpl(jdbcTemplate);

        System.out.println("Проверка метода findAll():");
        usersRepository.findAll();

        System.out.println("Проверка метода findById():");
        usersRepository.findById(3L);

        System.out.println("Проверка метода findByDate():");
        LocalDate searchDate = LocalDate.of(2025, 04, 03);
        usersRepository.findByDate(searchDate);

        System.out.println("Проверка метода deleteAll():");
        usersRepository.deleteAll();
    }
}
