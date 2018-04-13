package sample.View.Display_Products;




/*****************************
 * Database Design Project
 *
 *
 * Name:       Steve Walsh
 * Student No: R00151053
 * Date      : 12/4/18
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
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Database.DB_Display;
import sample.Database.DB_Edit;
import sample.View.HomePage.Display_Options;

import java.sql.SQLException;

//-----------------//
//    Class        //
//-----------------//
public class Display_Products {



    public static void load_Display_Products(Stage primaryStage){


        Label displayOptionsLabel = new Label("Order by: ");                        // label for display options
        displayOptionsLabel.setPadding(new Insets(0,0,0,0));      // set padding
        Button orderByID          = new Button("ID");                               // order by ID button
        Button orderByMake        = new Button("Make");                             // order by make button
        Button orderByPrice       = new Button("Price");                            // order by price button



        HBox displayOptions = new HBox();                                                 // display options main structure
        displayOptions.setPadding(new Insets(30,0,0,10));         // set padding

        displayOptions.setSpacing(15);                                                    // set spacing of children
        displayOptions.getChildren().addAll(displayOptionsLabel,orderByID,                // add children
                orderByMake,orderByPrice);



        Label deleteProductLabel = new Label("Enter ID: ");                          // label for deleting product
        TextField storeProductToDelete = new TextField();                                 // text field to store user input
        storeProductToDelete.setPromptText("EX: 2");                                      // prompt for text field
        storeProductToDelete.setMaxWidth(100);
        Button deleteProductButton = new Button("Delete");                           // delete button to submit ID for product entered in text field
        HBox deleteProduct = new HBox();                                                  // hbox to store
        deleteProduct.setPadding(new Insets(30,0,0,30));           // layout for hBox
        deleteProduct.setSpacing(20);                                                     // layout for hBox children
        deleteProduct.getChildren().addAll(displayOptionsLabel,orderByID,                 // add children to hbox
                orderByMake,orderByPrice,deleteProductLabel,storeProductToDelete,
                deleteProductButton);



        //Phone label
        Label PhoneTitleLabel = new Label("Phones");                                   // Label for phones
        PhoneTitleLabel.setAlignment(Pos.CENTER_LEFT);

        // scroll pane phones
        ScrollPane displayPhonesBox = new ScrollPane();                                    // new scroll pane to store the products
        displayPhonesBox.setFitToHeight(true);

        // TV label
        Label TVTitleLabel = new Label("TVs");                                        // Label for TVs

        TVTitleLabel.setAlignment(Pos.CENTER_LEFT);

        // scroll pane TVs
        ScrollPane displayTVBox = new ScrollPane();                                        // new scroll pane to store the products
        displayTVBox.setFitToHeight(true);

        // return button
        Button returnButton = new Button("Return");                                   // button to return to home
        returnButton.setAlignment(Pos.CENTER);


        // main structure
        VBox displayProducts_MainStructure = new VBox();                                                                   // store HBoxes
        displayProducts_MainStructure.setSpacing(50);                                                                      // set spacing between children
        displayProducts_MainStructure.setAlignment(Pos.CENTER);                                                            // center main structure
        displayProducts_MainStructure.getChildren().addAll(  PhoneTitleLabel,displayPhonesBox,// build main structure
                TVTitleLabel, displayTVBox,deleteProduct, returnButton);

        Scene displayProductsScene = new Scene(displayProducts_MainStructure, 700, 700);                     // Create the Scene // create new scene, add VBOX


        displayProducts(displayPhonesBox,displayTVBox );

        primaryStage.setScene(displayProductsScene);                                        // sets the scene




         /* ----------------------------------------------------
                  Buttons
            ---------------------------------------------------- */

        orderByID.setOnAction(e-> {                                                    // Clicking Order by id button

            displayProducts_MainStructure.getChildren().removeAll();

            String orderPhoneByIDQuery = "SELECT * FROM Phone Order By id DESC";       // the  SQL SELECT query.
            String orderTVByIDQuery    = "SELECT * FROM TV Order By id DESC";          // the  SQL SELECT query.

            try {
                DB_Display.displayAllProducts(orderPhoneByIDQuery,orderTVByIDQuery,
                                            displayPhonesBox,displayTVBox );         // access database to add phones to scroll pane
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });

        orderByMake.setOnAction(e-> {                                                    // Clicking Order by make button

            displayProducts_MainStructure.getChildren().removeAll();

            String orderPhonebyMakeQuery = "SELECT * FROM Phone Order By make DESC";     // the  SQL SELECT query.
            String orderTVbyMakeQuery    = "SELECT * FROM TV Order By make DESC";        // the  SQL SELECT query.

            try {
                DB_Display.displayAllProducts(orderPhonebyMakeQuery,orderTVbyMakeQuery,
                        displayPhonesBox,displayTVBox );                                 // access database to add phones to scroll pane
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });

        orderByPrice.setOnAction(e-> {                                                   // Clicking Order by price button


            displayProducts_MainStructure.getChildren().removeAll();


            String orderPhonebyPriceQuery = "SELECT * FROM Phone Order By price DESC";   // the  SQL SELECT query.
            String orderTVbyPriceQuery    = "SELECT * FROM TV Order By price DESC";      // the  SQL SELECT query.

            try {
                DB_Display.displayAllProducts(orderPhonebyPriceQuery,orderTVbyPriceQuery,
                        displayPhonesBox,displayTVBox );                                // access database to add phones to scroll pane
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });



        deleteProductButton.setOnAction(e-> {                                                   // Clicking Delete Button

            int productToDelete = Integer.parseInt(storeProductToDelete.getText());             // number from textfield


            try {
                DB_Edit.deleteProduct(productToDelete);                                         // delete product
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            storeProductToDelete.clear();                                                       // clear text field input

            displayProducts(displayPhonesBox,displayTVBox );                                    // display products

        });

        returnButton.setOnAction(e-> {                                 // Return home when adding new product

            Display_Options.load_Display_Options(primaryStage);        // return to home page

            displayPhonesBox.setContent(null);                         // remove data from scrollPane

            displayTVBox.setContent(null);                             // remove data from scrollPane



        });





    }


     /* --------------------------------------
                  Methods
        -------------------------------------- */


    public static void displayProducts(ScrollPane displayPhonesBox, ScrollPane displayTVBox){



        String phoneDetailsQuery = "SELECT * FROM Phone";                  // the  SQL SELECT query.
        String TVDetailsQuery    = "SELECT * FROM TV";                     // the  SQL SELECT query.

        try {
            DB_Display.displayAllProducts(phoneDetailsQuery,TVDetailsQuery,
                                         displayPhonesBox,displayTVBox );                        // access database to add phones to scroll pane
        } catch (SQLException e1) {
            e1.printStackTrace();
        }



    }


}
