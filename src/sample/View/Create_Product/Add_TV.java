package sample.View.Create_Product;




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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Database.DB_Edit;
import sample.View.HomePage.Display_Options;
import sample.Model.TV;

//-----------------//
//    Class        //
//-----------------//
public class Add_TV {





    public static void load_Add_TV(Stage primaryStage){

        Label addTV_heading = new Label("Fill out all fields below and submit to add new TV");
        addTV_heading.setAlignment(Pos.CENTER_LEFT);
        addTV_heading.setPadding(new Insets(30,0,0,0));

        HBox addTV_make_box   = new HBox();                                     // Ask make of tv
        Label addTV_askTVMake = new Label("TV make: \t\t");
        TextField storeTVMake = new TextField();
        storeTVMake.setPromptText("Samsung");
        addTV_make_box.getChildren().addAll(addTV_askTVMake, storeTVMake);
        addTV_make_box.setAlignment(Pos.CENTER_LEFT);

        HBox addTV_size_box       = new HBox();                                 // Ask screen size of tv
        Label addTV_askScreenSize = new Label("TV Screensize:\t");
        TextField storeTVSize     = new TextField();
        storeTVSize.setPromptText("32");
        addTV_size_box.getChildren().addAll(addTV_askScreenSize, storeTVSize);
        addTV_size_box.setAlignment(Pos.CENTER_LEFT);

        HBox addTV_type_box = new HBox();                                       // Ask type of tv
        Label addTV_askType = new Label("TV Type: \t\t");
        ComboBox askTypeBox = new ComboBox();
        askTypeBox.getItems().addAll(
                "LED", "LCD", "Plasma"
        );
        addTV_type_box.getChildren().addAll(addTV_askType, askTypeBox);
        addTV_type_box.setAlignment(Pos.CENTER_LEFT);

        HBox addTV_price_box = new HBox();                                      // Ask prize of tv
        Label addTV_askPrice = new Label("TV Price: \t\t");
        TextField storePrice = new TextField();
        storePrice.setPromptText("999");
        addTV_price_box.getChildren().addAll(addTV_askPrice, storePrice );
        addTV_price_box.setAlignment(Pos.CENTER_LEFT);

        HBox addTV_Submit   = new HBox();                                       //  Submit info or clear boxes
        Button addTV_Submit_button = new Button("Submit");
        Button addTV_Clear  = new Button("Clear");
        addTV_Submit.getChildren().addAll(addTV_Submit_button,addTV_Clear );
        addTV_Submit.setAlignment(Pos.CENTER_LEFT);
        addTV_Submit.setSpacing(20);

        HBox TVreturnToHome = new HBox();
        Label ProductSaved = new Label("Product Saved");
        Button returnHomeButton = new Button("Return to main options");
        returnHomeButton.setAlignment(Pos.CENTER_LEFT);


        ProductSaved.setVisible(false);
        TVreturnToHome.getChildren().addAll(returnHomeButton,ProductSaved);
        TVreturnToHome.setSpacing(30);


        VBox addTV_mainStructure = new VBox();                                                  // create main structure vbox

        addTV_mainStructure.getChildren().addAll(addTV_heading, addTV_make_box, addTV_size_box, //add hboxes to main vbox
                addTV_type_box,addTV_price_box,addTV_Submit,TVreturnToHome);

        addTV_mainStructure.setSpacing(25);
        addTV_mainStructure.setPadding(new Insets(0,0,0,30));

        Scene addTV = new Scene(addTV_mainStructure, 500, 500);                   // Create the Scene // create new scene, add VBOX


        primaryStage.setScene(addTV);






        /* ----------------------------------------------------
                  Buttons
           ---------------------------------------------------- */
        // Submit Button when adding new TV
        addTV_Submit_button.setOnAction(e-> {                               // addTV

            TV newTV = new TV();                                            // create new tv object

            String make = storeTVMake.getText();                            // get tv make from textfield

            newTV.setMake(make);                                            // set tv make of new tv object

            int screensize = Integer.parseInt(storeTVSize.getText());       // convert screensize to int and store

            newTV.setScreenSize(screensize);                                // set screensize  of new tv object

            String type = askTypeBox.getValue().toString();                 // get type from combo box

            switch (type) {                                                 // set type of tv of new tv object
                case "LED":
                    newTV.setType(1);
                    break;
                case "LCD":
                    newTV.setType(2);
                    break;
                default:
                    newTV.setType(3);
                    break;
            }

            double price = Double.parseDouble(storePrice.getText());        // get price of tv from textfield

            newTV.setPrice(price);                                          // set price of new tv object

            DB_Edit.saveTV(make, screensize, type, price );  // Save TV to product DB

            ProductSaved.setVisible(true);

            storeTVMake.clear();                                            // clear input fields

            storeTVSize.clear();                                            // clear input fields

            storePrice.clear();                                             // clear input fields

            newTV.print();                                               // **** TEST : Print newTV details to console

        });

        // Clear Button when adding new TV
        addTV_Clear.setOnAction(e-> {

            storeTVMake.clear();                                            // clear input fields

            storeTVSize.clear();                                            // clear input fields

            storePrice.clear();                                             // clear input fields

            ProductSaved.setVisible(false);                                 // hide label



        });



        returnHomeButton.setOnAction(e-> {

            Display_Options.load_Display_Options(primaryStage);


        });


    }


}
