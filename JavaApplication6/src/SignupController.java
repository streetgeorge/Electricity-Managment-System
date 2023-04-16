

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

// module Under construction to allow the user to sign in not as admin need helps



public class SignupController implements Initializable {
    
     @FXML
    private Button Signupbutton;

    @FXML
    private Button closebutton;

    @FXML
    private Button signinbutton;
    
    
     @FXML
    private PasswordField confirmpassword;

    @FXML
    private TextField email;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phone;
    
    private Connection connect;
    
    private PreparedStatement stm;
    private ResultSet result;

    private Alert alert;

    
    
    
    public void SignIn(){
    
        try{

            signinbutton.getScene().getWindow().hide();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();


        }catch(Exception e){e.printStackTrace();}
    
    }
     
    
    public void loginUser(){
            
            String sql ="INSERT INTO `users`( `firstName`, `lastName`, `email`, `phone`, `password`, `confirme password`) VALUES (?,?,?,?,?,?)";
            connect = database.connectDb();
          
        try{
    
    
            if(firstname.getText().isEmpty() || lastname.getText().isEmpty() || phone.getText().isEmpty()|| email.getText().isEmpty() || 
                    password.getText().isEmpty() || confirmpassword.getText().isEmpty()){

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill in all the blanck");
                alert.showAndWait();

            }else{ 
                
                if(!(password.getText()).equals(confirmpassword.getText())){ 
                    
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Password doesn't match confirm password");
                    alert.showAndWait();
                }else{ 
                    
                    stm = connect.prepareStatement(sql);

                    stm.setString(1,firstname.getText());
                    stm.setString(2,lastname.getText());
                    stm.setString(3,email.getText());
                    stm.setString(4,phone.getText());
                    stm.setString(5,password.getText());
                    stm.setString(6,confirmpassword.getText());
                    stm.executeUpdate();
                    
                    alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Your Account Have been created successfully");
                    alert.showAndWait();

                    Signupbutton.getScene().getWindow().hide();
                    Parent root;
                    root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.show();
                                
                }
            }
            
        }catch(Exception e){e.printStackTrace();}
          
    }
        
    public void closebutton(){System.exit(0);}
    
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
