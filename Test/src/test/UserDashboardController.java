
package test;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UserDashboardController implements Initializable {
    
    
    
    @FXML
    private Button Consumption_addbutton;
    
    @FXML
    private Button house_refreshbutton;

    @FXML
    private TableColumn<ConsumptionData,String> Consumption_col_daily;

    @FXML
    private TableColumn<ConsumptionData,String>Consumption_col_date;

    @FXML
    private TableColumn<ConsumptionData,String> Consumption_col_houseID;

    @FXML
    private TableColumn<ConsumptionData,String> Consumption_col_total;

    @FXML
    private TableColumn<ConsumptionData,String>  Consumption_col_weekly;

    @FXML
    private Button Consumption_deletebutton;

    @FXML
    private TableView<ConsumptionData> Consumption_tableview;

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
    private TableView<ProductionData> Production_tableview;

    @FXML
    private AnchorPane Productionform;

    @FXML
    private Button closebutton;

    @FXML
    private TextField consumptionDailytxt;

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
    private TableColumn<houseData,String> house_col_address;

    @FXML
    private TableColumn<houseData,String>  house_col_country;

    @FXML
    private TableColumn<houseData,String>  house_col_houseid;

    @FXML
    private TableColumn<houseData,String>  house_col_owner;

    @FXML
    private TableColumn<houseData,String>  house_col_town;

    @FXML
    private Button house_deletebutton;

    @FXML
    private TableView<houseData> house_tableview;

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
    private TableColumn<ProductionData, String> production_col_daily;

    @FXML
    private TableColumn<ProductionData, String>  production_col_date;

    @FXML
    private TableColumn<ProductionData, String>  production_col_houseid;

    @FXML
    private TableColumn<ProductionData, String>  production_col_total;

    @FXML
    private TableColumn<ProductionData, String> production_col_weekly;

    @FXML
    private TextField productiondailytxt;

   @FXML
    private DatePicker consumptionDatetxt;
   
    @FXML
    private TextField productionhouseidtxt;

    @FXML
    private TextField productiontotaltxt;

    @FXML
    private TextField productionweeklytxt;
    
    
    @FXML
    private DatePicker productiondatetxt;

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
    
    

//**********************************************************************************************************************************************
    
     
       public void UserAddProduction(){
    
        String sql ="INSERT INTO `productiondata`(`houseID`, `date`, `dailyProd`, `weeklyProd`) VALUES (?,?,?,?)";
        connect = database.connectDb();
        
        try{
            
           String houseID = productionhouseidtxt.getText();
           Date date = Date.valueOf(productiondatetxt.getValue());
           Double daily = Double.valueOf(productiondailytxt.getText());
           Double weekly = Double.valueOf(productionweeklytxt.getText());
           
         
           if (productionhouseidtxt.getText().isEmpty()||productiondailytxt.getText().isEmpty()||productionweeklytxt.getText().isEmpty()){
           
                   alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Error Message");
                   alert.setHeaderText(null);
                   alert.setContentText("Please fill and the blank");
                   alert.showAndWait();
                   
           } else {
                    stm = connect.prepareStatement(sql);
                    stm.setString(1, houseID);
                    stm.setDate(2, date);
                    stm.setDouble(3, daily);
                    stm.setDouble(4, weekly);
                    
                    stm.executeUpdate();
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("details add");
                    alert.showAndWait();
                 
           }

        
        }catch(Exception e){e.printStackTrace();}
    
    
    }
        public void refreshProduction(){
    
        String sql ="SELECT * FROM `productiondata`";
        connect = database.connectDb();
    
        try{

            productionList.clear();
            stm = connect.prepareCall(sql);
            result = stm.executeQuery();
            
            while(result.next()){
            
                productionList.add(new ProductionData(result.getString("houseID"),result.getDate("date"),result.getDouble("dailyProd"),
                        result.getDouble("weeklyProd"),result.getDouble("totalProd")));
                
                Production_tableview.setItems(productionList);
            
            
            }

        }catch(Exception e){e.printStackTrace();}

    }
     ObservableList<ProductionData> productionList =FXCollections.observableArrayList();
    
    public void loadProductionData() {
         
         connect = database.connectDb();
         refreshProduction();
         
         production_col_houseid.setCellValueFactory(new PropertyValueFactory<>("houseID"));
         production_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
         production_col_daily.setCellValueFactory(new PropertyValueFactory<>("dailyProd"));
         production_col_weekly.setCellValueFactory(new PropertyValueFactory<>("weeklyProd"));
         production_col_total.setCellValueFactory(new PropertyValueFactory<>("totalProd"));
        
    }
 
       
       

       
    public void UserAddConsumption(){
    
        String sql ="INSERT INTO `consomationdata`(`houseID`, `date`, `dailyCons`, `weeklyCons`) VALUES (?,?,?,?)";
        connect = database.connectDb();
        
        try{
            
           String houseID = consumptionHouseIDtxt.getText();
           Date date = Date.valueOf(consumptionDatetxt.getValue());
           Double daily = Double.valueOf(consumptionDailytxt.getText());
           Double weekly = Double.valueOf(consumptionWeeklytxt.getText());
           
         
           if (consumptionHouseIDtxt.getText().isEmpty()||
                   consumptionDailytxt.getText().isEmpty()||consumptionWeeklytxt.getText().isEmpty()){
           
                   alert = new Alert(Alert.AlertType.ERROR);
                   alert.setTitle("Error Message");
                   alert.setHeaderText(null);
                   alert.setContentText("Please fill and the blank");
                   alert.showAndWait();
                   
           } else {
                    stm = connect.prepareStatement(sql);
                    stm.setString(1, houseID);
                    stm.setDate(2, date);
                    stm.setDouble(3, daily);
                    stm.setDouble(4, weekly);
                    
                    stm.executeUpdate();
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("details add");
                    alert.showAndWait();
                 
           }

        
        }catch(Exception e){e.printStackTrace();}
 
    }
    
    
    public void refreshConsumption(){
    
        String sql ="SELECT * FROM `consomationdata`";
        connect = database.connectDb();
    
        try{

            consumptionList.clear();
            stm = connect.prepareCall(sql);
            result = stm.executeQuery();
            
            while(result.next()){
            
                consumptionList.add(new ConsumptionData(result.getString("houseID"),result.getDate("date"),result.getDouble("dailyCons"),
                        result.getDouble("weeklyCons"),result.getDouble("totalCons")));
                
                Consumption_tableview.setItems(consumptionList);
            
            
            }

        }catch(Exception e){e.printStackTrace();}

    }
     ObservableList<ConsumptionData> consumptionList =FXCollections.observableArrayList();
    
    public void loadConsumptionData() {
         
         connect = database.connectDb();
         refreshProduction();
         
         Consumption_col_houseID.setCellValueFactory(new PropertyValueFactory<>("houseID"));
         Consumption_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
         Consumption_col_daily.setCellValueFactory(new PropertyValueFactory<>("dailyCons"));
         Consumption_col_weekly.setCellValueFactory(new PropertyValueFactory<>("weeklyCons"));
         Consumption_col_total.setCellValueFactory(new PropertyValueFactory<>("totalCons"));
        
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
           
                   alert = new Alert(Alert.AlertType.ERROR);
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
                    
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("details add");
                    alert.showAndWait();
                 
           }

        
        }catch(Exception e){e.printStackTrace();}
    
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
    
    
     public void Delete(){
         
        house_tableview.getItems().removeAll(house_tableview.getSelectionModel().getSelectedItem());
        
    }

     

    public void closebutton(){System.exit(0);}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadHouseData();
        loadProductionData();
        loadConsumptionData();
    }    
    
}
