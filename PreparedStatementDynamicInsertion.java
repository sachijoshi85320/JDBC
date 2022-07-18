package com.mycompany.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class PreparedStatementDynamicInsertion {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","sachijoshiA1@");
        PreparedStatement ps=con.prepareStatement("insert into task values (?,?)");
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            int id=sc.nextInt();
            sc.nextLine();
            String str=sc.nextLine();
            ps.setInt(1,id);
            ps.setString(2, str);
            int count=ps.executeUpdate();
            if(count>0)
            {
                System.out.println("Successful");
            }
            else{
                System.err.println("Not done properly");
            }
            System.out.println("Do you want to do more? y/n");
            String s=sc.nextLine();
            if(s.equals("y"))
            {
                continue;
            }
            else{
                break;
            }
        }
        ps=con.prepareStatement("select * from task");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            System.out.print(rs.getString(1));
            System.out.println(", "+rs.getString(2));
        }
        ps.close();
        con.close();
    }
}
