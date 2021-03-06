package de.neuefische.ordersystem.db;

import de.neuefische.ordersystem.model.Order;
import de.neuefische.ordersystem.model.Product;

import java.util.HashMap;

public class OrderDB {

    private HashMap<Integer, Order> orderDb = new HashMap<>();

    public HashMap<Integer,Order> getHashMap() {
        return orderDb;
    }

    public void addOrder(Order order) {
        orderDb.put(order.getOrderId(), order);
    }

    public Order getOrderById(int id) {
        return orderDb.get(id);
    }

    public String list() {
        String result = "Order DB:\n";
        for (Order order: orderDb.values()) {
            result += "Order ID: " + order.getOrderId() + "; Products: \n" +
                    order.list();
        }
        return result + "End of Order DB\n";
    }

}
