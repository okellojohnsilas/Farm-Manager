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
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class Farm extends Application {

    @Override
    public void start(Stage primarystage) throws Exception {
        Button returnBackToMenuButton = new Button("BACK TO MENU");
//      ========================BUY ANIMAL INTERFACE==============================================================  
//      Text displayed
        Text firstusermessage = new Text("");
        Text tagNum = new Text("TAG NUMBER: ");
        Text a_breed = new Text("BREED: ");
        Text a_gender = new Text("GENDER: ");
        Text a_color = new Text("COLOR: ");
        Text h_type = new Text("HORN TYPE: ");
        Text a_ageGroup = new Text("AGE GROUP: ");
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
//                String picture = (InputStream)fls;
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
//      ========================END OF MENU INTERFACE===============================================================================
//      ========================REMOVE ANIMAL INTERFACE=============================================================================
//        Buttons
        Button removeAnimButton = new Button("REMOVE");
//        Labels
        Label AnimTagLabel = new Label("TAG NUMBER");
//        TextFields
        TextField removeAnimTextField = new TextField();
//        GridPane
        GridPane removeAnimGridpane = new GridPane();
//        Setting up size of Grid pane
        removeAnimGridpane.setMinSize(600, 400);
//      Setting the Padding
        removeAnimGridpane.setPadding(new Insets(10, 10, 10, 10));
//      Setting the vertical and horizontal gaps between the columns
        removeAnimGridpane.setVgap(10);
        removeAnimGridpane.setHgap(10);
//      Setting the grid alignment
        removeAnimGridpane.setAlignment(Pos.CENTER);
//      Arranging all the nodes on the grid
        removeAnimGridpane.add(AnimTagLabel, 1, 1);
        removeAnimGridpane.add(removeAnimTextField, 2, 1);
        removeAnimGridpane.add(removeAnimButton, 2, 2);
        removeAnimGridpane.add(returnBackToMenuButton, 2, 3);
        Scene removeAnimScene = new Scene(removeAnimGridpane);
//      ========================END OF REMOVE ANIMAL INTERFACE======================================================================
//      ========================ANIMAL TABLEVIEW INTERFACE==========================================================================
//      Instantiate the tableview class using viewUserstableView object
        TableView viewAnimaltableView = new TableView();
        Constants DBconnection = new Constants();
        Class.forName(DBconnection.getDriver());
        Connection con = (Connection) DriverManager.getConnection(DBconnection.getDatabaseUrl(), DBconnection.getUser(), DBconnection.getPassword());
        Statement stmt = (Statement) con.createStatement();
        ResultSet rs = (ResultSet) stmt.executeQuery("SELECT * FROM `animal`");
//        Animal_ID	Tag_Number	Animal_breed	Animal_gender	Animal_color	Animal_type	Horn_type	Age_group	Animal_price	Animal_picture	Animal_Added	Details_Last_Updated
        final ObservableList<AnimalDisplay> animals = FXCollections.observableArrayList();
        TableColumn<AnimalDisplay, String> column1 = new TableColumn<>("Tag Number");
        column1.setCellValueFactory(new PropertyValueFactory<AnimalDisplay, String>("tagNumber"));
        TableColumn<AnimalDisplay, String> column2 = new TableColumn<>("Animal Breed");
        column2.setCellValueFactory(new PropertyValueFactory<AnimalDisplay, String>("animalBreed"));
        TableColumn<AnimalDisplay, String> column3 = new TableColumn<>("Animal Gender");
        column3.setCellValueFactory(new PropertyValueFactory<AnimalDisplay, String>("animalGender"));
        TableColumn<AnimalDisplay, String> column4 = new TableColumn<>("Animal Color");
        column4.setCellValueFactory(new PropertyValueFactory<AnimalDisplay, String>("animalColor"));
        TableColumn<AnimalDisplay, String> column5 = new TableColumn<>("Animal Type");
        column5.setCellValueFactory(new PropertyValueFactory<AnimalDisplay, String>("animalType"));
        TableColumn<AnimalDisplay, String> column6 = new TableColumn<>("Horn Type");
        column6.setCellValueFactory(new PropertyValueFactory<AnimalDisplay, String>("hornType"));
        TableColumn<AnimalDisplay, String> column7 = new TableColumn<>("Age Group");
        column7.setCellValueFactory(new PropertyValueFactory<AnimalDisplay, String>("ageGroup"));
        TableColumn<AnimalDisplay, String> column8 = new TableColumn<>("Animal Price");
        column8.setCellValueFactory(new PropertyValueFactory<AnimalDisplay, String>("animalPrice"));

//            The Edit Button
        TableColumn<AnimalDisplay, Button> column9 = new TableColumn<>("Edit");
        Callback<TableColumn<AnimalDisplay, Button>, TableCell<AnimalDisplay, Button>> cellFactory = new Callback<TableColumn<AnimalDisplay, Button>, TableCell<AnimalDisplay, Button>>() {
            @Override
            public TableCell call(final TableColumn<AnimalDisplay, Button> param) {
                final TableCell<AnimalDisplay, String> cell = new TableCell<AnimalDisplay, String>() {
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
                                AnimalDisplay a = getTableView().getItems().get(getIndex());
                                final Dialog d = new Dialog();
                                d.setTitle("Edit animal");
                                d.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                                Node closeButton = d.getDialogPane().lookupButton(ButtonType.CLOSE);
                                closeButton.managedProperty().bind(closeButton.visibleProperty());
                                closeButton.setVisible(false);
                                d.getDialogPane().setContent(Farm.editAnimal(a));
                                d.showAndWait();
                            });
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        };
        column9.setCellFactory(cellFactory);
        viewAnimaltableView.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9);
        while (rs.next()) {
            String tagNumber = rs.getString("Tag_Number");
            String animBreed = rs.getString("Animal_breed");
            String animGender = rs.getString("Animal_gender");
            String animColor = rs.getString("Animal_color");
            String animType = rs.getString("Animal_type");
            String animHornType = rs.getString("Horn_type");
            String animAgeGroup = rs.getString("Age_group");
            String animPrice = rs.getString("Animal_price");
            AnimalDisplay cows = new AnimalDisplay(tagNumber.toUpperCase(), animBreed, animGender, animColor, animType, animHornType, animAgeGroup, animPrice);
            animals.add(cows);
        }
        viewAnimaltableView.setItems(animals);
        VBox usersvbox = new VBox();
        usersvbox.setSpacing(5);
        usersvbox.setPadding(new Insets(10, 0, 0, 10));
        usersvbox.getChildren().addAll(returnBackToMenuButton, viewAnimaltableView);
        Scene viewanimalsScene = new Scene(new Group());
        ((Group) viewanimalsScene.getRoot()).getChildren().addAll(usersvbox);
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
        primarystage.setScene(removeAnimScene);
        primarystage.show();
    }

    public static GridPane editAnimal(AnimalDisplay editAnimal) {
        Text firstusermessage = new Text("");
        Text tagNum = new Text("TAG NUMBER: ");
        Text a_breed = new Text("BREED: ");
        Text a_gender = new Text("GENDER: ");
        Text a_color = new Text("COLOR: ");
        Text h_type = new Text("HORN TYPE: ");
        Text a_ageGroup = new Text("AGE GROUP: ");
//        Text a_picture = new Text("PICTURE: ");
        Text a_price = new Text("PRICE: ");
//      Creating the TextFields
        TextField a_breedTextField = new TextField();
        a_breedTextField.setText(editAnimal.getAnimalBreed());
        TextField a_priceTextField = new TextField();
        a_priceTextField.setText(editAnimal.getAnimalPrice());
        TextField a_colorTextField = new TextField();
        a_colorTextField.setText(editAnimal.getAnimalColor());
        TextField tagNumTextField = new TextField();
        tagNumTextField.setText(editAnimal.getTagNumber());
//      ComboBox Section
//      Gender ComboBox
        ComboBox a_genderComboBox = new ComboBox();
        a_genderComboBox.getItems().addAll("Male", "Female");
        a_genderComboBox.setEditable(true);
        a_genderComboBox.setValue(editAnimal.getAnimalGender());
//        Horntype ComboBox
        ComboBox h_typeComboBox = new ComboBox();
        h_typeComboBox.getItems().addAll("Short", "Long", "None");
        h_typeComboBox.setEditable(true);
        h_typeComboBox.setValue(editAnimal.getHornType());
//        Agegroup ComboBox
        ComboBox a_ageGroupComboBox = new ComboBox();
        a_ageGroupComboBox.getItems().addAll("Mature", "Calf", "Youngling");
        a_ageGroupComboBox.setEditable(true);
        a_ageGroupComboBox.setValue(editAnimal.getAgeGroup());
//      Creating the Buttons
        Button saveAnimalButton = new Button("SAVE");
//      Creating the GridPane
        GridPane editAnimalGridPane = new GridPane();
//      Setting up size of Grid pane
        editAnimalGridPane.setMinSize(600, 400);
//      Setting the Padding
        editAnimalGridPane.setPadding(new Insets(10, 10, 10, 10));
//      Setting the vertical and horizontal gaps between the columns
        editAnimalGridPane.setVgap(10);
        editAnimalGridPane.setHgap(10);
//      Setting the grid alignment
        editAnimalGridPane.setAlignment(Pos.CENTER);
//      Arranging all the nodes on the grid
        editAnimalGridPane.add(a_breed, 0, 0);
        editAnimalGridPane.add(a_breedTextField, 1, 0);
        editAnimalGridPane.add(a_gender, 0, 2);
        editAnimalGridPane.add(a_genderComboBox, 1, 2);
        editAnimalGridPane.add(a_color, 0, 4);
        editAnimalGridPane.add(a_colorTextField, 1, 4);
        editAnimalGridPane.add(h_type, 0, 6);
        editAnimalGridPane.add(h_typeComboBox, 1, 6);
        editAnimalGridPane.add(a_ageGroup, 0, 8);
        editAnimalGridPane.add(a_ageGroupComboBox, 1, 8);
//        buyAnimalgridpane.add(a_picture, 0, 10);
//        buyAnimalgridpane.add(browsepicture,1, 10);
        editAnimalGridPane.add(a_price, 0, 10);
        editAnimalGridPane.add(a_priceTextField, 1, 10);
        editAnimalGridPane.add(tagNum, 0, 12);
        editAnimalGridPane.add(tagNumTextField, 1, 12);
        editAnimalGridPane.add(firstusermessage, 1, 14);
        editAnimalGridPane.add(saveAnimalButton, 1, 16);
//        buyAnimalgridpane.add(salesAnimalButton, 2, 16);
        return editAnimalGridPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
