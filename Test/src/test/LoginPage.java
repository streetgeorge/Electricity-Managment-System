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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author cell zone
 */
public class LoginPage implements Initializable {
    
   
    @FXML
    private Button Adminbutton;

    @FXML
    private PasswordField password;

    @FXML
    private Button signupbutton;

    @FXML
    private Button userbutton;

    @FXML
    private TextField username;
    
      @FXML
    private Button closebutton;
      
      
    private Connection connect;
    
    private PreparedStatement stm;
    
    private ResultSet result;
      
    public void closebutton(){System.exit(0);}
    
    
    public void SignUp(){
    
        try{
            signupbutton.getScene().getWindow().hide();
            Parent root;
            root =FXMLLoader.load(getClass().getResource("SignupPage.fxml"));
            Stage stage =  new Stage();
            Scene scene = new Scene(root);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();

        }catch(Exception e){e.printStackTrace();}
 
    }
    
    
    public void loginAdmin(){
        
        String sql ="SELECT * FROM admin WHERE username = '" + username.getText()+"' And password = '"+ password.getText()+"'";
        connect = database.connectDb();
        
    
        try{

            stm = connect.prepareStatement(sql);
            result=stm.executeQuery();
            
            

            if(username.getText().isEmpty()|| password.getText().isEmpty()){

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("INFORMATION");
                alert.setContentText("Please fill all the blancks");
                alert.showAndWait();

            }else{

                if(result.next()){

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("INFORMATION");
                alert.setContentText("Login successfull");
                alert.showAndWait();

                Adminbutton.getScene().getWindow().hide();
                Parent root;
                
                root = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
                Stage stage = new Stage();
                
                Scene scene = new Scene(root);
                stage.setScene(scene);
                
                stage. initStyle(StageStyle.TRANSPARENT);
                stage.show();

                }else{

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("INFORMATION");
                    alert.setContentText("username/passord incorrect");
                    alert.showAndWait();

                }

            }

        }catch(Exception e){e.printStackTrace();}

    }

    public void loginUser(){
        
            String sql ="SELECT * FROM users WHERE firstName = '" + username.getText()+"' And password = '"+ password.getText()+"'";
            connect = database.connectDb();

        try{

            stm = connect.prepareStatement(sql);
            result=stm.executeQuery();
   
            if(username.getText().isEmpty()|| password.getText().isEmpty()){

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("INFORMATION");
                alert.setContentText("Please fill all the blancks");
                alert.showAndWait();

            }else{

                if(result.next()){

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("INFORMATION");
                alert.setContentText("Login successfull");
                alert.showAndWait();

                Adminbutton.getScene().getWindow().hide();
                Parent root;
                root = FXMLLoader.load(getClass().getResource("UserDashboard.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage. initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();

                }else{

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("INFORMATION");
                    alert.setContentText("username/passord incorrect");
                    alert.showAndWait();

                }

            }

        }catch(Exception e){e.printStackTrace();}

    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
