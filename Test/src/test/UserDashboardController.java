
package test;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UserDashboardController implements Initializable {
    
    
    
    @FXML
    private Button Consumption_addbutton;

    @FXML
    private TableColumn<?, ?> Consumption_col_daily;

    @FXML
    private TableColumn<?, ?> Consumption_col_date;

    @FXML
    private TableColumn<?, ?> Consumption_col_houseID;

    @FXML
    private TableColumn<?, ?> Consumption_col_total;

    @FXML
    private TableColumn<?, ?> Consumption_col_weekly;

    @FXML
    private Button Consumption_deletebutton;

    @FXML
    private TableView<?> Consumption_tableview;

    @FXML
    private Button Consumptionbutton;

    @FXML
    private Button Productionbutton;

    @FXML
    private AnchorPane Consumptionform;

    @FXML
    private Button Production_addbutton;

    @FXML
    private Button Production_deletebutton;

    @FXML
    private TableView<?> Production_tableview;

    @FXML
    private AnchorPane Productionform;

    @FXML
    private Button closebutton;

    @FXML
    private TextField consumptionDailytxt;

    @FXML
    private TextField consumptionDatetxt;

    @FXML
    private TextField consumptionHouseIDtxt;

    @FXML
    private TextField consumptionTotaltxt;

    @FXML
    private TextField consumptionWeeklytxt;

    @FXML
    private TextField countrytxt;

    @FXML
    private Button homebutton;

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
    private TableView<?> house_tableview;

    @FXML
    private TextField houseaddresstxt;

    @FXML
    private Button housebutton;

    @FXML
    private AnchorPane houseform;

    @FXML
    private TextField houseidtxt;

    @FXML
    private Button logoutbutton;

    @FXML
    private TextField ownertxt;

    @FXML
    private TableColumn<?, ?> production_col_daily;

    @FXML
    private TableColumn<?, ?> production_col_date;

    @FXML
    private TableColumn<?, ?> production_col_houseid;

    @FXML
    private TableColumn<?, ?> production_col_total;

    @FXML
    private TableColumn<?, ?> production_col_weekly;

    @FXML
    private TextField productiondailytxt;

    @FXML
    private TextField productiondatetxt;

    @FXML
    private TextField productionhouseidtxt;

    @FXML
    private TextField productiontotaltxt;

    @FXML
    private TextField productionweeklytxt;

    @FXML
    private TextField towntxt;
    
    private Alert alert;
    
    private Connection connect;
    private ResultSet result;
    private PreparedStatement stm;
    
    
    public void SwitchingFormUser(ActionEvent event){
    
        if (event.getSource() == homebutton){

            homeform.setVisible(true);
            houseform.setVisible(false);
            Productionform.setVisible(false);
            Consumptionform.setVisible(false);
            
        }else if (event.getSource() == housebutton){
        
             homeform.setVisible(false);
             houseform.setVisible(true);
             Productionform.setVisible(false);
             Consumptionform.setVisible(false);
        
        }else if (event.getSource() == Productionbutton){
            
             homeform.setVisible(false);
             houseform.setVisible(false);
             Productionform.setVisible(true);
             Consumptionform.setVisible(false);
            
        }else if (event.getSource() == Consumptionbutton ){
            
             homeform.setVisible(false);
             houseform.setVisible(false);
             Productionform.setVisible(false);
             Consumptionform.setVisible(true);
        
        }  
 
    }
    
     public void UserAddConsumption(){
    
        String sql ="INSERT INTO `consumptiondata`(`houseID`, `Date`, `daily`, `weekly`) VALUES (?,?,?,?)";
        connect = database.connectDb();
        
        try{
            
           String houseID = consumptionHouseIDtxt.getText();
           String date = consumptionDatetxt.getText();
           String daily = consumptionDailytxt.getText();
           String weekly = consumptionWeeklytxt.getText();
           
         
           if (consumptionHouseIDtxt.getText().isEmpty()||consumptionDatetxt.getText().isEmpty()||
                   consumptionDailytxt.getText().isEmpty()||consumptionWeeklytxt.getText().isEmpty()){
           
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Error Message");
                   alert.setHeaderText(null);
                   alert.setContentText("Please fill and the blank");
                   alert.showAndWait();
                   
           } else {
                    stm = connect.prepareStatement(sql);
                    stm.setString(1, houseID);
                    stm.setString(2, date);
                    stm.setString(3, daily);
                    stm.setString(4, weekly);
                    
                    stm.executeUpdate();
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("details add");
                    alert.showAndWait();
                 
           }

        
        }catch(Exception e){e.printStackTrace();}
    
    
    }
    
    public void UserAddProduction(){
    
        String sql ="INSERT INTO `production`(`houseID`, `Date`, `daily`, `weekly`) VALUES (?,?,?,?)";
        connect = database.connectDb();
        
        try{
            
           String houseID = consumptionHouseIDtxt.getText();
           String date = consumptionDatetxt.getText();
           String daily = consumptionDailytxt.getText();
           String weekly = consumptionWeeklytxt.getText();
           
         
           if (consumptionHouseIDtxt.getText().isEmpty()||consumptionDatetxt.getText().isEmpty()||
                   consumptionDailytxt.getText().isEmpty()||consumptionWeeklytxt.getText().isEmpty()){
           
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Error Message");
                   alert.setHeaderText(null);
                   alert.setContentText("Please fill and the blank");
                   alert.showAndWait();
                   
           } else {
                    stm = connect.prepareStatement(sql);
                    stm.setString(1, houseID);
                    stm.setString(2, date);
                    stm.setString(3, daily);
                    stm.setString(4, weekly);
                    
                    stm.executeUpdate();
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("details add");
                    alert.showAndWait();
                 
           }

        
        }catch(Exception e){e.printStackTrace();}
    
    
    }
    
    
    public void UserAddHouse(){
    
        String sql ="INSERT INTO `housedata`(`houseID`, `country`, `town`, `owner`,`address`) VALUES (?,?,?,?,?)";
        connect = database.connectDb();
        
        try{
            
           String houseID = houseidtxt.getText();
           String country = countrytxt.getText();
           String town = towntxt.getText();
           String address = houseaddresstxt.getText();
           String owner = ownertxt.getText();
         
           if (houseidtxt.getText().isEmpty()||countrytxt.getText().isEmpty()||
                   towntxt.getText().isEmpty()||houseaddresstxt.getText().isEmpty()||ownertxt.getText().isEmpty()){
           
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Error Message");
                   alert.setHeaderText(null);
                   alert.setContentText("Please fill and the blank");
                   alert.showAndWait();
                   
           } else {
                    stm = connect.prepareStatement(sql);
                    stm.setString(1, houseID);
                    stm.setString(2, country);
                    stm.setString(3, town);
                    stm.setString(5, owner);
                    stm.setString(4, address);
                    stm.executeUpdate();
                    
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("details add");
                    alert.showAndWait();
                 
           }

        
        }catch(Exception e){e.printStackTrace();}
    
    }
    
    
    
    public void logout(){
        
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout");
        Optional<ButtonType> option = alert.showAndWait();
        
        
        
        try{
              if(option.get().equals(ButtonType.OK)){
                  
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Logout confirmation");
                alert.setContentText("ARE you sure you want to logout");
                logoutbutton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
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
      
    }    
    
}
