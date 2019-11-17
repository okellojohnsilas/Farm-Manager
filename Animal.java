package farm_manager;

import java.sql.*;

public class Animal extends Constants{
    Constants dbConn = new Constants();
//    Purchase Animal Method
    public void purchaseAnimal(String T_number,String A_breed,String A_gender,String A_color,String H_type,String A_group,String A_price) throws ClassNotFoundException, SQLException{
      try {  
        Class.forName(dbConn.getDriver());
        Connection con = (Connection)DriverManager.getConnection(dbConn.getDatabaseUrl(),dbConn.getUser(),dbConn.getPassword());
        Statement stmt = (Statement)con.createStatement();
//        Tag_Number	Animal_breed	Animal_gender	Animal_color	Horn_type	Age_group	Animal_price
        stmt.executeUpdate("INSERT INTO animal(Tag_Number,Animal_breed,Animal_gender,Animal_color,Horn_type,Age_group,Animal_price) VALUES('"+T_number+"','"+A_breed+"','"+A_gender+"','"+A_color+"','"+H_type+"','"+A_group+"','"+A_price+"')");
        successalert.setTitle("ADD STATUS");
        successalert.setHeaderText(null);
        successalert.setContentText("ANIMAL ADDED TO DATABASE SUCCESSFULLY");
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
        Class.forName(dbConn.getDriver());
        Connection con = (Connection)DriverManager.getConnection(dbConn.getDatabaseUrl(),dbConn.getUser(),dbConn.getPassword());
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
            Class.forName(dbConn.getDriver());
            Connection con = (Connection)DriverManager.getConnection(dbConn.getDatabaseUrl(),dbConn.getUser(),dbConn.getPassword());
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
    public void viewAnimals() throws ClassNotFoundException, SQLException{ 
        Class.forName(dbConn.getDriver());
        Connection con = (Connection)DriverManager.getConnection(dbConn.getDatabaseUrl(),dbConn.getUser(),dbConn.getPassword());
        Statement stmt = (Statement)con.createStatement();
    }
}