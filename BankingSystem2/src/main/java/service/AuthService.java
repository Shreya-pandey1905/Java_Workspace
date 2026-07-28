package service;

import dao.*;
import model.*;
import util.PasswordHash;

import java.sql.SQLException;
import java.util.List;

public class AuthService
{

    public static Users registerUser(String name, String email, String password, String branch, long AccountNo, String ifsccode) throws SQLException {
        return UsersDao.create(name,email,PasswordHash.hash(password),AccountNo, ifsccode, branch);

    }

//    public static Users loginUser(String email,String password) throws SQLException{
//        return UsersDao.findbyEmailAndPassword(email,PasswordHash.hash(password));
//
//    }

    public static Users loginUser(String email, String password) throws SQLException {

        Users existingUser = UsersDao.findByEmail(email);

        if (existingUser != null) {
            if (existingUser.isUserLock()) {
                System.out.println("Your account is locked. Please contact the admin.");

           }else {
              Users user = UsersDao.findbyEmailAndPassword(email,PasswordHash.hash(password));

                if (user != null) {
                    UsersDao.resetAttempts(user.getId());
                    return user;
                }
                UsersDao.incrAttempts(existingUser.getId());

                Users updatedUser = UsersDao.findByEmail(email);

                if (updatedUser.getAttempts() >= 3) {
                    UsersDao.lockUser(updatedUser.getId());
                    System.out.println("Your account has been locked after 3 failed login attempts....");
                }

            }
        }

        return null;
    }

    public static Users loginAdmin(String email, String password) throws SQLException {

        return AdminDao.login(email, PasswordHash.hash(password));
    }

    public static boolean deposit(double amount, int id) throws SQLException {
        return TransactionsDao.deposit(amount,id);

    }

    public static boolean withdraw(double amount, int id) throws SQLException {
        return TransactionsDao.withdraw(amount, id);
    }

    public static List<Transactions> transactionHistory(int id) throws SQLException {
        return TransactionsDao.transactionHistory(id);
    }

    public static List<Transactions> miniStatement(int id,int statechoice)   throws SQLException {
        String type;
        if (statechoice == 1) {
            type = Type.DEPOSIT.name();
        } else if (statechoice == 2) {
            type = Type.WITHDRAW.name();
        } else {
            System.out.println("invalid input");
            return null;
        }
        return TransactionsDao.miniStatement(id,type);
    }


       public static List<Users> findAllUsers() throws SQLException {
        return AdminDao.findAllUsers();
    }

    public static List<Transactions> findTransactions() throws SQLException {
        return AdminDao.findAllTransactions();
    }

    public static double checkBalance (int id) throws SQLException {
        return UsersDao.getBalance(id);
    }

    public static Transfer createTransfer(long sender_acc, long receiver_acc, Status status) throws SQLException {
        return TransferDao.create(sender_acc,receiver_acc,status);
    }

//    public static void userLock(int id) throws SQLException {
//         UsersDao.lockUser(id);
//    }
    public static void unlockUser(int id) throws SQLException {
        AdminDao.unlockUserr(id);
        UsersDao.resetAttempts(id);
    }

    public static boolean verifyPassword(int id,String password)throws SQLException{
        return UsersDao.verifyPassword(id,PasswordHash.hash(password));
    }
    public static boolean resetPassword(int id,String password)throws SQLException{
        return UsersDao.changePassword(PasswordHash.hash(password),id);
    }

    public static List<Users> highestBalanceUser() throws SQLException {
        return AdminDao.highestBalanceUser();
    }

    public static List<Transactions> transactionBetweenDate(String start,String end) throws SQLException {
        return AdminDao.transactionBetweenDate(start,end);
    }

    public static List<Transactions> AllfailTransaction() throws SQLException {
        return AdminDao.AllfailTransactions();
    }

    public static Beneficiary createBeneficiary(String name,long acc_no,String ifsc,String nickname,int user_id) throws SQLException {

        Beneficiary beneficiary = BeneficiaryDao.findByAccountNo(acc_no, user_id);

        if (beneficiary != null) {
            System.out.println("Beneficiary already exists.");
            return null;
        }

        return BeneficiaryDao.create(name, acc_no, ifsc, nickname, user_id);
    }
    public static Beneficiary updateBeneficiary(Beneficiary beneficiary) throws SQLException {
        return  BeneficiaryDao.updates(beneficiary);
    }
    public static Beneficiary findbeneficiary (int id, int userid) throws SQLException {
        return  BeneficiaryDao.findById(id, userid);
    }
    public static void deleteBeneficiary(int id, int user_id) throws SQLException {
        BeneficiaryDao.delete(id,user_id);
    }
    public static List<Beneficiary> viewBeneficiary(int userid) throws SQLException {
        return BeneficiaryDao.view(userid);
    }

//    public static void createAuditlogs(String email,String action, String description) throws SQLException {
//        AuditDao.create(email,action,description);
//    }
    public static List<AuditLogs> viewAuditByUsers(String email) throws SQLException {
     return AuditDao.viewAudits(email);
    }

    public static List<AuditLogs> viewAllAudits() throws SQLException {
        return AdminDao.viewAudits();
    }



}
