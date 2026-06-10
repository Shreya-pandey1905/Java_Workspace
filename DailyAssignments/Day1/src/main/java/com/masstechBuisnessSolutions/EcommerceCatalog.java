package com.masstechBuisnessSolutions;

import java.util.Objects;

class Products {
    int productId;
    String productName;
    double price;
    String category;

    public Products(int productId, String productName, double price, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;

    }

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return productId == products.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productId);
    }
}

public class EcommerceCatalog {

    public static void main(String[] args) {

        Products obj1 = new Products(1, "Chocolate",500, "Snacks");
        Products obj2 = new Products(1, "Chips",1000, "Snacks");
        Products obj3 = new Products(3, "Milk",200, "Grocery");
        Products obj4 = new Products(4, "Books",300, "Stationary");

        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);
        System.out.println(obj4);

        if (obj1.equals(obj2)){
            System.out.println("Products are same");
        }


    }


}
