package project.View.Create_Product;



/*****************************
 * Database Design Project
 *
 *
 * Name:       Steve Walsh
 * Student No: R00151053
 * Date      : 12/4/18
 *
 * ***************************
 *
 * Scene for adding new Phone
 * to database of products
 *
 *
 *****************************/


//-----------------//
//    Imports      //
//-----------------//
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import project.Database.DB_Display;
import project.Database.DB_Insert;
import project.View.HomePage.Display_Options;
import project.Model.Phone;

import java.sql.SQLException;
import java.util.ArrayList;

//-----------------//
//    Class        //
//-----------------//
public class Add_Phone {



    public static void load_Add_Phone(Stage primaryStage){

        Label addPhone_heading = new Label("Fill out all fields below and submit to add new Phone");
        addPhone_heading.setAlignment(Pos.CENTER_LEFT);
        addPhone_heading.setPadding(new Insets(30,0,0,0));

        HBox addPhone_make_box   = new HBox();                                     // Ask make of phone
        Label addPhone_make  = new Label("Phone make: \t\t");
        TextField storePhoneMake = new TextField();
        storePhoneMake.setPromptText("Samsung");
        addPhone_make_box.getChildren().addAll(addPhone_make, storePhoneMake);
        addPhone_make_box.setAlignment(Pos.CENTER_LEFT);

        HBox addPhone_model_box       = new HBox();                                 // Ask screen size of phone
        Label addPhone_model_label = new Label("Phone model:\t\t");
        TextField storePhoneModel    = new TextField();
        storePhoneModel.setPromptText("32");
        addPhone_model_box.getChildren().addAll(addPhone_model_label, storePhoneModel);
        addPhone_model_box.setAlignment(Pos.CENTER_LEFT);

        HBox addPhone_storage_box = new HBox();                                       // Ask type of phone
        Label addPhone_askStorage= new Label("Phone Storage(GB): \t");
        ComboBox askStorage = new ComboBox();
        askStorage.getItems().addAll(
                "16", "32", "64", "128", "256"
        );
        addPhone_storage_box.getChildren().addAll(addPhone_askStorage, askStorage);
        addPhone_storage_box.setAlignment(Pos.CENTER_LEFT);

        HBox addPhone_price_box = new HBox();                                      // Ask prize of phone
        Label addPhone_askPrice = new Label("Phone Price: \t\t");
        TextField storePhonePrice = new TextField();
        storePhonePrice.setPromptText("999");
        addPhone_price_box.getChildren().addAll(addPhone_askPrice, storePhonePrice );
        addPhone_price_box.setAlignment(Pos.CENTER_LEFT);

        HBox addPhone_Submit   = new HBox();                                       //  Submit info or clear boxes
        Button addPhone_Submit_button = new Button("Submit");
        Button addPhone_Clear  = new Button("Clear");
        addPhone_Submit.getChildren().addAll(addPhone_Submit_button,addPhone_Clear );
        addPhone_Submit.setAlignment(Pos.CENTER_LEFT);
        addPhone_Submit.setSpacing(20);

        HBox PhonereturnToHome = new HBox();
        Label phoneSaved = new Label("Product Saved");
        Label phoneAlreadyExists = new Label("Phone Already in System");

        phoneSaved.setVisible(false);
        phoneAlreadyExists.setVisible(false);
        Button returnHomeButton = new Button("Return Home");
        returnHomeButton.setAlignment(Pos.CENTER_LEFT);

        PhonereturnToHome.getChildren().addAll( returnHomeButton,phoneSaved,phoneAlreadyExists);
        PhonereturnToHome.setSpacing(40);

        VBox  addPhone_mainStructure = new VBox();                                                 // create main structure vbox

        addPhone_mainStructure.getChildren().addAll(addPhone_heading, addPhone_make_box, addPhone_model_box, //add hboxes to main vbox
                addPhone_storage_box,addPhone_price_box,addPhone_Submit,PhonereturnToHome);

        addPhone_mainStructure.setSpacing(25);
        addPhone_mainStructure.setPadding(new Insets(0,0,0,30));

        Scene addPhone = new Scene(addPhone_mainStructure, 500, 500);                // Create the Scene // create new scene, add VBOX


        primaryStage.setScene(addPhone);


         /* ----------------------------------------------------
                  Buttons
            ---------------------------------------------------- */


        addPhone_Submit_button.setOnAction(e-> {                            // addPhone

            phoneAlreadyExists.setVisible(false);                           // hide label

            Phone newPhone = new Phone();                                   // create new Phone object

            String make = storePhoneMake.getText();                         // take text from input field and store as make

            newPhone.setMake(make);                                         // set make of phone

            String model = storePhoneModel.getText();                       // take text from input field and store as make

            newPhone.setModel(model);                                       // set make of phone

            String storage = (String) askStorage.getValue();                // gets storage

            newPhone.setStorage(storage);                                   // sets storage

            double price =Double.parseDouble(storePhonePrice.getText());    // store price

            newPhone.setPrice(price);                                       // set price

            boolean phoneExists = false;

            try {
                ArrayList<Phone> phones = DB_Display.checkDuplicatePhone();   // loads arrayList of existing phones from database

                if (phones != null) {                                                    // while not null

                    for (Phone phone : phones) {                                         // loop through array List

                        if (phone.getMake().equals(newPhone.getMake())            &&     // compare makes
                                phone.getModel().equals(newPhone.getModel())      &&     // compare models
                                phone.getStorage().equals(newPhone.getStorage())  &&     // compare storage
                                phone.getPrice().equals(newPhone.getPrice())) {          // compare price

                            phoneAlreadyExists.setVisible(true);                        // if all the same show label
                            phoneExists = true;                                         // set true
                        }
                    }
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            if(!phoneExists) {                                                        // while the phone doesnt already exist

                DB_Insert.savePhone(make, model, Integer.parseInt(storage), price );  // add Phone to product DB

                phoneSaved.setVisible(true);

                storePhoneMake.clear();                                         // clear input fields

                storePhoneModel.clear();                                        // clear input fields

                storePhonePrice.clear();                                        // clear input fields
            }
          //  newPhone.print();                                             // **** TEST : Print newPhone details to console
        });


        addPhone_Clear.setOnAction(e-> {                                    // Clear Button when adding new Phone

            storePhoneMake.clear();                                         // clear input fields

            storePhoneModel.clear();                                        // clear input fields

            storePhonePrice.clear();                                        // clear input fields

            phoneSaved.setVisible(false);                                   // hide label


        });




        returnHomeButton.setOnAction(e-> Display_Options.load_Display_Options(primaryStage));





    }





    }
