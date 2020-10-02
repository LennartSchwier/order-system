package de.neuefische.ordersystem.model;

import de.neuefische.ordersystem.db.ProductDB;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testAddProducts() {
        // GIVEN
        ProductDB testDb = new ProductDB();
        Order testOrder = new Order();

        // WHEN
        testOrder.addProducts(testDb.getProductById(3));
        testOrder.addProducts(testDb.getProductById(4));
        testOrder.addProducts(testDb.getProductById(1));
        testOrder.addProducts(testDb.getProductById(3));


        String expected = "Name: aircraft, Product ID: 3\n" +
                          "Name: toilet paper, Product ID: 4\n" +
                          "Name: guitar, Product ID: 1\n" +
                          "Name: aircraft, Product ID: 3\n";

        // THEN
        assertEquals(expected, testOrder.list());
    }

}