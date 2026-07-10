package org.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.Scanner;

public class LoginValidation {
    public static void main(String[] args) throws Exception{

        Connection conn =   DBConnection.connection();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email");
        String  email = sc.nextLine();
        sc.nextLine();

        System.out.println("Enter your password");
        String password = sc.nextLine();

        CallableStatement cs = conn.prepareCall("{call checkUser(?,?,?)}");
        cs.setString(1,email);
        cs.setString(2,password);
        cs.registerOutParameter(3, Types.VARCHAR);

        cs.execute();
        boolean result =cs.getBoolean(3);

        if (result){
            System.out.println("Logged in");
        }
        else {
            System.out.println("Invalid Credentials");
        }


    }
}

