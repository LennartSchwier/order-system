package de.neuefische.ordersystem.model;

import de.neuefische.ordersystem.db.ProductDB;

import java.util.ArrayList;

public class Order {

    private ArrayList<Product> order = new ArrayList<>();
    private int orderId;
    public static int globalId;


    public Order() {
        globalId ++;
        orderId = globalId;
    }

    public void addProducts(Product product) {
        this.order.add(product);
    }

    public ArrayList<Product> getOrder() {
        return order;
    }

    public String list() {
        String result = "Order:\n";
        for (int i = 0; i < order.size(); i++) {
            result += "Name: " + order.get(i).getName() +"\n" +
                    "ID: " + order.get(i).getId() + "\n";
        }
        return result;
    }

    public int getOrderId() {
        return orderId;
    }
}
