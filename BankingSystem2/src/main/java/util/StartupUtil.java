package util;

import config.DBConnection;
import dao.AuditDao;
import dao.TransactionsDao;
import dao.TransferDao;
import dao.UsersDao;
import model.*;
import service.AuthService;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static dao.UsersDao.map;

public class StartupUtil {
    static Scanner scanner= new Scanner(System.in);
    AuthService authService = new AuthService();

    private static String readLine(String label){
        System.out.println(label);
        return scanner.nextLine();
    }

    private static int readInt(String label) {
        System.out.print(label);
        return Integer.parseInt(scanner.nextLine());
    }

    private static double readDouble(String label) {
        System.out.print(label);
        return Double.parseDouble(scanner.nextLine());
    }

    private static long readLong(String label) {
        System.out.print(label);
        return Long.parseLong(scanner.nextLine());
    }

    public static void start(){
        try {
            while (true){
                System.out.println("Welcome to out banking application");
                System.out.println("Press 1 for Sign Up");
                System.out.println("Press 2 for Sign In");
                System.out.println("Press 3 for Log In for Admin");
                System.out.println("Press 0 for Exit");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice){
                    case 1-> registerUser();
                    case 2 -> loginUser();
                    case 3-> loginAdmin();
                    case 4 -> {
                        return;
                    }
                    case 5-> System.out.println("Invalid choice");
                }
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }



    private static void registerUser() throws SQLException {
        Random random = new Random();
        long AccountNo = random.nextLong(8788864);
        String name = readLine("Name: ");
        String email = readLine("Email: ");
        String password = readLine("Password: ");
        String bankBranch = branch();
        String ifsccode =ifsc(bankBranch);

        Users user = AuthService.registerUser(name,email,password,bankBranch,AccountNo,ifsccode);
        System.out.println("Customer register with id: "+ user.getId() );
        AuditDao.create(user.getEmail(),"user signup","New user created");
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

    public static String ifsc(String branch) {

        String ifscc= switch (branch) {
            case "Andheri" -> "ubin00122";
            case "Vasai" -> "ubin123";
            case "Churchgate" -> "ubin54555";
            default -> "Invalid choice";
        };
        return ifscc;
    }

    private static void loginUser() throws SQLException {

        String email = readLine("Email: ");

        Users existingUser = UsersDao.findByEmail(email);

        if (existingUser != null && existingUser.isUserLock()) {
            System.out.println("Your account is locked");
        }else {
            String password = readLine("Password: ");

            Users user = AuthService.loginUser(email, password);
            if (user == null) {
                System.out.println("Invalid user credentials...");
                AuditDao.create(email, "failed login", "User login failed");
            } else {
                System.out.println("You are successfully logged in: " + user.getId());
                AuditDao.create(user.getEmail(), "user login", "User logged in");
                UserMenu(user);
            }
        }

    }
    private static void loginAdmin() throws SQLException {


        Users admin = AuthService.loginAdmin(
                readLine("Email : "),
                readLine("Password : ")
        );
        if (admin == null) {
            System.out.println("Invalid admin credentials....");
        }else {
            AdminMenu(admin);

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
                System.out.println("Press 6 for Transfer Money");
                System.out.println("Press 7 for mini statement");
                System.out.println("Press 8 for resetPassword");
                System.out.println("Press 9 for ManageBeneficiaries");
                System.out.println("Press 10 for auditLogs");


                System.out.println("Press 0 for logout");
                int choice = readInt("Choice: ");

                switch (choice){
                    case 1->deposit(users);
                    case 2-> withdraw(users);
                    case 3-> viewProfile(users);
                    case 4 -> checkbalance(users);
                    case 5 -> transactionHistory(users);
                    case 6 -> transferredMoney(users);
                    case 7 -> miniSttatement(users);
                    case 8 -> resetpassword(users);
                    case 9 -> manageBeneficiary(users);
                    case 10 -> viewAudit(users);
                    case 0 -> {
                        return;
                    }
                    default -> System.out.println("Invalid Option");



                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static void AdminMenu(Users users){

        try {
            while (true){

                System.out.println("You are logged in into the account");
                System.out.println("Press 1 for view all Users");
                System.out.println("press 2 for view all transactions ");
                System.out.println("press 3. view all failed transaction");
                System.out.println("press 4. view highest balance user");
                System.out.println("press 5. view transactions between selected dates");
                System.out.println("press 6. view audit logs");
                System.out.println("Press 7 for Unlock User");
                System.out.println("Press 0 for logout");
                int choice = readInt("Choice: ");

                switch (choice){
                    case 1->viewUsers();
                    case 2-> viewAllTransactions();
                    case 3-> viewAllFailTransaction();
                    case 4-> highestBalanceUser();
                    case 5 ->transactionBetweenDate();
                    case 6-> viewAllAudits(users);
                    case 7 -> unlockUser();
                    case 0 -> {
                        return;
                    }
                    default -> System.out.println("Invalid Option");



                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void deposit(Users user) throws SQLException {

        double amount = readDouble("Enter amount: ");
        AuthService.deposit(amount, user.getId());

        Transactions transaction = new Transactions(
                user.getId(),
                Type.DEPOSIT,
                amount,
                user.getBalance(),
                Status.SUCCESSFUL,
                "Deposit"
        );

        TransactionsDao.create(transaction);
        AuditDao.create(user.getEmail(),"Deposit","Amount Deposited");


        System.out.println("Deposit Successful....");
    }
    private static void withdraw(Users user) throws SQLException {

        double amount = readDouble("Enter amount : ");

        if (amount>0){
            Users sender = UsersDao.findByID(user.getId());

            if (amount <= sender.getBalance()){
                boolean isWithdraw= AuthService.withdraw(amount, user.getId());
                if (isWithdraw){
                    Users updatedUser = UsersDao.findByID(user.getId());

                    Transactions transaction = new Transactions(
                            user.getId(),
                            Type.WITHDRAW,
                            amount,
                            updatedUser.getBalance(),
                            Status.SUCCESSFUL,
                            "Withdraw"
                    );
                    TransactionsDao.create(transaction);
                    AuditDao.create(user.getEmail(),"WithDraw Successful","Amount Withdrawn");
                    System.out.println("Withdrawl successfull...");
                    System.out.println("Your existing Balance : " + updatedUser.getBalance());

                }else {
                    Transactions transaction = new Transactions(
                            user.getId(),
                            Type.WITHDRAW,
                            amount,
                            user.getBalance(),
                            Status.FAILED,
                            "Withdrawal Failed"
                    );

                    TransactionsDao.create(transaction);
                    AuditDao.create(user.getEmail(),"WithDraw Failed","Amount Withdrawn failed");

                }
            }else {
                System.out.println("Insufficient balance...");
            }
        }else {
            System.out.println("Enter valid amoutn");
        }
    }
    private static void viewProfile(Users user) {

        System.out.println("Id :" + user.getId());
        System.out.println("Name :" + user.getName());
        System.out.println("Email :" + user.getEmail());
        System.out.println("Account number :" + user.getAccount_no());
        System.out.println("IFSC :" + user.getIfsc());
        System.out.println("Branch :" + user.getBranch());
        System.out.println("Role :" + user.getRole());
        System.out.println("Balance :" + user.getBalance());
    }
    private static void checkbalance(Users user) throws SQLException {
        System.out.println("Balance :" + AuthService.checkBalance(user.getId()));

    }
    private static void transactionHistory(Users user) throws SQLException {

        List<Transactions> transactions =
                AuthService.transactionHistory(user.getId());

        for (Transactions transaction : transactions) {
            System.out.println("Type : " + transaction.getType());
            System.out.println("Amount : " + transaction.getAmount());
            System.out.println("Status : " + transaction.getStatus());
            System.out.println("Reason : " + transaction.getReason());
        }
    }



    private static void viewUsers() throws SQLException {

        AuthService.findAllUsers().forEach(user ->
                System.out.printf(
                        "Id=%d, Name=%s, Email=%s, Account No=%d, Branch=%s, IFSC=%s, Balance=%.2f%n",
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getAccount_no(),
                        user.getBranch(),
                        user.getIfsc(),
                        user.getBalance()
                )
        );
    }
    private static void viewAllTransactions() throws SQLException {

        AuthService.findTransactions().forEach(transaction ->
                System.out.printf(
                        "User Id=%d, Type=%s, Amount=%.2f, Balance After=%.2f, Status=%s, Reason=%s%n",
                        transaction.getUser_id(),
                        transaction.getType(),
                        transaction.getAmount(),
                        transaction.getBalance_after(),
                        transaction.getStatus(),
                        transaction.getReason()
                )
        );
    }
    private static void viewAllFailTransaction() throws SQLException{
        AuthService.AllfailTransaction().forEach(transaction ->
                System.out.printf(
                        "User Id=%d, Type=%s, Amount=%.2f, Balance After=%.2f, Status=%s, Reason=%s%n",
                        transaction.getUser_id(),
                        transaction.getType(),
                        transaction.getAmount(),
                        transaction.getBalance_after(),
                        transaction.getStatus(),
                        transaction.getReason()
                )
        );
    }
    private static void highestBalanceUser() throws SQLException {
        AuthService.highestBalanceUser().forEach(user ->
                System.out.printf(
                        "Id=%d, Name=%s, Email=%s, Account No=%d, IFSC=%s,Branch=%s,  Balance=%.2f%n",
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getAccount_no(),
                        user.getIfsc(),
                        user.getBranch(),
                        user.getBalance()
                )
        );
    }
    private static void transactionBetweenDate() throws SQLException{
        AuthService.transactionBetweenDate(readLine("enter start date"),readLine("enter end date")).forEach(transaction ->
                System.out.printf(
                        "User Id=%d, Type=%s, Amount=%.2f, Balance After=%.2f, Status=%s, Reason=%s%n",
                        transaction.getUser_id(),
                        transaction.getType(),
                        transaction.getAmount(),
                        transaction.getBalance_after(),
                        transaction.getStatus(),
                        transaction.getReason()
                )
        );
    }
    private static void transferredMoney(Users user) throws SQLException {
        long senderAcc = readLong("Enter the account you want to transfer money from: ");

        if (senderAcc != user.getAccount_no()) {
            System.out.println("account not found!");
        }else{

            long receiverAcc = readLong("Enter the account you want to transfer money to: ");
            Users receiver = UsersDao.findByAccountNo(receiverAcc);

            if (receiver == null) {

                System.out.println("receiver account not found!");

            } else {
                double amount = readDouble("Enter amount to transfer: ");

                if (amount> 0) {
                    if (amount <= user.getBalance()) {

                        AuthService.withdraw(amount, user.getId());
                        AuthService.deposit(amount, receiver.getId());
                        AuthService.createTransfer(senderAcc, receiverAcc, Status.TRANSFERRED);
                        System.out.println("Transfer Successful.");

                        Transactions senderTransaction = new Transactions(user.getId(),Type.WITHDRAW,
                                amount,
                                user.getBalance() - amount,
                                Status.SUCCESSFUL,
                                "Transferred to account: " + receiverAcc
                        );

                        TransactionsDao.create(senderTransaction);

                        AuditDao.create(user.getEmail(),"Transferred","Amount Transferred");


                        Transactions receiverTransaction = new Transactions(
                                receiver.getId(),
                                Type.DEPOSIT,
                                amount,
                                receiver.getBalance() + amount,
                                Status.SUCCESSFUL,
                                "Received from accont :" + senderAcc
                        );

                        TransactionsDao.create(receiverTransaction);
                        AuditDao.create(receiver.getEmail(),"Credit","Amount Credited");


                    }else {
                        System.out.println("Insufficient balance...");
                        Transactions senderTransaction = new Transactions(user.getId(),Type.WITHDRAW,
                                amount,
                                user.getBalance() - amount,
                                Status.FAILED,
                                "Transferred failed.. " + receiverAcc
                        );

                        TransactionsDao.create(senderTransaction);
                        AuditDao.create(user.getEmail(),"Transfer","Transfer Failed");

                    }
                }else {
                    System.out.print("Invalid amount");
                }

            }

        }


    }
    private static void miniSttatement(Users user) throws SQLException {

        System.out.println("on what basis you want miniStatments");
        System.out.println("press 1. DEPOSIT");
        System.out.println("press 2. WITHDRAW");
        int statechoice =readInt("Choice: ");

        List<Transactions> transactions = AuthService.miniStatement(user.getId(),statechoice);

        if (transactions.isEmpty()) {
            System.out.println("No transactions are done yet");
        }else {
            for (Transactions transaction : transactions) {
                System.out.println("Type : " + transaction.getType());
                System.out.println("Amount : " + transaction.getAmount());
                System.out.println("balance : " + transaction.getBalance_after());
                System.out.println("Status : " + transaction.getStatus());
            }
        }


    }
    private static void resetpassword(Users user) throws SQLException {

        String oldPassword = readLine("Enter your current password: ");
        boolean verify= AuthService.verifyPassword(user.getId(),oldPassword);
        if (verify) {
            String newPassword = readLine("Enter new password (with at least one uppercase,one digits,and minimum 8 characters): ");

            boolean isUpper = false;
            boolean islower = false;
            boolean isDigit = false;

            for (char ch : newPassword.toCharArray()) {

                if (Character.isUpperCase(ch)){
                    isUpper = true;
                }
                if (Character.isLowerCase(ch)) {
                    islower = true;
                }
                if (Character.isDigit(ch)){
                    isDigit=true;
                }
            }

            if (newPassword.length() >= 8 && isUpper && islower && isDigit) {
                AuthService.resetPassword(user.getId(), newPassword);
                System.out.println("password changed successfully....");
                AuditDao.create(user.getEmail(),"Password Changed","Password changed successfully");


            } else {
                System.out.println("password validation failed.");
                AuditDao.create(user.getEmail(),"Password Reset Faileed","Password changed Failed");

            }

        }

    }


    private static void unlockUser() throws SQLException {

        int id = readInt("Enter User ID: ");

        AuthService.unlockUser(id);

        System.out.println("User unlocked successfully.");
    }


    private static void manageBeneficiary(Users users) throws SQLException {
            System.out.println("1. Add Beneficiary");
            System.out.println("2. Update Beneficiary based on id");
            System.out.println("3. Delete Beneficiary");
            System.out.println("4. View Beneficiary");
            System.out.println("5. Exit");
            int choice =readInt("Choice: ");
            switch (choice){
                case 1-> addBeneficiary(users);
                case 2 -> updateBeneficiary(users);
                case 3 -> deleteBeneficiary(users);
                case 4 -> viewBeneficiary(users);
                case 5-> {
                    return;
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    private static void addBeneficiary(Users users) throws SQLException {
        String name = readLine("Name: ");
        long acc = readLong("Account_no: ");
        String ifsc = readLine("IFSC Code: ");
        String nickname = readLine("Nickname: ");

    Beneficiary beneficiary=  AuthService.createBeneficiary(name,acc,ifsc,nickname,users.getId());
        if (beneficiary != null) {
            System.out.println("Beneficiary created successfully...");
        }
    }
    private static void updateBeneficiary (Users users) throws SQLException {
        int beneficiaryId= readInt("Enter beneficiary ID which is to be updated: ");

       Beneficiary checkbeneficiary = AuthService.findbeneficiary(beneficiaryId, users.getId());

        if (checkbeneficiary != null) {
            String name = readLine("Name: ");
            long acc = readLong("Account_no: ");
            String ifsc = readLine("IFSC Code: ");
            String nickname = readLine("Nickname: ");

            Beneficiary beneficiary= new Beneficiary(beneficiaryId,name,acc,ifsc,nickname,users.getId());
         AuthService.updateBeneficiary(beneficiary);
            System.out.println("Beneficiary updated successfully...");
        }else {
            System.out.println("Beneficiary not found....");

        }



    }
    private static void deleteBeneficiary(Users users) throws SQLException {
        int beneficiaryId= readInt("Enter beneficiary ID which is to be deleted: ");

        Beneficiary checkbeneficiary = AuthService.findbeneficiary(beneficiaryId, users.getId());
        if (checkbeneficiary != null){
            AuthService.deleteBeneficiary(beneficiaryId, users.getId());
            System.out.println("Beneficiary deleted successfully...");
         }else {
            System.out.println("Beneficiary not found");
        }

    }
    private static void viewBeneficiary(Users users) throws SQLException {
        List<Beneficiary> beneficiaries = AuthService.viewBeneficiary(users.getId());

        if (beneficiaries.isEmpty()) {
            System.out.println("Beneficiaries not found");
        } else {

            for (Beneficiary beneficiary : beneficiaries) {
                System.out.println("Id  : " + beneficiary.id());
                System.out.println("Name : " + beneficiary.name());
                System.out.println("Account.no : " + beneficiary.account_no());
                System.out.println("IFSC : " + beneficiary.ifsc());
                System.out.println("Nicknmae :" + beneficiary.nickname());
            }
        }
    }


    private static void viewAudit(Users users) throws SQLException {
        List<AuditLogs> audits = AuthService.viewAuditByUsers(users.getEmail());

        for (AuditLogs auditLogs : audits) {
            System.out.println("Id  : " + auditLogs.id());
            System.out.println("Email : " + auditLogs.email());
            System.out.println("Action : " + auditLogs.action());
            System.out.println("Description : " + auditLogs.description());

        }

        }
    private static void viewAllAudits (Users users) throws SQLException {

            List<AuditLogs> audits = AuthService.viewAllAudits();

            if (audits.isEmpty()) {
                System.out.println("No audit logs found.");
            }else {
                for (AuditLogs audit : audits) {
                    System.out.printf(
                            "Id=%d, Email=%s, Action=%s, Description=%s%n",
                            audit.id(),
                            audit.email(),
                            audit.action(),
                            audit.description()
                    );

                }
            }


    }
    }






