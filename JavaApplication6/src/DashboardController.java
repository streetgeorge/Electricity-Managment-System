
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DashboardController implements Initializable {
    
    
    
    @FXML
    private Label Concomation_town;

    @FXML
    private Label Consomation_address;

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
    private TextField Consomation_daily;

    @FXML
    private TextField Consomation_houseID;

    @FXML
    private TextField Consomation_monthly;

    @FXML
    private TableView<?> Consomation_tableview;

    @FXML
    private Button Consomation_updatebutton;

    @FXML
    private TableView<?> Productiion_tableView;

    @FXML
    private Label Production_address;

    @FXML
    private Button Production_clearbutton;

    @FXML
    private TableColumn<?, ?> Production_col_address;

    @FXML
    private TableColumn<?, ?> Production_col_dailyprod;

    @FXML
    private TableColumn<?, ?> Production_col_houseID;

    @FXML
    private TableColumn<?, ?> Production_col_monthlyprod;

    @FXML
    private TableColumn<?, ?> Production_col_town;

    @FXML
    private TextField Production_daily;

    @FXML
    private TextField Production_houseID;

    @FXML
    private TextField Production_monthly;

    @FXML
    private Label Production_town;

    @FXML
    private Button Production_updatebutton;

    @FXML
    private Button addhouse_clearbutton;

    @FXML
    private TableColumn<?, ?> addhouse_col_address;

    @FXML
    private TableColumn<?, ?> addhouse_col_houseID;

    @FXML
    private TableColumn<?, ?> addhouse_col_town;

    @FXML
    private TextField addhouse_country;

    @FXML
    private Button addhouse_deletebutton;

    @FXML
    private AnchorPane addhouse_form;

    @FXML
    private TextField addhouse_houseID;

    @FXML
    private TextField addhouse_search;

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

   
    private Alert alert;
    
    public void dispalyName(){
     username.setText(getData.username);
    
    }
  
 // switching form module kinda proude of it working but if u can updrade just do it |;)
 // also i don't know what to do so it your turn |:)
    
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
    
    public void closebutton(){
    
        System.exit(0);
    }
    
    
    //  workoking just fine logout modul no need to do antthings 
    
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
    



    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
