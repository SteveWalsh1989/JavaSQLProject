package sample.View.Create_Order;



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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Database.DB_Display;

import java.sql.SQLException;

import static sample.Controller.Controller.currentCustomerID;
import static sample.Database.DB_Display.validateExistingCustomer;
import static sample.View.Create_Order.Choose_Customer_Type.load_Select_Customer_Type;
import static sample.View.HomePage.Display_Options.load_Display_Options;


//-----------------//
//    Class        //
//-----------------//
public class Create_Order {





    public static void load_Create_Order(Stage primaryStage){


        // title
        Label create_Order_Title  = new Label("Create an Order:");                // label showing who is logged in

        HBox title = new HBox();                                                       // structure to store logged in details

        title.setAlignment(Pos.CENTER);                                                // center align logged in box

        title.getChildren().add(create_Order_Title);                                   // add title label to title structure


        // Logged in as
        String currentCustomer = validateExistingCustomer(currentCustomerID);          // gets customers name

        Label loggedInAs       = new Label("Logged in as:");                      // label showing who is logged in

        Label loggedInCustomer = new Label(currentCustomer);                           // label with customer's name

        Button logOut  = new Button("Log out");                                   // log out Button

        HBox loggedInStructure = new HBox();                                           // structure to store logged in details

        loggedInStructure.setSpacing(30);                                              // set spacing

        loggedInStructure.setAlignment(Pos.CENTER);                                    // center align logged in box

        loggedInStructure.getChildren().addAll(loggedInAs,loggedInCustomer,logOut);    // add labels and log out button to logged in box



        // product labels
        Label productTypeLabel     = new Label("Product Type:");               // label showing who is logged in

        Label phoneModelTypeLabel  = new Label("Model:");                      // label showing who is logged in

        Label phoneMakeTypeLabel   = new Label("Make:");                       // label showing who is logged in

        Label storageTypeLabel     = new Label("Storage:");                    // label showing who is logged in

        Label phonePriceLabel      = new Label("Price:");                      // label showing who is logged in

        Label tvModelLabel         = new Label("Model:");                      // label showing who is logged in

        Label tvScreenSizeLabel    = new Label("ScreenSize:");                 // label showing who is logged in

        Label tvTypeLabel          = new Label("Type:");                       // label showing who is logged in


        HBox selectProductTitle = new HBox();                                      // structure to store logged in details

        selectProductTitle.setAlignment(Pos.CENTER);                               // center align logged in box

        selectProductTitle.setSpacing(25);

        selectProductTitle.getChildren().add(productTypeLabel);


        // Selecting Product combo boxes
        ComboBox productType = new ComboBox();                                         // combobox for product type
        productType.getItems().addAll("Phone", "TV");

        ComboBox phoneMakeType       = new ComboBox();                                 // combobox for product type

        ComboBox phoneModelType      = new ComboBox();                                 // combobox for product type

        ComboBox phoneStorageType    = new ComboBox();                                 // combobox for product type

        ComboBox phonePriceType      = new ComboBox();                                 // combobox for product type

        ComboBox tvModelType         = new ComboBox();                                 // combobox for product type

        ComboBox tvScreenSizeType    = new ComboBox();                                 // combobox for product type

        ComboBox TVType              = new ComboBox();                                 // combobox for product type

        ComboBox tvPriceType         = new ComboBox();                                 // combobox for product type

        HBox selectProductStructure = new HBox();                                      // structure to store logged in details

        selectProductStructure.setAlignment(Pos.CENTER);                               // center align logged in box

        selectProductStructure.setSpacing(25);

        selectProductStructure.getChildren().add(productType);


        //  select products  main structure
        VBox selectProductsVBox = new VBox();
        selectProductsVBox.getChildren().addAll(selectProductTitle,selectProductStructure );


        // display product selected



        HBox displaySelectedProductStructure = new HBox();                              // structure to display selected product

        displaySelectedProductStructure.setAlignment(Pos.CENTER);
        displaySelectedProductStructure.setSpacing(15);


        // button to confirm
        Button confirmOrder = new Button("Confirm Order");




        // button to return to homepage
        Button returnHome = new Button("Return to Home");



        // main scene structure
        VBox createOrderMainStructure  = new VBox();
        createOrderMainStructure.setSpacing(50);

        createOrderMainStructure.setAlignment(Pos.CENTER);
        createOrderMainStructure.getChildren().addAll(title,loggedInStructure,selectProductsVBox,
                                                      displaySelectedProductStructure, confirmOrder, returnHome);


        // scene
        Scene createOrderScene = new Scene(createOrderMainStructure,700, 500);      // add create order structure to scene


        //stage
        primaryStage.setScene(createOrderScene);                                    // add scene to primary stage






          /* ----------------------------------------------------
                  Buttons
             ---------------------------------------------------- */


        // select Product Type
        productType.setOnAction(e-> {

                    if (productType.getValue().equals("Phone")) {                                   // Scenario 1: Phone

                        //add
                        selectProductTitle.getChildren().addAll(phoneMakeTypeLabel,phoneModelTypeLabel,
                                                                storageTypeLabel, phonePriceLabel);


                        selectProductStructure.getChildren().addAll(phoneMakeType,phoneModelType,   // add Phone filter boxes
                                                                phoneStorageType,phonePriceType);

                        // display
                        String displayMake = "Select make from Phone";


                        try {
                            DB_Display.displayInComboxBox(displayMake, "make", phoneMakeType);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }


                        // remove
                        selectProductStructure.getChildren().removeAll(tvModelType, TVType,         // remove tv filter boxes
                                                             tvScreenSizeType, tvPriceType);

                        selectProductTitle.getChildren().removeAll(tvModelLabel, tvTypeLabel,
                                tvScreenSizeLabel, tvPriceType);

                    } else if (productType.getValue().equals("TV")) {                               // Scenario 2: TV

                        //add
                        selectProductTitle.getChildren().addAll(tvModelLabel, tvTypeLabel,
                                                              tvScreenSizeLabel, tvPriceType);

                        selectProductStructure.getChildren().addAll(tvModelType, TVType,            // add tv filter boxes
                                                                    tvScreenSizeType, tvPriceType);


                        // display
                        String displayMake = "Select make from TV";


                        try {
                            DB_Display.displayInComboxBox(displayMake, "make", tvModelType);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        // remove
                        selectProductStructure.getChildren().removeAll(phoneMakeType,phoneModelType,// remove Phone filter boxes
                                                                        phoneStorageType,phonePriceType);

                        selectProductTitle.getChildren().removeAll(phoneMakeTypeLabel,phoneModelTypeLabel,
                                storageTypeLabel, phonePriceLabel);

                    }

                });



        phoneMakeType.setOnAction(e->{


            phoneModelType.getItems().clear();
            phoneStorageType.getItems().clear();
            phonePriceType.getItems().clear();

            String query = "Select model from Phone where make = \"" + phoneMakeType.getValue() +"\"";

            try {
                DB_Display.displayInComboxBox(query, "model", phoneModelType);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });


        phoneModelType.setOnAction(e->{

            phoneStorageType.getItems().clear();
            phonePriceType.getItems().clear();
            String query = "Select storage from Phone where model = \"" + phoneModelType.getValue() +"\"";

            try {
                DB_Display.displayInComboxBox(query, "storage", phoneStorageType);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });


        phoneStorageType.setOnAction(e->{


            phonePriceType.getItems().clear();


            String query = "Select price from Phone where storage = \"" + phoneStorageType.getValue()
                                                  +"\" and  model = \"" + phoneModelType.getValue() +"\" ";

            try {
                DB_Display.displayInComboxBox(query, "price", phonePriceType);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        });



        phonePriceType.setOnAction(e->{


            String query = "Select * from Phone where model = \"" + phoneModelType.getValue()     +  "\" and " +
                                                    " make = \"" + phoneMakeType.getValue()       +  "\" and " +
                                                    " price = \"" + phonePriceType.getValue()     +  "\" and " +
                                                    " storage = \"" + phoneStorageType.getValue() +"\"";


            try {
                DB_Display.displayPhoneOrderSelected(query, displaySelectedProductStructure );
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        });

        tvModelType.setOnAction(e->{

            TVType.getItems().clear();
            tvScreenSizeType.getItems().clear();
            tvPriceType.getItems().clear();

            String query = "Select type from TV where make = \"" + tvModelType.getValue() +"\"";

            try {
                DB_Display.displayInComboxBox(query, "type", TVType);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });



        TVType.setOnAction(e->{
            tvScreenSizeType.getItems().clear();
            tvPriceType.getItems().clear();


            String query = "Select screen_size from TV where type = \"" + TVType.getValue() +"\"";

            try {
                DB_Display.displayInComboxBox(query, "screen_size", tvScreenSizeType);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        });


        tvScreenSizeType.setOnAction(e->{
            tvPriceType.getItems().clear();


            String query = "Select price from TV where screen_size = \"" + tvScreenSizeType.getValue() +"\"  and " +
                                                     " type = \""        + TVType.getValue()  +  "\"";


            try {
                DB_Display.displayInComboxBox(query, "price", tvPriceType);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        });



        tvPriceType.setOnAction(e->{

            String query = "Select * from TV where make = \""  + tvModelType.getValue()       +  "\" and " +
                                           " type = \""        + TVType.getValue()            +  "\" and " +
                                           " screen_size = \"" + tvScreenSizeType.getValue()  +  "\" and " +
                                           " price = \""       + tvPriceType.getValue()       +  "\"";

            try {
                DB_Display.displayTVOrderSelected(query, displaySelectedProductStructure );
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        });







        logOut.setOnAction(e-> {                                        // load the select customer type scene

            load_Select_Customer_Type(primaryStage);
        });






        returnHome.setOnAction(e-> {                                     // load home page

            load_Display_Options(primaryStage);
        });







    }








}
