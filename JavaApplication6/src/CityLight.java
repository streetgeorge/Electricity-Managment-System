
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

// DO NOT TOUCHE DONT EVEN THINK OF IT  PERFECT AND IT NOT ME WHO CODE IT SO BETTE NOT TOUCHE xxxxxxxx OR YOU WILL GET 288 ERROR 

public class CityLight extends Application {
        
         @Override
    public void start(Stage stage) throws IOException {
        
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
