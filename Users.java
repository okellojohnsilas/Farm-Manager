package farm_manager;

import java.sql.*;
import static javafx.application.Application.launch;
import javafx.scene.control.Alert;
import org.apache.commons.lang3.RandomStringUtils;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Users {

    Boolean Status;
    public void setStatus(Boolean loginStatus) {
        loginStatus = this.Status;
    }

    public Boolean getStatus() {
        return Status;
    }
    //    Instantiation of the Constants Class inorder to create a database connection
    Constants dbConn = new Constants();
    //    Alert Boxes
    Alert successalert = new Alert(Alert.AlertType.INFORMATION);
    Alert failurealert = new Alert(Alert.AlertType.INFORMATION);
    
    public Boolean Login(String Username, String Userpass) throws NoSuchAlgorithmException, InvalidKeySpecException {
        try {
            Class.forName(dbConn.getDriver());
            Connection con = (Connection) DriverManager.getConnection(dbConn.getDatabaseUrl(), dbConn.getUser(), dbConn.getPassword());
            Statement stmt = (Statement) con.createStatement();
            ResultSet rs = (ResultSet) stmt.executeQuery("SELECT * FROM `users` WHERE `userName` ='"+Username+"'");
            while (rs.next()){
                String storedDatabaseUsername = rs.getString("userName"); 
                System.out.println(storedDatabaseUsername);
                if(Username == null ? storedDatabaseUsername == null : Username.equals(storedDatabaseUsername)){
                    String storedDatabasePassword = (rs.getString("user_password"));
                    boolean isDecPass =  PasswordHashing.validatePassword(Userpass,storedDatabasePassword);
                    if(isDecPass == true){
                        Status = true;
                        setStatus(Status);
                        successalert.setTitle("LOGIN SUCCESS");
                        successalert.setHeaderText(null);
                        successalert.setContentText("WELCOME BACK " +storedDatabaseUsername+ "!!");
                        successalert.showAndWait();
                    } else{
                        Status = false;
                        setStatus(Status);
//                        failurealert.setTitle("LOGIN FAILED");
//                        failurealert.setHeaderText(null);
//                        failurealert.setContentText("INCORRECT PASWORD");
//                        failurealert.showAndWait();
                        System.out.println("Sorry Incorrect Password");
                    }
                }
                else {
//                    failurealert.setTitle("LOGIN FAILED");
//                    failurealert.setHeaderText(null);
//                    failurealert.setContentText("INCORRECT USERNAME");
//                    failurealert.showAndWait();
                    System.out.println("Sorry Incorrect Username");
                }
//                break;
            }
        } catch (ClassNotFoundException | SQLException e) {
            failurealert.setTitle("LOGIN FAILED");
            failurealert.setHeaderText(null);
            failurealert.setContentText(e.toString());
            failurealert.showAndWait();
            System.out.println(e);
        }
        System.out.println(getStatus());
        return getStatus();
    }
    
    public void AddUser(String newFirstName, String newLastName, String newUserName, String newUserType, String newUser_password, String newUser_telephone_number, String newUser_farmName) throws NoSuchAlgorithmException,InvalidKeySpecException{
        String enc_pass = PasswordHashing.generateStrongPasswordHash(newUser_password);
        // Generate Random UserId 
        String RandomUsers_ID = RandomStringUtils.randomAlphanumeric(17).toUpperCase();
        try {
            Class.forName(dbConn.getDriver());
            Connection con = (Connection) DriverManager.getConnection(dbConn.getDatabaseUrl(), dbConn.getUser(), dbConn.getPassword());
            Statement stmt = (Statement) con.createStatement();
            // FirstName,LastName,userName,userType,user_password,user_telephone_number,user_profile_picture,Farm_Name
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
    
    public void removeUser(String Userid) {
    }
    public void viewUsers(){
        try {
            Class.forName(dbConn.getDriver());
            Connection con = (Connection) DriverManager.getConnection(dbConn.getDatabaseUrl(), dbConn.getUser(), dbConn.getPassword());
            Statement stmt = (Statement) con.createStatement();
            ResultSet rs = (ResultSet) stmt.executeQuery("SELECT * FROM `users`");
        }catch(Exception viewUserException){
            viewUserException.printStackTrace();
        }
    }
}
