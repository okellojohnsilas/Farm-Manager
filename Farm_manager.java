package farm_manager;

import java.sql.SQLException;
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
import org.apache.commons.lang3.RandomStringUtils;

public class Farm_manager extends Application{
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
        a_genderComboBox.getItems().addAll("Male","Female");
        a_genderComboBox.setEditable(false);
//        Horntype ComboBox
        ComboBox h_typeComboBox = new ComboBox();
        h_typeComboBox.getItems().addAll("Short","Long","None");
        h_typeComboBox.setEditable(true);
//        Agegroup ComboBox
        ComboBox a_ageGroupComboBox = new ComboBox();
        a_ageGroupComboBox.getItems().addAll("Mature","Calf","Youngling");
        a_ageGroupComboBox.setEditable(true);
//      Creating the Buttons
        Button buyAnimalButton = new Button("BUY");
        Button salesAnimalButton = new Button("ANIMAL SALES");
//      Creating the GridPane
        GridPane initialgridpane = new GridPane();
//      Setting up size of Grid pane
        initialgridpane.setMinSize(600,400);
//      Setting the Padding
        initialgridpane.setPadding(new Insets(10,10,10,10));
//      Setting the vertical and horizontal gaps between the columns
        initialgridpane.setVgap(10);
        initialgridpane.setHgap(10);
//      Setting the grid alignment
        initialgridpane.setAlignment(Pos.CENTER);
//      Arranging all the nodes on the grid
        initialgridpane.add(a_breed, 0, 0);
        initialgridpane.add(a_breedTextField,1, 0);
        initialgridpane.add(a_gender, 0, 2);
        initialgridpane.add(a_genderComboBox,1, 2);
        initialgridpane.add(a_color, 0, 4);
        initialgridpane.add(a_colorTextField,1, 4);
        initialgridpane.add(h_type, 0, 6);
        initialgridpane.add(h_typeComboBox,1, 6);
        initialgridpane.add(a_ageGroup, 0, 8);
        initialgridpane.add(a_ageGroupComboBox,1, 8);
//        initialgridpane.add(a_picture, 0, 10);
//        initialgridpane.add(filechoice,1, 10);
        initialgridpane.add(a_price, 0, 10);
        initialgridpane.add(a_priceTextField,1, 10);
        initialgridpane.add(tagNum, 0, 12);
        initialgridpane.add(tagNumTextField, 1, 12);
        initialgridpane.add(firstusermessage,1, 14);
        initialgridpane.add(buyAnimalButton,1, 16);
        initialgridpane.add(salesAnimalButton,2, 16);
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
        salesgridpane.setMinSize(600,400);
//      Setting the Padding
        salesgridpane.setPadding(new Insets(10,10,10,10));
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
        buyAnimalButton.setOnAction((e) ->{
            try {
                cow.purchaseAnimal(tagNumTextField.getText(),a_breedTextField.getText(),a_genderComboBox.getValue().toString(),a_colorTextField.getText(),h_typeComboBox.getValue().toString(),a_ageGroupComboBox.getValue().toString(),a_priceTextField.getText());
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
        saleAnimalButton.setOnAction((e) ->{
            try {
                cow.saleAnimal(secondtagNumTextField.getText(),buyerTextField.getText(),buyerContactTextField.getText(),salespriceTextField.getText());
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
        primarystage.setScene(testScene);
        primarystage.show();
   }
   public static void main(String[] args){
         launch(args);
   }
}
