package ru.innopolis.jpademo.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.jpademo.model.Order;
import ru.innopolis.jpademo.model.User;
import ru.innopolis.jpademo.repository.UsersRepository;

import java.time.LocalDate;
import java.util.List;

public class UsersRepositoryImpl implements UsersRepository {

    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void findAll() {
        List<User> users = jdbcTemplate.query("SELECT * FROM users", rowMapper());

        if (users != null && !users.isEmpty()) {
            for (User user : users) {
                System.out.println(user);
            }
        } else {
            System.out.println("No users found.");
        }
    }

    @Override
    public User findById(Long id) {
        User user = jdbcTemplate
                .queryForObject("SELECT * FROM users u WHERE u.id = " + id, rowMapper());
        if (user != null) {
            System.out.println("User found with ID " + id + ": " + user);
            return user;
        } else {
            System.out.println("User with ID " + id + " not found.");
            return null;
        }
    }

    @Override
    public List<Order> findByDate(LocalDate date) {
        String sql = "SELECT * FROM orders u WHERE u.order_date = ?";
        List<Order> orders = jdbcTemplate
                .query(sql, new Object[]{date}, rowMapper1());

        if (orders != null && !orders.isEmpty()) {
            System.out.println("Orders found for date: " + date);
            for (Order order : orders) {
                System.out.println(order);
            }
        } else {
            System.out.println("No orders found for date: " + orders);
        }
        return orders;
    }

    @Override
    public void deleteAll() {
        jdbcTemplate
                .execute("DELETE FROM users");
    }

    private RowMapper<User> rowMapper() {
        return (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setFirst_name_last_name(rs.getString("first_name_last_name"));
            return user;
        };
    }

    private RowMapper<Order> rowMapper1() {
        return (rs, rowNum) -> {
            Order order = new Order();
            order.setId(rs.getLong("id"));
            order.setDateTime(rs.getDate("order_date").toLocalDate());
            order.setCount(rs.getLong("count_of_orders"));
            order.setDiscount(rs.getLong("discount"));
            return order;
        };
    }
}
