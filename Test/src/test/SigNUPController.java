/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;




public class SigNUPController implements Initializable {

    
    
    
    
    
    
    
    
    
    
    
    
    private Connection connect;
    
    private PreparedStatement stm;
    
    private ResultSet result;
    
    public void closebuttom(){
    System.exit(0);
    
    }
    
    public void signupUser(){
        
        String sql ="INSERT INTO users";
        connect = database.connectDb();
    try{
    
        stm = connect.prepareStatement(sql);
       
    
    
    
    
    
    
    }catch(Exception e){e.printStackTrace();}

    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
