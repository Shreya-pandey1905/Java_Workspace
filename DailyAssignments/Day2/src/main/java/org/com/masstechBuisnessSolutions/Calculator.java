package org.com.masstechBuisnessSolutions;

 class Calculator {


    public int additionOperation(int num1, int num2) {
        return num1 + num2;
    }


    public int additionOperation(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }

    public double additionOperation(double num1, double num2, double num3) {
        return num1 + num2 + num3;
    }

    public int multiplicationOperation(int num1, int num2) {
        return num1 * num2;
    }

    public int multiplicationOperation(int num1, int num2, int num3) {
        return num1 * num2 * num3;
    }

    public double multiplicationOperation(double num1, double num2, double num3) {
        return num1 * num2 * num3;
    }



    public static void main(String[] args) {
        Calculator calc = new Calculator();


        double add = calc.additionOperation(96, 20);
        double add2 = calc.additionOperation(10, 85, 30);
        double addDouble = calc.additionOperation(2, 56, 89.555);
        double multiply = calc.multiplicationOperation(96, 20);
        double multiply2 = calc.multiplicationOperation(2,2,2);
        double multiply3 = calc.multiplicationOperation(55.5,66.988,87.55);

        System.out.println("Sum of two integer numbers is " + add);
        System.out.println("Sum of three integere numbers is" + add2);
        System.out.println("Sum of three decimal numbers is" + addDouble);
        System.out.println("Multiplication of two integer numbers is " + multiply);
        System.out.println("Multiplication of three integer numbers is " + multiply2);
        System.out.println("Multiplication of three double numbers is " + multiply);
    }
}