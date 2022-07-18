package com.mycompany.jdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
public class StoredFunctionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","sachijoshiA1@");
        CallableStatement cs=con.prepareCall("{?=call getAvgIdd()}");
        cs.registerOutParameter(1,Types.FLOAT);
        cs.execute();
        System.out.print(cs.getInt(1));
        con.close();
    }
}
