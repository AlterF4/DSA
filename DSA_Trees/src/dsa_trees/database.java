/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Database connection
package dsa_trees;

//import java packages
import Interface.Delete1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yasi
 */
//class is created for deal with databases
public class database {
    //Declare public variable for connection
    public Connection con;
    String tit,f_nm,s_nm;
    int id;
    BinaryTree Newtree =new BinaryTree();
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
                System.out.print("| " + result.getString(1) + " | " + result.getString(2) + " | " + result.getString(3) + " | " + result.getString(4) + " | \n");
                id = result.getInt(1);
                tit = result.getString(2);
                f_nm = result.getString(3);
                s_nm = result.getString(4);
                Newtree.insert(id, tit, f_nm, s_nm);
            }
            con.close();
            Newtree.traverse();
        }
        catch( SQLException sql)
        {
            System.out.println("Exception 1 threw"+ sql);
        }
    }
    
    
    public void insert(String isbn,String title,String f_name,String s_name)
    {
        String des = "desc";
        try
        {
            //System.out.println(title +" "+ f_name+" "+ s_name +" "+ isbn);
            connection();
            Statement stmt = (Statement) con.createStatement();
            String insert = "INSERT INTO books VALUES ('" + isbn + "','" + title + "','" + f_name + "','" + s_name + "')";
            stmt.executeUpdate(insert);
            con.close();
        }   
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
    }   
     public void selectisb()
    { 
        try
        {   
            Delete1 comb= new Delete1();
            comb.setVisible(true);
            connection();
            PreparedStatement statement = con.prepareStatement("SELECT isbn FROM books");
            ResultSet result = statement.executeQuery();
            
            while(result.next())
                  {
                      Global.addisbn=result.getInt("isbn");
                  
                      comb.set_combo(Global.addisbn);
                      
                  }
        }
        //catch exceptions
        catch(SQLException sql)
        {
            System.out.println("Exception 1 threw"+ sql);
        }
        
    }
}
