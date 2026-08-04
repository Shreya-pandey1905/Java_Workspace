package org.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
    private boolean isOpen;
    private LocalDate date;
    @Lob
    private byte[] image;

    @Transient
    private double x;



    public Address( String street, String city,boolean isOpen, LocalDate date, byte[] image, double x) {
        this.isOpen = isOpen;
        this.id = id;
        this.street = street;
        this.city = city;
        this.date = date;
        this.image = image;
        this.x = x;
    }


    public  Address(){

    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



}
