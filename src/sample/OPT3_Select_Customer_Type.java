package sample;


/**
 * Created by Steve on 11/04/2018.
 */



//-----------------//
//    Imports      //
//-----------------//
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


//-----------------//
//    Class        //
//-----------------//
public class OPT3_Select_Customer_Type {




    public static void load_Select_Customer_Type(Stage primaryStage){


            // Title
        HBox chooseCustomerType_Title = new HBox();                                                             // store title

        Label label_chooseCustomerType_Title = new Label("Please select if new of existing customer");     // create label for title

            chooseCustomerType_Title.getChildren().

        add(label_chooseCustomerType_Title);                                                                    // add label to title HBox

            chooseCustomerType_Title.setAlignment(Pos.CENTER);                                                  // center main structure

        // Options
        HBox chooseCustomerType_Options = new HBox();                                                           // store options

        Button newCustomer = new Button("New Customer");                                                   // create button to add phone

        Button existingCustomer = new Button("Existing Customer");                                         // create button to add tv

            chooseCustomerType_Options.getChildren().

        addAll(newCustomer, existingCustomer);                                                                  // add buttons to hbox

            chooseCustomerType_Options.setSpacing(30);                                                          // adds spacing between elements

            chooseCustomerType_Options.setAlignment(Pos.CENTER);                                                // center main structure

        // main structure
        VBox chooseCustomerType_MainStructure = new VBox();                                                     // store HBoxes

            chooseCustomerType_MainStructure.getChildren().

        addAll(chooseCustomerType_Title, chooseCustomerType_Options); // add HBox's to vBox

            chooseCustomerType_MainStructure.setSpacing(50);                                                     // set spacing between children

            chooseCustomerType_MainStructure.setAlignment(Pos.CENTER);                                           // center main structure

        Scene chooseCustomerType = new Scene(chooseCustomerType_MainStructure, 500, 500);          // Create the Scene // create new scene, add VBOX


            primaryStage.setScene(chooseCustomerType);




         /* ----------------------------------------------------
                  Buttons
            ---------------------------------------------------- */

        newCustomer.setOnAction(e-> {                                   //  Option 1: new customer

            OPT3_Create_New_Customer.load_Create_New_Customer(primaryStage); // load OPT3_Create_New_Customer scene

        });



        existingCustomer.setOnAction(e-> {                                   //  Option 2: Existing customer



            OPT3_Log_Existing_Customer.load_Log_Existing_Customer(primaryStage);  // load OPT3_Log_Existing_Customer scene

        });



    }

}
