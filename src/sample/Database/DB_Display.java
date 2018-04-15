package sample.Database;
/**
 *
 *   Contains methods that allow for displaying data to the database
 *
 *
 *
 */



//-----------------//
//    Imports      //
//-----------------//

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.Model.Product;

import java.sql.*;

//---------------//
//    Class      //
//---------------//

public class DB_Display {


    /**
     * displayAllProducts
     *
     * Displays all products
     * in View to user
     *
     * @throws SQLException
     */
 public static void displayAllProducts(String phoneDetailsQuery,String TVDetailsQuery, ScrollPane displayPhoneBox, ScrollPane displayTVBox) throws SQLException {


     try {                                                                                                   //
         Class.forName("com.mysql.jdbc.Driver");                                                             //
     } catch (ClassNotFoundException e) {                                                                    //      Testing the JDBC
         System.out.println("MySQL JDBC Driver Not found: Please import");                                   //        connection
         e.printStackTrace();                                                                                //
         return;                                                                                             //
     }                                                                                                       //    Outputs error message
     Connection connection = null;                                                                           //


     try {
         connection = DriverManager                                                                          //
                 .getConnection("jdbc:mysql://localhost:3306/DBProject?autoReconnect=true&useSSL=false", // Connect to DB
                         "root", "Ilikefood1");                                               //


     } catch (SQLException e) {
         System.out.println("Connection Failed! Check output console");                                      // Print error if connection failed
         e.printStackTrace();
         return;
     }

     Statement st = connection.createStatement();                                                            // create the java statement

     ResultSet rsPhoneDetails = st.executeQuery(phoneDetailsQuery);                                          // execute the query, and get a java resultset

     VBox listPhones = new VBox();
     listPhones.setPadding(new Insets(0,0,0,110));
     listPhones.setAlignment(Pos.CENTER_LEFT);



     while (rsPhoneDetails.next())                                                                           // iterate through the java resultset
     {


         Label PhoneIDLabel = new Label("ID:");
         Label PhoneID      = new Label(""+rsPhoneDetails.getInt("id"));
         Label PhoneMake    = new Label(""+rsPhoneDetails.getString("make"));
         Label PhoneModel   = new Label(""+rsPhoneDetails.getString("model"));
         Label PhoneStorage = new Label(""+rsPhoneDetails.getInt("storage"));
         Label PhoneGB      = new Label("GB");
         Label PhoneEuro    = new Label("€");
         Label PhonePrice   = new Label(""+rsPhoneDetails.getDouble("price"));


         PhoneID.setMinWidth(60);
         PhoneMake.setMinWidth(100);
         PhoneModel.setMinWidth(70);
         PhoneStorage.setMinWidth(27);
         PhoneGB.setMinWidth(50);
         PhonePrice.setMinWidth(70);

         HBox TVDetails = new HBox();
         //TVDetails.setSpacing(30);

         TVDetails.setAlignment(Pos.CENTER_LEFT);
         TVDetails.getChildren().addAll(PhoneIDLabel,PhoneID,PhoneMake,PhoneModel,PhoneStorage,PhoneGB,PhoneEuro,PhonePrice );

         listPhones.getChildren().add(TVDetails);

     }
     st.close();
     displayPhoneBox.setContent(listPhones);                                    // add  phone list of  label to scrollpane


     Statement st2 = connection.createStatement();                              // create the java statement

     ResultSet rsTVDetails = st2.executeQuery(TVDetailsQuery);                  // execute the query, and get a java resultset

     VBox listTVs = new VBox();

     listTVs.setPadding(new Insets(0,0,0,110));
     listTVs.setAlignment(Pos.CENTER_LEFT);

     while (rsTVDetails.next())                                                 // iterate through the java resultset
     {
         Label TVIDLabel= new Label("ID:");
         Label TVID     = new Label(""+rsTVDetails.getInt("id"));
         Label TVMake   = new Label(""+rsTVDetails.getString("make"));
         Label TVScreen = new Label(""+rsTVDetails.getInt("screen_size"));
         Label TVInch = new Label("\"");
         Label TVType   = new Label(""+rsTVDetails.getString("type"));
         Label TVEuro = new Label("€");
         Label TVPrice  = new Label(""+rsTVDetails.getDouble("price"));

         TVID.setMinWidth(60);
         TVMake.setMinWidth(100);
         TVScreen.setMinWidth(17);
         TVInch.setMinWidth(50);
         TVType.setMinWidth(70);
         TVPrice.setMinWidth(70);

         HBox TVDetails = new HBox();
         //TVDetails.setSpacing(30);

         TVDetails.setAlignment(Pos.CENTER_LEFT);
         TVDetails.getChildren().addAll(TVIDLabel,TVID,TVMake,TVScreen,TVInch,TVType,TVEuro,TVPrice );

         listTVs.getChildren().add(TVDetails);
     }
     st.close();

     displayTVBox.setContent(listTVs);// add  Tvs list of  label  to scroll pane



 }

    /**
     *
     * getnewCustomerID
     *
     * created new customer ID from database and
     * returns to user when creating new customer
     *
     * @return customerID  returns new customerID
     */
    public static int getnewCustomerID(){

     int customerID = -1;

    try {                                                                                                   //
        Class.forName("com.mysql.jdbc.Driver");                                                             //
    } catch (ClassNotFoundException e) {                                                                    //      Testing the JDBC
        System.out.println("MySQL JDBC Driver Not found: Please import");                                   //        connection
        e.printStackTrace();                                                                                //
                                                                                                    //
    }                                                                                                       //    Outputs error message
    Connection connection = null;                                                                           //


    try {
        connection = DriverManager                                                                          //
                .getConnection("jdbc:mysql://localhost:3306/DBProject?autoReconnect=true&useSSL=false", // Connect to DB
                        "root", "Ilikefood1");                                               //

    } catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");                                      // Print error if connection failed
        e.printStackTrace();
    }



    if (connection != null) {                                                       // while there is a connection
        Statement stmt = null;

        try {
            stmt = (Statement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        ResultSet rs1 = null;

        try {
            rs1 = stmt.executeQuery("SELECT COUNT(id) FROM DBProject.Customer");

        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            if(rs1.next() ){
                customerID= rs1.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(customerID == -1){
            System.out.println("Error Occured");

        }

    } else {
        System.out.println("Failed to make connection!");                           // if connection failed print error to console
    }


return customerID;
}


    /**
     * validateExistingCustomer
     *
     *
     * takes in customer ID and checks if that customer is in our customer database
     *
     *
     * @param customerID     takes in customer ID to search
     * @return customerName returns customers name if found
     */
    public static String validateExistingCustomer(int customerID){

        String customerName = null;


        try {                                                                                                   //
            Class.forName("com.mysql.jdbc.Driver");                                                             //
        } catch (ClassNotFoundException e) {                                                                    //      Testing the JDBC
            System.out.println("MySQL JDBC Driver Not found: Please import");                                   //        connection
            e.printStackTrace();                                                                                //
            //
        }                                                                                                       //    Outputs error message
        Connection connection = null;                                                                           //


        try {
            connection = DriverManager                                                                          //
                    .getConnection("jdbc:mysql://localhost:3306/DBProject?autoReconnect=true&useSSL=false", // Connect to DB
                            "root", "Ilikefood1");                                               //



        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");                                      // Print error if connection failed
            e.printStackTrace();
        }



        if (connection != null) {                                                       // while there is a connection
            Statement stmt = null;

            try {
                stmt = (Statement) connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            ResultSet rs1 = null;

            String query = "SELECT * FROM DBProject.Customer where id =  "+ customerID;


            try {
                rs1 = stmt.executeQuery(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }


            try {
                if(rs1.next() ){

                    customerName = rs1.getString("name") ;

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(customerID == -1){
                System.out.println("Error Occured");

            }

        } else {
            System.out.println("Failed to make connection!");                           // if connection failed print error to console
        }


        return customerName;
    }



    public static void getProductNum(){


        try {                                                                           //
            Class.forName("com.mysql.jdbc.Driver");                                     //
        } catch (ClassNotFoundException e) {                                            //      Testing the JDBC
            System.out.println("MySQL JDBC Driver Not found: Please import");           //        connection
            e.printStackTrace();                                                        //
            return ;                                                                     //
        }                                                                               //    Outputs error message
        Connection connection = null;                                                   //

        try {
            connection = DriverManager                                                                          //
                    .getConnection("jdbc:mysql://localhost:3306/DBProject?autoReconnect=true&useSSL=false", // Connect to DB
                            "root", "Ilikefood1");                                               //

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");              // Print error if connection failed
            e.printStackTrace();
            return;
        }
        if (connection != null) {                                                       // while there is a connection
            int countPhone = -1;
            int countTV    = -1;
            Statement stmt = null;
            Statement stmt2 = null;

            try {
                stmt = (Statement) connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                stmt2 = (Statement) connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ResultSet rs1 = null;
            ResultSet rs2 = null;

            try {
                rs1 = stmt.executeQuery("SELECT COUNT(id) FROM DBProject.Phone");

            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                rs2 = stmt2.executeQuery("SELECT COUNT(id) FROM DBProject.TV");

            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(rs1.next() ){
                    countPhone= rs1.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(countPhone == -1){
                System.out.println("Error Occured");

            }
            try {
                if(rs2.next() ){
                    countTV = rs2.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(countTV == -1){
                System.out.println("Error Occured");

            }
            Product.count  = countPhone + countTV;


        } else {
            System.out.println("Failed to make connection!");                           // if connection failed print error to console
        }

    }


    public static void displayInComboxBox(String query,String columnName,  ComboBox comboBox) throws SQLException {


        try {                                                                                                   //
            Class.forName("com.mysql.jdbc.Driver");                                                             //
        } catch (ClassNotFoundException e) {                                                                    //      Testing the JDBC
            System.out.println("MySQL JDBC Driver Not found: Please import");                                   //        connection
            e.printStackTrace();                                                                                //
            return;                                                                                             //
        }                                                                                                       //    Outputs error message
        Connection connection = null;                                                                           //


        try {
            connection = DriverManager                                                                          //
                    .getConnection("jdbc:mysql://localhost:3306/DBProject?autoReconnect=true&useSSL=false", // Connect to DB
                            "root", "Ilikefood1");                                               //


        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");                                      // Print error if connection failed
            e.printStackTrace();
            return;
        }

        Statement st = connection.createStatement();                  // create the java statement

        ResultSet rsDetails = st.executeQuery(query);                 // execute the query, and get a java resultset


        while (rsDetails.next())                                     // iterate through the java result set
        {

            comboBox.getItems().add(rsDetails.getString(columnName));

        }
        st.close();
    }





    public static void displayPhoneOrderSelected(String query, HBox structure) throws SQLException {


        try {                                                                                                   //
            Class.forName("com.mysql.jdbc.Driver");                                                             //
        } catch (ClassNotFoundException e) {                                                                    //      Testing the JDBC
            System.out.println("MySQL JDBC Driver Not found: Please import");                                   //        connection
            e.printStackTrace();                                                                                //
            return;                                                                                             //
        }                                                                                                       //    Outputs error message
        Connection connection = null;                                                                           //


        try {
            connection = DriverManager                                                                          //
                    .getConnection("jdbc:mysql://localhost:3306/DBProject?autoReconnect=true&useSSL=false", // Connect to DB
                            "root", "Ilikefood1");                                               //


        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");                                      // Print error if connection failed
            e.printStackTrace();
            return;
        }


        structure.getChildren().clear();


        Statement st = connection.createStatement();                  // create the java statement

        ResultSet rsDetails = st.executeQuery(query);                 // execute the query, and get a java resultset


        while (rsDetails.next())                                     // iterate through the java result set
        {

            Label PhoneIDLabel = new Label("Order for: ID:");
            Label PhoneID      = new Label(""+rsDetails.getInt("id"));
            Label PhoneMake    = new Label(""+rsDetails.getString("make"));
            Label PhoneModel   = new Label(""+rsDetails.getString("model"));
            Label PhoneStorage = new Label(""+rsDetails.getInt("storage"));
            Label PhoneGB      = new Label("GB");
            Label PhoneEuro    = new Label("€");
            Label PhonePrice   = new Label(""+rsDetails.getDouble("price"));

            PhoneID.setMinWidth(60);
            PhoneMake.setMinWidth(100);
            PhoneModel.setMinWidth(70);
            PhoneStorage.setMinWidth(27);
            PhoneGB.setMinWidth(50);
            PhonePrice.setMinWidth(70);


            structure.getChildren().addAll(PhoneIDLabel,PhoneID,PhoneMake,PhoneModel,PhoneStorage,PhoneGB,PhoneEuro,PhonePrice);


        }


        st.close();
    }



    public static void displayTVOrderSelected(String query, HBox structure) throws SQLException {


        try {                                                                                                   //
            Class.forName("com.mysql.jdbc.Driver");                                                             //
        } catch (ClassNotFoundException e) {                                                                    //      Testing the JDBC
            System.out.println("MySQL JDBC Driver Not found: Please import");                                   //        connection
            e.printStackTrace();                                                                                //
            return;                                                                                             //
        }                                                                                                       //    Outputs error message
        Connection connection = null;                                                                           //


        try {
            connection = DriverManager                                                                          //
                    .getConnection("jdbc:mysql://localhost:3306/DBProject?autoReconnect=true&useSSL=false", // Connect to DB
                            "root", "Ilikefood1");                                               //


        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");                                      // Print error if connection failed
            e.printStackTrace();
            return;
        }


        structure.getChildren().clear();


        Statement st = connection.createStatement();                  // create the java statement

        ResultSet rsDetails = st.executeQuery(query);                 // execute the query, and get a java resultset


        while (rsDetails.next())                                     // iterate through the java result set
        {

            Label TVIDLabel= new Label("ID:");
            Label TVID     = new Label(""+rsDetails.getInt("id"));
            Label TVMake   = new Label(""+rsDetails.getString("make"));
            Label TVScreen = new Label(""+rsDetails.getInt("screen_size"));
            Label TVInch = new Label("\"");
            Label TVType   = new Label(""+rsDetails.getString("type"));
            Label TVEuro = new Label("€");
            Label TVPrice  = new Label(""+rsDetails.getDouble("price"));

            TVID.setMinWidth(60);
            TVMake.setMinWidth(100);
            TVScreen.setMinWidth(17);
            TVInch.setMinWidth(50);
            TVType.setMinWidth(70);
            TVPrice.setMinWidth(70);



            structure.getChildren().addAll(TVIDLabel,TVID,TVMake,TVScreen,TVInch,TVType,TVEuro,TVPrice);


        }


        st.close();
    }



}






















