package sample.View.Display_Orders;




/*****************************
 * Database Design Project
 *
 *
 * Name:       Steve Walsh
 * Student No: R00151053
 * Date      : 15/4/18
 *
 *****************************/

//-----------------//
//    Imports      //
//-----------------//
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Database.DB_Display;
import sample.View.HomePage.Display_Options;

import java.sql.SQLException;

import static sample.Database.DB_Display.displayOrders;


//-----------------//
//    Class        //
//-----------------//
public class Display_Orders {



    public static void load_Display_Orders(Stage primaryStage){




        Label displayOrdersTitleLabel = new Label("Orders: ");                      // label for display options


        ScrollPane orderPane = new ScrollPane();                                         // scroll pane to store orders
        orderPane.setMinHeight(200);


        try {
            displayOrders(orderPane);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        Label displayOptionsLabel = new Label("Order by: ");                       // label for display options
        displayOptionsLabel.setPadding(new Insets(0,0,0,0));     // set padding
        Button orderByCustomer          = new Button("Customer");                          // order by customer button
        Button orderByPrice       = new Button("Price");                           // order by price button


        HBox orderByBox = new HBox();                                                   // hold order by options
        orderByBox.setAlignment(Pos.CENTER);                                            // center align
        orderByBox.setSpacing(30);
        orderByBox.getChildren().addAll(displayOptionsLabel,orderByCustomer,orderByPrice  );    // add children to box


        Button returnHomeButton = new Button("Return to main options");            // return home button
        returnHomeButton.setAlignment(Pos.CENTER_LEFT);                                 // center align


        VBox displayOrdersMainStructure = new VBox();                                   // main structure of scene
        displayOrdersMainStructure.setAlignment(Pos.CENTER);
        displayOrdersMainStructure.setSpacing(30);
        displayOrdersMainStructure.getChildren().addAll(displayOrdersTitleLabel,orderPane,
                                                        orderByBox,returnHomeButton );

        Scene displayOrdersScene = new Scene(displayOrdersMainStructure);               // create scene to display orders

        primaryStage.setScene(displayOrdersScene);                                      // makes display orders primary stage scene

        /* ----------------------------------------------------
                  Buttons
           ---------------------------------------------------- */

        orderByCustomer.setOnAction(e-> {

            try {
                DB_Display.displayOrdersByCustomer(orderPane);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        });


        orderByPrice.setOnAction(e-> {

            try {
                DB_Display.displayOrdersByPrice(orderPane);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        });



        returnHomeButton.setOnAction(e-> {

            Display_Options.load_Display_Options(primaryStage);


        });


    }








}
