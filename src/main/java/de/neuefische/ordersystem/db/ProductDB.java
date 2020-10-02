package de.neuefische.ordersystem.db;

import de.neuefische.ordersystem.model.Product;

import java.util.HashMap;
import java.util.Objects;

public class ProductDB {

    private HashMap<Integer, Product>productDb = new HashMap<>();

    private Product product1 = new Product(1, "guitar");
    private Product product2 = new Product(2, "bike");
    private Product product3 = new Product(3, "aircraft");
    private Product product4 = new Product(4, "toilet paper");
    private Product product5 = new Product(5, "wifi cable");

    public ProductDB() {
        productDb.put(product1.getId(), product1);
        productDb.put(product2.getId(), product2);
        productDb.put(product3.getId(), product3);
        productDb.put(product4.getId(), product4);
        productDb.put(product5.getId(), product5);
    }


    public Product getProductById(int id) {
        return productDb.get(id);
    }


    public String list() {
        String result = "Product DB:\n";
        for (Product product: productDb.values()) {
            result += "Name: " + product.getName() +"\n" +
                    "ID: " + product.getId() + "\n";
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDB productDB = (ProductDB) o;
        return Objects.equals(productDb, productDB.productDb) &&
                Objects.equals(product1, productDB.product1) &&
                Objects.equals(product2, productDB.product2) &&
                Objects.equals(product3, productDB.product3) &&
                Objects.equals(product4, productDB.product4) &&
                Objects.equals(product5, productDB.product5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productDb, product1, product2, product3, product4, product5);
    }
}
