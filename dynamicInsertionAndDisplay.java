package com.mycompany.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class dynamicInsertionAndDisplay {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //step 1 : load and register drive
        Class.forName("com.mysql.cj.jdbc.Driver");
        //step 2: Establish Connection b/w java application and database
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank1","root","sachijoshiA1@");   
        //create statement object
        Statement st=con.createStatement();
        //send and execute SQL Query
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the ID");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the name");
        String str=sc.nextLine();
        String query1="insert into task values('"+id+"','"+str+"')";
        int p=st.executeUpdate(query1);
        if(p>0)
        {
            ResultSet rs=st.executeQuery("select * from task");
            while(rs.next())
                {
                    System.out.print(rs.getString(1));
                    System.out.println("\t"+rs.getString(2));
                }
        }
        //fetching the value from the rs   
    }
}
