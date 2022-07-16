package com.mycompany.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCupdate {
     public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //step 1 : load and register drive
        Class.forName("com.mysql.jdbc.Driver");
        //step 2: Establish Connection b/w java application and database
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","sachijoshiA1@");   
        //create statement object
        Statement st=con.createStatement();
        //send and excute a SQL instruction
        int rowCount=st.executeUpdate("insert into task values('103','aryan')");
        if(rowCount>0)
        {
            System.out.println("Success");
        }
        else{
            System.err.println("Failure");
        }
    }

}
