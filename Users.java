package farm_manager;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.commons.lang3.RandomStringUtils;

public class Users extends Application{
    Boolean Status = false;
    public void setStatus(Boolean loginStatus){
        loginStatus = this.Status;
    }
    public Boolean getStatus(){
        return Status;
    }
   @Override     
   public void start(Stage usersstage) throws Exception {
//      ========================LOGIN INTERFACE=================================================================================
////        Text
//        Text usernameText = new Text("USERNAME");
//        Text passwordText = new Text("PASSWORD");
////        Textfields
//        TextField usernameTextField = new TextField();
//        PasswordField  passwordTextField = new PasswordField ();
////        Buttons
//        Button loginButton = new Button("LOGIN");
//        Button registerButton = new Button("REGISTER");
////        Creating the gridpane
//        GridPane loginGridpane = new GridPane();
////      Setting up size of Grid pane
//        loginGridpane.setMinSize(600,400);
////      Setting the Padding
//        loginGridpane.setPadding(new Insets(10,10,10,10));
////      Setting the vertical and horizontal gaps between the columns
//        loginGridpane.setVgap(10);
//        loginGridpane.setHgap(10);
////      Setting the grid alignment
//        loginGridpane.setAlignment(Pos.CENTER);
////      Arranging all the nodes on the grid
//        loginGridpane.add(usernameText, 0, 0);
//        loginGridpane.add(passwordText, 0, 2);
//        loginGridpane.add(usernameTextField, 1, 0);
//        loginGridpane.add(passwordTextField, 1, 2);
//        loginGridpane.add(loginButton, 1, 4);
//        loginGridpane.add(registerButton, 1, 6);
//        Scene loginScene = new Scene(loginGridpane);
//        usersstage.setScene(loginScene);
//        usersstage.setTitle("LOGIN FORM");
//        usersstage.show();
//        loginButton.setOnAction((e) ->{
//                Login(usernameTextField.getText(),passwordTextField.getText());
//                Farm_manager farmer = new Farm_manager();
//                if(getStatus() == true){
//                    try{
//                    farmer.start(usersstage);
//                    }catch(Exception ex){
//                        ex.printStackTrace();
//                    }
//                    usernameTextField.clear();
//                    passwordTextField.clear();
//                }else{
//                    
//                }
//        });
//      ========================END OF LOGIN INTERFACE=============================================================================
//      ========================ADD USER INTERFACE=================================================================================
//      Texts
        Text adduserFirstNameText = new Text("FIRST NAME");
        Text adduserLastNameText = new Text("LAST NAME");
        Text adduserUsernameText = new Text("USERNAME");
        Text adduseruserTypeText = new Text("USERTYPE");
        Text adduseruser_PasswordText = new Text("PASSWORD");
        Text adduserConfirmUser_PasswordText = new Text("CONFIRM PASSWORD");
        Text adduserTelephoneText = new Text("TELEPHONE CONTACT(e.g +256 123....)");
        Text adduserFarmNameText = new Text("FARM NAME");
//      TextFields
        TextField adduserfirstNameTextField = new TextField();
        TextField adduserlastNameTextField = new TextField();
        TextField adduserUserNameTextField = new TextField();
        TextField addusertelephoneNumberTextField = new TextField();
        TextField adduserfarmNameTextField = new TextField();
//      Combo Box
        ComboBox userTypeComboBox = new ComboBox();
        userTypeComboBox.getItems().addAll("Admin","User");
        userTypeComboBox.setEditable(false);
//      PasswordField
        PasswordField newUserPassword = new PasswordField();
        PasswordField ConfirmNewUserPassword = new PasswordField();
//      Buttons
        Button addUser_Button= new Button("ADD");
//      Creating new GridPane
        GridPane addUserGridpane = new GridPane();
//      Setting up size of Grid pane
        addUserGridpane.setMinSize(600,400);
//      Setting the Padding
        addUserGridpane.setPadding(new Insets(10,10,10,10));
//      Setting the vertical and horizontal gaps between the columns
        addUserGridpane.setVgap(10);
        addUserGridpane.setHgap(10);
//      Setting the grid alignment
        addUserGridpane.setAlignment(Pos.CENTER);
//      Arranging all the nodes on the grid
        addUserGridpane.add(adduserFirstNameText, 0, 0);
        addUserGridpane.add(adduserLastNameText, 0, 2);
        addUserGridpane.add(adduseruserTypeText, 0, 4);
        addUserGridpane.add(adduserUsernameText, 0, 6);
        addUserGridpane.add(adduseruser_PasswordText, 0, 8);
        addUserGridpane.add(adduserConfirmUser_PasswordText, 0, 10);
        addUserGridpane.add(adduserTelephoneText, 0, 12);
        addUserGridpane.add(adduserFarmNameText, 0, 14);
        addUserGridpane.add(adduserfirstNameTextField, 1, 0);
        addUserGridpane.add(adduserlastNameTextField, 1, 2);
        addUserGridpane.add(userTypeComboBox, 1, 4);
        addUserGridpane.add(adduserUserNameTextField, 1, 6);
        addUserGridpane.add(newUserPassword, 1, 8);
        addUserGridpane.add(ConfirmNewUserPassword, 1, 10);
        addUserGridpane.add(addusertelephoneNumberTextField, 1, 12);
        addUserGridpane.add(adduserfarmNameTextField, 1, 14);
        addUserGridpane.add(addUser_Button, 1, 16);
        Scene addUserScene = new Scene(addUserGridpane);
        usersstage.setScene(addUserScene);
        usersstage.setTitle("ADD USERS FORM");
        usersstage.show();
        addUser_Button.setOnAction((e) ->{
            if(newUserPassword.getText() == null ? ConfirmNewUserPassword.getText() == null : newUserPassword.getText().equals(ConfirmNewUserPassword.getText())){
//            FirstName,LastName,userName,userType,user_password,user_telephone_number,Farm_Name
                AddUser(adduserfirstNameTextField.getText(),adduserlastNameTextField.getText(),adduserUserNameTextField.getText(),userTypeComboBox.getValue().toString(),newUserPassword.getText(),addusertelephoneNumberTextField.getText(),adduserfarmNameTextField.getText());
                adduserfirstNameTextField.clear();
                adduserlastNameTextField.clear();
                adduserUserNameTextField.clear();
                newUserPassword.clear();
                addusertelephoneNumberTextField.clear();
                userTypeComboBox.getSelectionModel().clearSelection();
                adduserfarmNameTextField.clear();
            }
            else{
                System.out.println("The passwords didnt match");
            }
        });
//      ========================END OF ADD USER INTERFACE==========================================================================
 }
    Constants dbConn = new Constants();
    //    Alert Boxes
    Alert successalert = new Alert(Alert.AlertType.INFORMATION);
    Alert failurealert = new Alert(Alert.AlertType.INFORMATION);
    public Boolean Login(String User, String UserPass){
       try {  
            Class.forName(dbConn.getDriver());
            Connection con = (Connection)DriverManager.getConnection(dbConn.getDatabaseUrl(),dbConn.getUser(),dbConn.getPassword());
            Statement stmt = (Statement)con.createStatement();
            ResultSet rs = (ResultSet) stmt.executeQuery("SELECT * FROM users");
            while(rs.next()){
                String storedDatabaseUsername = rs.getString("Username");
                String storedDatabasePassword = (rs.getString("User_password"));
                if(User.equals(storedDatabaseUsername)){
                    String secretKey = "@!#-%$&!~";
                    final String iv = "0123456789123456";
                    String decPass = Crypto.decrypt(storedDatabasePassword,iv,secretKey);
                    if(UserPass.equals(decPass)){
                        setStatus(true);
                        successalert.setTitle("LOGIN SUCCESS");
                        successalert.setHeaderText(null);
                        successalert.setContentText("WELCOME BACK "+storedDatabaseUsername+"!!");
                        successalert.showAndWait();
                    }
                    else{
                        setStatus(false);
                        failurealert.setTitle("LOGIN FAILED");
                        failurealert.setHeaderText(null);
                        failurealert.setContentText("INCORRECT PASWORD");
                        failurealert.showAndWait();
                    }
                    break;
                }
                else{
                    failurealert.setTitle("LOGIN FAILED");
                    failurealert.setHeaderText(null);
                    failurealert.setContentText("INCORRECT USERNAME");
                    failurealert.showAndWait();
                }
            }
        }
       catch(ClassNotFoundException | SQLException e ){
        failurealert.setTitle("LOGIN FAILED");
        failurealert.setHeaderText(null);
        failurealert.setContentText(e.toString());
        failurealert.showAndWait();
        System.out.println(e);
      }
      return getStatus();
    }
//    FirstName,LastName,userName,userType,user_password,user_telephone_number,user_profile_picture,Farm_Name,Account_Created,Account_Last_Updated
    public void AddUser(String newFirstName,String newLastName,String newUserName,String newUserType,String newUser_password,String newUser_telephone_number,String newUser_farmName){
        String secretKey = "@!#-%$&!~";
        final String iv = "0123456789123456";
        String enc_pass = Crypto.encrypt(newUser_password,iv,secretKey);
        String RandomUsers_ID = RandomStringUtils.randomAlphanumeric(17).toUpperCase();
        try {  
            Class.forName(dbConn.getDriver());
            Connection con = (Connection)DriverManager.getConnection(dbConn.getDatabaseUrl(),dbConn.getUser(),dbConn.getPassword());
            Statement stmt = (Statement)con.createStatement();
//     FirstName,LastName,userName,userType,user_password,user_telephone_number,user_profile_picture,Farm_Name
            stmt.executeUpdate("INSERT INTO users(User_ID,FirstName,LastName,userName,userType,user_password,user_telephone_number,Farm_Name) VALUES('"+RandomUsers_ID+"','"+newFirstName+"','"+newLastName+"','"+newUserName+"','"+newUserType+"','"+enc_pass+"','"+newUser_telephone_number+"','"+newUser_farmName+"')");
            successalert.setTitle("ADD USER STATUS");
            successalert.setHeaderText(null);
            successalert.setContentText(newFirstName+" "+newLastName+" WAS ADDED TO DATABASE SUCCESSFULLY");
            successalert.showAndWait();
      }catch(ClassNotFoundException | SQLException e ){
            failurealert.setTitle("FAILED TO ADD "+newFirstName+" "+newLastName+" TO THE DATABASE");
            failurealert.setHeaderText(null);
            failurealert.setContentText(e.toString());
            failurealert.showAndWait();
            System.out.println(e);
      }
    }
    public static void main(String[] args){
         launch(args);
    }
    public void RemoveUser(){
    }
}
