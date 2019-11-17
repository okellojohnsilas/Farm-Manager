package farm_manager;

import java.sql.*;
import static javafx.application.Application.launch;
import javafx.scene.control.Alert;
import org.apache.commons.lang3.RandomStringUtils;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Users {

    Boolean Status = false;

    public void setStatus(Boolean loginStatus) {
        loginStatus = this.Status;
    }

    public Boolean getStatus() {
        return Status;
    }
    Constants dbConn = new Constants();
    //    Alert Boxes
    Alert successalert = new Alert(Alert.AlertType.INFORMATION);
    Alert failurealert = new Alert(Alert.AlertType.INFORMATION);

    public Boolean Login(String User, String UserPass) throws NoSuchAlgorithmException, InvalidKeySpecException {
        try {
            Class.forName(dbConn.getDriver());
            Connection con = (Connection) DriverManager.getConnection(dbConn.getDatabaseUrl(), dbConn.getUser(), dbConn.getPassword());
            Statement stmt = (Statement) con.createStatement();
            ResultSet rs = (ResultSet) stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                String storedDatabaseUsername = rs.getString("Username");
                String storedDatabasePassword = (rs.getString("User_password"));
                boolean decPass = true; 
                decPass =  PasswordHashing.validatePassword(User,storedDatabasePassword);
                if(decPass){
                    if (UserPass.equals(decPass)) {
                        setStatus(true);
                        successalert.setTitle("LOGIN SUCCESS");
                        successalert.setHeaderText(null);
                        successalert.setContentText("WELCOME BACK " + storedDatabaseUsername + "!!");
                        successalert.showAndWait();
                    } else {
                        setStatus(false);
                        failurealert.setTitle("LOGIN FAILED");
                        failurealert.setHeaderText(null);
                        failurealert.setContentText("INCORRECT PASWORD");
                        failurealert.showAndWait();
                    }
                    break;
                } else {
                    failurealert.setTitle("LOGIN FAILED");
                    failurealert.setHeaderText(null);
                    failurealert.setContentText("INCORRECT USERNAME");
                    failurealert.showAndWait();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            failurealert.setTitle("LOGIN FAILED");
            failurealert.setHeaderText(null);
            failurealert.setContentText(e.toString());
            failurealert.showAndWait();
            System.out.println(e);
        }
        return getStatus();
    }
//    FirstName,LastName,userName,userType,user_password,user_telephone_number,user_profile_picture,Farm_Name,Account_Created,Account_Last_Updated

    public void AddUser(String newFirstName, String newLastName, String newUserName, String newUserType, String newUser_password, String newUser_telephone_number, String newUser_farmName) throws NoSuchAlgorithmException,InvalidKeySpecException{
        String enc_pass = PasswordHashing.generateStrongPasswordHash(newUser_password);
//        Generate Random UserId 
        String RandomUsers_ID = RandomStringUtils.randomAlphanumeric(17).toUpperCase();
        try {
            Class.forName(dbConn.getDriver());
            Connection con = (Connection) DriverManager.getConnection(dbConn.getDatabaseUrl(), dbConn.getUser(), dbConn.getPassword());
            Statement stmt = (Statement) con.createStatement();
//     FirstName,LastName,userName,userType,user_password,user_telephone_number,user_profile_picture,Farm_Name
            stmt.executeUpdate("INSERT INTO users(User_ID,FirstName,LastName,userName,userType,user_password,user_telephone_number,Farm_Name) VALUES('" + RandomUsers_ID + "','" + newFirstName + "','" + newLastName + "','" + newUserName + "','" + newUserType + "','" + enc_pass + "','" + newUser_telephone_number + "','" + newUser_farmName + "')");
            successalert.setTitle("ADD USER STATUS");
            successalert.setHeaderText(null);
            successalert.setContentText(newFirstName + " " + newLastName + " WAS ADDED TO DATABASE SUCCESSFULLY");
            successalert.showAndWait();
        } catch (ClassNotFoundException | SQLException e) {
            failurealert.setTitle("FAILED TO ADD " + newFirstName + " " + newLastName + " TO THE DATABASE");
            failurealert.setHeaderText(null);
            failurealert.setContentText(e.toString());
            failurealert.showAndWait();
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void RemoveUser() {
    }
}
