package farm_manager;

import static java.lang.Integer.parseInt;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class Farm_manager extends Application {

    @Override
    public void start(Stage primarystage) throws Exception {
//      ========================BUY ANIMAL INTERFACE==============================================================  
//      Text displayed
        Text firstusermessage = new Text("");
        Text tagNum = new Text("TAG NUMBER: ");
        Text a_breed = new Text("BREED: ");
        Text a_gender = new Text("GENDER: ");
        Text a_color = new Text("COLOR: ");
        Text h_type = new Text("HORN TYPE: ");
        Text a_ageGroup = new Text("AGE GROUP: ");
        Text a_picture = new Text("PICTURE: ");
        Text a_price = new Text("PRICE: ");
//      Creating the TextFields
        TextField a_breedTextField = new TextField();
        TextField a_priceTextField = new TextField();
        TextField a_colorTextField = new TextField();
        TextField tagNumTextField = new TextField();
//      ComboBox Section
//      Gender ComboBox
        ComboBox a_genderComboBox = new ComboBox();
        a_genderComboBox.getItems().addAll("Male", "Female");
        a_genderComboBox.setEditable(false);
//        Horntype ComboBox
        ComboBox h_typeComboBox = new ComboBox();
        h_typeComboBox.getItems().addAll("Short", "Long", "None");
        h_typeComboBox.setEditable(true);
//        Agegroup ComboBox
        ComboBox a_ageGroupComboBox = new ComboBox();
        a_ageGroupComboBox.getItems().addAll("Mature", "Calf", "Youngling");
        a_ageGroupComboBox.setEditable(true);
//      Creating the Buttons
        Button buyAnimalButton = new Button("BUY");
        Button salesAnimalButton = new Button("ANIMAL SALES");
//      Creating the GridPane
        GridPane initialgridpane = new GridPane();
//      Setting up size of Grid pane
        initialgridpane.setMinSize(600, 400);
//      Setting the Padding
        initialgridpane.setPadding(new Insets(10, 10, 10, 10));
//      Setting the vertical and horizontal gaps between the columns
        initialgridpane.setVgap(10);
        initialgridpane.setHgap(10);
//      Setting the grid alignment
        initialgridpane.setAlignment(Pos.CENTER);
//      Arranging all the nodes on the grid
        initialgridpane.add(a_breed, 0, 0);
        initialgridpane.add(a_breedTextField, 1, 0);
        initialgridpane.add(a_gender, 0, 2);
        initialgridpane.add(a_genderComboBox, 1, 2);
        initialgridpane.add(a_color, 0, 4);
        initialgridpane.add(a_colorTextField, 1, 4);
        initialgridpane.add(h_type, 0, 6);
        initialgridpane.add(h_typeComboBox, 1, 6);
        initialgridpane.add(a_ageGroup, 0, 8);
        initialgridpane.add(a_ageGroupComboBox, 1, 8);
//        initialgridpane.add(a_picture, 0, 10);
//        initialgridpane.add(filechoice,1, 10);
        initialgridpane.add(a_price, 0, 10);
        initialgridpane.add(a_priceTextField, 1, 10);
        initialgridpane.add(tagNum, 0, 12);
        initialgridpane.add(tagNumTextField, 1, 12);
        initialgridpane.add(firstusermessage, 1, 14);
        initialgridpane.add(buyAnimalButton, 1, 16);
        initialgridpane.add(salesAnimalButton, 2, 16);
        buyAnimalButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill:white; -fx-font-size:13pt;");
        salesAnimalButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill:white; -fx-font-size:13pt;");
        initialgridpane.setStyle("-fx-background-color:BEIGE;");
        Scene testScene = new Scene(initialgridpane);
//      ========================END OF BUY ANIMAL INTERFACE==============================================================
//      ========================SALE ANIMAL INTERFACE====================================================================
//        The text to be displayed
        Text Secondusermessage = new Text("");
        Text secondtagNum = new Text("TAG NUMBER: ");
        Text animalBuyer = new Text("BUYER: ");
        Text amountPaid = new Text("AMOUNT PAID: ");
        Text buyerContact = new Text("BUYER CONTACT: ");
//      Creating the TextFields
        TextField secondtagNumTextField = new TextField();
        TextField salespriceTextField = new TextField();
        TextField buyerTextField = new TextField();
        TextField buyerContactTextField = new TextField();
//      Creating the Buttons
        Button saleAnimalButton = new Button("SALE ANIMAL");
        Button backButton = new Button("BUY ANIMAL");
//      Instatiating the Gridpane
        GridPane salesgridpane = new GridPane();
//      Setting up size of Grid pane
        salesgridpane.setMinSize(600, 400);
//      Setting the Padding
        salesgridpane.setPadding(new Insets(10, 10, 10, 10));
//      Setting the vertical and horizontal gaps between the columns
        salesgridpane.setVgap(10);
        salesgridpane.setHgap(10);
//      Setting the grid alignment
        salesgridpane.setAlignment(Pos.CENTER);
//      Arranging all the nodes on the grid
        salesgridpane.add(secondtagNum, 0, 0);
        salesgridpane.add(secondtagNumTextField, 1, 0);
        salesgridpane.add(animalBuyer, 0, 2);
        salesgridpane.add(buyerTextField, 1, 2);
        salesgridpane.add(amountPaid, 0, 4);
        salesgridpane.add(salespriceTextField, 1, 4);
        salesgridpane.add(buyerContact, 0, 6);
        salesgridpane.add(buyerContactTextField, 1, 6);
        salesgridpane.add(Secondusermessage, 1, 7);
        salesgridpane.add(saleAnimalButton, 1, 8);
        salesgridpane.add(backButton, 2, 8);
        saleAnimalButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill:white; -fx-font-size:13pt;");
        backButton.setStyle("-fx-background-color: darkslateblue; -fx-text-fill:white; -fx-font-size:13pt;");
        Scene salesScene = new Scene(salesgridpane);
        primarystage.setTitle("FARM MANAGER");
//      ========================END OF SALE ANIMAL INTERFACE====================================================================
//        Adding action events
//        Animal related buttons
        Animal cow = new Animal();
        buyAnimalButton.setOnAction((e) -> {
            try {
                cow.purchaseAnimal(tagNumTextField.getText(), a_breedTextField.getText(), a_genderComboBox.getValue().toString(), a_colorTextField.getText(), h_typeComboBox.getValue().toString(), a_ageGroupComboBox.getValue().toString(), a_priceTextField.getText());
                tagNumTextField.clear();
                a_breedTextField.clear();
                a_colorTextField.clear();
                a_priceTextField.clear();
                a_genderComboBox.getSelectionModel().clearSelection();
                a_ageGroupComboBox.getSelectionModel().clearSelection();
                h_typeComboBox.getSelectionModel().clearSelection();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Farm_manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        saleAnimalButton.setOnAction((e) -> {
            try {
                cow.saleAnimal(secondtagNumTextField.getText(), buyerTextField.getText(), buyerContactTextField.getText(), salespriceTextField.getText());
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Farm_manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        salesAnimalButton.setOnAction(e -> {
            primarystage.setScene(salesScene);
        });
        backButton.setOnAction((e) -> {
            primarystage.setScene(testScene);
        });
        Users farmer = new Users();
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
        userTypeComboBox.getItems().addAll("Admin", "User");
        userTypeComboBox.setEditable(false);
//      PasswordField
        PasswordField newUserPassword = new PasswordField();
        PasswordField ConfirmNewUserPassword = new PasswordField();
//      Buttons
        Button addUser_Button = new Button("ADD");
//      Creating new GridPane
        GridPane addUserGridpane = new GridPane();
//      Setting up size of Grid pane
        addUserGridpane.setMinSize(600, 400);
//      Setting the Padding
        addUserGridpane.setPadding(new Insets(10, 10, 10, 10));
//      Setting the vertical and horizontal gaps between the columns
        addUserGridpane.setVgap(10);
        addUserGridpane.setHgap(10);
//      Setting the grid alignment
        addUserGridpane.setAlignment(Pos.CENTER);
//      Arranging all the nodes on the gridFFFFFF
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
        addUser_Button.setOnAction((e) -> {
            if (newUserPassword.getText() == null ? ConfirmNewUserPassword.getText() == null : newUserPassword.getText().equals(ConfirmNewUserPassword.getText())){
                try{
                    farmer.AddUser(adduserfirstNameTextField.getText(), adduserlastNameTextField.getText(), adduserUserNameTextField.getText(), userTypeComboBox.getValue().toString(), newUserPassword.getText(), addusertelephoneNumberTextField.getText(), adduserfarmNameTextField.getText()); 
                }
                catch (NoSuchAlgorithmException | InvalidKeySpecException adduserException) {
                    adduserException.printStackTrace();
                }
                adduserfirstNameTextField.clear();
                adduserlastNameTextField.clear();
                adduserUserNameTextField.clear();
                newUserPassword.clear();
                addusertelephoneNumberTextField.clear();
                userTypeComboBox.getSelectionModel().clearSelection();
                adduserfarmNameTextField.clear();
                primarystage.setScene(testScene);
            } else {
                System.out.println("The passwords didnt match");
            }
        });
//      ========================END OF ADD USER INTERFACE==========================================================================
//      ========================LOGIN INTERFACE=================================================================================
//        Text
        Text usernameText = new Text("USERNAME");
        Text passwordText = new Text("PASSWORD");
//        Textfields
        TextField usernameTextField = new TextField();
        PasswordField passwordTextField = new PasswordField();
//        Buttons
        Button loginButton = new Button("LOGIN");
        Button registerButton = new Button("REGISTER");
//        Creating the gridpane
        GridPane loginGridpane = new GridPane();
//      Setting up size of Grid pane
        loginGridpane.setMinSize(600, 400);
//      Setting the Padding
        loginGridpane.setPadding(new Insets(10, 10, 10, 10));
//      Setting the vertical and horizontal gaps between the columns
        loginGridpane.setVgap(10);
        loginGridpane.setHgap(10);
//      Setting the grid alignment
        loginGridpane.setAlignment(Pos.CENTER);
//      Arranging all the nodes on the grid
        loginGridpane.add(usernameText, 0, 0);
        loginGridpane.add(passwordText, 0, 2);
        loginGridpane.add(usernameTextField, 1, 0);
        loginGridpane.add(passwordTextField, 1, 2);
        loginGridpane.add(loginButton, 1, 4);
        loginGridpane.add(registerButton, 1, 6);
        Scene loginScene = new Scene(loginGridpane);
        loginButton.setOnAction((e) -> {
            try {
                boolean isCurrentStatus = farmer.Login(usernameTextField.getText(), passwordTextField.getText());
//                Checking if Login was successful
                if (isCurrentStatus == true) {
                try {
                    primarystage.setScene(testScene);
                } catch (Exception loginException) {
                    loginException.printStackTrace();
                }
//                If the Login was unsuccessful
                } else {
                    primarystage.setScene(loginScene);
                    usernameTextField.clear();
                    passwordTextField.clear();
                }
            } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
                Logger.getLogger(Farm_manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        registerButton.setOnAction((e) -> {
            primarystage.setScene(addUserScene);
        });
//      ========================END OF LOGIN INTERFACE=============================================================================
//      ========================USERS TABLEVIEW INTERFACE==========================================================================
//      Instantiate the tableview class using viewUserstableView object
//        Button tableactionbutton = new Button();
        TableView viewUserstableView = new TableView();
        Constants DBconnection = new Constants();
        Class.forName(DBconnection.getDriver());
        Connection con = (Connection) DriverManager.getConnection(DBconnection.getDatabaseUrl(), DBconnection.getUser(), DBconnection.getPassword());
        Statement stmt = (Statement) con.createStatement();
        ResultSet rs = (ResultSet) stmt.executeQuery("SELECT * FROM `users`");
        while (rs.next()){
            String storedDbfName = rs.getString("FirstName");
            String storedDblName = rs.getString("LastName");
            String storedDbuName = rs.getString("userName");
            String storedDbuType = rs.getString("userType");
            String storedDbPhone = rs.getString("user_telephone_number");
            String storedDbFarmName = rs.getString("Farm_Name");
//        }
            TableColumn<String, usersDisplay> column1 = new TableColumn<>("First Name");
            column1.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
            TableColumn<String, usersDisplay> column2 = new TableColumn<>("Last Name");
            column2.setCellValueFactory(new PropertyValueFactory<>("LastName"));
            TableColumn<String, usersDisplay> column3 = new TableColumn<>("Username");
            column3.setCellValueFactory(new PropertyValueFactory<>("Username"));
            TableColumn<String, usersDisplay> column4 = new TableColumn<>("Usertype");
            column4.setCellValueFactory(new PropertyValueFactory<>("Usertype"));
            TableColumn<String, usersDisplay> column5 = new TableColumn<>("Telephone Number");
            column5.setCellValueFactory(new PropertyValueFactory<>("telephone_num"));
            TableColumn<String, usersDisplay> column6 = new TableColumn<>("Farm Name");
            column6.setCellValueFactory(new PropertyValueFactory<>("farm"));
            viewUserstableView.getColumns().addAll(column1,column2,column3,column4,column5,column6);
            viewUserstableView.getItems().addAll(new usersDisplay(storedDbfName,storedDblName,storedDbuName,storedDbuType,storedDbPhone,storedDbFarmName));
        }
        VBox usersvbox = new VBox(viewUserstableView);
        Scene viewUsersScene = new Scene(usersvbox);
//      ========================END OF USERS TABLEVIEW INTERFACE===================================================================
        primarystage.setScene(viewUsersScene);
        primarystage.show();
//        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
