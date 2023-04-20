
package test;

import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class AdminDashboardController implements Initializable {
    
       @FXML
    private AnchorPane Userform;

    @FXML
    private Button closebutton;

    @FXML
    private TextField countrytxt;

    @FXML
    private TextField firstnametxt;

    @FXML
    private AnchorPane homeform;

    @FXML
    private Button house_addbutton;

    @FXML
    private TableColumn<?, ?> house_col_address;

    @FXML
    private TableColumn<?, ?> house_col_country;

    @FXML
    private TableColumn<?, ?> house_col_houseid;

    @FXML
    private TableColumn<?, ?> house_col_owner;

    @FXML
    private TableColumn<?, ?> house_col_town;

    @FXML
    private Button house_deletebutton;
    
     @FXML
    private Button homebutton;
  
    @FXML
    private Button housebutton;
    
    @FXML
    private Button usersbutton;

    @FXML
    private TableView<?> house_tableview;

    @FXML
    private TextField houseaddresstxt;

    @FXML
    private AnchorPane houseform;

    @FXML
    private TextField houseidtxt;

    @FXML
    private TextField lastnametxt;

    @FXML
    private TextField ownertxt;

    @FXML
    private TextField phonetxt;

    @FXML
    private TextField towntxt;
    
    
    @FXML
    private Button logoutbutton;

    @FXML
    private Button user_addbutton;

    @FXML
    private Button user_deletebutton;

    @FXML
    private TextField useraddresstxt;

    @FXML
    private TextField useridtxt;

    @FXML
    private TableColumn<?, ?> users_col_address;

    @FXML
    private TableColumn<?, ?> users_col_firstname;

    @FXML
    private TableColumn<?, ?> users_col_lastname;

    @FXML
    private TableColumn<?, ?> users_col_phone;

    @FXML
    private TableColumn<?, ?> users_col_userid;

    @FXML
    private TableView<?> users_tableview;
    
    
    public void SwitchingForm(ActionEvent event){
    
        if (event.getSource() == homebutton){

            homeform.setVisible(true);
            houseform.setVisible(false);
            Userform.setVisible(false);
            
        }else if (event.getSource() == housebutton){
        
             homeform.setVisible(false);
             houseform.setVisible(true);
             Userform.setVisible(false);
        
        }else if (event.getSource() == usersbutton){
            
             homeform.setVisible(false);
             houseform.setVisible(false);
             Userform.setVisible(true);
            
        }  
 
    }
    
    public void logout(){
    
        try{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Logout");
            alert.setHeaderText(null);
            alert.setContentText("Do you Want to Logout");
            Optional<ButtonType> option = alert.showAndWait();
            
            if(option.get().equals(ButtonType.OK)){
            
                logoutbutton.getScene().getWindow().hide();
                Parent root;
                root = FXMLLoader.load(getClass().getResource("LogPage.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
  
            }

        }catch(Exception e){e.printStackTrace();}
    
    }
    
    
    public void closebutton(){System.exit(0);}
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
