
import java.sql.Connection;
import java.sql.DriverManager;


public class database {

    // Working fine 
    // use for to link to a database
    public static Connection connectDb(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cityLight?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
            return connect;
           }catch(Exception e){e.printStackTrace();}
             return null;
    }
    
}
