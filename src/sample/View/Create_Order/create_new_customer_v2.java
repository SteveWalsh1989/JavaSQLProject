package sample.View.Create_Order;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Database.DB_Display;
import sample.Database.DB_Edit;
import sample.View.HomePage.Display_Options;

import static sample.Controller.Controller.currentCustomerID;
import static sample.View.Create_Order.Create_Order.load_Create_Order;


/*****************************
 * Database Design Project
 *
 *
 * Name:       Steve Walsh
 * Student No: R00151053
 * Date      : 12/4/18
 *
 *****************************/

public class create_new_customer_v2 {




    public static void load_create_new_customer_v2(Stage primaryStage){



        // title
        Label addCustomerDetailsTitle = new Label("Add details To Create New Customer Account:");  // label for title of page
        addCustomerDetailsTitle.setAlignment(Pos.CENTER);                       // center label

        // store name
        HBox addCustomerNameStructure = new HBox();                            // structure to hold name label and field
        addCustomerNameStructure.setAlignment(Pos.CENTER_LEFT);                 // center label
        addCustomerNameStructure.setSpacing(50);                                // spacing for box's children
        Label addCustomerNameLabel     = new Label("Name:    ");           // label asking for name
        addCustomerNameLabel.setMinWidth(100);
        TextField storeCustomerName    = new TextField();                       // textfield to store name
        storeCustomerName.setPromptText("Ex: Alice");                           // prompt text for textfield
        addCustomerNameStructure.getChildren().addAll(addCustomerNameLabel,     // add label and textfield to box
                storeCustomerName );

        // store address
        HBox  addCustomerAddressStructure = new HBox();                          // structure to hold address label and field
        addCustomerAddressStructure.setAlignment(Pos.CENTER_LEFT);               // center label
        addCustomerAddressStructure.setSpacing(50);                              // spacing for box's children
        Label addCustomerAddressLabel     = new Label("Address:");          // label asking for address
        addCustomerAddressLabel.setMinWidth(100);
        TextField storeCustomerAddress    = new TextField();                     // textfield to store address
        storeCustomerAddress.setPromptText("Ex: Cork");                          // prompt text for textfield
        addCustomerAddressStructure.getChildren().addAll(addCustomerAddressLabel,// add label and textfield to box
                storeCustomerAddress );

        // store email
        HBox  addCustomerEmailStructure = new HBox();                          // structure to hold address label and field
        addCustomerEmailStructure.setAlignment(Pos.CENTER_LEFT);               // center label
        addCustomerEmailStructure.setSpacing(50);                              // spacing for box's children
        Label addCustomerEmailLabel     = new Label("Email:");            // label asking for address
        addCustomerEmailLabel.setMinWidth(100);
        TextField storeCustomerEmail    = new TextField();                     // textfield to store address
        storeCustomerEmail.setPromptText("Ex: john@gmail.com");                // prompt text for textfield
        addCustomerEmailStructure.getChildren().addAll(addCustomerEmailLabel,
                                                       storeCustomerEmail) ; // add label and textfield to box

        // store password
        HBox addCustomerPasswordStructure = new HBox();                          // structure to hold address label and field
        addCustomerPasswordStructure.setAlignment(Pos.CENTER_LEFT);              // center label
        addCustomerPasswordStructure.setSpacing(50);                             // spacing for box's children
        Label addCustomerPasswordLabel     = new Label("Password:");        // label asking for address
        addCustomerPasswordLabel.setMinWidth(100);
        TextField storeCustomerPassword    = new TextField();                    // textfield to store address
        storeCustomerPassword.setPromptText("Ex: 123456");                        // prompt text for textfield
        addCustomerPasswordStructure.getChildren().addAll(addCustomerPasswordLabel,
                                                          storeCustomerPassword);// add label and textfield to box


        // submit and clear buttons
        HBox newCustomerSaveClearButtons = new HBox();                           // structure to hold submit and clear button
        newCustomerSaveClearButtons.setAlignment(Pos.CENTER_LEFT);               // center label
        newCustomerSaveClearButtons.setSpacing(50);                              // spacing for box's children
        Button newCustomerSubmitButton  = new Button("Submit");             // button to submit details
        Button newCustomerClearButton  = new Button("Clear");               // button to clear details
        newCustomerSaveClearButtons.getChildren().addAll(newCustomerSubmitButton,// add buttons to  box
                newCustomerClearButton);

        // Label to  advise of ID
        HBox newCustomerIDBox = new HBox();                                      // structure to hold customers new ID
        newCustomerIDBox.setAlignment(Pos.CENTER_LEFT);                          // center label
        newCustomerIDBox.setSpacing(50);                                         // spacing for box's children
        Label newCustomerIDLabel = new Label("Your ID is: ");// label for ID
        Label newCustomerID = new Label("123 ");// label with ID
        newCustomerIDBox.getChildren().addAll(newCustomerIDLabel,newCustomerID );// add labels to box

        // Label to  advise save ID
        HBox newCustomerSaveIDBox = new HBox();                                          // structure to hold customers new ID
        newCustomerSaveIDBox.setAlignment(Pos.CENTER_LEFT);                              // center label
        newCustomerSaveIDBox.setSpacing(50);                                             // spacing for box's children
        Label newCustomerSaveIDLabel = new Label("*** Save your ID as it is " +
                "required when making new orders ***");  // label for ID
        newCustomerSaveIDBox.getChildren().add(newCustomerSaveIDLabel );                 // add labels to box


        // Proceed to order
        HBox proceedToOrderBox = new HBox();                                          // main structure
        proceedToOrderBox.setAlignment(Pos.CENTER_LEFT);                                   // center label
        proceedToOrderBox.setSpacing(50);                                             // spacing for box's children
        Button proceedToOrderButton = new Button("Proceed to Order");            // proceed to order button
        proceedToOrderBox.getChildren().add(proceedToOrderButton);                    // add button to mbox


        Button returnHomeButton = new Button("Return to main options");

        // main scene structure
        VBox addCustomerDetails = new VBox();                                         // main scene structure
        addCustomerDetails.setSpacing(30);
        addCustomerDetails.setAlignment(Pos.CENTER_LEFT);
        addCustomerDetails.setPadding(new Insets(0,0,0,40));
        addCustomerDetails.getChildren().addAll(addCustomerDetailsTitle,addCustomerNameStructure,
                                                addCustomerAddressStructure,addCustomerEmailStructure,
                                                addCustomerPasswordStructure, newCustomerSaveClearButtons,
                                                newCustomerIDBox,newCustomerSaveIDBox,
                                                proceedToOrderBox,returnHomeButton );






        newCustomerIDLabel.setVisible(false);                        // hide label initially
        newCustomerID.setVisible(false);                             // hide label initially
        proceedToOrderButton.setDisable(true);                       // hide place order
        newCustomerSaveIDLabel.setVisible(false);                    // hide label initially



        Scene addCustomerDetailsScene = new Scene(addCustomerDetails, 500, 500);



        primaryStage.setScene(addCustomerDetailsScene);              // loads scene



        /* ----------------------------------------------------
                  Buttons
           ---------------------------------------------------- */

        newCustomerSubmitButton.setOnAction(e-> {                                 //  Option 2: Existing customer

            String customerName     = storeCustomerName.getText();                // store customer name

            String customerAddress  = storeCustomerAddress.getText();             // store customer address

            String customerEmail    = storeCustomerEmail.getText();               // store customer email

            String customerPassword = storeCustomerPassword .getText();           // store customer password






            DB_Edit.saveCustomer(customerName,customerAddress,customerEmail,customerPassword); // save customer details


            currentCustomerID = DB_Display.getnewCustomerID();                    // get customer ID

            newCustomerIDLabel.setVisible(true);                                  // show label
            newCustomerID.setVisible(true);                                       // show label
            newCustomerSaveIDLabel.setVisible(true);
            newCustomerID.setText(""+currentCustomerID);
            proceedToOrderButton.setDisable(false);                           // allow user to place order

        });



        proceedToOrderButton.setOnAction(e-> {                                 // load create order scene

            load_Create_Order(primaryStage);


        });



        newCustomerClearButton.setOnAction(e-> {                                 // load create order scene

            storeCustomerAddress.clear();

            storeCustomerName.clear();





        });

        returnHomeButton.setOnAction(e-> {                                     // load home page scene

            Display_Options.load_Display_Options(primaryStage);


        });




    }


}
