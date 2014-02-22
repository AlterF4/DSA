/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Database connection
package dsa_trees;

//import java packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Yasi
 */
//class is created for deal with databases
public class database {
    //Declare public variable for connection
    public Connection con;
    //a function is created to connect with database
    public void connection()
    {
        try
        {
            //System.out.print("Inside the function");
            Class.forName("com.mysql.jdbc.Driver");
            //connection is created
            con = DriverManager.getConnection("jdbc:mysql://localhost/test"); 
            
        }
        //catch exceptions
        catch(ClassNotFoundException | SQLException sql)
        {
            System.out.println("Exception 1 threw"+ sql);
        }
        
        
    }
    
    //Select method
    public void select()
    {
        try
        {
            //call connection function
            connection();
            //define sql statement
            PreparedStatement statement = con.prepareStatement("SELECT * FROM books");
            //retrive data to resultset
            ResultSet result = statement.executeQuery();
            //print out put
            while(result.next())
            {
                System.out.print(result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " " + result.getString(4) + "\n");
            }
            con.close();
        }
        catch( SQLException sql)
        {
            System.out.println("Exception 1 threw"+ sql);
        }
    }
    
}
