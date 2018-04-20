package project.View.Create_Order;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project.Database.DB_Display;
import project.Database.DB_Insert;
import project.View.HomePage.Display_Options;

import static project.Controller.Controller.currentCustomer;
import static project.Controller.Controller.currentCustomerID;
import static project.View.Create_Order.Create_Order.load_Create_Order;


/*****************************
 * Database Design Project
 *
 *
 * Name:       Steve Walsh
 * Student No: R00151053
 * Date      : 12/4/18
 *
 *****************************/

public class Create_New_Customer {




    public static void load_Create_New_Customer(Stage primaryStage){



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

        // Account created
        HBox newCustomerCreatedBox = new HBox();                                      // structure to hold customers new ID
        newCustomerCreatedBox.setAlignment(Pos.CENTER_LEFT);                          // center label
        newCustomerCreatedBox.setSpacing(50);                                         // spacing for box's children
        Label newCustomerCreatedLabel = new Label("Account Created ");          // label for account created
        Label newCustomerNotCreatedLabel = new Label("Password must be less than 6 digits in length ");// label for invalid password
        newCustomerCreatedBox.getChildren().addAll(newCustomerCreatedLabel,newCustomerNotCreatedLabel );// add labels to box



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
                                                newCustomerCreatedBox,
                                                proceedToOrderBox,returnHomeButton );





        newCustomerNotCreatedLabel.setVisible(false);                // hide label initially
        newCustomerCreatedLabel.setVisible(false);                   // hide label initially
        proceedToOrderButton.setDisable(true);                       // hide place order



        Scene addCustomerDetailsScene = new Scene(addCustomerDetails, 500, 550);



        primaryStage.setScene(addCustomerDetailsScene);              // loads scene



        /* ----------------------------------------------------
                  Buttons
           ---------------------------------------------------- */

        newCustomerSubmitButton.setOnAction(e-> {                                 //  Option 2: Existing customer

            String customerName     = storeCustomerName.getText();                // store customer name

            String customerAddress  = storeCustomerAddress.getText();             // store customer address

            String customerEmail    = storeCustomerEmail.getText();               // store customer email

            String customerPassword = storeCustomerPassword .getText();           // store customer password

            if (customerPassword.length() <=6) {


                DB_Insert.saveCustomer(customerName,customerAddress,customerEmail,customerPassword); // save customer details


                currentCustomerID = DB_Display.getnewCustomerID();                    // get customer ID

                currentCustomer = customerName;

                newCustomerCreatedLabel.setVisible(true);                    // show label
                proceedToOrderButton.setDisable(false);                      // allow user to place order
                newCustomerNotCreatedLabel.setVisible(false);                // hide label initially


            }else {

                storeCustomerPassword.clear();                              // clear password which is too long

                newCustomerNotCreatedLabel.setVisible(true);                // hide label initially




            }






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
