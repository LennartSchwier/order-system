package de.neuefische.ordersystem;

import de.neuefische.ordersystem.db.OrderDB;
import de.neuefische.ordersystem.db.ProductDB;
import de.neuefische.ordersystem.model.Order;
import de.neuefische.ordersystem.model.Product;
import de.neuefische.ordersystem.OrderService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Test
    void testGenerateNewOrder() {
        // GIVEN
        ProductDB testProductDb = new ProductDB();
        OrderDB testOrderDb = new OrderDB();
        OrderService testService = new OrderService();
        ArrayList<Product> listOfProducts = new ArrayList<>(
                List.of(
                        testProductDb.getProductById(3),
                        testProductDb.getProductById(1),
                        testProductDb.getProductById(4)
                ));

        // WHEN
        testService.generateNewOrder(listOfProducts, testOrderDb);
        String result = testOrderDb.list();
        String expected = "Order DB:\n" +
                          "Order ID: 1; Products: \n" +
                          "Name: aircraft, Product ID: 3\n" +
                          "Name: guitar, Product ID: 1\n" +
                          "Name: toilet paper, Product ID: 4\n" +
                          "End of Order DB\n";

        // THEN
        assertEquals(expected, result);
    }

}