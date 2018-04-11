package sample;



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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


//---------------//
//    Class      //
//---------------//
public class DB_Edit {


    /**
     * savePhone
     * <p>
     * adds Phone to DB
     */
    public static void savePhone(int id, String make, String model, int storage, double price) {

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
            System.out.println("Connection Failed! Check output console");              // Print error if connection failed
            e.printStackTrace();
            return;
        }

        if (connection != null) {                                                       // while there is a connection
            PreparedStatement savePhone = null;
            try {
                savePhone = connection.prepareCall("INSERT INTO Phone VALUES(?, ?, ?, ?, ?)");
                savePhone.setInt(1, id);
                savePhone.setString(2, make);
                savePhone.setString(3, model);
                savePhone.setInt(4, storage);
                savePhone.setDouble(5, price);

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
    public static void saveTV(int id, String make, int screenSize, String type, double price) {

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
            System.out.println("Connection Failed! Check output console");              // Print error if connection failed
            e.printStackTrace();
            return;
        }
        if (connection != null) {                                                       // while there is a connection

            PreparedStatement saveTV = null;
            try {
                saveTV = connection.prepareCall("INSERT INTO TV VALUES(?, ?, ?, ?, ?)");
                saveTV.setInt(1, id);
                saveTV.setString(2, make);
                saveTV.setInt(3, screenSize);
                saveTV.setString(4, type);
                saveTV.setDouble(5, price);

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
     * adds cuwtomer to DB
     */
    public static void saveCustomer(int cstID, String cstName, String cstAddress) {

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
                            "root", "Ilikefood1");


            //

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");              // Print error if connection failed
            e.printStackTrace();
            return;
        }
        if (connection != null) {                                                       // while there is a connection
            PreparedStatement saveCustomer = null;
            try {
                saveCustomer = connection.prepareCall("INSERT INTO Customer VALUES(?, ?, ?)");
                saveCustomer.setInt(1, cstID);
                saveCustomer.setString(2, cstName);
                saveCustomer.setString(3, cstAddress);

                int i = saveCustomer.executeUpdate();

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * saveCustomer
     * <p>
     * adds cuwtomer to DB
     */
    public static void deleteProduct(int productID) throws SQLException {

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
                            "root", "Ilikefood1");


            //

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");                // Print error if connection failed
            e.printStackTrace();
            return;
        }
        if (connection != null) {                                                         // while there is a connection

            PreparedStatement deletePhone = null;
            PreparedStatement deleteTV = null;

                deletePhone = connection.prepareCall("Delete from Phone where id = (?)");       // searched Phone table for ID to delete
                deletePhone.setInt(1, productID);

                int i = deletePhone.executeUpdate();

                deleteTV = connection.prepareCall("Delete from TV where id = (?)");             // searched TV table for ID to delete
                deleteTV.setInt(1, productID);

                int e = deleteTV.executeUpdate();






            connection.close();

    }
    }

}












