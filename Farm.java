package farm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Platform;

public class Farm extends Application {

    private ObservableList<Animal> observableNames;
    private Animal connect = new Animal();
    public Farm() {
        try {
            observableNames = FXCollections.observableArrayList(connect.viewAnimals());
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Farm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    @Override
    public void start(Stage primarystage) throws Exception {
        Button returnBackToMenuButton = new Button("BACK TO MENU");
//      ========================BUY ANIMAL INTERFACE==============================================================  
//      Text displayed
        Text tagNum = new Text("TAG NUMBER: ");
        Text a_breed = new Text("ANIMAL BREED: ");
        Text a_gender = new Text("GENDER: ");
        Text a_color = new Text("COLOR: ");
        Text a_type = new Text("ANIMAL TYPE: ");
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
//        Animal Type ComboBox
        ComboBox a_typeComboBox = new ComboBox();
        a_typeComboBox.getItems().addAll("Cow", "Goat", "Sheep");
        a_typeComboBox.setEditable(true);
//        Horntype ComboBox
        ComboBox h_typeComboBox = new ComboBox();
        h_typeComboBox.getItems().addAll("Short", "Long", "None");
        h_typeComboBox.setEditable(true);
//        Agegroup ComboBox
        ComboBox a_ageGroupComboBox = new ComboBox();
        a_ageGroupComboBox.getItems().addAll("Old", "Prime", "Young");
        a_ageGroupComboBox.setEditable(true);
//      Creating the Buttons
        Button buyAnimalButton = new Button("BUY");
        Button leaveAndReturnButton = new Button("BACK TO MENU");
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
        buyAnimalgridpane.add(a_type, 0, 6);
        buyAnimalgridpane.add(a_typeComboBox, 1, 6);
        buyAnimalgridpane.add(h_type, 0, 8);
        buyAnimalgridpane.add(h_typeComboBox, 1, 8);
        buyAnimalgridpane.add(a_ageGroup, 0, 10);
        buyAnimalgridpane.add(a_ageGroupComboBox, 1, 10);
        buyAnimalgridpane.add(a_price, 0, 12);
        buyAnimalgridpane.add(a_priceTextField, 1, 12);
        buyAnimalgridpane.add(tagNum, 0, 14);
        buyAnimalgridpane.add(tagNumTextField, 1, 14);
//        buyAnimalgridpane.add(firstusermessage, 1, 14);
        buyAnimalgridpane.add(buyAnimalButton, 1, 16);
        buyAnimalgridpane.add(leaveAndReturnButton, 1, 18);
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
        Button backButton = new Button("BACK TO MENU");
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
                cow.purchaseAnimal(tagNumTextField.getText(), a_breedTextField.getText(), a_genderComboBox.getValue().toString(), a_colorTextField.getText(),a_typeComboBox.getValue().toString(), h_typeComboBox.getValue().toString(), a_ageGroupComboBox.getValue().toString(), a_priceTextField.getText());
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
        Button addNewAnimalButton = new Button("ADD ANIMAL");
        Button exitApp = new Button("EXIT FARM MANAGER");
        exitApp.setStyle("-fx-background-color: #F08080;-fx-text-fill: #0000ff;-fx-font-size: 1.5em;");
        exitApp.setOnAction((e) -> {
            primarystage.close();
        });
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
        menuGridpane.add(addNewAnimalButton, 1, 8);
        menuGridpane.add(exitApp, 1, 12);
        Scene menuScene = new Scene(menuGridpane);
//      ========================END OF MENU INTERFACE===============================================================================
//      ========================REMOVE ANIMAL INTERFACE=============================================================================
//        Buttons
        Button removeAnimButton = new Button("REMOVE");
        Button backToMenuButton = new Button("BACK TO MENU");
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
        removeAnimGridpane.add(AnimTagLabel, 0, 0);
        removeAnimGridpane.add(removeAnimTextField, 1, 0);
        removeAnimGridpane.add(removeAnimButton, 1, 2);
        removeAnimGridpane.add(backToMenuButton, 1, 4);
        removeAnimButton.setOnAction((e) -> {
            cow.removeAnimal(removeAnimTextField.getText());
            removeAnimTextField.clear();
        });
        backToMenuButton.setOnAction((e) -> {
            primarystage.setScene(menuScene);
        });
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
        TableColumn<AnimalDisplay, String> column1 = new TableColumn<>("Tag Number");
        column1.setCellValueFactory(new PropertyValueFactory<>("tagNumber"));
        TableColumn<AnimalDisplay, String> column2 = new TableColumn<>("Animal Breed");
        column2.setCellValueFactory(new PropertyValueFactory<>("animalBreed"));
        TableColumn<AnimalDisplay, String> column3 = new TableColumn<>("Animal Gender");
        column3.setCellValueFactory(new PropertyValueFactory<>("animalGender"));
        TableColumn<AnimalDisplay, String> column4 = new TableColumn<>("Animal Color");
        column4.setCellValueFactory(new PropertyValueFactory<>("animalColor"));
        TableColumn<AnimalDisplay, String> column5 = new TableColumn<>("Animal Type");
        column5.setCellValueFactory(new PropertyValueFactory<>("animalType"));
        TableColumn<AnimalDisplay, String> column6 = new TableColumn<>("Horn Type");
        column6.setCellValueFactory(new PropertyValueFactory<>("hornType"));
        TableColumn<AnimalDisplay, String> column7 = new TableColumn<>("Age Group");
        column7.setCellValueFactory(new PropertyValueFactory<>("ageGroup"));
        TableColumn<AnimalDisplay, String> column8 = new TableColumn<>("Animal Price");
        column8.setCellValueFactory(new PropertyValueFactory<>("animalPrice"));
//        The Edit Button
        TableColumn<AnimalDisplay, Button> column9 = new TableColumn<>("ACTIONS");
        Callback<TableColumn<AnimalDisplay, Button>, TableCell<AnimalDisplay, Button>> cellFactory = new Callback<TableColumn<AnimalDisplay, Button>, TableCell<AnimalDisplay, Button>>() {
            @Override
            public TableCell call(final TableColumn<AnimalDisplay, Button> param) {
                final TableCell<AnimalDisplay, String> cell = new TableCell<AnimalDisplay, String>() {
                    final Button editBtn = new Button("EDIT");
                    final Button delBtn = new Button("DELETE");
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        }
                        else {
                            HBox buttonPane = new HBox(editBtn, delBtn);
                            buttonPane.setSpacing(10);
                            setGraphic(buttonPane);
                            editBtn.setOnAction((e) -> {
                                    AnimalDisplay a = getTableView().getItems().get(getIndex());
//                                    System.out.println(a);
                                    final Dialog d = new Dialog();
                                    d.setTitle("Edit animal");
                                    d.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                                    Node closeButton = d.getDialogPane().lookupButton(ButtonType.CLOSE);
                                    closeButton.managedProperty().bind(closeButton.visibleProperty());
                                    closeButton.setVisible(false);
                                    d.getDialogPane().setContent(Farm.editAnimal(a));
                                    System.out.println(a);
                                    d.showAndWait();
                            });
                            delBtn.setOnAction((e) -> {
                                Alert alert = new Alert(AlertType.CONFIRMATION, "ARE YOU SURE?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                                alert.showAndWait();
                                if (alert.getResult() == ButtonType.YES) {
                                    AnimalDisplay a = getTableView().getItems().get(getIndex());
                                    Farm.deleteAnimal(a);
                                }
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
        viewAnimaltableView.setItems(cow.viewAnimals());
        VBox usersvbox = new VBox();
        usersvbox.setSpacing(5);
        usersvbox.setMinSize(1000, 1000);
        usersvbox.setPadding(new Insets(10, 0, 0, 10));
        Button reLoadTable = new Button("REFRESH TABLE");
        reLoadTable.setOnAction((e) -> {
            try {
//                System.out.println("Restarting the program");
                primarystage.close();
                Platform.runLater( () -> {
                    try {
                        new Farm().start( new Stage() );
                    } catch (Exception ex) {
                        Logger.getLogger(Farm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } );
            } catch (Exception ex) {
                Logger.getLogger(Farm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        HBox topPane = new HBox(returnBackToMenuButton, reLoadTable);
        topPane.setSpacing(30);
        usersvbox.getChildren().addAll(topPane,viewAnimaltableView);
        Scene viewanimalsScene = new Scene(new Group());
        ((Group) viewanimalsScene.getRoot()).getChildren().addAll(usersvbox);
//      ========================END OF ANIMAL TABLEVIEW INTERFACE===================================================================
//      ========================ADD ANIMAL INTERFACE================================================================================
    //      Text displayed
        Text animalTagNum = new Text("TAG NUMBER: ");
        Text animalBreed = new Text("ANIMAL BREED: ");
        Text animalGender = new Text("GENDER: ");
        Text animalColor = new Text("COLOR: ");
        Text animalType = new Text("ANIMAL TYPE: ");
        Text animalHornType = new Text("HORN TYPE: ");
        Text animalAgeGroup = new Text("AGE GROUP: ");
//      Creating the TextFields
        TextField animalBreedTextField = new TextField();
        TextField animalColorTextField = new TextField();
        TextField animalTagNumTextField = new TextField();
//      ComboBox Section
//      Gender ComboBox
        ComboBox animalGenderComboBox = new ComboBox();
        animalGenderComboBox.getItems().addAll("Male", "Female");
        animalGenderComboBox.setEditable(false);
//        Animal Type ComboBox
        ComboBox animalTypeComboBox = new ComboBox();
        animalTypeComboBox.getItems().addAll("Cow", "Goat", "Sheep");
        animalTypeComboBox.setEditable(true);
//        Horntype ComboBox
        ComboBox animalHornTypeComboBox = new ComboBox();
        animalHornTypeComboBox.getItems().addAll("Short", "Long", "None");
        animalHornTypeComboBox.setEditable(true);
//        Agegroup ComboBox
        ComboBox animalAgeGroupComboBox = new ComboBox();
        animalAgeGroupComboBox.getItems().addAll("Old", "Prime", "Young");
        animalAgeGroupComboBox.setEditable(true);
//      Creating the Buttons
        Button addAnimalButton = new Button("ADD");
        Button ToMenuButton = new Button("BACK TO MENU");
//      Creating the GridPane
        GridPane addAnimalgridpane = new GridPane();
//      Setting up size of Grid pane
        addAnimalgridpane.setMinSize(600, 400);
//      Setting the Padding
        addAnimalgridpane.setPadding(new Insets(10, 10, 10, 10));
//      Setting the vertical and horizontal gaps between the columns
        addAnimalgridpane.setVgap(10);
        addAnimalgridpane.setHgap(10);
//      Setting the grid alignment
        addAnimalgridpane.setAlignment(Pos.CENTER);
//      Arranging all the nodes on the grid
        addAnimalgridpane.add(animalBreed, 0, 0);
        addAnimalgridpane.add(animalBreedTextField, 1, 0);
        addAnimalgridpane.add(animalGender, 0, 2);
        addAnimalgridpane.add(animalGenderComboBox, 1, 2);
        addAnimalgridpane.add(animalColor, 0, 4);
        addAnimalgridpane.add(animalColorTextField, 1, 4);
        addAnimalgridpane.add(animalType, 0, 6);
        addAnimalgridpane.add(animalTypeComboBox, 1, 6);
        addAnimalgridpane.add(animalHornType, 0, 8);
        addAnimalgridpane.add(animalHornTypeComboBox, 1, 8);
        addAnimalgridpane.add(animalAgeGroup, 0, 10);
        addAnimalgridpane.add(animalAgeGroupComboBox, 1, 10);
        addAnimalgridpane.add(animalTagNum, 0, 12);
        addAnimalgridpane.add(animalTagNumTextField, 1, 12);
        addAnimalgridpane.add(addAnimalButton, 1, 14);
        addAnimalgridpane.add(ToMenuButton, 1, 16);
        Scene addAnimalScene = new Scene(addAnimalgridpane);
//      ========================END OF ADD ANIMAL INTERFACE=========================================================================
//        addAnimalButton onclick Listener
        addAnimalButton.setOnAction((e) -> {
            try {
                //            Tag_Number	Animal_breed	Animal_gender	Animal_color	Animal_type	Horn_type	Age_group	Animal_price
                cow.addAnimal(animalTagNumTextField.getText(), animalBreedTextField.getText(), animalGenderComboBox.getValue().toString(), animalColorTextField.getText(),animalTypeComboBox.getValue().toString(), animalHornTypeComboBox.getValue().toString(), animalAgeGroupComboBox.getValue().toString());
                animalTagNumTextField.clear();
                animalBreedTextField.clear();
                animalGenderComboBox.getSelectionModel().clearSelection();
                animalColorTextField.clear();
                animalTypeComboBox.getSelectionModel().clearSelection();
                animalHornTypeComboBox.getSelectionModel().clearSelection();
                animalAgeGroupComboBox.getSelectionModel().clearSelection();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Farm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
//        Universal Menu Button
        returnBackToMenuButton.setOnAction((e) -> {
            primarystage.setScene(menuScene);
        });
//        ---------------------------------------
        purchaseAnimalMenuButton.setOnAction((e) -> {
            primarystage.setScene(buyAnimalScene);
        });
        removeAnimalMenuButton.setOnAction((e) -> {
            primarystage.setScene(removeAnimScene);
        });
        viewAnimalMenuButton.setOnAction((e) -> {
//            refreshTableView();
            primarystage.setScene(viewanimalsScene);
        });
//        ---------------------------------------
        saleAnimalMenuButton.setOnAction(e -> {
            primarystage.setScene(salesScene);
        });
        backButton.setOnAction((e) -> {
            primarystage.setScene(menuScene);
        });
//        ---------------------------------------
        leaveAndReturnButton.setOnAction((e) -> {
            primarystage.setScene(menuScene);
        });
        ToMenuButton.setOnAction((e) -> {
            primarystage.setScene(menuScene);
        });
        addNewAnimalButton.setOnAction((e) -> {
            primarystage.setScene(addAnimalScene);
        });
        primarystage.setScene(menuScene);
        primarystage.show();
    }
    
    public static String deleteAnimal(AnimalDisplay t_number){
        Constants dbConn = new Constants();
        Alert successalert = new Alert(Alert.AlertType.INFORMATION);
        Alert failurealert = new Alert(Alert.AlertType.INFORMATION);
        try {  
            Class.forName(dbConn.getDriver());
            Connection con = (Connection)DriverManager.getConnection(dbConn.getDatabaseUrl(),dbConn.getUser(),dbConn.getPassword());
            Statement stmt = (Statement)con.createStatement();
            stmt.executeUpdate("DELETE FROM animal WHERE Tag_Number ='"+t_number.getTagNumber()+"'");
            System.out.println(t_number.getTagNumber());
            successalert.setTitle("ADD STATUS");
            successalert.setHeaderText(null);
            successalert.setContentText("ANIMAL REMOVED FROM DATABASE SUCCESSFULLY");
            successalert.showAndWait();
        }catch(ClassNotFoundException | SQLException e ){
            failurealert.setTitle("FAILED");
            failurealert.setHeaderText(null);
            failurealert.setContentText(e.toString());
            failurealert.showAndWait();
            System.out.println(e);
        }
        return "Success";
    }

    public static GridPane editAnimal(AnimalDisplay editAnimal) {
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
