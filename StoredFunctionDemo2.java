package com.mycompany.jdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author HP
 */
public class StoredFunctionDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","sachijoshiA1@");
        CallableStatement cs=con.prepareCall("{?=call getNameEmp(?)}");
        cs.setInt(2, 101);
        cs.registerOutParameter(1,Types.VARCHAR);
        cs.execute();
        System.out.print(cs.getString(1));
        con.close();
    }
}
