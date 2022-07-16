package com.mycompany.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class JDBC {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //step 1 : load and register drive
        Class.forName("com.mysql.jdbc.Driver");
        //step 2: Establish Connection b/w java application and database
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","sachijoshiA1@");   
        //create statement object
        Statement st=con.createStatement();
        //send and execute SQL Query
        ResultSet rs=st.executeQuery("select * from task");
        //fetching the value from the rs
        while(rs.next())
        {
            System.out.print(  rs.getString(1));
            System.out.println(", "+rs.getString(2));
        }
    }
}
