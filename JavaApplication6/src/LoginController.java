


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;
import java.io.IOException;


// module Under construction to must find a way to log as and admin and ass a normal user 
// login as admin is working but still a lot to do with the dashboard


public class LoginController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    
    
    @FXML
    private Button Loginbutton;
    

    @FXML
    private Button closebutton;
    
    @FXML
    private Button signupbutton;
    
    
    private Connection connect;
    
    private PreparedStatement prepare;
    private ResultSet result;
    private Alert alert;
    
// module to display the sign up page
    
    public void SignUP(){
    
    try{
        
        signupbutton.getScene().getWindow().hide();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        
        
        
    }catch(Exception e){e.printStackTrace();}
    
    
  
    }

// module to log as an admin also include so work and under progresse

    
    public void LoginAdmin(){
        
        // sql statement to compare the data store in the database and compare  them to the one entre when login 
        
        
        String sql ="SELECT * FROM admin WHERE username = '" + username.getText()+"' And password = '"+ password.getText()+"'";
            connect = database.connectDb();
        
        try{
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            
        // sentinelle to alert if when wrong password or username are entre or if one field it blanck
        
            if(username.getText().isEmpty() || password.getText().isEmpty()){
            
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blanck");
                alert.showAndWait();
            
            }else{
                
        // grante access to the dasboard as an admin
        
                if(result.next()){
                
                    getData.username = username.getText();
                    alert=new Alert(AlertType.CONFIRMATION);
                    
                    alert.setTitle(" confimation Message");
                    alert.setHeaderText(null);
                    
                    alert.setContentText("SUCCESSFULL LOGIN");
                    alert.showAndWait();
                    
                    Loginbutton.getScene().getWindow().hide();
                    Parent root;
                    
                    root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                    Stage stage = new Stage();
                    
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    
                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.show();
                    
                
        // sentinelle to alert if when wrong password or username are entre or if one field it blanck
        
                }else{
                    
                    alert=new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong username/password");
                    
                    alert.showAndWait();
                
                
                }
            
            }
            
          
        }catch(Exception e){e.printStackTrace();}
        
           
        
       
        
    }

    public void closebutton(){
        System.exit(0);
}



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
