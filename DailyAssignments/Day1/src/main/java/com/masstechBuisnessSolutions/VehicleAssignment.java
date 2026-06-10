package com.masstechBuisnessSolutions;

 class Vehicle {

    String vehicleNumber;
    String ownerName;
    double vehiclePrice;
    int manufacturingYear;

    public Vehicle(String vehicleNumber, String ownerName, double vehiclePrice, int manufacturingYear){
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehiclePrice = vehiclePrice;
        this.manufacturingYear = manufacturingYear;

    }

     public double calculateInsurancePremium() {
         return 0;
     }

     public double calculateRoadTax() {
         return 0;
     }
}

class Car extends Vehicle {
     int airbags;

    public Car(String vehicleNumber, String ownerName, double vehiclePrice, int manufacturingYear, int airbags ){
        super(vehicleNumber, ownerName, vehiclePrice, manufacturingYear);
        this.airbags = airbags;
    }


    @Override
    public double calculateRoadTax() {
        return vehiclePrice * 0.08;
    }

    @Override
    public double calculateInsurancePremium() {
        return vehiclePrice * 0.04;
    }



    public void displayInsuranceReport() {

        double insurancePremiumCar = calculateInsurancePremium();
        double roadTaxCar = calculateRoadTax();

        System.out.println("Insurance report details");
        System.out.println("Vehicle type: Car");
        System.out.println("Vehicle number= " + vehicleNumber);
        System.out.println("Owner Name is " + ownerName);
        System.out.println("Vehicle Price is " + vehiclePrice);
        System.out.println("Manufacturing Year :" + manufacturingYear);
        System.out.println("Airbags: " + airbags);


        System.out.println("Insurance Premium: " + insurancePremiumCar);
        System.out.println("Road Tax= " + roadTaxCar);
        System.out.println("Total Charges= " + (insurancePremiumCar + roadTaxCar));
    }


}

class Bike extends Vehicle {

    String color;

    public Bike(String vehicleNumber, String ownerName,double vehiclePrice, int manufacturingYear,String color) {

        super(vehicleNumber, ownerName, vehiclePrice, manufacturingYear);
        this.color = color;
    }

    @Override
    public double calculateInsurancePremium() {
        return vehiclePrice * 0.02;
    }

    @Override
    public double calculateRoadTax() {
        return vehiclePrice * 0.05;
    }

    public void displayInsuranceReport() {

        double insurancePremiumBike = calculateInsurancePremium();

        double roadTaxBike = calculateRoadTax();

        System.out.println("Insurance report details");
        System.out.println("Vehicle type: Bike");
        System.out.println("Vehicle number= " + vehicleNumber);
        System.out.println("Owner Name is " + ownerName);
        System.out.println("Vehicle Price is " + vehiclePrice);
        System.out.println("Manufacturing Year :" + manufacturingYear);
        System.out.println("Color: " + color);


        System.out.println("Insurance Premium: " + insurancePremiumBike);
        System.out.println("Road Tax= " + roadTaxBike);
        System.out.println("Total Charges= " + (insurancePremiumBike + roadTaxBike));
    }
}

class Truck extends Vehicle{

     int wheels;

    public Truck(String vehicleNumber, String ownerName,double vehiclePrice, int manufacturingYear,int wheels) {

        super(vehicleNumber, ownerName, vehiclePrice, manufacturingYear);
        this.wheels = wheels;
    }

    @Override
    public double calculateRoadTax() {
          return vehiclePrice * 0.1;
    }

    @Override
    public double calculateInsurancePremium() {
        return vehiclePrice * 0.06;
    }

    public void displayInsuranceReport() {

        double insurancePremiumTruck = calculateInsurancePremium();

        double roadTaxTruck = calculateRoadTax();

        System.out.println("Insurance report details");
        System.out.println("Vehicle type: Truck");
        System.out.println("Vehicle number= " + vehicleNumber);
        System.out.println("Owner Name is " + ownerName);
        System.out.println("Vehicle Price is " + vehiclePrice);
        System.out.println("Manufacturing Year :" + manufacturingYear);
        System.out.println("Wheels: " + wheels);


        System.out.println("Insurance Premium: " + insurancePremiumTruck);
        System.out.println("Road Tax= " + roadTaxTruck);
        System.out.println("Total Charges= " + (insurancePremiumTruck + roadTaxTruck));
    }
}

public class VehicleAssignment{
    public static void main(String[] args) {

//        Car car = new Car("MH98756","Jake Gyllenhaal",90000000,2026,15 );
//
//        car.displayInsuranceReport();

//        Bike bike = new Bike("MH78955","Chris Evans",8000000,2025,"Black");
//        bike.displayInsuranceReport();

        Truck truck = new Truck("MH56555","Walter White",8500000,2026,16);
        truck.displayInsuranceReport();

    }

}
