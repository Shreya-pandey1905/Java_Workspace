package service;

import dao.UsersDao;
import model.Users;
import util.PasswordHash;

import java.sql.SQLException;

public class AuthService
{

    public static Users registerUser(String name, String email, String password, String branch, long AccountNo, String ifsccode) throws SQLException {
        return UsersDao.create(name,email,PasswordHash.hash(password),AccountNo, ifsccode, branch);

    }
    public static Users loginUser(String email,String password) throws SQLException{
        return UsersDao.findbyEmailAndPassword(email,PasswordHash.hash(password));

    }

    public static Users deposit(double balance, int id) throws SQLException {
        return UsersDao.deposit(balance,id);
    }
}
