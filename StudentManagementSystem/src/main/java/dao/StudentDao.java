package dao;

import util.DBConnection;
import model.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDao {

    public static void add (Students students) throws Exception{
        try (Connection conn = DBConnection.connection()) {
            conn.setAutoCommit(false);


            try (PreparedStatement ps = conn.prepareStatement("insert into students values(?,?,?,?)");) {
                ps.setInt(1, students.getId());
                ps.setString(2, students.getName());
                ps.setString(3, students.getCourse());
                ps.setInt(4, students.getMarks());
                ps.executeUpdate();
                conn.commit();
            }
            catch (Exception e){
                conn.rollback();
            }
        }


    }
    public static void view () throws Exception{
       try( Connection conn = DBConnection.connection()) {
           conn.setAutoCommit(false);

           try (PreparedStatement ps = conn.prepareStatement("select * from students");){
               ResultSet rs = ps.executeQuery();
               while (rs.next()) {
                   System.out.println(rs.getInt(1) + "..." + rs.getString(2) + "..." + rs.getString(3) + "..." + rs.getInt(4));
               }

           }
           catch (Exception e){
               conn.rollback();
           }

       }

    }

    public static void update(int sid,int marks2) throws Exception{
        try(Connection conn = DBConnection.connection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement("update students set marks=? where id =?")) {
                ps.setInt(1, marks2);
                ps.setInt(2, sid);
                ps.executeUpdate();
                conn.commit();
            }
            catch (Exception e){
                conn.rollback();
            }
        }

    }
    public static void delete(int studID) throws Exception{
        try(Connection conn = DBConnection.connection()){
            conn.setAutoCommit(false);

            try(PreparedStatement ps = conn.prepareStatement("delete from students where id =?")){

                ps.setInt(1,studID);
                ps.executeUpdate();
                conn.commit();
            }
            catch (Exception e){
                conn.rollback();
            }
        }

    }






}
