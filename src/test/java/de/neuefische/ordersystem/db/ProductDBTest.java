package de.neuefische.ordersystem.db;

import de.neuefische.ordersystem.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductDBTest {

    @Test
    void testList() {
        // GIVEN
        ProductDB testDb = new ProductDB();

        // WHEN
        String expected = "Product DB:\n" +
                          "Name: guitar\n" +
                          "ID: 1\n" +
                          "Name: bike\n" +
                          "ID: 2\n" +
                          "Name: aircraft\n" +
                          "ID: 3\n" +
                          "Name: toilet paper\n" +
                          "ID: 4\n" +
                          "Name: wifi cable\n" +
                          "ID: 5\n";
                String result = testDb.list();

        // THEN
        assertEquals(expected, result);
    }


    @Test
    void testGetProductById() {
        // GIVEN
        ProductDB testDb = new ProductDB();

        // WHEN
        Product expected = new Product(1, "guitar");
        Product result = testDb.getProductById(1);

        // THEN
        assertEquals(expected.getId(), result.getId());
    }
}