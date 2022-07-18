package com.mycompany.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementNormalInsertion {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","sachijoshiA1@");
        PreparedStatement ps=con.prepareStatement("insert into task values (?,?)");
        ps.setInt(1,110);
        ps.setString(2, "Dinesh");
        int i=ps.executeUpdate();
        System.out.println(i);
        ps.close();
        con.close();
    }
}
