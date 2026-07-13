package util;

import dao.AdminDao;
import dao.CustomerDao;
import dao.DriverDao;
import dao.RideDao;
import model.Customer;
import model.Driver;
import service.AuthService;
import service.RideService;

import java.sql.SQLException;
import java.util.Scanner;

public class StartupUtil {
   private final Scanner scanner = new Scanner(System.in);
    private final CustomerDao customerDao = new CustomerDao();
    private final DriverDao driverDao = new DriverDao();
    private final RideDao rideDao = new RideDao();
    private final AuthService authService = new AuthService(customerDao,driverDao,new AdminDao());
//    private final RideService rideService = new RideService(rideDao,driverDao);

    public void start(){
        while (true){
            System.out.println("Uber ride Appplication");
            System.out.println(" 1 for Customer Register");
            System.out.println(" 2 for Customer Login");
            System.out.println(" 3 for Driver Register");
            System.out.println(" 4 for Driver Login");
            System.out.println("5 Admin Login");
            System.out.println("0 for exit");

            int choice = readInt("Choose: ");

            try{
                switch (choice){
                    case 1 -> registerCustomer();
                    case 2 -> loginCustomer();
                }
            }
            catch (Exception exception){
                System.out.println("Error: "+ exception.getMessage());
            }


        }
    }

    private String readLine(String label){
        System.out.println(label);// Email: "jake.com"
        return scanner.nextLine();
    }

    private int readInt(String label){
        return Integer.parseInt(readLine(label));
    }

    private void registerCustomer() throws SQLException{
        Customer customer = authService.registerCustomer(
                readLine("Name: "),
                readLine("Email: "),
                readLine("Phone: "),
                readLine("Password: ")

        );
        System.out.println("Customer register with id: "+ customer.getId());

        }

        private void loginCustomer() throws  SQLException{
        Customer customer = authService.loginCustomer(
                readLine("Email: "),
                readLine("Password: ")
        );
            System.out.println("You are successfully loggedin :"+ customer.getId());
        }

        private void customerMenu(Customer customer) throws SQLException{
        while (true){
            System.out.println("Customer menu"+ customer.getName());
            System.out.println("1 for Book Ride");
            System.out.println("2 for Cancel Ride");
            System.out.println("3 for Ride History");
            System.out.println("0 for Logout");
            int choice = readInt("choose: ");

            switch (choice){
                case 1->
            }
        }
        }

    }


