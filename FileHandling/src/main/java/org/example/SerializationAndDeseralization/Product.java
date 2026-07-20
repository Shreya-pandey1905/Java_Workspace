package org.example.SerializationAndDeseralization;

import java.io.Serializable;

public class Product implements Serializable {
    int id;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", password='" + password + '\'' +
                '}';
    }

    String name;
    int qty;
    double price;
    transient String password;

    public Product(int id, String name, int qty, double price, String password) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.password = password;
    }


}
