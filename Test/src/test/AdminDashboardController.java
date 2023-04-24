
package test;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableColumn<adminHouseData, String> house_col_address;

    @FXML
    private TableColumn<adminHouseData, String> house_col_country;

    @FXML
    private TableColumn<adminHouseData, String> house_col_houseid;

    @FXML
    private TableColumn<adminHouseData, String> house_col_owner;

    @FXML
    private TableColumn<adminHouseData, String> house_col_town;

    @FXML
    private Button house_deletebutton;
    
     @FXML
    private Button homebutton;
  
    @FXML
    private Button housebutton;
    
    @FXML
    private Button usersbutton;

    @FXML
    private TableView<adminHouseData> house_tableview;

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
    
    
    private Connection connect;
    private PreparedStatement stm;
    private Statement statement;
    private ResultSet result;
    private Alert alert;
    
    
    
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
    
    
    public void AdminAddUser(){
            
            String sql ="INSERT INTO `users`( `firstName`, `lastName`, `address`, `phone`) VALUES (?,?,?,?)";
            connect = database.connectDb();
          
        try{
    
    
            if(firstnametxt.getText().isEmpty() || lastnametxt.getText().isEmpty() || phonetxt.getText().isEmpty()||useraddresstxt.getText().isEmpty()){

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill in all the blanck");
                alert.showAndWait();

            }else{ 
                stm = connect.prepareStatement(sql);

                    stm.setString(1,firstnametxt.getText());
                    stm.setString(2,lastnametxt.getText());
                    stm.setString(3,useraddresstxt.getText());
                    stm.setString(4,phonetxt.getText());
                    stm.executeUpdate();
                    
                    alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Account Have been Add successfully");
                    alert.showAndWait();                   
            }
            
        }catch(Exception e){e.printStackTrace();}
        
          
    }
    

    public void AdminAddHouse(){
    
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
           
                   Alert alert = new Alert(AlertType.ERROR);
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
                    
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("details add");
                    alert.showAndWait();
                    
                    showHouseData();
           }

        
        }catch(Exception e){e.printStackTrace();}
    
    }
//*******************************************************************************************************************************************************
     public ObservableList<adminHouseData> house(){
    
         ObservableList<adminHouseData>listData = FXCollections.observableArrayList();
         String sql = "SELECT * FROM `housedata` ";
         
         try{
             
             stm  = connect.prepareStatement(sql);
             result = stm.executeQuery();
             adminHouseData AdmihouseD;
             
             while(result.next()){
             
                 AdmihouseD = new adminHouseData (result.getString("houseID"),result.getString("country"),
                 result.getString("town"),result.getString("addess"),result.getString("owner"));
                 
                 listData.add(AdmihouseD);
             }
         
         }catch(Exception e){e.printStackTrace();}
         return listData;
         
    }
    
    private ObservableList<adminHouseData> datalist;
    public void showHouseData(){
    
        datalist = house();
        house_col_houseid.setCellValueFactory(new PropertyValueFactory<>("houseID"));
        house_col_country.setCellValueFactory(new PropertyValueFactory<>("country"));
        house_col_town.setCellValueFactory(new PropertyValueFactory<>("town"));
        house_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        house_col_owner.setCellValueFactory(new PropertyValueFactory<>("owner"));
        house_tableview.setItems(datalist);
 
        
    }
//******************************************************************************************************************************************************
   
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
                root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
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
        showHouseData();
    }    
    
}
