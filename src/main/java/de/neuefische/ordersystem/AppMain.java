package de.neuefische.ordersystem;

import de.neuefische.ordersystem.db.OrderDB;
import de.neuefische.ordersystem.db.ProductDB;
import de.neuefische.ordersystem.model.Product;

import java.util.ArrayList;
import java.util.List;

public class AppMain {

    public static void main(String[] args) {

        final ProductDB productDb = new ProductDB();
        OrderDB orderDb = new OrderDB();
        OrderService orderService = new OrderService();

        listProducts(productDb);

        ArrayList<Product> firstOrder = new ArrayList<>(
                List.of(
                        productDb.getProductById(3),
                        productDb.getProductById(1),
                        productDb.getProductById(2)
                ));

        ArrayList<Product> secondOrder = new ArrayList<>(
                List.of(
                        productDb.getProductById(5),
                        productDb.getProductById(2),
                        productDb.getProductById(1)
                ));

        ArrayList<Product> thirdOrder = new ArrayList<>(
                List.of(
                        productDb.getProductById(2),
                        productDb.getProductById(5),
                        productDb.getProductById(4)
                ));

        orderService.generateNewOrder(firstOrder, orderDb);
        orderService.generateNewOrder(secondOrder, orderDb);
        orderService.generateNewOrder(thirdOrder, orderDb);

        System.out.println(orderService.listOrders(orderDb));
    }

    public static void listProducts(ProductDB productDB) {
        System.out.println(productDB.list());
    }


}
