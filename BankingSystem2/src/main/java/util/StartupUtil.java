package util;

import dao.TransactionsDao;
import dao.UsersDao;
import model.Status;
import model.Transactions;
import model.Type;
import model.Users;
import service.AuthService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class StartupUtil {
    static Scanner scanner= new Scanner(System.in);
    AuthService authService = new AuthService();


    public static void start(){
        try {
            while (true){
                System.out.println("Welcome to out banking application");
                System.out.println("Press 1 for Sign Up");
                System.out.println("Press 2 for Sign In");
                System.out.println("Press 0 for Exit");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice){
                    case 1-> registerUser();
                    case 2 -> loginUser();
                }
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void UserMenu(Users users){

        try {
            while (true){

                System.out.println("You are logged in into the account");
                System.out.println("Press 1 for Deposit");
                System.out.println("press 2 for Withdraw");
                System.out.println("Press 3 for My profile");
                System.out.println("Press 4 for CheckBalance");
                System.out.println("Press 5 for Transaction History");
                System.out.println("Press 0 for logout");
                int choice = scanner.nextInt();

                switch (choice){

                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static String branch() {

        System.out.println("1. Andheri");
        System.out.println("2. Vasai");
        System.out.println("3. Churchgate");

        int choice = Integer.parseInt(scanner.nextLine());


        String br= switch (choice) {
            case 1 -> "Andheri";
            case 2 -> "Vasai";
            case 3 -> "Churchgate";
            default -> "Invalid choicee";
        };
        return  br;
    }

    private static void registerUser() throws SQLException {
        Random random = new Random();
        long AccountNo = random.nextLong(8788864);
        String name = readLine("Name: ");
        String email = readLine("Email: ");
        String password = readLine("Password: ");
        String bankBranch = branch();
        String ifsccode =ifsc(bankBranch);

        Users user = AuthService.registerUser(
              name,
                email,
                password,

                bankBranch,
                AccountNo,
                ifsccode);
        System.out.println("Customer register with id: "+ user.getId() );

    }

    public static String ifsc(String branch) {

        String ifscc= switch (branch) {
            case "Andheri" -> "ubin00122";
            case "Vasai" -> "ubin123";
            case "Churchgate" -> "ubin54555";
            default -> "Invalid choice";
        };
        return ifscc;
    }

    private static void loginUser() throws  SQLException{

        Users user = AuthService.loginUser(
                readLine("Email: "),
                readLine("Password: ")
        );
        System.out.println("You are successfully loggedin :"+ user.getId());
        UserMenu(user);
    }

    private static String readLine(String label){
        System.out.println(label);
        return scanner.nextLine();
    }

    private static void deposit(Users user) throws SQLException {

        double amount = Double.parseDouble(readLine("Enter amount : "));

        Users updatedUser = AuthService.deposit(amount, user.getId());

        Transactions transaction = new Transactions(
                updatedUser.getId(),
                Type.DEPOSIT,
                amount,
                updatedUser.getBalance(),
                Status.SUCCESSFUL,
                "Cash Deposit"
        );

        TransactionsDao.create(transaction);

        System.out.println("Deposit Successful");
        System.out.println("Current Balance : " + updatedUser.getBalance());
    }










}
