package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static sample.Main.currentCustomerID;

/**
 * Created by Steve on 11/04/2018.
 */
public class Log_Existing_Customer {







    public static void load_Log_Existing_Customer(Stage primaryStage) {


        Label existingCustomerDetailsTitle = new Label("Provide Details:");     // label for title of page
        existingCustomerDetailsTitle.setAlignment(Pos.CENTER);                       // center label

        // store name
        HBox  existingCustomerIDStructure = new HBox();                            // structure to hold name label and field
        existingCustomerIDStructure.setAlignment(Pos.CENTER_LEFT);                    // center label
        existingCustomerIDStructure.setSpacing(50);                                   // spacing for box's children
        Label existingCustomerIDLabel     = new Label("ID:     ");             // label asking for name
        TextField storeCustomerID         = new TextField();                       // textfield to store name
        storeCustomerID.setPromptText("Ex: 2");                                    // prompt text for textfield
        existingCustomerIDStructure.getChildren().addAll(existingCustomerIDLabel, // add label and textfield to box
                storeCustomerID );

        // store address
        HBox  existingCustomerNameStructure = new HBox();                            // structure to hold address label and field
        existingCustomerNameStructure.setAlignment(Pos.CENTER_LEFT);                   // center label
        existingCustomerNameStructure.setSpacing(50);                                  // spacing for box's children
        Label existingCustomerNameLabel     = new Label("name:");;              // label asking for address
        TextField storeExistingCustomerName = new TextField();                       // textfield to store address
        storeExistingCustomerName.setPromptText("Ex: Cork");                         // prompt text for textfield
        existingCustomerNameStructure.getChildren().addAll(existingCustomerNameLabel,// add label and textfield to box
                storeExistingCustomerName );

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
        proceedToOrderBox.setAlignment(Pos.CENTER);                                   // center label
        proceedToOrderBox.setSpacing(50);                                             // spacing for box's children
        Button proceedToOrderButton = new Button("Proceed to Order");            // proceed to order button
        proceedToOrderBox.getChildren().add(proceedToOrderButton);                    // add button to mbox


        Button returnHomeButton = new Button("Return to main options");



        // main scene structure
        VBox existingCustomerDetails = new VBox();                               // main scene structure
        existingCustomerDetails.setSpacing(30);
        existingCustomerDetails.setAlignment(Pos.CENTER_LEFT);
        existingCustomerDetails.setPadding(new Insets(0,0,0,40));
        existingCustomerDetails.getChildren().addAll(existingCustomerDetailsTitle,existingCustomerIDStructure,
                existingCustomerNameStructure, existingCustomerSaveClearButtons,
                validCustomerBox, proceedToOrderBox,returnHomeButton);





        validCustomer.setVisible(false);
        invalidCustomer.setVisible(false);
        proceedToOrderButton.setDisable(true);                      // hide place order

        Scene existingCustomerDetailsScene = new Scene(existingCustomerDetails, 500, 500);



        primaryStage.setScene(existingCustomerDetailsScene);                    // set the primary stage




         /* ----------------------------------------------------
                  Buttons
            ---------------------------------------------------- */

        existingCustomerSubmitButton.setOnAction(e-> {                            //  Option 2: Existing customer

            int customerID   = Integer.parseInt(storeCustomerID.getText());       // store customer ID

            String customerNameInput = storeExistingCustomerName.getText();       // store customer name

            String customerName = DB_Display.validateExistingCustomer(customerID); // checks if customer 12 and name for customer in databse

            if (customerNameInput.equals(customerName) ){                         // Scenario 1: valid customer

                validCustomer.setVisible(true);                                   // show label
                proceedToOrderButton.setDisable(false);                           // allow user to place order
                invalidCustomer.setVisible(false);                                // hide label saying incorrect details

                currentCustomerID = customerID;
            } else {                                                              // Scenario 2: invalid customer
                validCustomer.setVisible(false);                                  // hide label
                invalidCustomer.setVisible(true);                                 // show label with incorrect details

            }

        });


        returnHomeButton.setOnAction(e-> {

            Display_Options.load_Display_Options(primaryStage);


        });



    }

}
