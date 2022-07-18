package com.mycompany.jdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public class CallableStatementINQuery {
    public static void main(String[] args)throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","sachijoshiA1@");
        CallableStatement cs=con.prepareCall("{call getEmpData(?)}");
        cs.setInt(1, 101);
        ResultSet rs=cs.executeQuery();
        while(rs.next())
        {
            System.out.println("ID\t"+rs.getInt(1)+"\tName\t"+rs.getString(2));
        }
    }
}
