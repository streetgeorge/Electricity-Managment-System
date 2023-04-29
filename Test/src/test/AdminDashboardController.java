
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
    private TableColumn<houseData,String> house_col_address;

    @FXML
    private TableColumn<houseData,String> house_col_country;

    @FXML
    private TableColumn<houseData,String> house_col_houseid;

    @FXML
    private TableColumn<houseData,String> house_col_owner;

    @FXML
    private TableColumn<houseData,String> house_col_town;

    @FXML
    private Button house_deletebutton;
    
     @FXML
    private Button homebutton;
  
    @FXML
    private Button housebutton;
    
    @FXML
    private Button usersbutton;

    @FXML
    private TableView<houseData> house_tableview;

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
    private TableColumn<userData, String> users_col_address;

    @FXML
    private TableColumn<userData, String> users_col_firstname;

    @FXML
    private TableColumn<userData, String> users_col_lastname;

    @FXML
    private TableColumn<userData, String> users_col_phone;

    @FXML
    private TableView<userData> users_tableview;
    
    @FXML
    private Button house_refreshbutton;
    
    
    private Connection connect;
    private PreparedStatement stm;
    
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
    
//****************************************************ADMIN DASHBOARD USER MODULE************************************************************************* 
    
    public void AdminAddUser(){
            
            String sql ="INSERT INTO `userdata`( `firstName`, `lastName`, `address`, `phone`) VALUES (?,?,?,?)";
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
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Account Have been Add successfully");
                    alert.showAndWait();                   
            }
            
        }catch(Exception e){e.printStackTrace();}
    
    }
    
     public void DeleteUser(){
         
        users_tableview.getItems().removeAll(users_tableview.getSelectionModel().getSelectedItem());
        
    }
    
    public void refreshUser(){
        
        
    
        String sql ="SELECT * FROM `userdata`";
        connect = database.connectDb();
    
        try{

            userList.clear();
            stm = connect.prepareCall(sql);
            result = stm.executeQuery();
            
            while(result.next()){
            
                userList.add(new userData(result.getString("firstname"),result.getString("lastname"),result.getString("address"),
                        result.getString("phone")));
                
                users_tableview.setItems(userList);

            }

        }catch(Exception e){e.printStackTrace();}

    }
     ObservableList<userData> userList =FXCollections.observableArrayList();
    
    public void loadUserData() {
         
         connect = database.connectDb();
         refreshUser();
         
         users_col_firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
         users_col_lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
         users_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
         users_col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
         house_col_owner.setCellValueFactory(new PropertyValueFactory<>("Owner"));
        
    }
    
   
//*****************************************ADMIN DASHBOARD HOUSE MODULE ***************************************************************************************************************
    
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
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("details add");
                    alert.showAndWait();
                    
           }

        
        }catch(Exception e){e.printStackTrace();}
    
    }
    
    public void DeleteHouse(){
        
        house_tableview.getItems().removeAll(house_tableview.getSelectionModel().getSelectedItem());
    
    }

    public void refreshHouse(){
    
        String sql ="SELECT * FROM `housedata`";
        connect = database.connectDb();
    
        try{

            houseList.clear();
            stm = connect.prepareCall(sql);
            result = stm.executeQuery();
            
            while(result.next()){
            
                houseList.add(new houseData(result.getString("houseID"),result.getString("country"),result.getString("town"),
                        result.getString("address"),result.getString("Owner")));
                
                house_tableview.setItems(houseList);
            
            
            }

        }catch(Exception e){e.printStackTrace();}

    }
     ObservableList<houseData> houseList =FXCollections.observableArrayList();
    
    public void loadHouseData() {
         
         connect = database.connectDb();
         refreshHouse();
         
         house_col_houseid.setCellValueFactory(new PropertyValueFactory<>("houseID"));
         house_col_country.setCellValueFactory(new PropertyValueFactory<>("country"));
         house_col_town.setCellValueFactory(new PropertyValueFactory<>("town"));
         house_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
         house_col_owner.setCellValueFactory(new PropertyValueFactory<>("Owner"));
        
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
//********************************************************************************************************************************************************    
    
    public void closebutton(){System.exit(0);}
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadHouseData();
        loadUserData();
    }    

   
    
}
