package project.View.Create_Order;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project.Database.DB_Display;
import project.View.HomePage.Display_Options;

import java.sql.SQLException;

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

public class Log_Existing_Customer {

    public static void load_Log_Existing_Customer(Stage primaryStage) {


        Label existingCustomerDetailsTitle = new Label("Log In Using Existing Customer Details");     // label for title of page
        existingCustomerDetailsTitle.setAlignment(Pos.CENTER);                                             // center label


        // store name
        HBox  existingCustomerNameStructure = new HBox();                            // structure to hold address label and field
        existingCustomerNameStructure.setAlignment(Pos.CENTER_LEFT);                 // center label
        existingCustomerNameStructure.setSpacing(50);                                // spacing for box's children
        Label existingCustomerNameLabel     = new Label("Name:");               // label asking for name
        existingCustomerNameLabel.setMinWidth(100);
        TextField storeExistingCustomerName = new TextField();                       // textfield to store address
        storeExistingCustomerName.setPromptText("Ex: Steve");                        // prompt text for textfield
        existingCustomerNameStructure.getChildren().addAll(existingCustomerNameLabel,// add label and textfield to box
                storeExistingCustomerName );



        // store password
        HBox  existingCustomerPasswordStructure = new HBox();                            // structure to hold address label and field
        existingCustomerPasswordStructure.setAlignment(Pos.CENTER_LEFT);                 // center label
        existingCustomerPasswordStructure.setSpacing(50);                                // spacing for box's children
        Label existingCustomerPasswordLabel     = new Label("Password:");           // label asking for address
        existingCustomerPasswordLabel.setMinWidth(100);
        PasswordField storeExistingCustomerPassword = new PasswordField();                       // textfield to store address
        storeExistingCustomerName.setPromptText("Ex: 123456");                           // prompt text for textfield
        existingCustomerPasswordStructure.getChildren().addAll(existingCustomerPasswordLabel,// add label and textfield to box
                                                               storeExistingCustomerPassword );



        // submit and clear buttons
        HBox existingCustomerSaveClearButtons = new HBox();                           // structure to hold submit and clear button
        existingCustomerSaveClearButtons.setAlignment(Pos.CENTER_LEFT);               // center label
        existingCustomerSaveClearButtons.setSpacing(50);                              // spacing for box's children
        Button existingCustomerSubmitButton  = new Button("Submit");             // button to submit details
        Button existingCustomerClearButton   = new Button("Clear");              // button to clear details
        existingCustomerSaveClearButtons.getChildren().addAll(existingCustomerSubmitButton,// add buttons to  box
                existingCustomerClearButton);

        // Label to  advise if valid customer
        HBox validCustomerBox = new HBox();                                      // structure to hold customers new ID
        validCustomerBox.setAlignment(Pos.CENTER_LEFT);                          // center label
        validCustomerBox.setSpacing(50);                                         // spacing for box's children
        Label validCustomer   = new Label("Account Found");                 // label for ID
        Label invalidCustomer = new Label("Invalid Details Entered");       // label with ID
        validCustomerBox.getChildren().addAll(validCustomer,invalidCustomer );   // add labels to box


        // Proceed to order
        HBox proceedToOrderBox = new HBox();                                          // main structure
        proceedToOrderBox.setAlignment(Pos.CENTER_LEFT);                                   // center label
        proceedToOrderBox.setSpacing(50);                                             // spacing for box's children
        Button proceedToOrderButton = new Button("Proceed to Order");            // proceed to order button
        proceedToOrderBox.getChildren().add(proceedToOrderButton);                    // add button to mbox


        Button returnHomeButton = new Button("Return to main options");



        // main scene structure
        VBox existingCustomerDetails = new VBox();                               // main scene structure
        existingCustomerDetails.setSpacing(30);
        existingCustomerDetails.setAlignment(Pos.CENTER_LEFT);
        existingCustomerDetails.setPadding(new Insets(0,0,0,40));
        existingCustomerDetails.getChildren().addAll(existingCustomerDetailsTitle,existingCustomerNameStructure,
                                                     existingCustomerPasswordStructure, existingCustomerSaveClearButtons,
                                                     validCustomerBox, proceedToOrderBox,returnHomeButton);





        validCustomer.setVisible(false);                            // hide label
        invalidCustomer.setVisible(false);                          // hide label
        proceedToOrderButton.setDisable(true);                      // dont allow to place order until logged in

        Scene existingCustomerDetailsScene = new Scene(existingCustomerDetails, 500, 550);



        primaryStage.setScene(existingCustomerDetailsScene);                    // set the primary stage




         /* ----------------------------------------------------
                  Buttons
            ---------------------------------------------------- */

        existingCustomerSubmitButton.setOnAction(e-> {                            //  Option 2: Existing customer

            String customerName          = storeExistingCustomerName.getText();          // store customer ID

            String customerPasswordInput = storeExistingCustomerPassword.getText();          // store customer name

            String customerPassword      = null; // checks if password is related to the email entered
            try {
                customerPassword = DB_Display.validateExistingCustomer2(customerName);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            if (customerPasswordInput.equals(customerPassword) ){                 // Scenario 1: valid customer as entered correct password

                currentCustomer = customerName;

                currentCustomerID = DB_Display.getCustomerID(currentCustomer);

                validCustomer.setVisible(true);                                   // show label
                proceedToOrderButton.setDisable(false);                           // allow user to place order
                invalidCustomer.setVisible(false);                                // hide label saying incorrect details

            } else {                                                              // Scenario 2: invalid customer
                validCustomer.setVisible(false);                                  // hide label
                invalidCustomer.setVisible(true);                                 // show label with incorrect details

            }

        });

        existingCustomerClearButton.setOnAction(e-> {                             // load create order scene

            storeExistingCustomerPassword.clear();

            storeExistingCustomerName.clear();





        });

        proceedToOrderButton.setOnAction(e-> {                                 // load create order scene

            load_Create_Order(primaryStage);


        });


        returnHomeButton.setOnAction(e-> Display_Options.load_Display_Options(primaryStage));



    }

}
