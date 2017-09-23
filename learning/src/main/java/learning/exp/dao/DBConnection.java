package learning.exp.dao;

import java.sql.*;

/**
 * Created by Nameet on 2/10/2016.
 */
public class DBConnection{

    private Connection conn;

    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }


        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordpress", "root","");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sql){
        Statement stmt= null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;


    }









}
