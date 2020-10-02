package de.neuefische.ordersystem.db;

import de.neuefische.ordersystem.model.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderDBTest {

    @Test
    void testAddOrders() {
        // GIVEN
        ProductDB testProductDb = new ProductDB();
        OrderDB testOrderDb = new OrderDB();
        Order testOrder1 = new Order();
        Order testOrder2 = new Order();
        Order testOrder3 = new Order();
        testOrder1.addProducts(testProductDb.getProductById(1));
        testOrder2.addProducts(testProductDb.getProductById(2));
        testOrder3.addProducts(testProductDb.getProductById(3));

        // WHEN
        testOrderDb.addOrder(testOrder1);
        testOrderDb.addOrder(testOrder2);
        testOrderDb.addOrder(testOrder3);

        // THEN
        assertEquals(3, testOrderDb.getHashMap().size());

    }


    @Test
    void testList() {
        // GIVEN
        ProductDB testProductDb = new ProductDB();
        OrderDB testOrderDb = new OrderDB();
        Order testOrder1 = new Order();
        Order testOrder2 = new Order();
        Order testOrder3 = new Order();
        testOrder1.addProducts(testProductDb.getProductById(1));
        testOrder2.addProducts(testProductDb.getProductById(2));
        testOrder3.addProducts(testProductDb.getProductById(3));

        // WHEN
        testOrderDb.addOrder(testOrder1);
        testOrderDb.addOrder(testOrder2);
        testOrderDb.addOrder(testOrder3);
        String result = testOrderDb.list();

        // THEN
        assertEquals("", result);


    }


}