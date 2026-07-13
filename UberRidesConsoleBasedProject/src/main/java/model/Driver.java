package model;

import java.math.BigDecimal;

public class Driver {
    private long id;
    private String email;
    private String phone;
    private String vehicleNo;
    private String currentLocation;
    private boolean available;
    private BigDecimal rating;

    public Driver( long id,String name, String email, String phone, String vehicleNo, String currentLocation, boolean available, BigDecimal rating) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.vehicleNo = vehicleNo;
        this.currentLocation = currentLocation;
        this.available = available;
        this.rating = rating;
    }

    private String name;

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public BigDecimal getRating() {
        return rating;
    }






}
