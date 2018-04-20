package project.Database;



/**
 *
 *   Contains methods that allow for saving data to the database
 *
 *
 *
 */

//-----------------//
//    Imports      //
//-----------------//

import java.sql.*;
import static project.Controller.Controller.numberProducts;


//---------------//
//    Class      //
//---------------//
public class DB_Insert {


    /**
     * savePhone
     * <p>
     * adds Phone to DB
     */
    public static void savePhone( String make, String model, int storage, double price) {

        try {                                                                                                   //
            Class.forName("com.mysql.jdbc.Driver");                                                             //
        } catch (ClassNotFoundException e) {                                                                    //      Testing the JDBC
            System.out.println("MySQL JDBC Driver Not found: Please import");                                   //        connection
            e.printStackTrace();                                                                                //
            return;                                                                                             //
        }                                                                                                       //    Outputs error message
        Connection connection;


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
            PreparedStatement savePhone;
            try {



                savePhone = connection.prepareCall("INSERT INTO Phone ( make, model, storage, price, id) VALUES ( ?, ?, ?, ?,?)");
                savePhone.setString(1, make);
                savePhone.setString(2, model);
                savePhone.setInt(3, storage);
                savePhone.setDouble(4, price);
                savePhone.setInt(5, ++numberProducts);


                savePhone.executeUpdate();

                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * saveTV
     * <p>
     * adds tv to DB
     */
    public static void saveTV( String make, int screenSize, String type, double price) {

        try {                                                                                                   //
            Class.forName("com.mysql.jdbc.Driver");                                                             //
        } catch (ClassNotFoundException e) {                                                                    //      Testing the JDBC
            System.out.println("MySQL JDBC Driver Not found: Please import");                                   //        connection
            e.printStackTrace();                                                                                //
            return;                                                                                             //
        }                                                                                                       //    Outputs error message
        Connection connection;

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

            PreparedStatement saveTV;
            try {

                saveTV = connection.prepareCall("INSERT INTO TV ( make, screen_size, type, price, id) VALUES(?, ?, ?, ?,?)");
                saveTV.setString(1, make);
                saveTV.setInt(2, screenSize);
                saveTV.setString(3, type);
                saveTV.setDouble(4, price);
                saveTV.setInt(5, ++numberProducts);

                int i = saveTV.executeUpdate();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * saveCustomer
     * <p>
     * adds customer to DB
     */
    public static void saveCustomer( String cstName, String cstAddress, String cstEmail, String cstPassword) {

        try {                                                                                                   //
            Class.forName("com.mysql.jdbc.Driver");                                                             //
        } catch (ClassNotFoundException e) {                                                                    //      Testing the JDBC
            System.out.println("MySQL JDBC Driver Not found: Please import");                                   //        connection
            e.printStackTrace();                                                                                //
            return;                                                                                             //
        }                                                                                                       //    Outputs error message
        Connection connection;                                                                           //

        try {
            connection = DriverManager                                                                          //
                    .getConnection("jdbc:mysql://localhost:3306/DBProject?autoReconnect=true&useSSL=false", // Connect to DB
                            "root", "Ilikefood1");


        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");              // Print error if connection failed
            e.printStackTrace();
            return;
        }
        if (connection != null) {                                                       // while there is a connection
            PreparedStatement saveCustomer;
            try {
                saveCustomer = connection.prepareCall("INSERT INTO Customer( name, address, email, password) VALUES(?,?,?,?)");
                saveCustomer.setString(1, cstName);
                saveCustomer.setString(2, cstAddress);
                saveCustomer.setString(3, cstEmail);
                saveCustomer.setString(4, cstPassword);


                int i = saveCustomer.executeUpdate();

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * deleteProduct
     * <p>
     * deletes product from databaes
     */
    public static void deleteProduct(int productID) throws SQLException {

        try {                                                                                                   //
            Class.forName("com.mysql.jdbc.Driver");                                                             //
        } catch (ClassNotFoundException e) {                                                                    //      Testing the JDBC
            System.out.println("MySQL JDBC Driver Not found: Please import");                                   //        connection
            e.printStackTrace();                                                                                //
            return;                                                                                             //
        }                                                                                                       //    Outputs error message
        Connection connection;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/DBProject?autoReconnect=true&useSSL=false", // Connect to DB
                            "root", "Ilikefood1");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");                // Print error if connection failed
            e.printStackTrace();
            return;
        }
        if (connection != null) {                                                         // while there is a connection

            PreparedStatement deletePhone;
            PreparedStatement deleteTV;

                deletePhone = connection.prepareCall("Delete from Phone where id = (?)");       // searched Phone table for ID to delete
                deletePhone.setInt(1, productID);

                int i = deletePhone.executeUpdate();

                deleteTV = connection.prepareCall("Delete from TV where id = (?)");             // searched TV table for ID to delete
                deleteTV.setInt(1, productID);

                int e = deleteTV.executeUpdate();
            connection.close();

    }
    }



    /**
     * saveCustomer
     * <p>
     * adds cuwtomer to DB
     */
    public static void saveOrder(String query) throws SQLException {

        try {                                                                                                   //
            Class.forName("com.mysql.jdbc.Driver");                                                             //
        } catch (ClassNotFoundException e) {                                                                    //      Testing the JDBC
            System.out.println("MySQL JDBC Driver Not found: Please import");                                   //        connection
            e.printStackTrace();                                                                                //
            return;                                                                                             //
        }                                                                                                       //    Outputs error message
        Connection connection;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/DBProject?autoReconnect=true&useSSL=false", // Connect to DB
                            "root", "Ilikefood1");


            //

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");                // Print error if connection failed
            e.printStackTrace();
            return;
        }
        if (connection != null) {                                                         // while there is a connection

            System.out.println("TEST SAVE Order:query is : " + query);


            PreparedStatement saveOrder;                                                  // create prepared statement

            saveOrder = connection.prepareCall(query);                                    // save customer to database

            int i = saveOrder.executeUpdate();                                            // execute statement

            connection.close();                                                           // close connection

        }
    }



}












