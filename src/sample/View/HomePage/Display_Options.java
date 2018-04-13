package sample.View.HomePage;





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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Database.DB_Display;
import sample.View.Create_Order.Choose_Customer_Type;
import sample.View.Create_Product.Add_Product;
import sample.View.Display_Products.Display_Products;


//-----------------//
//    Class        //
//-----------------//
public class Display_Options {




    public static void load_Display_Options(Stage primaryStage){



        //----------------//
        //     Layout     //
        //----------------//

        VBox homePageOptions = new VBox();                                                   // create new vBox to tore options

        homePageOptions.setAlignment(Pos.CENTER);                                            // center labels and buttons

        homePageOptions.setSpacing(25);                                                      // add spacing between elements

        Scene homePage = new Scene(homePageOptions, 500, 500);                 // Create the Scene // create new scene, add VBOX

        Label homePageHeader   = new Label("Main menu");                                // main page header

        homePageHeader.setFont(new Font(30));                                           // change font size for label

        homePageHeader.setPadding(new Insets(0,0,20,0));              // set padding beneath label for extra space

        Button createProduct   = new Button("Create a product");                        // Option 1: create a product

        createProduct.setMinWidth(200);                                                      // set width

        Button displayProducts = new Button("Display products");                        // Option 2: display products

        displayProducts.setMinWidth(200);                                                    // set width

        Button createOrder     = new Button("Create an Order");                         // Option 3: create new order

        createOrder.setMinWidth(200);                                                        // set width

        Button displayOrders   = new Button("Display Orders");                          // Option 4: display orders

        displayOrders.setMinWidth(200);                                                      // set width

        Button exit            = new Button("Exit");                                    // Option 5: exit program

        exit.setMinWidth(50);                                                                // set width


        homePageOptions.getChildren().addAll(homePageHeader,createProduct,displayProducts,   // add label and buttons to vBox
                createOrder,displayOrders,exit );


        primaryStage.setTitle("R00151053 Project");                                          // set title of primary stage

        primaryStage.setScene(homePage);                                                     // add homePage scene to primary stage

        primaryStage.setMaxWidth(650);
        primaryStage.setMinWidth(500);

        primaryStage.setMaxHeight(700);
        primaryStage.setMinHeight(500);

        primaryStage.show();                                                                 // show primary stage



        /* ----------------------------------------------------
                  Buttons
           ---------------------------------------------------- */



        //---------------------------------------//
        //    Option 1:  Create new Product      //
        //---------------------------------------//

        createProduct.setOnAction(e-> {


            Add_Product.load_Add_Options(primaryStage);                           // load up the Add_Product Scene

         DB_Display.getProductNum();                                              // initialises the product count variable

        });

        //---------------------------------------//
        //    Option 2:  Display Products        //
        //---------------------------------------//
        displayProducts.setOnAction(e-> {

        Display_Products.load_Display_Products(primaryStage);                 // sets display_Products scene

        });

        //---------------------------------------//
        //    Option 3: Create Order             //
        //---------------------------------------//
        createOrder.setOnAction(e-> {

            Choose_Customer_Type.load_Select_Customer_Type(primaryStage);     // sets Choose_Customer_Type scene

        });

        //---------------------------------------//
        //    Option 4:  Display Orders          //
        //---------------------------------------//
        displayOrders.setOnAction(e-> {


        });

        //---------------------------------------//
        //    Option 5:  Exit                    //
        //---------------------------------------//

        exit.setOnAction(e->{

            primaryStage.close();                       // closes program


        });



    }



}
