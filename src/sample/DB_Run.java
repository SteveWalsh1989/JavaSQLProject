package sample;



/**
 * Tests basic connection functionality for DB
 *
 * Gets productNum for product ID values
 */


//-----------------//
//    Imports      //
//-----------------//
import java.sql.*;


//---------------//
//    Class      //
//---------------//
public class DB_Run {



    /**
     * connectDB
     *
     * Establishes connection to
     * local MySQL database : DBProject
     */
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


}




