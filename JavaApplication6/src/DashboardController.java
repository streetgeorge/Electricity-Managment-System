
import com.mysql.cj.xdevapi.Statement;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DashboardController implements Initializable {
    
    
    
   @FXML
    private Button Consomation_clearbutton;

    @FXML
    private TableColumn<?, ?> Consomation_col_adrress;

    @FXML
    private TableColumn<?, ?> Consomation_col_dailycons;

    @FXML
    private TableColumn<?, ?> Consomation_col_houseID;

    @FXML
    private TableColumn<?, ?> Consomation_col_monthlycons;

    @FXML
    private TableColumn<?, ?> Consomation_col_town;

    @FXML
    private TextField Consomation_consomation;

    @FXML
    private TextField Consomation_date;

    @FXML
    private TextField Consomation_houseID;

    @FXML
    private TableView<?> Consomation_tableview;

    @FXML
    private TextField Consomation_totalconsomation;

    @FXML
    private Button Consomation_updatebutton;

    @FXML
    private TableView<?> Productiion_tableView;

    @FXML
    private TextField Production_Date;

    @FXML
    private Button Production_clearbutton;

    @FXML
    private TableColumn<?, ?> Production_col_date;

    @FXML
    private TableColumn<?, ?> Production_col_houseID;

    @FXML
    private TableColumn<?, ?> Production_col_production;

    @FXML
    private TableColumn<?, ?> Production_col_totalroduction;

    @FXML
    private TextField Production_houseID;

    @FXML
    private TextField Production_production;

    @FXML
    private TextField Production_totalproduction;

    @FXML
    private Button Production_updatebutton;

    @FXML
    private Button addhouse_addbutton;

    @FXML
    private TextField addhouse_address;

    @FXML
    private Button addhouse_clearbutton1;

    @FXML
    private TableColumn<?, ?> addhouse_col_address;

    @FXML
    private TableColumn<?, ?> addhouse_col_country;

    @FXML
    private TableColumn<?, ?> addhouse_col_houseID;

    @FXML
    private TableColumn<?, ?> addhouse_col_town;

    @FXML
    private TextField addhouse_country;

    @FXML
    private AnchorPane addhouse_form;

    @FXML
    private TextField addhouse_houseID;

    @FXML
    private TableView<?> addhouse_tableView;

    @FXML
    private TextField addhouse_town;

    @FXML
    private Button addhousebutton;

    @FXML
    private Button closebutton;

    @FXML
    private AnchorPane consomation_form;

    @FXML
    private Button consomationbutton;

    @FXML
    private AnchorPane home_form;

    @FXML
    private AnchorPane home_totaconsomation;

    @FXML
    private AnchorPane home_totahouse;

    @FXML
    private AnchorPane home_totaproduction;

    @FXML
    private Button homebutton;

    @FXML
    private Button logoutbutton;

    @FXML
    private AnchorPane production_form;

    @FXML
    private Button productionbutton;

    @FXML
    private Label username;

    private Connection connect;
    
    private PreparedStatement stm;
    
    private ResultSet result;
    
    private Statement stmt;
    
    private Alert alert;
    
    
    
    public void switchForm(ActionEvent event){
    
        if(event.getSource() == homebutton){

            home_form.setVisible(true);
            addhouse_form.setVisible(false);
            production_form.setVisible(false);
            consomation_form.setVisible(false);

        }else if(event.getSource()== addhousebutton){

            home_form.setVisible(false);
            addhouse_form.setVisible(true);
            production_form.setVisible(false);
            consomation_form.setVisible(false);


        }else if(event.getSource()== productionbutton){

            home_form.setVisible(false);
            addhouse_form.setVisible(false);
            production_form.setVisible(true);
            consomation_form.setVisible(false);

        }else if(event.getSource()== consomationbutton){

            home_form.setVisible(false);
            addhouse_form.setVisible(false);
            production_form.setVisible(false);
            consomation_form.setVisible(true);
      
    }

    }

    
// THIS PART ALLOW THE USER TO ENTRE THE HOUSE DETAILS IN THE DATABASE 
    
    public void addhouseAdd(){
          
        String sql = "INSERT INTO `housedata`( `houseID`, `country`, `town`, `address`) VALUES (?,?,?,?)";
        connect=database.connectDb();
        
        try{
            
            if(addhouse_houseID.getText().isEmpty() || addhouse_address.getText().isEmpty() || 
                addhouse_town.getText().isEmpty() || addhouse_country.getText().isEmpty()){
            
               alert = new Alert(AlertType.INFORMATION);
               alert.setTitle("Information Message");
               alert.setHeaderText(null);
               alert.setContentText("Fill all the House details");
               alert.showAndWait();
               
            }else{
                
                stm = connect.prepareStatement(sql);
                stm.setString(1,addhouse_houseID.getText());
                stm.setString(2,addhouse_country.getText());
                stm.setString(3,addhouse_town.getText());
                stm.setString(4,addhouse_address.getText());
                stm.executeUpdate();
                
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("House detail add successfully");
                alert.showAndWait();
            }
          
        }catch(Exception e){e.printStackTrace();}
    }
    
// THIS PART ALLOW THE USER TO ENTRE THE Production DETAILS IN THE DATABASE 
    
    public void consomation(){
          
        String sql = "INSERT INTO `consomation`( `houseID`, `date`, `production`,'totalconsomation') VALUES (?,?,?,?)";
        connect=database.connectDb();
        
        try{
            
            if(Consomation_houseID.getText().isEmpty() || Consomation_date.getText().isEmpty() || 
                Consomation_consomation.getText().isEmpty() || Consomation_totalconsomation.getText().isEmpty()){
            
               alert = new Alert(AlertType.INFORMATION);
               alert.setTitle("Information Message");
               alert.setHeaderText(null);
               alert.setContentText("Fill all the blanck details");
               alert.showAndWait();
               
            }else{
                
                stm = connect.prepareStatement(sql);
                stm.setString(1,Consomation_houseID.getText());
                stm.setString(2,Consomation_date.getText());
                stm.setString(3,Consomation_consomation.getText());
                stm.setString(4,Consomation_totalconsomation.getText());
                stm.executeUpdate();
                
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Consomation details add successfully");
                alert.showAndWait();
            }
          
        }catch(Exception e){e.printStackTrace();}
    }
// // THIS PART ALLOW THE USER TO ENTRE THE Consomation DETAILS IN THE DATABASE  
    
    public void production(){
          
        String sql = "INSERT INTO `production`( `houseID`, `date`, `consomation`,'totalproduction') VALUES (?,?,?,?)";
        connect=database.connectDb();
        
        try{
            
            if(Production_houseID.getText().isEmpty() || Production_Date.getText().isEmpty() || 
                Production_production.getText().isEmpty() || Production_totalproduction.getText().isEmpty()){
            
               alert = new Alert(AlertType.INFORMATION);
               alert.setTitle("Information Message");
               alert.setHeaderText(null);
               alert.setContentText("Fill all the blanck details");
               alert.showAndWait();
               
            }else{
               
                stm = connect.prepareStatement(sql);
                stm.setString(1,Production_houseID.getText());
                stm.setString(2,Production_Date.getText());
                stm.setString(3,Production_production.getText());
                stm.setString(4,Production_totalproduction.getText());
                stm.executeUpdate();
                
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Production details add successfully");
                alert.showAndWait();
            }
          
        }catch(Exception e){e.printStackTrace();}
    }
    
//************************************************************************************************************************************************8          
// / THIS part is suppos to display the house details but it difficulte and i dont quit get it so need helps please
    
    
    public ObservableList<house>houselist(){
    
        ObservableList<house>houselist = FXCollections.observableArrayList();
        String sql = "SELECT * FROM housedata";
        connect = database.connectDb();
        
        try{
            
            stm = connect.prepareStatement(sql);
            result = stm.executeQuery();
            house houseD;
        
            while(result.next()){
            
                houseD = new house(result.getString("houseID")
                                  ,result.getString("country")
                                  ,result.getString("town")
                                  ,result.getString("address"));
                
                houselist.add(houseD);
            
            }
        
        }catch(Exception e){e.printStackTrace();}
 
        return houselist;
    
    }
    
    private ObservableList<house>addhouseList;
    public void houseData() {
        
            addhouseList = houselist();
            
            addhouse_col_houseID.setCellValueFactory(new PropertyValueFactory<>("HouseID"));
            addhouse_col_country.setCellValueFactory(new PropertyValueFactory<>("County"));
            addhouse_col_town.setCellValueFactory(new PropertyValueFactory<>("town"));
            addhouse_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        }
//     **********************************************************************************************************************************************************
    
    
    
    
    
    public void logoutAdmin(){
        
        alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout");
        Optional<ButtonType> option = alert.showAndWait();
        
        
        
        try{
              if(option.get().equals(ButtonType.OK)){
                  
                alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Logout confirmation");
                alert.setContentText("ARE you sure you want to logout");
                logoutbutton.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
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
        houseData();
    }    

    

}
