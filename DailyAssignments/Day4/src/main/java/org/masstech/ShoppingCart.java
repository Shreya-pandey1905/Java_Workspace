package org.masstech;

import java.util.List;
import java.util.ArrayList;


interface Products{

    String getProductName();

    double getPrice();

    String getCategory();

}

class Book implements Products{

    public String productName;
    public double productPricee;
    public String category;

    public Book (String productName,double productPricee){
            this.productName=productName;
            this.productPricee=productPricee;
            this.category="Book";
   }


    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public double getPrice() {
        return productPricee;
    }

    @Override
    public String getCategory() {
        return category;
    }
}
class Laptop implements Products {

    public String productName;
    public double productPricee;
    public String category;

    public Laptop(String productName, double productPricee) {
        this.productName = productName;
        this.productPricee = productPricee;
        this.category = "Laptop";
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public double getPrice() {
        return productPricee;
    }

    @Override
    public String getCategory() {
        return category;
    }
}
class MobilePhone implements Products {

    public String productName;
    public double productPricee;
    public String category;

    public MobilePhone(String productName, double productPricee) {
        this.productName = productName;
        this.productPricee = productPricee;
        this.category = "MobilePhone";
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public double getPrice() {
        return productPricee;
    }

    @Override
    public String getCategory() {
        return category;
    }
}



class CartService {

    List<Products> cart = new ArrayList<>();

    public void addProduct(Products pdt) {
        cart.add(pdt);
        System.out.println("product added successfully in thw cart");
    }

    public void removeProduct(String productName) {

        Products removeProduct = null;

        for (Products pdt : cart) {

            if (pdt.getProductName().equals(productName)) {
                removeProduct = pdt;
                break;
            }
        }


    }

    public void displayProducts() {

        for (Products pdt : cart) {

            System.out.println("Product name : " + pdt.getProductName() + " Product price : " + pdt.getPrice() + " Product category : " + pdt.getCategory());
        }
    }

    public double totalCartValue() {

        int totalValue = 1;

        for (Products pdt : cart) {
            totalValue *= pdt.getPrice();
        }

        return totalValue;
    }

    public void generateBill() {

              for (Products p : cart) {

            System.out.println("Product Name : " + p.getProductName()+ "Product category : " + p.getCategory()+ "Price : " + p.getPrice());
        }


        System.out.println("Total amount  : " + totalCartValue());
    }
}

public class ShoppingCart {
    public static void main(String[] args) {

        CartService cart = new CartService();

        Products book =  new Book("Deadly web", 300);


        Products laptop = new Laptop("HP Victus", 70000);


        Products mobile =new MobilePhone("Samsung", 30000);


//        cart.addProduct(book);
//        cart.addProduct(laptop);
//        cart.addProduct(mobile);
        cart.removeProduct("Samsung");

//        cart.displayProducts();
//
////        cart.generateBill();
    }
}