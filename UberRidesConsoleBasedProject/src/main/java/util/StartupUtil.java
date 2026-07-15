package util;

import dao.AdminDao;
import dao.CustomerDao;
import dao.DriverDao;
import dao.RideDao;
import model.Admin;
import model.Customer;
import model.Driver;
import model.Ride;
import service.AuthService;
import service.RideService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartupUtil {
    private static final Logger logger = LoggerFactory .getLogger(StartupUtil.class);

    private final Scanner scanner = new Scanner(System.in);
    private final CustomerDao customerDao = new CustomerDao();
    private final DriverDao driverDao = new DriverDao();
    private final RideDao rideDao = new RideDao();
    private final AuthService authService = new AuthService(customerDao,driverDao,new AdminDao());
    private final RideService rideService = new RideService(rideDao,driverDao);

    public void start(){
        while (true){
            logger.info("Uber ride Appplication");
            logger.info(" 1 for Customer Register");
            logger.info(" 2 for Customer Login");
            logger.info(" 3 for Driver Register");
            logger.info(" 4 for Driver Login");
            logger.info (" 5 Admin Login");
            System.out.println(" 0 for exit");

            int choice = readInt("Choose: ");

            try{
                switch (choice){
                    case 1 -> registerCustomer();
                    case 2 -> loginCustomer();
                    case 3-> registerDriver();
                    case 4 -> loginDriver();
                    case 5 -> loginAdmin();

                    case 0 -> {
                        System.out.println("Thank you!");
                        return;
                    }
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

    private BigDecimal readDecimal(String label){
        System.out.print(label);
        BigDecimal value = scanner.nextBigDecimal();
        scanner.nextLine();
        return value;
    }

    private boolean readBoolean(String label){
       return Boolean.parseBoolean(readLine(label));
    }

    private int readInt(String label){
        return Integer.parseInt(readLine(label));
    }

    private long readLong(String label){
        return Long.parseLong(readLine(label));
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
            customerMenu(customer);
        }

    private void registerDriver() throws SQLException {

        Driver driver = authService.registerDriver(
                readLine("Name: "),
                readLine("Email: "),
                readLine("Phone: "),
                readLine("Password: "),
                readLine("Vehicle No: "),
                readLine("Current Location: "),
                readBoolean("Available (enter true or false ): "),
                readDecimal("Rating: ")
        );

        System.out.println("Driver register with id: "+ driver.getId());

    }

    private void loginDriver() throws  SQLException{
        Driver driver = authService.loginDriver(
                readLine("Email: "),
                readLine("Password: ")
        );
        System.out.println("You are successfully loggedin :"+ driver.getId());

        driverMenu(driver);
    }

    private void loginAdmin() throws SQLException {
        Admin admin = authService.loginAdmin(
                readLine("Email: "),
                readLine("Password: ")
        );

        if (admin == null) {
            System.out.println("Invalid email or password.");
            return;
        }

        System.out.println("You are successfully logged in: " + admin.getId());

    }

    private void printRides(List<Ride> rides){
        if (rides.isEmpty()){
            System.out.println("no rides found");
            return;
        }
        rides.forEach(ride -> System.out.printf(
                "Id=%d, Customer=%d,Driver=%s, From=%s, To=%s,Fare=%s,Status=%s,Requested=%s,Updated=%s%n",
                ride.getId(),ride.getCustomerId(),ride.getDriverId(),ride.getPickupLocation(),
                ride.getDropLocation(),ride.getFare(),ride.getStatus(),ride.getRequestedAt(),ride.getUpdatedAt()
        ));

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
                case 1 -> {
                    Ride ride = rideService.bookRide(
                            customer.getId(),
                            readLine("Pickup Location: "),
                            readLine("Drop Location: ")
                    );
                    System.out.println("Ride requested . Ride Id="+ ride.getId()+", Fare= " + ride.getFare());

                }
                case 2 ->{
                   long rideId = readLong("Ride id: ");
                    System.out.println(rideDao.cancelRide(rideId,customer.getId())
                    ? "Ride cancelled"
                    : "Only requested rides owned by you can be cacelled"   );

                }
                case 3-> {
                    printRides(rideDao.findByCustomerId(customer.getId()));
                }
                case 0-> {
                    return;
                }
                default -> System.out.println("Invalid option");

            }
        }
        }

        private void driverMenu(Driver signedInDriver) throws SQLException{
        while (true){
            Driver driver = driverDao.findByID(signedInDriver.getId());
            if (driver == null){
                System.out.println("Driver record not found . Logged Out!");
                return;
            }
            System.out.println("Driver Menu" + driver.getName());
            System.out.println("1. Update Availability");
            System.out.println("2. View Requeted Ride");
            System.out.println("3. Accept Ride");
            System.out.println("4. Complete Ride");
            System.out.println("5. My rides");
            System.out.println("0. Logout");
            int choice = readInt("Choose: ");

            switch (choice){
                case 1-> driverDao.updateAvailability(driver.getId(),
                        readBoolean("Available true/false"));
                case 2-> printRides(rideDao.findRequestedRides());
                case 3 -> {
                    long rideId = readLong("Ride id: ");
                    System.out.println(rideService.acceptRide(rideId,driver)
                    ? "Ride Accepted"
                            : "Ride no longer available"
                    );
                }
                case 4->{
                    long rideId = readLong("Ride id: ");
                    System.out.println(rideService.completeRide(rideId,driver.getId())
                    ? "Ride Completed"
                     : "Only acceped rides can be completed"
                    );
                }
                case 5-> printRides(rideDao.findByDriverId(driver.getId()));
                case 0-> {
                    return;
                }
                default -> System.out.println("Invalid Option");
            }
        }
        }

        private void adminMenu (Admin admin) throws SQLException{
        while (true){
            System.out.println("Admin Menu: " + admin.getName());
            System.out.println("1. View Customers");
            System.out.println("2. View Drivers");

            System.out.println("3. View Rides");
            System.out.println("0. Logout");
            int choice = readInt("Choose: ");
            switch (choice){
                case 1-> customerDao.findAll().forEach(customer -> System.out.printf(

                        "Id=%d,Name=%s,Email=%s,Phone=%s%n",
                        customer.getId(),customer.getName(),customer.getEmail(),customer.getPhone()
                        ));
                case 2-> driverDao.findAll().forEach(driver -> System.out.printf(

                        "Id=%d,Name=%s,Email=%s, Vehicle=%s, Location=%s, Available=%s, Rating=%s%n" ,
                                driver.getId(),driver.getName(),driver.getEmail(), driver.getVehicleNo(),
                        driver.getCurrentLocation(), driver.isAvailable(),driver.getRating()

                        ));
                case 3-> printRides(rideDao.findAll());
                case 0 ->{
                    return;
                }
                default -> System.out.println("Invalid option");
            }





        }
        }

    }


