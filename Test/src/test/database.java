/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author cell zone
 */
public class database {
    
    public static Connection connectDb(){
    
        try{
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cityLight?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            return connect;

        }catch(Exception e){e.printStackTrace();} 
           return null;
 
    }
    
}
