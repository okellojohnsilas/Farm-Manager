package farm;

import javafx.scene.control.Alert;

public class Constants {
//    Alert Boxes
    public final Alert successalert = new Alert(Alert.AlertType.INFORMATION);
    public final Alert failurealert = new Alert(Alert.AlertType.INFORMATION);
//  =============================================Database Constants===========================================================================================================
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/Farm?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "root";
    public static final String PASSWORD ="";
    public  String getDriver(){
        return DRIVER;
    }
    public  String getDatabaseUrl(){
        return DATABASE_URL;
    }
    public  String getUser(){
        return USER;
    }
    public  String getPassword(){
        return PASSWORD;
    }
//  ========================================End of Database Constants===========================================================================================================
}
