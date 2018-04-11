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
public class Create_New_Customer {




    public static void load_Create_New_Customer(Stage primaryStage){



        // title
        Label addCustomerDetailsTitle = new Label("Add details:");         // label for title of page
        addCustomerDetailsTitle.setAlignment(Pos.CENTER);                       // center label

        // store name
        HBox addCustomerNameStructure = new HBox();                            // structure to hold name label and field
        addCustomerNameStructure.setAlignment(Pos.CENTER_LEFT);                 // center label
        addCustomerNameStructure.setSpacing(50);                                // spacing for box's children
        Label addCustomerNameLabel     = new Label("Name:    ");           // label asking for name
        TextField storeCustomerName    = new TextField();                       // textfield to store name
        storeCustomerName.setPromptText("Ex: Alice");                           // prompt text for textfield
        addCustomerNameStructure.getChildren().addAll(addCustomerNameLabel,     // add label and textfield to box
                storeCustomerName );

        // store address
        HBox  addCustomerAddressStructure = new HBox();                          // structure to hold address label and field
        addCustomerAddressStructure.setAlignment(Pos.CENTER_LEFT);               // center label
        addCustomerAddressStructure.setSpacing(50);                              // spacing for box's children
        Label addCustomerAddressLabel     = new Label("Address:");;         // label asking for address
        TextField storeCustomerAddress    = new TextField();                     // textfield to store address
        storeCustomerAddress.setPromptText("Ex: Cork");                          // prompt text for textfield
        addCustomerAddressStructure.getChildren().addAll(addCustomerAddressLabel,// add label and textfield to box
                storeCustomerAddress );

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
        Label newCustomerIDLabel = new Label("Your ID is: ");;              // label for ID
        Label newCustomerID = new Label("123 ");;                           // label with ID
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
        proceedToOrderBox.setAlignment(Pos.CENTER);                                   // center label
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
                addCustomerAddressStructure, newCustomerSaveClearButtons,
                newCustomerIDBox,newCustomerSaveIDBox,proceedToOrderBox,returnHomeButton );






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

            String customerName    = storeCustomerName.getText();                 // store customer name

            String customerAddress = storeCustomerAddress.getText();              // store customer address

            currentCustomerID = DB_Display.getnewCustomerID();                    // get customer ID

            DB_Edit.saveCustomer(currentCustomerID,customerName,customerAddress); // save customer details

            newCustomerIDLabel.setVisible(true);                                  // show label
            newCustomerID.setVisible(true);                                       // show label
            newCustomerSaveIDLabel.setVisible(true);
            newCustomerID.setText(""+currentCustomerID);
            proceedToOrderButton.setDisable(false);                           // allow user to place order

        });



        returnHomeButton.setOnAction(e-> {

            Display_Options.load_Display_Options(primaryStage);


        });




    }


}
