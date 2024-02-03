package ru.polytech.labs.j130.lab2.task1.service;

import ru.polytech.labs.j130.lab2.task1.ConnectionManager;
import ru.polytech.labs.j130.lab2.task1.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    /**
     * Метод для вывода на экран списка продуктов
     *
     * @return список продуктов
     */
    public static List<Product> readProducts() throws SQLException {
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT ARTICLE, PRODUCT_NAME, COLOR, PRICE, STOCK FROM PRODUCTS")) {
            return readProductsFromResultSet(rs);
        }
    }

    /**
     * Метод для чтения списка продуктов из заказа с заданным id
     *
     * @param orderId id заказа
     * @return список продуктов из заказа
     */
    public static List<Product> readProductsFromOrder(int orderId) throws SQLException {
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT ARTICLE, PRODUCT_NAME, COLOR, PRICE, STOCK FROM PRODUCTS WHERE ARTICLE IN (SELECT ARTICLE FROM ORDER_POSITIONS WHERE ORDER_ID = ?)")) {
            pstmt.setInt(1, orderId);
            try (ResultSet rs = pstmt.executeQuery()) {
                return readProductsFromResultSet(rs);
            }
        }
    }

    /**
     * Метод для регистрации нового заказа
     *
     * @param customerName    ФИО заказчика
     * @param contactPhone    контактный телефон
     * @param emailAddress    адрес эл. почты
     * @param deliveryAddress адрес доставки
     * @param articles        артикулы товаров в заказе
     * @param stock           количество товара для каждой позиции заказа
     */
    public static void registerOrder(String customerName,
                                     String contactPhone,
                                     String emailAddress,
                                     String deliveryAddress,
                                     List<String> articles,
                                     List<Integer> stock) throws SQLException {
        if (articles.size() != stock.size())
            throw new IllegalArgumentException("articles and stock must have the same length");

        if (articles.isEmpty())
            throw new IllegalArgumentException("order details must be provided");

        try (Connection conn = ConnectionManager.getConnection()) {
            int orderId;
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT COALESCE(MAX(ORDER_ID), 0) FROM ORDERS")) {
                rs.next();
                orderId = rs.getInt(1) + 1;
            }

            try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ORDERS (ORDER_ID, CREATION_DATE, CUSTOMER_NAME, CONTACT_PHONE, EMAIL_ADDRESS, DELIVERY_ADDRESS, ORDER_STATUS) VALUES (?, CURRENT_DATE, ?, ?, ?, ?, 'P')")) {
                pstmt.setInt(1, orderId);
                pstmt.setString(2, customerName);
                pstmt.setString(3, contactPhone);
                pstmt.setString(4, emailAddress);
                pstmt.setString(5, deliveryAddress);

                pstmt.executeUpdate();
            }

            try (PreparedStatement priceStmt = conn.prepareStatement("SELECT PRICE FROM PRODUCTS WHERE ARTICLE = ?");
                 PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO ORDER_POSITIONS (ORDER_ID, ARTICLE, PRICE, QUANTITY) VALUES (?, ?, ?, ?)")) {
                insertStmt.setInt(1, orderId);

                for (int i = 0; i < articles.size(); i++) {
                    priceStmt.setString(1, articles.get(i));
                    int price;
                    try (ResultSet rs = priceStmt.executeQuery()) {
                        rs.next();
                        price = rs.getInt(1);
                    }

                    insertStmt.setString(2, articles.get(i));
                    insertStmt.setInt(3, price);
                    insertStmt.setInt(4, stock.get(i));

                    insertStmt.addBatch();
                }

                insertStmt.executeBatch();
            }
        }
    }

    /**
     * Метод для чтения списка продуктов из ResultSet
     *
     * @param rs ResultSet с данными из базы данных
     * @return список продуктов
     */
    private static List<Product> readProductsFromResultSet(ResultSet rs) throws SQLException {
        List<Product> res = new ArrayList<>();
        while (rs.next()) {
            Product p = new Product(
                    rs.getInt("article"),
                    rs.getString("product_name"),
                    rs.getString("color"),
                    rs.getInt("price"),
                    rs.getInt("stock")
            );
            res.add(p);
        }
        return res;
    }
}
