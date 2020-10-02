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
        testOrder1.addProducts(testProductDb.getProductById(2));
        testOrder1.addProducts(testProductDb.getProductById(4));
        testOrder2.addProducts(testProductDb.getProductById(2));
        testOrder2.addProducts(testProductDb.getProductById(5));
        testOrder2.addProducts(testProductDb.getProductById(5));
        testOrder3.addProducts(testProductDb.getProductById(3));
        testOrder3.addProducts(testProductDb.getProductById(3));
        testOrder3.addProducts(testProductDb.getProductById(3));


        // WHEN
        testOrderDb.addOrder(testOrder1);
        testOrderDb.addOrder(testOrder2);
        testOrderDb.addOrder(testOrder3);
        String result = testOrderDb.list();
        String expected = "Order DB:\n" +
        "Order ID: 1; Products: \n" +
        "Name: guitar, Product ID: 1\n" +
        "Name: bike, Product ID: 2\n" +
        "Name: toilet paper, Product ID: 4\n" +
        "Order ID: 2; Products: \n" +
        "Name: bike, Product ID: 2\n" +
        "Name: wifi cable, Product ID: 5\n" +
        "Name: wifi cable, Product ID: 5\n" +
        "Order ID: 3; Products: \n" +
        "Name: aircraft, Product ID: 3\n" +
        "Name: aircraft, Product ID: 3\n" +
        "Name: aircraft, Product ID: 3\n" +
        "End of Order DB\n";

        // THEN
        assertEquals(expected, result);


    }


}