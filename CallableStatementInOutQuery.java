package com.mycompany.jdbc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
public class CallableStatementInOutQuery {
    public static void main(String[] args)throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","sachijoshiA1@");
        CallableStatement cs=con.prepareCall("{call inOutdata(?,?)}");
        cs.setInt(1, 111);
        cs.registerOutParameter(2, Types.VARCHAR);
        cs.execute();
        System.out.println("Name:\t"+cs.getString(2));
        con.close();
    }
}
