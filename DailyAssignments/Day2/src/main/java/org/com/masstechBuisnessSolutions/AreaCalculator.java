package org.com.masstechBuisnessSolutions;


 public class AreaCalculator {


    public double calculateArea(int side) {
        return side * side;
    }


    public double calculateArea(int length, int width) {
        return length * width;
    }


    public double calculateArea(double radius) {
        return 3.14 * radius * radius;
    }


    public double calculateArea(double base, double height) {
        return 0.5 * base * height;
    }



    public static void main(String[] args) {

        AreaCalculator obj = new AreaCalculator();

        double AreaOfSquare = obj.calculateArea(6);
        double AreaOfRectangle = obj.calculateArea(25, 4);
        double AreaOfCircle = obj.calculateArea(3);
        double AreaOfTriangle = obj.calculateArea(50, 6.0);

        System.out.println("Area of Square is " + AreaOfSquare);
        System.out.println("Area of Rectangle is " + AreaOfRectangle);
        System.out.println("Area of Circle is " + AreaOfCircle);
        System.out.println("Area of Triangle is " + AreaOfTriangle);

}
}