package org.example;

public class DepartmentPrint {
    static void main() {
//        int deptId=2;
//
//        String dept= switch (deptId){
//            case 1 ->"Hr";
//            case 2 -> "IT";
//            case 3 -> "Accounts";
//            default -> "Invalid";
//        };
//
//        System.out.println(dept);
//
//        String day="Tuesday";
//        boolean weekday = switch (day){
//            case "Sunday","Saturday" -> false;
//            default -> true;
//
//        };
//        System.out.println(weekday);


//        String status = "Success";
//
//        String result =  switch (status){
//            case "Success" -> {
//                System.out.println("Transaction successful");
//                yield "Payment done";
//            }
//            case "Failure" -> {
//                System.out.println("Insufficinet balamce");
//                yield "Payment done";
//            }
//            default -> "Insufficient balance";
//        };
//        System.out.println(result);

        int httpstatus=200;

        String requesttype= switch(httpstatus){
            case 200 -> "success";
            case 400 -> "bad request";
            case 401 -> "unauthrised access";
            case 404 -> "not found";
            case 500 -> "server error";
            default -> "Invalid request";
        };
        System.out.println(requesttype);


    }
}
