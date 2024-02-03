package ru.polytech.labs.j130.lab2.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_db_name";

    private static final String USERNAME = "your_db_username";

    private static final String PASSWORD = "your_db_password";

    /**
     * Метод для получения соединения с базой данных
     *
     * @return соединение с базой данных
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}
