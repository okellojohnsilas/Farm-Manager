package farm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class Farm extends Application {
    @Override
    public void start(Stage primarystage) throws Exception {
        Button returnBackToMenuButton = new Button("MENU");
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
//        Button salesAnimalButton = new Button("MENU");
//      Creating the GridPane
        GridPane buyAnimalgridpane = new GridPane();
//      Setting up size of Grid pane
        buyAnimalgridpane.setMinSize(600, 400);
//      Setting the Padding
        buyAnimalgridpane.setPadding(new Insets(10, 10, 10, 10));
//      Setting the vertical and horizontal gaps between the columns
        buyAnimalgridpane.setVgap(10);
        buyAnimalgridpane.setHgap(10);
//      Setting the grid alignment
        buyAnimalgridpane.setAlignment(Pos.CENTER);
//      Arranging all the nodes on the grid
        buyAnimalgridpane.add(a_breed, 0, 0);
        buyAnimalgridpane.add(a_breedTextField, 1, 0);
        buyAnimalgridpane.add(a_gender, 0, 2);
        buyAnimalgridpane.add(a_genderComboBox, 1, 2);
        buyAnimalgridpane.add(a_color, 0, 4);
        buyAnimalgridpane.add(a_colorTextField, 1, 4);
        buyAnimalgridpane.add(h_type, 0, 6);
        buyAnimalgridpane.add(h_typeComboBox, 1, 6);
        buyAnimalgridpane.add(a_ageGroup, 0, 8);
        buyAnimalgridpane.add(a_ageGroupComboBox, 1, 8);
//        initialgridpane.add(a_picture, 0, 10);
//        initialgridpane.add(filechoice,1, 10);
        buyAnimalgridpane.add(a_price, 0, 10);
        buyAnimalgridpane.add(a_priceTextField, 1, 10);
        buyAnimalgridpane.add(tagNum, 0, 12);
        buyAnimalgridpane.add(tagNumTextField, 1, 12);
        buyAnimalgridpane.add(firstusermessage, 1, 14);
        buyAnimalgridpane.add(buyAnimalButton, 1, 16);
//        buyAnimalgridpane.add(salesAnimalButton, 2, 16);
        buyAnimalgridpane.add(returnBackToMenuButton, 2, 18);
        Scene buyAnimalScene = new Scene(buyAnimalgridpane);
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
        Button backButton = new Button("MENU");
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
        Scene salesScene = new Scene(salesgridpane);
        primarystage.setTitle("FARM MANAGER");
//      ========================END OF SALE ANIMAL INTERFACE====================================================================
//        Adding action events
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
                Logger.getLogger(Farm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        saleAnimalButton.setOnAction((e) -> {
            try {
                cow.saleAnimal(secondtagNumTextField.getText(), buyerTextField.getText(), buyerContactTextField.getText(), salespriceTextField.getText());
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Farm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
//      ========================MENU INTERFACE=====================================================================================
//        Buttons
        Button removeAnimalMenuButton = new Button("REMOVE ANIMAL");
        Button purchaseAnimalMenuButton = new Button("BUY ANIMAL");
        Button saleAnimalMenuButton = new Button("SALE ANIMAL");
        Button viewAnimalMenuButton = new Button("VIEW ANIMALS");
        GridPane menuGridpane = new GridPane();
//        Labels
//      Setting up size of Grid pane
        menuGridpane.setMinSize(600, 400);
//      Setting the Padding
        menuGridpane.setPadding(new Insets(10, 10, 10, 10));
//      Setting the vertical and horizontal gaps between the columns
        menuGridpane.setVgap(10);
        menuGridpane.setHgap(10);
//      Setting the grid alignment
        menuGridpane.setAlignment(Pos.CENTER);
//      Arranging all the nodes on the grid
        menuGridpane.add(saleAnimalMenuButton, 1, 0);
        menuGridpane.add(purchaseAnimalMenuButton, 2, 0);
        menuGridpane.add(removeAnimalMenuButton, 1, 4);
        menuGridpane.add(viewAnimalMenuButton, 2, 4);
        Scene menuScene = new Scene(menuGridpane);
//      ========================END OF MENU INTERFACE==============================================================================
//      ========================ANIMAL TABLEVIEW INTERFACE==========================================================================
//      Instantiate the tableview class using viewUserstableView object
        TableView viewAnimaltableView = new TableView();
        Constants DBconnection = new Constants();
        Class.forName(DBconnection.getDriver());
        Connection con = (Connection) DriverManager.getConnection(DBconnection.getDatabaseUrl(), DBconnection.getUser(), DBconnection.getPassword());
        Statement stmt = (Statement) con.createStatement();
        ResultSet rs = (ResultSet) stmt.executeQuery("SELECT * FROM `animal`");
        final ObservableList<UsersDisplay> users = FXCollections.observableArrayList();
        TableColumn<UsersDisplay, String> column1 = new TableColumn<>("First Name");
            column1.setCellValueFactory(new PropertyValueFactory<UsersDisplay, String>("FirstName"));
            TableColumn<UsersDisplay, String> column2 = new TableColumn<>("Last Name");
            column2.setCellValueFactory(new PropertyValueFactory<UsersDisplay, String>("LastName"));
            TableColumn<UsersDisplay, String> column3 = new TableColumn<>("Username");
            column3.setCellValueFactory(new PropertyValueFactory<UsersDisplay, String>("Username"));
            TableColumn<UsersDisplay, String> column4 = new TableColumn<>("Usertype");
            column4.setCellValueFactory(new PropertyValueFactory<UsersDisplay, String>("Usertype"));
            TableColumn<UsersDisplay, String> column5 = new TableColumn<>("Telephone Number");
            column5.setCellValueFactory(new PropertyValueFactory<UsersDisplay, String>("telephone_num"));
            TableColumn<UsersDisplay, String> column6 = new TableColumn<>("Farm Name");
            column6.setCellValueFactory(new PropertyValueFactory<UsersDisplay, String>("farm"));
            TableColumn<UsersDisplay,Button> column7 = new TableColumn<>("Edit");
            Callback<TableColumn<UsersDisplay,Button>, TableCell<UsersDisplay,Button>> cellFactory = new Callback<TableColumn<UsersDisplay,Button>, TableCell<UsersDisplay,Button>>(){
                @Override
                public TableCell call(final TableColumn<UsersDisplay,Button> param){
                    final TableCell<UsersDisplay, String> cell = new TableCell<UsersDisplay, String>() {
                    final Button editBtn = new Button("Edit");
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {                            
                            setGraphic(editBtn);
                            editBtn.setOnAction((e) -> {
//                                ResultSet grs = (ResultSet) stmt.executeQuery("SELECT * FROM `users` WHERE `User_ID` = '"+rs.getString("User_ID")+"'");
//                                farmer.setEdituserInfo(grs.getString("User_ID"));
//                                primarystage.setScene(editUserScene);
                            });
                            setText(null);
                        }
                    }
                };
                return cell;
                }
            };
            column7.setCellFactory(cellFactory);
            viewAnimaltableView.getColumns().addAll(column1,column2,column3,column4,column5,column6,column7);
        while (rs.next()){
            String storedDbfName = rs.getString("FirstName");
            String storedDblName = rs.getString("LastName");
            String storedDbuName = rs.getString("userName");
            String storedDbuType = rs.getString("userType");
            String storedDbPhone = rs.getString("user_telephone_number");
            String storedDbFarmName = rs.getString("Farm_Name");
            Button editBtn = new Button("Edit");
            UsersDisplay user = new UsersDisplay(storedDbfName,storedDblName,storedDbuName,storedDbuType,storedDbPhone,storedDbFarmName,editBtn);
            users.add(user);            
//            viewUserstableView.getItems().addAll(new UsersDisplay(storedDbfName,storedDblName,storedDbuName,storedDbuType,storedDbPhone,storedDbFarmName));
        }
        viewAnimaltableView.setItems(users);
        VBox usersvbox = new VBox(viewAnimaltableView);
        Scene viewanimalsScene = new Scene(usersvbox);
//      ========================END OF ANIMAL TABLEVIEW INTERFACE===================================================================
//        Universal Menu Button
        returnBackToMenuButton.setOnAction((e) -> {
            primarystage.setScene(menuScene);
        });
//        ---------------------------------------
        purchaseAnimalMenuButton.setOnAction((e) -> {
            primarystage.setScene(buyAnimalScene);    
        });
        removeAnimalMenuButton.setOnAction((e) -> {
            primarystage.setScene(salesScene);    
        });
        viewAnimalMenuButton.setOnAction((e) -> {
            primarystage.setScene(viewanimalsScene);    
        });      
//        ---------------------------------------
//        salesAnimalButton.setOnAction(e -> {
//            primarystage.setScene(menuScene);
//        });
        backButton.setOnAction((e) -> {
            primarystage.setScene(menuScene);
        });
//        ---------------------------------------
        primarystage.setScene(menuScene);
        primarystage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
