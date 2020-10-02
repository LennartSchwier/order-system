package de.neuefische.ordersystem;

import de.neuefische.ordersystem.db.OrderDB;
import de.neuefische.ordersystem.model.Order;
import de.neuefische.ordersystem.model.Product;

import java.util.ArrayList;

public class OrderService {

    public void generateNewOrder(ArrayList<Product> products, OrderDB orderDb) {
        Order newOrder = new Order();
        for (Product product: products) {
            if (product.getName().isEmpty()){
                System.out.println("Failure");
            } else{
                newOrder.addProducts(product);
            }
        }
        orderDb.addOrder(newOrder);
    }

    public String listOrders(OrderDB orderDB) {
        return orderDB.list();
    }
}
