package jm.task.core.jdbc.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "jpa_user";
    private static final String PWD = "jpa_pwd";
    private static final String DB_Driver = "com.mysql.cj.jdbc.Driver";

    private static Connection connection = null;

public static Connection getConnection() {
    if (connection == null) {
        try {
            Class.forName(DB_Driver).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(DB_URL, USER, PWD);
            System.out.println("Успешное соединение с БД");
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | NoSuchMethodException | SQLException e) {
            System.out.println("Ошибка при установке соединения с БД: " + e.getMessage());
        } catch (InvocationTargetException e) {
            System.out.println("Ошибка при создании драйвера: " + e.getCause().getMessage());
        }
    }
    return connection;
}
        public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Соединение закрыто");
            } else {
                System.out.println("Соединение не было установлено");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при закрытии соединения");
        }
    }
}
