package service;

import dao.AdminDao;
import dao.TransactionsDao;
import dao.UsersDao;
import model.Transactions;
import model.Users;
import util.PasswordHash;

import java.sql.SQLException;
import java.util.List;

public class AuthService
{

    public static Users registerUser(String name, String email, String password, String branch, long AccountNo, String ifsccode) throws SQLException {
        return UsersDao.create(name,email,PasswordHash.hash(password),AccountNo, ifsccode, branch);

    }

    public static Users loginUser(String email,String password) throws SQLException{
        return UsersDao.findbyEmailAndPassword(email,PasswordHash.hash(password));

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

    public static Users loginAdmin(String email, String password) throws SQLException {

        return AdminDao.login(email, PasswordHash.hash(password));
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


}
