package farm;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Animal extends Constants{
//    Purchase Animal Method
    public void purchaseAnimal(String T_number,String A_breed,String A_gender,String A_color,String A_type,String H_type,String A_group,String A_price) throws ClassNotFoundException, SQLException{
      try {  
        Class.forName(getDriver());
        Connection con = (Connection)DriverManager.getConnection(getDatabaseUrl(),getUser(),getPassword());
        Statement stmt = (Statement)con.createStatement();
//        Tag_Number	Animal_breed	Animal_gender	Animal_color	Animal_type	Horn_type	Age_group	Animal_price
        stmt.executeUpdate("INSERT INTO animal(Tag_Number,Animal_breed,Animal_gender,Animal_color,Animal_type,Horn_type,Age_group,Animal_price) VALUES('"+T_number.toUpperCase()+"','"+A_breed+"','"+A_gender+"','"+A_color+"','"+A_type+"','"+H_type+"','"+A_group+"','"+A_price+"')");
        successalert.setTitle("ADD STATUS");
        successalert.setHeaderText(null);
        successalert.setContentText(T_number+" WAS PURCHASED SUCCESSFULLY");
        successalert.showAndWait();
      }catch(ClassNotFoundException | SQLException e ){
        failurealert.setTitle("FAILED");
        failurealert.setHeaderText(null);
        failurealert.setContentText(e.toString());
        failurealert.showAndWait();
        System.out.println(e);
      }
    }
//    Sale Animal Method
    public void saleAnimal(String Tag_number,String Buyer,String Buyer_Contact,String Amount_Paid) throws ClassNotFoundException, SQLException{
        try {  
        Class.forName(getDriver());
        Connection con = (Connection)DriverManager.getConnection(getDatabaseUrl(),getUser(),getPassword());
        Statement stmt = (Statement)con.createStatement();
//        Tag_Number	Buyer	Buyer_Contact	Amount_Paid	
        stmt.executeUpdate("INSERT INTO sales(Tag_Number,Buyer,Buyer_Contact,Amount_Paid) VALUES('"+Tag_number+"','"+Buyer+"','"+Buyer_Contact+"','"+Amount_Paid+"')");
        removeAnimal(Tag_number);
        }catch(ClassNotFoundException | SQLException e ){
        failurealert.setTitle("FAILED");
        failurealert.setHeaderText(null);
        failurealert.setContentText(e.toString());
        failurealert.showAndWait();
        System.out.println(e);
    }
    }
//    Remove animal method
    public void removeAnimal(String t_number){
        try {  
            Class.forName(getDriver());
            Connection con = (Connection)DriverManager.getConnection(getDatabaseUrl(),getUser(),getPassword());
            Statement stmt = (Statement)con.createStatement();
            stmt.executeUpdate("DELETE FROM animal WHERE Tag_Number ='"+t_number+"'");
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
    }
//    View Animals method
    public ObservableList viewAnimals() throws ClassNotFoundException, SQLException{ 
        final ObservableList<AnimalDisplay> animalDetails = FXCollections.observableArrayList();
        Class.forName(getDriver());
        Connection con = (Connection)DriverManager.getConnection(getDatabaseUrl(),getUser(),getPassword());
        Statement stmt = (Statement)con.createStatement();
        ResultSet rs = (ResultSet) stmt.executeQuery("SELECT * FROM `animal`");
        while (rs.next()) {
            animalDetails.add(new AnimalDisplay(rs.getString("Tag_Number"),rs.getString("Animal_breed"),rs.getString("Animal_gender"),rs.getString("Animal_color"),rs.getString("Animal_type"),rs.getString("Horn_type"),rs.getString("Age_group"),rs.getString("Animal_price")));
        }
        return animalDetails;
    }
    public void addAnimal(String T_number,String A_breed,String A_gender,String A_color,String A_type,String H_type,String A_group) throws ClassNotFoundException, SQLException{
      try {  
        Class.forName(getDriver());
        Connection con = (Connection)DriverManager.getConnection(getDatabaseUrl(),getUser(),getPassword());
        Statement stmt = (Statement)con.createStatement();
//        Tag_Number	Animal_breed	Animal_gender	Animal_color	Animal_type	Horn_type	Age_group	Animal_price
        stmt.executeUpdate("INSERT INTO animal(Tag_Number,Animal_breed,Animal_gender,Animal_color,Animal_type,Horn_type,Age_group,Animal_price) VALUES('"+T_number.toUpperCase()+"','"+A_breed+"','"+A_gender+"','"+A_color+"','"+A_type+"','"+H_type+"','"+A_group+"','ADDED BY FARMER')");
        successalert.setTitle("ADD STATUS");
        successalert.setHeaderText(null);
        successalert.setContentText(T_number+" WAS ADDED TO DATABASE SUCCESSFULLY");
        successalert.showAndWait();
      }catch(ClassNotFoundException | SQLException e ){
        failurealert.setTitle("FAILED");
        failurealert.setHeaderText(null);
        failurealert.setContentText(e.toString());
        failurealert.showAndWait();
        System.out.println(e);
      }
    }
}
