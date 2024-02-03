package ru.polytech.labs.j130.lab2.task1;

import ru.polytech.labs.j130.lab2.task1.model.Product;

import java.sql.SQLException;
import java.util.List;

import static ru.polytech.labs.j130.lab2.task1.service.OrderService.readProducts;
import static ru.polytech.labs.j130.lab2.task1.service.OrderService.readProductsFromOrder;
import static ru.polytech.labs.j130.lab2.task1.service.OrderService.registerOrder;

public class OrderSystemMain {
    public static void main(String[] args) throws SQLException {
        System.out.println("List of Products:");
        for (Product p : readProducts()) {
            System.out.println(p);
        }

        List<Integer> orderIds = List.of(1, 3);
        System.out.println("Product Names in Orders with IDs 1 and 3:");
        for (Integer orderId : orderIds) {
            List<Product> productsInOrder = readProductsFromOrder(orderId);
            for (Product p : productsInOrder) {
                System.out.println(p);
            }
        }

        System.out.println("Registering a new order:");

        List<String> newOrderArticles = List.of("1234567", "7654321");
        List<Integer> newOrderStock = List.of(3, 5);

        registerOrder(
                "John Smith",
                "+7(123)456-78-99",
                null,
                "Площадь Ленина",
                newOrderArticles,
                newOrderStock
        );
        System.out.println("New order registered successfully.");
    }
}
